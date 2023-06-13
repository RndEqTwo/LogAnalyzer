package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.JSONBaseListener;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONLexer;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONListener;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONParser;
import de.jduwe.loganalyzer.*;
import javafx.scene.layout.Region;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.pf4j.Extension;

import java.util.List;


@Extension
public class JsonPlugin implements LogAnalyzerFinderPlugin {

    private ConfigView view;

    public JsonPlugin(ConfigView view) {
        this.view = view;
    }

    @Override
    public String getDisplayName() {
        return "Json Filter";
    }

    @Override
    public LogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return view;
    }

    @Override
    public FinderResult find(ALogFile logFile) {
        String log = String.join("\n",logFile.getLines());
        CharStream input = CharStreams.fromString(log);

        JSONLexer lexer = new JSONLexer(input);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokenStream);
        ParseTree tree = parser.json();

        JSONListener listener = new MyJSONListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        return new FinderResult() {
            @Override
            public boolean isVisible(long rowNumber) {
                return false;
            }

            @Override
            public List<AFinderResultEntry> getFilterResultEntries() {
                return null;
            }
        };
    }

    @Override
    public Region getFinderShowArea() {
        return null;
    }
}

class MyJSONListener extends JSONBaseListener {
    @Override
    public void enterPair(JSONParser.PairContext ctx) {
        String key = ctx.STRING().getText();
        String value = ctx.value().getText();
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
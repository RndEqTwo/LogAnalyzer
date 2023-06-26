package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.*;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JsonAnalyzer {

    public ParseTree parse(String line) {
        int jsonIndex = line.indexOf('{');
        if (jsonIndex > 0) {
            String jsonGuess = line.substring(jsonIndex);
            CharStream input = CharStreams.fromString(jsonGuess);

            JSONLexer lexer = new JSONLexer(input);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            JSONParser parser = new JSONParser(tokenStream);
            JSONParser.JsonContext parseTree = parser.json();

            if(parser.getNumberOfSyntaxErrors() == 0){
                return parseTree;
            }

        }
        return null;
    }
}


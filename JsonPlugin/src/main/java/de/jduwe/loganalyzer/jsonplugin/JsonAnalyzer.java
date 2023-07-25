package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.*;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Properties;

public class JsonAnalyzer {

    private Properties properties;

    public JsonAnalyzer(Properties properties) {
        this.properties = properties;
    }

    public ParseTree parse(String line) {
        int objectStart = line.indexOf('{');
        int arrayStart = line.indexOf('[');
        int jsonIndex = Math.min(objectStart, arrayStart);
        if (jsonIndex >= 0) {
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


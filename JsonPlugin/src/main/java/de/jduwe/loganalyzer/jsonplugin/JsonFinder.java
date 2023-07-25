package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.*;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Region;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JsonFinder implements ILogAnalyzerFinder {

    private IEventManager eventManager;
    private Properties properties;

    public JsonFinder(IEventManager eventManager, Properties properties) {
        this.eventManager = eventManager;
        this.properties = properties;
    }

    @Override
    public String getDisplayName() {
        return "JSON Finder";
    }


    @Override
    public Region find(List<ILogLine> logFile) {
        List<FinderEntry> foundEntries = new ArrayList<>();
        String contentGroupName = properties.getProperty("jsonplugin.contentGroupName");

        for(ILogLine line : logFile){
            String content = line.getLogInformation(contentGroupName);

            JsonAnalyzer analyzer = new JsonAnalyzer(properties);
            ParseTree parseTree = analyzer.parse(content);
            if(parseTree != null){
                TreeItem<String> rootItem = new TreeItem<>("Json");
                CustomJsonVisitor visitor = new CustomJsonVisitor(rootItem);
                visitor.visit(parseTree);
                TreeItem<String> json = visitor.getParentItem();
                foundEntries.add(new FinderEntry(line, json));
            }
        }
        return new FinderResultShowArea(eventManager, foundEntries);
    }
}


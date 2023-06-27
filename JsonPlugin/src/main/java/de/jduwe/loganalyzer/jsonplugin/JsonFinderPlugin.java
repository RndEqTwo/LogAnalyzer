package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.*;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Region;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class JsonFinderPlugin implements ILogAnalyzerFinderPlugin {

    private IEventManager eventManager;

    public JsonFinderPlugin(IEventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Override
    public String getDisplayName() {
        return "JSON Finder";
    }

    @Override
    public ILogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return null;
    }

    @Override
    public Region find(List<ILogLine> logFile) {
        List<FinderEntry> foundEntries = new ArrayList<>();

        for(ILogLine line : logFile){
            String lineContent = line.getLineContent();
            JsonAnalyzer analyzer = new JsonAnalyzer();
            ParseTree parseTree = analyzer.parse(lineContent);
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


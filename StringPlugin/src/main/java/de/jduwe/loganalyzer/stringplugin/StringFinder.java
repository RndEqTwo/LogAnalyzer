package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.*;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.List;

public class StringFinder implements ILogAnalyzerFinder {

    private String searchText;
    private IEventManager eventManager;

    public StringFinder(IEventManager eventManager, String searchText) {
        this.eventManager = eventManager;
        this.searchText = searchText;
    }

    @Override
    public String getDisplayName() {
        return searchText;
    }

    @Override
    public Region find(List<ILogLine> logFile) {
        List<ILogLine> foundLines = new ArrayList<>();

        for (ILogLine line : logFile){
            if(line.visibility().get() && line.getLineContent().contains(searchText)){
                foundLines.add(line);
            }
        }
        return new FinderView(eventManager, foundLines);
    }
}

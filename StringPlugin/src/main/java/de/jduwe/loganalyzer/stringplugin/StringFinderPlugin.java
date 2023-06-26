package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.*;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.List;

public class StringFinderPlugin implements ILogAnalyzerFinderPlugin {

    private String searchText;
    private IEventManager eventManager;

    public StringFinderPlugin(IEventManager eventManager, String searchText) {
        this.eventManager = eventManager;
        this.searchText = searchText;
    }

    @Override
    public String getDisplayName() {
        return searchText;
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
        List<ILogLine> foundLines = new ArrayList<>();

        for (ILogLine line : logFile){
            if(line.visibility().get() && line.getLineContent().contains(searchText)){
                foundLines.add(line);
            }
        }
        return new FinderView(eventManager, foundLines);
    }
}

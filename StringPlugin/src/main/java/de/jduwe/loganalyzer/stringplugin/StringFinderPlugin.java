package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.*;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.List;

public class StringFinderPlugin implements LogAnalyzerFinderPlugin {

    private String searchText;
    private StringFinderResult lastResult;

    public StringFinderPlugin(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String getDisplayName() {
        return searchText;
    }

    @Override
    public LogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return null;
    }

    @Override
    public FinderResult find(ALogFile logFile) {

        List<AFinderResultEntry> foundEntries = new ArrayList<>();

        for (int i = 0; i < logFile.getLines().size(); i++){
            if (logFile.getLines().get(i).contains(searchText)){
                foundEntries.add(new StringFinderResultEntry(i, i));
            }
        }

        lastResult = new StringFinderResult(foundEntries);
        return lastResult;
    }

    @Override
    public Region getFinderShowArea() {
        return new FinderView(lastResult);
    }
}

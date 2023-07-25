package de.jduwe.loganalyzer.loglevelplugin;

import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;

import java.util.List;

public class LogLevelFilter implements ILogAnalyzerFilter {

    List<String> filterTexts;

    public LogLevelFilter(List<String> filterTexts) {
        this.filterTexts = filterTexts;
    }

    @Override
    public String getDisplayName() {
        return "Log Level Filter";
    }


    @Override
    public boolean filter(String line) {

        for(String filterText : filterTexts){
            if (line.contains(filterText)){
                return true;
            }
        }
        return false;
    }
}

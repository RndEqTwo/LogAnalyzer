package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.ALogFile;
import de.jduwe.loganalyzer.LogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.LogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;


@Extension
public class StringFilterPlugin implements LogAnalyzerFilterPlugin {

    private String filterText;

    public StringFilterPlugin(String filterText) {
        this.filterText = filterText;
    }

    @Override
    public String getDisplayName() {
        return "\"" + filterText + "\"";
    }

    @Override
    public LogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        ConfigView view = new ConfigView();
        view.Update(filterText);
        return view;
    }

    @Override
    public ALogFile filter(ALogFile logFile) {
        logFile.getLines().removeIf(element -> !element.contains(filterText));
        return logFile;
    }
}

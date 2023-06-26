package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;


@Extension
public class StringFilterPlugin implements ILogAnalyzerFilterPlugin {

    private String filterText;
    private IEventManager eventManager;

    public StringFilterPlugin(IEventManager eventManager, String filterText) {
        this.eventManager = eventManager;
        this.filterText = filterText;
    }

    @Override
    public String getDisplayName() {
        return "\"" + filterText + "\"";
    }

    @Override
    public ILogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        ConfigView view = new ConfigView();
        view.Update(filterText);
        return view;
    }

    @Override
    public boolean filter(String line) {
        return !line.contains(filterText);
    }
}

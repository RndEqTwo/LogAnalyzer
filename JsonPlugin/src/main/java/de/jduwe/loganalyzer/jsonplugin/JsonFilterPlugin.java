package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import de.jduwe.loganalyzer.jsonplugin.antlr.*;

public class JsonFilterPlugin implements ILogAnalyzerFilterPlugin {

    private JsonAnalyzer analyzer;
    private IEventManager eventManager;

    public JsonFilterPlugin(IEventManager eventManager) {
        analyzer = new JsonAnalyzer();
        this.eventManager = eventManager;
    }

    @Override
    public String getDisplayName() {
        return "Json Filter";
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
    public boolean filter(String line) {
       return analyzer.parse(line) == null;
    }
}

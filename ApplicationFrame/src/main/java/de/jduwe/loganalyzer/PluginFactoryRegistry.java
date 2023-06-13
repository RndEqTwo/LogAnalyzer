package de.jduwe.loganalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PluginFactoryRegistry {

    private List<LogAnalyzerPluginFactory> pluginFactoryList;

    public PluginFactoryRegistry() {
        pluginFactoryList = new ArrayList<>();
    }

    public List<LogAnalyzerPluginFactory> getPluginFactoryList() {
        return Collections.unmodifiableList(pluginFactoryList);
    }

    public void registerPluginFactory(LogAnalyzerPluginFactory pluginFactory){
        pluginFactoryList.add(pluginFactory);
    }

}

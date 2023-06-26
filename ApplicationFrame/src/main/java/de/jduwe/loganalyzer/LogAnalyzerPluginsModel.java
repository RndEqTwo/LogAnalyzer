package de.jduwe.loganalyzer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class LogAnalyzerPluginsModel {

    private List<ILogAnalyzerPluginFactory> pluginFactoryList;
    private ILogAnalyzerPluginFactory activePluginFactory;
    private ObservableList<ILogAnalyzerFilterPlugin> filterPlugins;
    private ILogAnalyzerFinderPlugin activeFinderPlugin;
    private EventManager eventManager;

    public LogAnalyzerPluginsModel(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public List<ILogAnalyzerPluginFactory> getPluginFactoryList() {
        if(pluginFactoryList == null) {
            pluginFactoryList = new ArrayList<>();
        }
        return pluginFactoryList;
    }

    public void addPluginFactory(ILogAnalyzerPluginFactory pluginFactory){
        getPluginFactoryList().add(pluginFactory);
    }

    public void setActivePluginFactory(ILogAnalyzerPluginFactory pluginFactory){
        activePluginFactory = pluginFactory;
    }

    public ObservableList<ILogAnalyzerFilterPlugin> getFilterPlugins(){
        if(filterPlugins == null){
            filterPlugins = FXCollections.observableArrayList(new ArrayList<>());
        }
        return filterPlugins;
    }

    public void CreateFilterPluginFromCurrentFactory(){
        if(activePluginFactory != null){
            getFilterPlugins().add(activePluginFactory.createFilterPlugin());
        }
    }

    public void RemoveFilterPlugin(ILogAnalyzerFilterPlugin filterPlugin){
        getFilterPlugins().remove(filterPlugin);
        System.out.println(getFilterPlugins().size());
    }

    public ILogAnalyzerFinderPlugin getActiveFinderPlugin(){
        return activeFinderPlugin;
    }

    public void createActiveFinderPlugin(){
        if(activePluginFactory != null){
            activeFinderPlugin = activePluginFactory.createFinderPlugin();
        }
    }

    public void removeActiveFactory() {
        activePluginFactory = null;
    }
}

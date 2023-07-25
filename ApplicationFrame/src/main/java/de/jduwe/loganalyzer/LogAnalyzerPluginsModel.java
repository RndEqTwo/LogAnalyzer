package de.jduwe.loganalyzer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class LogAnalyzerPluginsModel {

    private List<ILogAnalyzerPlugin> pluginFactoryList;
    private ILogAnalyzerPlugin activePluginFactory;
    private ObservableList<ILogAnalyzerFilter> filterPlugins;
    private ILogAnalyzerFinder activeFinderPlugin;
    private EventManager eventManager;

    public LogAnalyzerPluginsModel(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public List<ILogAnalyzerPlugin> getPluginFactoryList() {
        if(pluginFactoryList == null) {
            pluginFactoryList = new ArrayList<>();
        }
        return pluginFactoryList;
    }

    public void addPluginFactory(ILogAnalyzerPlugin pluginFactory){
        getPluginFactoryList().add(pluginFactory);
    }

    public void setActivePluginFactory(ILogAnalyzerPlugin pluginFactory){
        activePluginFactory = pluginFactory;
    }

    public ObservableList<ILogAnalyzerFilter> getFilterPlugins(){
        if(filterPlugins == null){
            filterPlugins = FXCollections.observableArrayList(new ArrayList<>());
        }
        return filterPlugins;
    }

    public void CreateFilterPluginFromCurrentFactory(){
        if(activePluginFactory != null){
            getFilterPlugins().add(activePluginFactory.createFilter());
        }
    }

    public void RemoveFilterPlugin(ILogAnalyzerFilter filterPlugin){
        getFilterPlugins().remove(filterPlugin);
        System.out.println(getFilterPlugins().size());
    }

    public ILogAnalyzerFinder getActiveFinderPlugin(){
        return activeFinderPlugin;
    }

    public void createActiveFinderPlugin(){
        if(activePluginFactory != null){
            activeFinderPlugin = activePluginFactory.createFinder();
        }
    }

    public void removeActiveFactory() {
        activePluginFactory = null;
    }
}

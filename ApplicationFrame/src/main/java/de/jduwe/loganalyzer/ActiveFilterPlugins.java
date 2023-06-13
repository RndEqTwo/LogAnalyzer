package de.jduwe.loganalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActiveFilterPlugins {


    private List<LogAnalyzerFilterPlugin> currentActivePluginList;

    public ActiveFilterPlugins() {
        currentActivePluginList = new ArrayList<>();
    }

    public void addPlugin(LogAnalyzerFilterPlugin plugin){
        currentActivePluginList.add(plugin);
    }

    public void removePlugin(LogAnalyzerFilterPlugin plugin){
        currentActivePluginList.remove(plugin);
    }

    public List<LogAnalyzerFilterPlugin> getActivePlugins(){
        return Collections.unmodifiableList(currentActivePluginList);
    }


}

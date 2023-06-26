package de.jduwe.loganalyzer;

import javafx.collections.ObservableList;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {

    private String regexFilter = "\\d{2}:\\d{2}:\\d{2}.\\d{3}\\|[^|]*\\|[^|]*\\|[^|]*\\|.*";
    private int ignoreLines = 1;
    private LogAnalyzerPluginsModel pluginsModel;
    private IEventManager eventManager;

    public LogAnalyzer(IEventManager eventManager, LogAnalyzerPluginsModel pluginsModel) {
        this.eventManager = eventManager;
        this.pluginsModel = pluginsModel;
        loadPlugins();
    }

    private void loadPlugins() {
        PluginManager pluginManager = new DefaultPluginManager(Paths.get("Plugins"));
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        List<ILogAnalyzerPluginFactory> pluginFactories = pluginManager.getExtensions(ILogAnalyzerPluginFactory.class);
        for(ILogAnalyzerPluginFactory pluginFactory : pluginFactories){
            pluginFactory.setEventManager(eventManager);
            pluginsModel.addPluginFactory(pluginFactory);
        }
    }

    public List<String> initialScan(List<String> lines){
        for (int i = ignoreLines; i< lines.size(); i++){
            if(!lines.get(i).matches(regexFilter)){
                lines.set(i-1, lines.get(i-1)  + lines.get(i).replaceAll("\\s+", ""));
                lines.remove(i);
                i--;
            }
        }
        return lines;
    }

    public List<String> readFromFile(String pathToFile){
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(pathToFile);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return initialScan(lines);
    }

    public void evalFilters(ObservableList<ILogLine> logFile){
        for(ILogLine line : logFile){
            line.visibility().set(true);
        }

        for (ILogAnalyzerFilterPlugin plugin : pluginsModel.getFilterPlugins()){
            for(ILogLine line : logFile){
                line.visibility().set(!plugin.filter(line.getLineContent()));
            }
            //logFile.removeIf(line -> plugin.filter(line));
        }

    }

}

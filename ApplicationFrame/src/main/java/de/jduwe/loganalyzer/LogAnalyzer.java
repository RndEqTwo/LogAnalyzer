package de.jduwe.loganalyzer;

import javafx.collections.ObservableList;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

    private String regexFilter;
    private int ignoreLines ;
    private LogAnalyzerPluginsModel pluginsModel;
    private IEventManager eventManager;
    private Properties properties;
    private List<String> regexGroups;

    public LogAnalyzer(IEventManager eventManager, LogAnalyzerPluginsModel pluginsModel, Properties properties) {
        this.eventManager = eventManager;
        this.pluginsModel = pluginsModel;
        this.properties = properties;
        regexFilter = properties.getProperty("loganalyzer.filter");
        ignoreLines = Integer.parseInt(properties.getProperty("loganalyzer.ignorelines"));
        analyzeRegexFilter();
        loadPlugins();
    }

    private void analyzeRegexFilter() {
        List<String> regexGroups = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\(\\?<([\\w]+)>");
        Matcher matcher = pattern.matcher(regexFilter);

        while(matcher.find()){
            String match = matcher.group(1);
            regexGroups.add(match);
        }
        this.regexGroups = regexGroups;
    }

    private void loadPlugins() {
        PluginManager pluginManager = new DefaultPluginManager(Paths.get("Plugins"));
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        List<ILogAnalyzerPlugin> pluginFactories = pluginManager.getExtensions(ILogAnalyzerPlugin.class);
        for(ILogAnalyzerPlugin pluginFactory : pluginFactories){
            pluginFactory.setEventManager(eventManager);
            pluginFactory.setProperties(properties);
            pluginsModel.addPluginFactory(pluginFactory);
        }
    }

    public List<ILogLine> initialScan(List<String> lines){
        List<ILogLine> logLines = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexFilter);

        for (int i = ignoreLines; i< lines.size(); i++){
            String line = lines.get(i);
            Matcher matcher = pattern.matcher(line);

            if(matcher.find()){
                ILogLine logLine = new LogLine(line, i+1, regexGroups.get(regexGroups.size() -1));

                for (String namedGroup : regexGroups){
                    String groupContent = matcher.group(namedGroup);
                    logLine.setLogInformation(namedGroup, groupContent);
                }
                logLines.add(logLine);
            }
            else {
                ILogLine lastLine = logLines.get(logLines.size()-1);
                lastLine.appendToLine(line);
            }
        }
        return logLines;
    }

    public List<ILogLine> readFromFile(String pathToFile){
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

        for (ILogAnalyzerFilter plugin : pluginsModel.getFilterPlugins()){
            for(ILogLine line : logFile){
                if(line.visibility().get())
                    line.visibility().set(plugin.filter(line.getLineContent()));
            }
        }
    }

}

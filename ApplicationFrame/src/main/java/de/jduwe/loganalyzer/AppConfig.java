package de.jduwe.loganalyzer;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.springframework.context.annotation.*;

import java.nio.file.Paths;
import java.util.List;

@Configuration()
@ComponentScan()
public class AppConfig {

    private PluginManager pluginManager;

    public AppConfig() {
        pluginManager = new DefaultPluginManager(Paths.get("D:/Jars"));
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
    }

    @Bean
    @Scope("singleton")
    public List<LogAnalyzerPluginFactory> pluginFactories() {
        return pluginManager.getExtensions(LogAnalyzerPluginFactory.class);
    }

    @Bean
    public LogAnalyzer analyzer(){
        return new LogAnalyzer();
    }

    /*
    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
    public MainWindowController mainWindowController(){
        return new MainWindowController();
    }

     */

}

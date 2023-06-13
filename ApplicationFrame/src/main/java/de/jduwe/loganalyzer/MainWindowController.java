package de.jduwe.loganalyzer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    public List<String> originalLoadedText;
    public List<String> textAreaContent;

    private PluginFactoryRegistry pluginFactoryRegistry;
    private ActiveFilterPlugins activeFilterPlugins;
    private LogAnalyzerPluginFactory currentActivePluginFactory;
    private LogAnalyzer logAnalyzer;

    @FXML
    TextArea logFileTextArea;

    @FXML
    VBox AvailablePluginsList;

    @FXML
    FlowPane activePluginChips;

    @FXML
    Pane PlaceholderArea;

    @FXML
    Pane FinderPlacerholderArea;

    @FXML
    Button FindButton;
    private BooleanProperty findButtonActive = new SimpleBooleanProperty(false);

    @FXML
    Button FilterButton;
    private BooleanProperty filterButtonActive = new SimpleBooleanProperty(false);

    public MainWindowController() {
        pluginFactoryRegistry = new PluginFactoryRegistry();
        activeFilterPlugins = new ActiveFilterPlugins();
        logAnalyzer = new LogAnalyzer();
        loadPlugins();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FindButton.visibleProperty().bind(findButtonActive);
        FilterButton.visibleProperty().bind(filterButtonActive);
        for (LogAnalyzerPluginFactory pluginFactory : pluginFactoryRegistry.getPluginFactoryList()){
            Button button = new Button(pluginFactory.getName());
            button.setOnAction(event -> {
                currentActivePluginFactory = pluginFactory;
                findButtonActive.set(pluginFactory.isFinder());
                filterButtonActive.set(pluginFactory.isFilter());
                PlaceholderArea.getChildren().add(pluginFactory.createView());
            });
            AvailablePluginsList.getChildren().add(button);
        }
    }

    public void loadFromFile(){
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testFile.log");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        originalLoadedText = logAnalyzer.initialScan(lines);
        textAreaContent = originalLoadedText;
        syncLogFile();
    }

    private void syncLogFile() {
        String joinedLog = String.join("\n", textAreaContent);
        logFileTextArea.textProperty().set(joinedLog);
    }

    private void createChipFromFilterPlugin(LogAnalyzerFilterPlugin plugin){
        activeFilterPlugins.addPlugin(plugin);
        syncActiveFilterPluginChips();
    }

    private void removeFilterPlugin(LogAnalyzerFilterPlugin plugin){
        activeFilterPlugins.removePlugin(plugin);
        syncActiveFilterPluginChips();
    }

    private void syncActiveFilterPluginChips(){
        List<Chip> chips = new ArrayList<>();
        for (LogAnalyzerFilterPlugin plugin : activeFilterPlugins.getActivePlugins()){
            Chip chip = new Chip(plugin);
            chip.SetButtonAction(event -> {
                removeFilterPlugin(plugin);
            });
            chips.add(chip);
        }
        activePluginChips.getChildren().setAll(chips);
        evalCurrentActivePlugins();
    }

    private ALogFile evalCurrentActivePlugins(){
        ALogFile logFile = new ALogFile(new ArrayList<>(originalLoadedText));
        textAreaContent = logAnalyzer.evalFilters(activeFilterPlugins, logFile).getLines();
        syncLogFile();
        return logFile;
    }

    public void findButtonClicked(){
        LogAnalyzerFinderPlugin plugin = currentActivePluginFactory.createFinderPlugin();
        plugin.find(evalCurrentActivePlugins());
        FinderPlacerholderArea.getChildren().add(plugin.getFinderShowArea());
        clearPluginSettingsArea();
    }

    public void filterButtonClicked(){
        LogAnalyzerFilterPlugin plugin = currentActivePluginFactory.createFilterPlugin();
        createChipFromFilterPlugin(plugin);
        clearPluginSettingsArea();
    }

    private void clearPluginSettingsArea(){
        PlaceholderArea.getChildren().clear();
        findButtonActive.set(false);
        findButtonActive.set(false);
    }

    private void loadPlugins() {
        PluginManager pluginManager = new DefaultPluginManager(Paths.get("Plugins"));
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        List<LogAnalyzerPluginFactory> pluginFactories = pluginManager.getExtensions(LogAnalyzerPluginFactory.class);
        for(LogAnalyzerPluginFactory pluginFactory : pluginFactories){
            pluginFactoryRegistry.registerPluginFactory(pluginFactory);
        }

    }
}

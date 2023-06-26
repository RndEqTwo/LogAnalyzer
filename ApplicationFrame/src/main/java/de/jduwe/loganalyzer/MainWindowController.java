package de.jduwe.loganalyzer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private LogFileModel logFileModel;
    private LogAnalyzer logAnalyzer;
    private LogAnalyzerPluginsModel pluginsModel;
    private EventManager eventManager;

    @FXML
    LogListView logListView;

    @FXML
    VBox AvailablePluginsList;

    @FXML
    FlowPane activePluginChips;

    @FXML
    Pane PluginSettingsArea;

    @FXML
    Pane FinderShowArea;

    @FXML
    Button FindButton;
    private BooleanProperty findButtonActive = new SimpleBooleanProperty(false);

    @FXML
    Button FilterButton;
    private BooleanProperty filterButtonActive = new SimpleBooleanProperty(false);

    public MainWindowController() {
        initializeEventManager();
        pluginsModel = new LogAnalyzerPluginsModel(eventManager);
        logAnalyzer = new LogAnalyzer(eventManager, pluginsModel);
        logFileModel = new LogFileModel();
        logFileModel.getLogFile().addListener((ListChangeListener<ILogLine>) change -> updateLogViewer());
    }

    private void initializeEventManager() {
        eventManager = new EventManager();
        eventManager.registerEvent(EventTypes.SELECT_ROW);
        eventManager.registerEvent(EventTypes.LOAD_PLUGIN_INFO);
        eventManager.subscribe(EventTypes.SELECT_ROW, (eventInfo, eventData) -> {
            try {
                int rowNumber = (int) eventData;
                highlightLogRow(rowNumber);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void updateLogViewer() {
        FilteredList<ILogLine> filteredList = new FilteredList<>(logFileModel.getLogFile(), line -> line.visibility().get());
        logListView.setItems(filteredList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FindButton.visibleProperty().bind(findButtonActive);
        FilterButton.visibleProperty().bind(filterButtonActive);

        for(ILogAnalyzerPluginFactory pluginFactory : pluginsModel.getPluginFactoryList()){
            Button button = new Button(pluginFactory.getName());
            button.setOnAction(event -> {
                clearPluginSettingsArea();
                pluginsModel.setActivePluginFactory(pluginFactory);
                findButtonActive.set(pluginFactory.isFinder());
                filterButtonActive.set(pluginFactory.isFilter());
                PluginSettingsArea.getChildren().add(pluginFactory.createView());
            });
            AvailablePluginsList.getChildren().add(button);
        }

        pluginsModel.getFilterPlugins().addListener((ListChangeListener<ILogAnalyzerFilterPlugin>) change -> {
            logAnalyzer.evalFilters(logFileModel.getLogFile());
            syncActiveFilterPluginChips();
        });
    }

    public void loadFromFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select log file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
        FileChooser.ExtensionFilter logFilter = new FileChooser.ExtensionFilter("Log Files", "*.log");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
        fileChooser.getExtensionFilters().addAll(allFilter, logFilter, txtFilter);

        File selectedFIle = fileChooser.showOpenDialog(logListView.getScene().getWindow());
        logFileModel.setLogFile(logAnalyzer.readFromFile(selectedFIle.getAbsolutePath()), result -> updateLogViewer());
    }

    private void syncActiveFilterPluginChips(){
        List<Chip> chips = new ArrayList<>();
        for (ILogAnalyzerFilterPlugin plugin : pluginsModel.getFilterPlugins()){
            Chip chip = new Chip(plugin);
            chip.SetButtonAction(event -> pluginsModel.RemoveFilterPlugin(plugin));
            chips.add(chip);
        }
        activePluginChips.getChildren().setAll(chips);
    }

    public void findButtonClicked() {
        pluginsModel.createActiveFinderPlugin();
        Region finderResult = pluginsModel.getActiveFinderPlugin().find(logFileModel.getLogFile());
        FinderShowArea.getChildren().add(finderResult);
        finderResult.prefHeightProperty().bind(FinderShowArea.heightProperty());
        finderResult.prefWidthProperty().bind(FinderShowArea.widthProperty());
        clearPluginSettingsArea();
    }

    public void filterButtonClicked(){
        pluginsModel.CreateFilterPluginFromCurrentFactory();
        clearPluginSettingsArea();
    }

    private void highlightLogRow(int rowNumber){
        logListView.getSelectionModel().select(rowNumber);
        logListView.scrollTo(rowNumber);
    }

    private void clearPluginSettingsArea(){
        PluginSettingsArea.getChildren().clear();
        findButtonActive.set(false);
        filterButtonActive.set(false);
        pluginsModel.removeActiveFactory();
    }
}

package de.jduwe.loganalyzer.loglevelplugin;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigView extends VBox {

    private List<LogLevel> logLevels;
    GridPane grid;

    public ConfigView() {
        logLevels = new ArrayList<>();
        Label label = new Label("Log Level Plugins");
        getChildren().add(label);

        grid = new GridPane();
        grid.setPadding(new Insets(5));

        ColumnConstraints labelColumn = new ColumnConstraints();
        labelColumn.setHgrow(Priority.ALWAYS);
        ColumnConstraints textFieldColumn = new ColumnConstraints();
        textFieldColumn.setHalignment(HPos.RIGHT);
        ColumnConstraints checkboxColumn = new ColumnConstraints();
        checkboxColumn.setHalignment(HPos.RIGHT);

        grid.getColumnConstraints().addAll(labelColumn, textFieldColumn, checkboxColumn);

        newLogLevel("Info");
        newLogLevel("Warn");
        newLogLevel("Error");
        newLogLevel("Debug");
        getChildren().add(grid);
    }

    private void newLogLevel(String name){
        LogLevel level = new LogLevel(name);
        Label label = new Label(name);
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(level.filterTextProperty());
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().bindBidirectional(level.selectedProperty());
        logLevels.add(level);

        int row = grid.getRowCount();
        grid.add(label, 0, row);
        grid.add(textField, 1, row);
        grid.add(checkBox, 2, row);
    }

    public List<String> getFilterTexts(){
        List<String> filterTexts = logLevels.stream()
                .filter(logLevel -> logLevel.selectedProperty().get())
                .map(logLevel -> logLevel.filterTextProperty().get())
                .collect(Collectors.toList());
        return filterTexts;
    }

}

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

    private List<HBox> logLevels;

    public ConfigView() {
        logLevels = new ArrayList<>();
        Label label = new Label("Log Level Plugins");
        getChildren().add(label);
        getChildren().add(setupLogLevel("Info", "INFO"));
        getChildren().add(setupLogLevel("Warn", "WARN"));
        getChildren().add(setupLogLevel("Error", "ERROR"));
        getChildren().add(setupLogLevel("Debug", "DEBUG"));

    }

    private HBox setupLogLevel(String name, String initialValue){
        HBox hBox = new HBox();
        Label label = new Label(name);
        TextField field = new TextField(initialValue);
        CheckBox checkBox = new CheckBox(initialValue);
        hBox.getChildren().addAll(label, field, checkBox);
        logLevels.add(hBox);
        return hBox;
    }



    public List<String> getFilterTexts(){
        List<String> filterTexts = logLevels.stream()
                .filter(hbox -> ((CheckBox) hbox.getChildren().get(2)).isSelected())
                .map(hBox -> ((TextField) hBox.getChildren().get(1)).getText())
                .collect(Collectors.toList());
        return filterTexts;
    }

}

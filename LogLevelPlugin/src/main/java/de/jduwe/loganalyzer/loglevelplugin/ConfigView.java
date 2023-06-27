package de.jduwe.loganalyzer.loglevelplugin;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ConfigView extends VBox {

    private List<CheckBox> checkboxes;

    public ConfigView() {
        checkboxes = new ArrayList<>();
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
        checkboxes.add(checkBox);
        hBox.getChildren().addAll(label, field, checkBox);
        return hBox;
    }
}

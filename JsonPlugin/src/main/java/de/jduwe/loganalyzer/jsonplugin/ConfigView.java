package de.jduwe.loganalyzer.jsonplugin;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;


public class ConfigView extends VBox {

    public ConfigView() {
        setAlignment(Pos.CENTER);
        Label label = new Label("Json Plugin");
        label.setAlignment(Pos.CENTER);
        getChildren().add(label);
    }

}

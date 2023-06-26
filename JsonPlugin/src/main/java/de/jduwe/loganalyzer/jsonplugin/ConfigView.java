package de.jduwe.loganalyzer.jsonplugin;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;


public class ConfigView extends VBox {
    private CheckBox removeLogPrefix;

    public ConfigView() {
        Label label = new Label("Filter Json?");
        removeLogPrefix = new CheckBox("Json");

        getChildren().addAll(label, removeLogPrefix);
        setAlignment(Pos.CENTER);

    }

    public boolean getCheckboxValue(){
        return removeLogPrefix.isSelected();
    }

}

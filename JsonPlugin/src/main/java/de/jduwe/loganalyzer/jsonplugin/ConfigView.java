package de.jduwe.loganalyzer.jsonplugin;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;


public class ConfigView extends VBox {
    private CheckBox checkbox;

    public ConfigView() {
        Label label = new Label("Filter Json?");
        checkbox = new CheckBox("Json");

        getChildren().addAll(label, checkbox);
        setAlignment(Pos.CENTER);

    }

    public boolean getCheckboxValue(){
        return checkbox.isSelected();
    }

}

package de.jduwe.loganalyzer.stringplugin;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConfigView extends VBox {
    private String filterText;
    private Label label2;

    public ConfigView() {
        Label label = new Label("Filter String");
        label2 = new Label(filterText);
        TextField field = new TextField();

        field.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filterText = newValue;
            label2.textProperty().set(newValue);
        });

        getChildren().addAll(label, label2, field);
        setAlignment(Pos.CENTER);
    }

    public void Update(String filterText){
        this.filterText = filterText;
    }

    public String getFilterText() {
        return filterText;
    }
}

package de.jduwe.loganalyzer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


public class Chip extends HBox {
    private ILogAnalyzerFilter plugin;
    private Button button;
    private Label label;

    public Chip(ILogAnalyzerFilter plugin) {
        this.plugin = plugin;
        label = new Label(plugin.getDisplayName());
        button = new Button("X");

        getChildren().addAll(label, button);
        getStyleClass().add("chip");
        setAlignment(Pos.CENTER);
    }

    public void SetButtonAction(EventHandler<ActionEvent> event){
        button.setOnAction(event);
    }

    public void SetBackgroundCLickAction(EventHandler<MouseEvent> event){
        this.setOnMouseClicked(event);
    }
}

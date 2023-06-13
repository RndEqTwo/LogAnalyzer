package de.jduwe.loganalyzer;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class OldChip extends Region {
    private Rectangle background;
    private Text label;
    private Button deleteButton;

    private static final double DEFAULT_MAX_WIDTH = 150;
    private static final double DEFAULT_MAX_HEIGHT = 30;

    private double maxWidth = DEFAULT_MAX_WIDTH;
    private double maxHeight = DEFAULT_MAX_HEIGHT;

    public OldChip(String text){

        background = new Rectangle();
        background.setArcWidth(15);
        background.setArcHeight(15);
        background.setFill(Color.LIGHTGRAY);

        label = new Text(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        label.setFill(Color.BLACK);

        deleteButton = new Button("X");
        deleteButton.setStyle("-fx-background-color: transparent; -fx-text-fill: red;");

        setPadding(new Insets(2));
        HBox inside = new HBox();
        inside.getChildren().addAll(label, deleteButton);


        getChildren().addAll(background, inside);



        setOnMouseClicked(mouseEvent -> {
            background.setFill(Color.DODGERBLUE);
            mouseEvent.consume();
        });

        setOnMouseEntered(mouseEvent -> {
            background.setFill(Color.LIGHTBLUE);
            mouseEvent.consume();
        });

        setOnMouseExited(mouseEvent -> {
            background.setFill(Color.LIGHTGRAY);
            mouseEvent.consume();
        });
    }

    @Override
    protected double computePrefWidth(double height) {
        return Math.min(super.computePrefWidth(height), maxWidth);
    }

    @Override
    protected double computePrefHeight(double width) {
        return Math.min(super.computePrefHeight(width), maxHeight);
    }

    @Override
    protected void layoutChildren() {
        double width = Math.min(getWidth(), maxWidth);
        double height = Math.min(getHeight(), maxHeight);
        background.setWidth(width);
        background.setHeight(height);

        double buttonSize = label.getFont().getSize();
        deleteButton.setPrefSize(buttonSize, buttonSize);

        double availableWidth = width - getInsets().getLeft() - getInsets().getRight();
        double labelWidth = Math.min(label.getLayoutBounds().getWidth(), availableWidth - buttonSize - 4);

        label.setWrappingWidth(labelWidth);
        label.setLayoutX(getInsets().getLeft());
        label.setLayoutY((height - label.getLayoutBounds().getHeight()) / 2);

        deleteButton.setLayoutX(getInsets().getLeft() + labelWidth + 4);
        deleteButton.setLayoutY((height - buttonSize) / 2);

    }
}

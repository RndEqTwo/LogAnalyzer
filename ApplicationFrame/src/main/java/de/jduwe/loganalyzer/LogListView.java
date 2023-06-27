package de.jduwe.loganalyzer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class LogListView extends ListView<ILogLine> {

    public LogListView() {
        getSelectionModel().select(1);
        setCellFactory(param -> new ListCell<ILogLine>() {
            @Override
            protected void updateItem(ILogLine item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null || !item.visibility().get()){
                    setText(null);
                }
                else {
                    setText(item.getIndex() + ":     " + item.getLineContent());
                }
            }
        });
    }
    /*
    final class GridViewListCell extends ListCell<HBox>{
        @Override
        protected void updateItem(HBox item, boolean empty) {
            super.updateItem(item, empty);
            if(empty){
                setGraphic(null);
            }
            else {
                GridPane gridPane = new GridPane();
                gridPane.setPadding(new Insets(5));

                ColumnConstraints labelColumn = new ColumnConstraints();
                labelColumn.setHgrow(Priority.ALWAYS);
                ColumnConstraints textFieldColumn = new ColumnConstraints();
                textFieldColumn.setHalignment(HPos.RIGHT);
                ColumnConstraints checkboxColumn = new ColumnConstraints();
                checkboxColumn.setHalignment(HPos.RIGHT);

                gridPane.getColumnConstraints().addAll(labelColumn, textFieldColumn, checkboxColumn);

                gridPane.add(item.getChildren().get(0), 0, 0);
                gridPane.add(item.getChildren().get(1), 0, 1);
                gridPane.add(item.getChildren().get(2), 0, 2);

                setGraphic(gridPane);
            }
        }
    }

     */
}

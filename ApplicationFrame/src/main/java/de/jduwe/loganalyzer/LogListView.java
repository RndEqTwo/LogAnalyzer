package de.jduwe.loganalyzer;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

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
}

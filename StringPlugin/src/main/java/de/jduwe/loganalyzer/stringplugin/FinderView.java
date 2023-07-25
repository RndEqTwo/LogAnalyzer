package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.EventTypes;
import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;

import java.util.List;

public class FinderView extends ListView<ILogLine> {

    private ObservableList<ILogLine> entries;

    public FinderView(IEventManager eventManager, List<ILogLine> resultEntries) {
        entries = FXCollections.observableArrayList(resultEntries);
        setItems(entries);
        setCellFactory( param -> new ListCell<ILogLine>() {
            @Override
            protected void updateItem(ILogLine item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null){
                    setText(null);
                }
                else {
                    setText(item.getIndex() + " : " + item.getLineContent());
                }
            }
        });
        setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){
                ILogLine logline = getSelectionModel().getSelectedItem();
                eventManager.triggerEvent(EventTypes.SELECT_ROW, this, logline);
            }
        });
    }
}

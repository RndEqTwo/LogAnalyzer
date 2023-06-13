package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.AFinderResultEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class FinderView extends ListView<AFinderResultEntry> {

    private ObservableList<AFinderResultEntry> entries;

    public FinderView(StringFinderResult finderResult) {
        entries = FXCollections.observableArrayList(finderResult.getFilterResultEntries());
        setItems(entries);
        setCellFactory( param -> new ListCell<AFinderResultEntry>() {
            @Override
            protected void updateItem(AFinderResultEntry item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null){
                    setText(null);
                }
                else {
                    setText(item.getDisplayText());
                }
            }
        });
    }

}

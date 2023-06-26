package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.IEventManager;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.List;

public class FinderResultShowArea extends TreeView<String> {

    TreeItem<String> rootItem;
    IEventManager eventManager;

    public FinderResultShowArea(IEventManager eventManager, List<FinderEntry> entries) {
        this.eventManager = eventManager;
        rootItem = new TreeItem<>("root");
        for (FinderEntry entry : entries){
            rootItem.getChildren().add(entry.getRootItem());
        }
        setRoot(rootItem);
        setShowRoot(false);
        /*
        setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){
                ILogLine logline = getSelectionModel().getSelectedItem();
                eventManager.triggerEvent(EventTypes.SELECT_ROW, this, logline.getIndex());
            }
        });
         */
    }
}

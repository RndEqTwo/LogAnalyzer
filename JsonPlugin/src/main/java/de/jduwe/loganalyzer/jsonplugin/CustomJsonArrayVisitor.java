package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.JSONParser;
import javafx.scene.control.TreeItem;

public class CustomJsonArrayVisitor extends CustomJsonVisitor {

    public CustomJsonArrayVisitor(TreeItem<String> rootItem) {
        super(rootItem);
    }

    @Override
    protected String getParentItemText(TreeItem<String> parentItem, String text) {
        return text;
    }
}

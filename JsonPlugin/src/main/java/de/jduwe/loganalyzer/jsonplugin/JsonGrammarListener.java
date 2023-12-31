package de.jduwe.loganalyzer.jsonplugin;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;
import de.jduwe.loganalyzer.jsonplugin.antlr.*;

public class JsonGrammarListener extends JSONBaseListener {

    private List<TreeItem<String>> treeItemList;

    public JsonGrammarListener() {
        treeItemList = new ArrayList<>();
    }

    @Override
    public void enterPair(JSONParser.PairContext ctx) {
        String key = ctx.key().getText();
        String value = ctx.value().getText();
        TreeItem<String> item = new TreeItem<>(key + " : " + value );
        treeItemList.add(item);
    }

    public List<TreeItem<String>> getTreeItemList() {
        return treeItemList;
    }
}

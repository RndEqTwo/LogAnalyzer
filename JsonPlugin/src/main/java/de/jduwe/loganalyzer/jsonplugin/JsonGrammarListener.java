package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.JSONBaseListener;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONParser;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

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

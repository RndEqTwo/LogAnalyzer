/*package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.JSONBaseVisitor;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONParser;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyJsonVisitor extends JSONBaseVisitor<TreeItem<String>> {

    private TreeItem<String> rootItem;
    private TreeItem<String> currentParent;


    public MyJsonVisitor() {
        rootItem = new TreeItem<>("jsonRoot");
        currentParent = rootItem;
    }

    public TreeItem<String> getRootItem() {
        return rootItem;
    }

    /*
    @Override
    protected TreeItem<String> aggregateResult(TreeItem<String> aggregate, TreeItem<String> nextResult) {
        // Example: Return the result of the current visitation if it's not null
        if (nextResult != null) {
            return nextResult;
        }

        // If the result is null, return the accumulated result as-is
        return aggregate;
    }



    @Override
    public TreeItem<String> visitJson(JSONParser.JsonContext ctx) {
        TreeItem<String> jsonNode = new TreeItem<>("json");
        jsonNode.getChildren().addAll(visitChildren(ctx));
        rootItem = jsonNode;
        return jsonNode;
    }

    @Override
    public TreeItem<String> visitObject(JSONParser.ObjectContext ctx) {
        TreeItem<String> objectNode = new TreeItem<>("object");

        for(JSONParser.PairContext child : ctx.pair()){
            TreeItem<String> pair = visit(child);
            objectNode.getChildren().add(pair);
        }
        return objectNode;
    }

    @Override
    public TreeItem<String> visitPair(JSONParser.PairContext ctx) {
        String keyNode = ctx.key().getText();
        JSONParser.ValueContext valueContext = ctx.value();
        TreeItem<String> pairNode = new TreeItem<>(keyNode);
        TreeItem<String> valueNode = visit(valueContext);
        pairNode.getChildren().add(valueNode);
        return pairNode;
    }

    @Override
    public TreeItem<String> visitArray(JSONParser.ArrayContext ctx) {
        TreeItem<String> arrayNode = new TreeItem<>("array");

        for(JSONParser.ValueContext child : ctx.value()){
            TreeItem<String> valueItem = visit(child);
            arrayNode.getChildren().add(valueItem);
        }

        return arrayNode;
    }

    @Override
    public TreeItem<String> visitValue(JSONParser.ValueContext ctx) {
        TerminalNode stringNode = ctx.STRING();
        TerminalNode numberNode = ctx.NUMBER();

        if (stringNode != null) {
            return new TreeItem<>(stringNode.getText());
        } else if (numberNode != null) {
            return new TreeItem<>(numberNode.getText());
        } else {
            TreeItem<String> valueNode = new TreeItem<>(ctx.getText());
            valueNode.getChildren().addAll(visitChildren(ctx));
            return valueNode;
        }
    }
}
*/
package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.jsonplugin.antlr.JSONBaseVisitor;
import de.jduwe.loganalyzer.jsonplugin.antlr.JSONParser;
import javafx.scene.control.TreeItem;

public class CustomJsonVisitor extends JSONBaseVisitor<Void> {

    private TreeItem<String> parentItem;

    public CustomJsonVisitor(TreeItem<String> rootItem) {
        this.parentItem = rootItem;
    }

    public TreeItem<String> getParentItem() {
        return parentItem;
    }

    @Override
    public Void visitObject(JSONParser.ObjectContext ctx) {

        for (JSONParser.PairContext child : ctx.pair()) {
            CustomJsonVisitor visitor = new CustomJsonVisitor(parentItem);
            visitor.visit(child);
        }
        return null;
    }

    @Override
    public Void visitPair(JSONParser.PairContext ctx) {
        String keyNode = ctx.key().getText();
        TreeItem<String> pairNode = new TreeItem<>(keyNode);
        CustomJsonVisitor visitor = new CustomJsonVisitor(pairNode);

        visitor.visit(ctx.value());
        parentItem.getChildren().add(pairNode);
        return null;
    }

    @Override
    public Void visitArray(JSONParser.ArrayContext ctx) {
        for (JSONParser.ValueContext child : ctx.value()) {
            TreeItem<String> childItem = new TreeItem<>(child.getText());
            CustomJsonArrayVisitor visitor = new CustomJsonArrayVisitor(childItem);
            visitor.visit(child);
            parentItem.getChildren().add(childItem);
        }
        return null;
    }

    @Override
    public Void visitPrimitive(JSONParser.PrimitiveContext ctx) {
        parentItem.setValue(getParentItemText(parentItem, ctx.getText()));
        return null;
    }

    protected String getParentItemText(TreeItem<String> parentItem, String text){
        return parentItem.getValue() + " : " + text;
    }

}
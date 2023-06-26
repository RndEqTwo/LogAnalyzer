package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.ILogLine;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.tree.ParseTree;

public class FinderEntry {

    private ILogLine line;
    private TreeItem<String> rootItem;

    public FinderEntry(ILogLine line, TreeItem<String>  parseTree) {
        this.line = line;
        this.rootItem = parseTree;
    }

    public ILogLine getLine() {
        return line;
    }

    public TreeItem<String>  getRootItem() {
        return rootItem;
    }
}

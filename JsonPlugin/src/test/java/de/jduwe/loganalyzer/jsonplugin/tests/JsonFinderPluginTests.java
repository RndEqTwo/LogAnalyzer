package de.jduwe.loganalyzer.jsonplugin.tests;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.jsonplugin.CustomJsonVisitor;
import de.jduwe.loganalyzer.jsonplugin.JsonAnalyzer;
import de.jduwe.loganalyzer.jsonplugin.JsonFinder;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class JsonFinderPluginTests {

    private String resourcesFolder;
    private final JsonFinder pluginUnderTest;
    private Properties propertiesMock;
    public JsonFinderPluginTests() {
        IEventManager eventManager = Mockito.mock(IEventManager.class);
        propertiesMock = Mockito.mock(Properties.class);
        this.pluginUnderTest = new JsonFinder(eventManager, propertiesMock);
    }

    @Before
    public void init() {
        resourcesFolder = System.getProperty("user.dir") + "\\src\\test\\resources";
    }


    @Test
    public void printTreeItemTree(){
        String line = "";
        Path path = Paths.get(resourcesFolder + "/validJson.txt");

        try {
            line = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonAnalyzer analyzer = new JsonAnalyzer(propertiesMock);
        ParseTree parseTree = analyzer.parse(line);

        if(parseTree != null){
            TreeItem<String> item = new TreeItem<>("root");
            CustomJsonVisitor visitor = new CustomJsonVisitor(item);
            visitor.visit(parseTree);
            printTreeItem(item, " ;");
        }
        else{
            System.out.println("ParseTree is null");
        }
    }


    public static void printTreeItem(TreeItem<String> treeItem, String indent) {
        System.out.println(indent + treeItem.getValue());

        for (TreeItem<String> child : treeItem.getChildren()) {
            printTreeItem(child, indent + "  ");
        }
    }

}

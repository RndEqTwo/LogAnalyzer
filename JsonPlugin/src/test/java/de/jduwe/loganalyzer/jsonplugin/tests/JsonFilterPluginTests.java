package de.jduwe.loganalyzer.jsonplugin.tests;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.jsonplugin.JsonFilterPlugin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFilterPluginTests {

    private String resourcesFolder;
    private final JsonFilterPlugin pluginUnderTest;

    public JsonFilterPluginTests() {
        IEventManager eventManager = Mockito.mock(IEventManager.class);

        this.pluginUnderTest = new JsonFilterPlugin(eventManager);
    }

    @Before
    public void init() {
        resourcesFolder = System.getProperty("user.dir") + "\\src\\test\\resources";
    }

    @Test
    public void filterIdentifysValidJsonCorrectly() {
        String testLine = null;
        Path path = Paths.get(resourcesFolder + "/validJson.txt");

        try {
            testLine = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(testLine != null){
            Boolean output = pluginUnderTest.filter(testLine);
            Assert.assertEquals(false, output);
        }

    }

    @Test
    public void filterIdentifysImvalidJsonCorrectly(){
        String testLine = null;
        Path path = Paths.get(resourcesFolder + "/invalidJson.txt");

        try {
            testLine = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(testLine != null){
            Boolean output = pluginUnderTest.filter(testLine);
            Assert.assertEquals(true, output);
        }
    }
}

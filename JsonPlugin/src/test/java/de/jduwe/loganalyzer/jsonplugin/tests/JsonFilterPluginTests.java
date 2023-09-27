package de.jduwe.loganalyzer.jsonplugin.tests;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.jsonplugin.JsonFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class JsonFilterPluginTests {

    private String resourcesFolder;
    private final JsonFilter pluginUnderTest;

    public JsonFilterPluginTests() {
        IEventManager eventManager = Mockito.mock(IEventManager.class);
        Properties propertiesMock = Mockito.mock(Properties.class);
        Mockito.when(propertiesMock.getProperty(Mockito.anyString())).thenReturn("Content");

        this.pluginUnderTest = new JsonFilter(eventManager, propertiesMock);
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
            Assert.assertEquals(true, output);
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

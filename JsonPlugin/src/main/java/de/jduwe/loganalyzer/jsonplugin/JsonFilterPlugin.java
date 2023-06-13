package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.ALogFile;
import de.jduwe.loganalyzer.LogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.LogAnalyzerPluginFactory;
import javafx.scene.layout.Region;

import java.util.regex.Pattern;

public class JsonFilterPlugin implements LogAnalyzerFilterPlugin {


    @Override
    public String getDisplayName() {
        return "Json Filter";
    }

    @Override
    public LogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return null;
    }

    @Override
    public ALogFile filter(ALogFile logFile) {

        String regex = "\\{.*\\}";
        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        logFile.getLines().removeIf(element -> !pattern.matcher(element).find());


        return logFile;
    }
}

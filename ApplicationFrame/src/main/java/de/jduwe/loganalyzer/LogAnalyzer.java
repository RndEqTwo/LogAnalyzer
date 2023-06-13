package de.jduwe.loganalyzer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LogAnalyzer {

    private String regexFilter = "\\d{2}:\\d{2}:\\d{2}.\\d{3}\\|\\[.+\\]\\|[A-Z]+\\s*\\|\\w+\\|.+";
    private int ignoreLines = 1;

    public List<String> initialScan(List<String> lines){
        for (int i = ignoreLines; i< lines.size(); i++){
            if(!lines.get(i).matches(regexFilter)){
                String currentLine = lines.get(i);
                String previousLine = lines.get(i-1);
                lines.set(i-1, lines.get(i-1)  + lines.get(i).replaceAll("\\s+", ""));
                lines.remove(i);
                i--;
            }
        }
        writeToFile(lines, "output.txt");
        return lines;
    }

    public ALogFile evalFilters(ActiveFilterPlugins activeFilterPlugins, ALogFile logFile){

        for (LogAnalyzerFilterPlugin plugin : activeFilterPlugins.getActivePlugins()){
            logFile = plugin.filter(logFile);
        }
        return logFile;
    }

    private void writeToFile(List<String> lines, String fileName){

        // Delete the file if it exists
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Existing file deleted successfully.");
            } else {
                System.err.println("Failed to delete the existing file.");
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String str : lines) {
                writer.write(str);
                writer.newLine();
            }
            System.out.println("Strings successfully written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing strings to the file: " + e.getMessage());
        }
    }

}

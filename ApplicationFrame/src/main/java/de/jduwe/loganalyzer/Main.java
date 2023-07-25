package de.jduwe.loganalyzer;

import javafx.application.Application;


public class Main {

    public static void main (String[] args){
        System.out.println(System.getProperty("de.jduwe.loganalyzer.test", "test"));
        Application.launch(LogAnalyzerFxApplication.class, args);
    }
}

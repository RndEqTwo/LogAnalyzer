package de.jduwe.loganalyzer.logfilegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class LogGenerator {

    private static String JsonFile;
    private static String xmlFile;

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(LogGenerator.class);
        Random rand = new Random();

        try {
            JsonFile = new String(Files.readAllBytes(Paths.get("src/main/resources/sample.json")));
            xmlFile = new String(Files.readAllBytes(Paths.get("src/main/resources/sample.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i<10000 ;i++){
            double randomNumber = rand.nextDouble();

            if (randomNumber < 0.01){
                logger.debug(JsonFile);
                System.out.println(randomNumber);
            }
            else if (randomNumber > 0.01 && randomNumber <= 0.02){
                logger.debug(xmlFile);
                System.out.println(randomNumber);
            }
            else{
                logger.info(generateLogText());
            }

        }

    }

    private static String generateLogText(){
        return "Hello WOrld";
    }
}

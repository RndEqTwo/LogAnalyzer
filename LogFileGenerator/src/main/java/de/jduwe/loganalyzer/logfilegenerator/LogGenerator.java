package de.jduwe.loganalyzer.logfilegenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.andreinc.mockneat.MockNeat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class LogGenerator {

    private static String JsonFile;
    private static String xmlFile;



    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(LogGenerator.class);
        Random rand = new Random();
        MockNeat mockNeat = MockNeat.threadLocal();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            //JsonFile = new String(Files.readAllBytes(Paths.get("C:/Users/jadu/IdeaProjects/LogAnalyzer/LogFileGenerator/src/main/resources/sample.json")));
            xmlFile = new String(Files.readAllBytes(Paths.get("C:/Users/Jan/IdeaProjects/LogAnalyzer/LogFileGenerator/src/main/resources/sample.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (int i = 0; i<5000 ;i++){
            double randomNumber = rand.nextDouble();

            if (randomNumber < 0.01){
                String json = mockNeat
                        .reflect(UserProfile.class)
                        .field("name", mockNeat.names().full())
                        .field("userName", mockNeat.users())
                        .field("email", mockNeat.emails())
                        .field("profiles",
                                mockNeat.reflect(Profile.class)
                                        .field("profileId", mockNeat.ints().range(100, 1000))
                                        .field("profileAdded", mockNeat.localDates().toUtilDate())
                                        .list(2))
                        .map(gson::toJson) /* Transforms the UserProfile class into a 'pretty' json. */
                        .val();
                logger.debug(json);
                System.out.println(randomNumber);
            }
            else if (randomNumber > 0.01 && randomNumber <= 0.02){
                logger.debug(xmlFile);
                System.out.println(randomNumber);
            }
            else if (randomNumber > 0.02 && randomNumber <= 0.05){
                logger.error("ERROR");
                System.out.println(randomNumber);
            }
            else if (randomNumber > 0.05 && randomNumber <= 0.1){
                logger.warn("Warning");
                System.out.println(randomNumber);
            }
            else{
                logger.info(generateLogText());
            }

        }

    }

    private static String generateLogText(){
        return "Normal Operation";
    }
}

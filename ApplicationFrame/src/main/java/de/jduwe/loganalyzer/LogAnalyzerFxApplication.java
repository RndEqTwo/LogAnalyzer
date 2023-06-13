package de.jduwe.loganalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class LogAnalyzerFxApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL location = getClass().getResource("MainWindow.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("LogAnalyzer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

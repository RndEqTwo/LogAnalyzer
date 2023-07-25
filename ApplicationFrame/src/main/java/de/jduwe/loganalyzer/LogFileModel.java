package de.jduwe.loganalyzer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LogFileModel {

    private ObservableList<ILogLine> logFile;

    public ObservableList<ILogLine> getLogFile() {
        if(logFile == null){
            logFile = FXCollections.observableArrayList(new ArrayList<>());
        }
        return logFile;
    }

    public void setLogFile(List<ILogLine> logFileList, Consumer<ILogLine> callback){
        getLogFile().clear();
        for(int i = 0; i<logFileList.size(); i++){
            ILogLine line = logFileList.get(i);
            line.visibility().addListener((observable, oldValue, newValue) -> callback.accept(line));
            getLogFile().add(line);
        }
    }

}

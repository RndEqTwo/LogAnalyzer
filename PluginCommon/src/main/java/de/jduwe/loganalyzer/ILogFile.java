package de.jduwe.loganalyzer;

import java.util.List;

public interface ILogFile {
    List<ILogLine> getLogLines();
    List<String> getLogLineNamedGroups();
}

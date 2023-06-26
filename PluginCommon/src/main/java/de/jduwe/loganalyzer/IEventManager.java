package de.jduwe.loganalyzer;

import java.util.function.BiConsumer;

public interface IEventManager {

    void registerEvent(EventTypes eventType);
    void subscribe(EventTypes eventType, BiConsumer<Object, Object> callback);
    void triggerEvent(EventTypes eventType, Object eventInfo, Object eventData);
}

package de.jduwe.loganalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class EventManager implements IEventManager{

    Map<EventTypes, List<BiConsumer<Object, Object>>> eventDictionary;

    public EventManager() {
        eventDictionary = new HashMap<>();
    }

    public void registerEvent(EventTypes eventType){
        eventDictionary.putIfAbsent(eventType, new ArrayList<>());
    }

    public void subscribe(EventTypes type, BiConsumer<Object, Object> callback){
        eventDictionary.get(type).add(callback);
    }

    public void triggerEvent(EventTypes type, Object arg1, Object arg2){
        List<BiConsumer<Object, Object>> callbacks = eventDictionary.get(type);
        for (BiConsumer<Object, Object> callback : callbacks){
            callback.accept(arg1, arg2);
        }
    }
}

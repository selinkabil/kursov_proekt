package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Hall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Manages events in the ticket system.
 */
public class EventManager {
    // List to store events
    private static List<Event> events = new ArrayList<>();

    /**
     * Constructs a new EventManager.
     */
    public EventManager() {
    }

    /**
     * Gets the list of events.
     *
     * @return the list of events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Adds an event to the list.
     *
     * @param event the event to add
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Checks if an event with the same date and hall already exists.
     *
     * @param date the date of the event
     * @param hall the hall of the event
     * @return true if a duplicate event exists, false otherwise
     */
    public boolean duplicateEventCheck(Date date, Hall hall) {
        for (Event existingEvent : events) {
            if (existingEvent.getDate().equals(date) && existingEvent.getHall().equals(hall)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds an event by its date and name.
     *
     * @param date the date of the event
     * @param name the name of the event
     * @return the event if found, otherwise null
     */
    public Event findEvent(Date date, String name) {
        for (Event e : events) {
            if (e.getDate().equals(date) && e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
}

package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.util.Date;
import java.util.Objects;

/**
 * Represents an event.
 */
public class Event {
    private String name;
    private Date date;
    private Hall hall;

    /**
     * Constructs a new Event with the specified name, date, and hall.
     *
     * @param name the name of the event
     * @param date the date of the event
     * @param hall the hall associated with the event
     * @throws InvalidArgument if the name is null or empty, or if the date or hall is null
     */
    public Event(String name, Date date, Hall hall) throws InvalidArgument {
        setDate(date);
        setHall(hall);
        setName(name);
    }

    /**
     * Gets the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event.
     *
     * @param name the name of the event
     * @throws InvalidArgument if the name is null or empty
     */
    public void setName(String name) throws InvalidArgument {
        if (name == null || name.isEmpty()) {
            throw new InvalidArgument("Event name cannot be null or empty");
        }
        this.name = name;
    }

    /**
     * Gets the date of the event.
     *
     * @return the date of the event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the event.
     *
     * @param date the date of the event
     * @throws InvalidArgument if the date is null
     */
    public void setDate(Date date) throws InvalidArgument {
        if (date == null) {
            throw new InvalidArgument("Event date cannot be null");
        }
        this.date = date;
    }

    /**
     * Gets the hall associated with the event.
     *
     * @return the hall associated with the event
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * Sets the hall associated with the event.
     *
     * @param hall the hall associated with the event
     * @throws InvalidArgument if the hall is null
     */
    public void setHall(Hall hall) throws InvalidArgument {
        if (hall == null) {
            throw new InvalidArgument("Event hall cannot be null");
        }
        this.hall = hall;
    }

    /**
     * Compares this Event to the specified object. The result is true if and only if the argument is not null and is an Event object with the same name, date, and hall.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name) && Objects.equals(date, event.date) && Objects.equals(hall, event.hall);
    }

    /**
     * Returns a hash code value for the Event.
     *
     * @return a hash code value for this Event
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, date, hall);
    }

    /**
     * Returns a string representation of the Event.
     *
     * @return a string representation of the Event
     */
    @Override
    public String toString() {
        return name + " ";
    }
}

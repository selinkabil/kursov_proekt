package bg.tu_varna.sit.a2.f22621625.models;

import java.util.Date;
import java.util.Objects;

/**
 * Represents an event, which includes a name, date, and associated hall.
 */
public class Event {
    private String name;
    private Date date;
    private Hall hall;

    /**
     * Constructs a new event with the specified name, date, and hall.
     *
     * @param name the name of the event
     * @param date the date of the event
     * @param hall the hall associated with the event
     */
    public Event(String name, Date date, Hall hall) {
        this.name = name;
        this.date = date;
        this.hall = hall;
    }

    /**
     * Checks if this event is equal to another object. Two events are considered equal
     * if they have the same name, date, and hall.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!Objects.equals(name, event.name)) return false;
        if (!Objects.equals(date, event.date)) return false;
        return Objects.equals(hall, event.hall);
    }

    /**
     * Generates a hash code value for this event.
     *
     * @return the hash code value for this event
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        return result;
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
     * Gets the date of the event.
     *
     * @return the date of the event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the hall associated with the event.
     *
     * @return the hall associated with the event
     */
    public Hall getHalls() {
        return hall;
    }

    /**
     * Returns a string representation of the event.
     *
     * @return a string representation of the event
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nEvent\n");
        sb.append("name: '").append(name).append("'");
        sb.append(",\n");
        sb.append("date: '").append(date).append("'");
        sb.append(",\n");
        sb.append("hall: '").append(hall).append("'");
        return sb.toString();
    }
}

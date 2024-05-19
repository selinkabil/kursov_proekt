package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The TicketHandle class manages events, tickets, and halls.
 * It provides functionality to find events, tickets, halls, and to parse dates.
 */
public class TicketHandle {
    private final List<Event> events = new ArrayList<>();
    private final Map<String, Ticket> tickets = new HashMap<>();
    private final List<Hall> halls = new ArrayList<>();

    /**
     * Constructs a new TicketHandle object and initializes halls.
     *
     * @throws InvalidArgument if there is an invalid argument.
     */
    public TicketHandle() throws InvalidArgument {
        initHalls();
    }

    /**
     * Retrieves the list of events.
     *
     * @return the list of events.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Retrieves the map of tickets.
     *
     * @return the map of tickets.
     */
    public Map<String, Ticket> getTickets() {
        return tickets;
    }

    /**
     * Finds a hall by its number.
     *
     * @param number the hall number to search for.
     * @return the hall with the specified number, or null if not found.
     */
    public Hall findHallByNumber(int number) {
        for (Hall h : halls) {
            if (h.getNumber() == number)
                return h;
        }
        return null;
    }

    /**
     * Initializes halls.
     *
     * @throws InvalidArgument if there is an invalid argument.
     */
    private void initHalls() throws InvalidArgument {
        halls.add(new Hall(1, 2, 5));
        halls.add(new Hall(2, 5, 5));
        halls.add(new Hall(3, 1, 5));
        halls.add(new Hall(4, 6, 6));
    }

    /**
     * Finds the ticket key for the specified seat, date, and event name.
     *
     * @param seat the seat to find the ticket for.
     * @param date the date of the event.
     * @param name the name of the event.
     * @return the ticket key, or null if not found.
     */
    public String findTicketKey(Seat seat, Date date, String name) {
        Event event = findEvent(date, name);
        if (event == null) {
            System.out.println("No event found on this date.");
            return null;
        }
        Ticket ticket;
        for (Map.Entry<String, Ticket> entry : tickets.entrySet()) {
            ticket = entry.getValue();
            if (ticket.getEvent().equals(event) && ticket.getSeat().equals(seat)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Finds an event by date and name.
     *
     * @param date the date of the event.
     * @param name the name of the event.
     * @return the event, or null if not found.
     */
    public Event findEvent(Date date, String name) {
        Event event = null;
        for (Event e : events) {
            if (e.getDate().equals(date) && e.getName().equals(name)) {
                event = e;
                break;
            }
        }
        return event;
    }



    /**
     * Parses a date from a string.
     *
     * @param dateString the string representation of the date.
     * @return the parsed date, or null if parsing fails.
     */
    public Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd.MM.yyyy");
            return null;
        }
    }

    /**
     * Retrieves the list of halls.
     *
     * @return the list of halls.
     */
    public List<Hall> getHalls() {
        return halls;
    }
}

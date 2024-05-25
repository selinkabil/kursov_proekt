package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class represents the menu option to view bookings.
 */
public class BookingOption extends MainMenuOption {

    /**
     * Constructs a new BookingOption.
     *
     * @throws InvalidArgument if an invalid argument is provided during construction.
     */
    public BookingOption() throws InvalidArgument {
    }

    /**
     * Performs the action of viewing bookings.
     * This method reads input from the user and displays booked tickets based on the input.
     *
     * @param arguments the input arguments for viewing bookings.
     */
    @Override
    public void performAction(String arguments) {
        try {
            String input = arguments.trim();
            String[] parts = input.split("\\s+");
            if (parts.length < 2) {
                bookingsWithOneParam(parts[0]);
            } else {
                bookingsWithTwoParam(parts[0], parts[1]);
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }

    /**
     * Finds events by their name.
     *
     * @param name the name of the events to find.
     * @return a list of events with the given name.
     */
    private List<Event> findEventsByName(String name) {
        List<Event> eventsWithGivenName = new ArrayList<>();
        for (Event event : getEventManager().getEvents()) {
            if (event.getName().equals(name))
                eventsWithGivenName.add(event);
        }
        return eventsWithGivenName;
    }

    /**
     * Prints booked tickets for a given event.
     *
     * @param event the event for which to print booked tickets.
     */
    private void printBookedTickets(Event event) {
        for (Ticket ticket : getTicketManager().getTickets()) {
            if (ticket.getEvent().equals(event) && ticket.getTicketStatus().equals(TicketStatus.BOOKED)) {
                System.out.println(ticket);
            }
        }

    }

    /**
     * Checks if a given input is a date.
     *
     * @param input the input string to check.
     * @return true if the input is a valid date, false otherwise.
     */
    private boolean isDate(String input) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Displays bookings with two parameters: date and event name.
     *
     * @param input1 the date of the event.
     * @param input2 the name of the event.
     */
    private void bookingsWithTwoParam(String input1, String input2) {
        Date date = parseDate(input1);
        Event event = getEventManager().findEvent(date, input2);
        if (event != null) {
            System.out.println("Booked tickets:");
            printBookedTickets(event);
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }

    /**
     * Displays bookings with one parameter, which can be either a date or an event name.
     *
     * @param input the date or event name.
     */
    private void bookingsWithOneParam(String input) {
        if (isDate(input)) {
            Date date = parseDate(input);
            System.out.println("Booked tickets for all events on " + date + ":");
            for (Event event : getEventManager().getEvents()) {
                if (event.getDate().equals(date)) {
                    printBookedTickets(event);
                }
            }
        } else {
            List<Event> eventsWithGivenName = findEventsByName(input);
            if (!eventsWithGivenName.isEmpty()) {
                System.out.println("Booked tickets for event " + input + ":");
                for (Event event : eventsWithGivenName)
                    printBookedTickets(event);
            } else {
                System.out.println("No event found with name: " + input);
            }
        }
    }
}

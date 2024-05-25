package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;
import bg.tu_varna.sit.a2.f22621625.models.Hall;

import java.util.*;

/**
 * Represents an option to generate a report of events within a specified date range.
 */
public class ReportOption extends MainMenuOption {

    /**
     * Constructs a new ReportOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered during initialization
     */
    public ReportOption() throws InvalidArgument {
    }

    /**
     * Performs the action of generating a report of events within a specified date range.
     *
     * @param arguments the arguments passed to the menu option
     */
    @Override
    public void performAction(String arguments) {
        try {
            String input = arguments.trim();
            String[] parts = input.split("\\s+");

            if (parts.length < 2) {
                System.out.println("Missing 'from' or 'to' dates.");
                return;
            }

            String from = parts[0];
            String to = parts[1];
            Hall hall = null;
            int hallNum = 0;
            if (parts.length > 2) {
                hallNum = Integer.parseInt(parts[2]);
                hall = findHallByNumber(hallNum);
            }

            Date fromDate = parseDate(from);
            Date toDate = parseDate(to);

            List<Event> eventsInRange = filterEventsByDate(fromDate, toDate);

            if (eventsInRange.isEmpty()) {
                System.out.println("No events found within the specified date range.");
                return;
            }

            if (hall != null) {
                eventsInRange = filterEventsByHall(eventsInRange, hallNum);

                System.out.println("Report from " + from + " to " + to + " for " + hall);
                for (Event event : eventsInRange) {
                    int soldTickets = countSoldTickets(event, fromDate, toDate);
                    System.out.println("\nEvent: " + event.getName() + ", Sold tickets: " + soldTickets);
                }
            } else {
                System.out.println("Report from " + from + " to " + to + " :");
                for (Hall hallIterator : getHalls()) {
                    System.out.println("\n" + hallIterator);
                    for (Event event : eventsInRange) {
                        int soldTickets = countSoldTickets(event, fromDate, toDate);
                        if (event.getHall().equals(hallIterator))
                            System.out.println("Event: " + event.getName() + ", Sold tickets: " + soldTickets);
                    }
                }
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }

    // Helper method to filter events by date range
    private List<Event> filterEventsByDate(Date fromDate, Date toDate) {
        List<Event> eventsInRange = new ArrayList<>();
        for (Event event : getEventManager().getEvents()) {
            if (event.getDate().after(fromDate) && event.getDate().before(toDate)) {
                eventsInRange.add(event);
            }
        }
        return eventsInRange;
    }

    // Helper method to filter events by hall number
    private List<Event> filterEventsByHall(List<Event> events, int hallNumber) {
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getHall().getNumber() == hallNumber) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }

    // Helper method to count sold tickets for an event within a date range
    private int countSoldTickets(Event event, Date fromDate, Date toDate) {
        int soldTickets = 0;
        for (Ticket ticket : getTicketManager().getTickets()) {
            if (ticket.getEvent().equals(event) && ticket.getTicketStatus().equals(TicketStatus.PAID)) {
                soldTickets++;
            }
        }
        return soldTickets;
    }
}

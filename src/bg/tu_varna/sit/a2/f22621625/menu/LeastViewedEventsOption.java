package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;
import bg.tu_varna.sit.a2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;

import java.util.*;

/**
 * Represents an option to display and potentially remove the least viewed events.
 */
public class LeastViewedEventsOption implements MenuItem {
    private TicketHandle ticketSystem;
    private final Scanner scanner;

    /**
     * Constructs a LeastViewedEventsOption object with the given TicketHandle and Scanner.
     *
     * @param ticketSystem the TicketHandle object to handle tickets and events
     * @param scanner      the Scanner object for user input
     */
    public LeastViewedEventsOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    /**
     * Displays the least viewed events and allows the user to remove them.
     *
     * @throws MainException if an error occurs during the operation
     */
    @Override
    public void performAction() throws MainException {
        // ticket counts for each event
        Map<Event, Integer> eventTicketCounts = new HashMap<>();
        for (Event event : ticketSystem.getEvents()) {
            int ticketCount = countTicketsForEvent(event);
            eventTicketCounts.put(event, ticketCount);
        }

        // Calculating the total number of tickets sold
        int totalTicketsSold = countAllTickets();

        // Find events with less than 10% attendance
        List<Event> leastViewedEvents = new ArrayList<>();
        for (Map.Entry<Event, Integer> entry : eventTicketCounts.entrySet()) {
            Event event = entry.getKey();
            int ticketCount = entry.getValue();
            double attendanceRate = (double) ticketCount / totalTicketsSold;
            if (attendanceRate < 0.10) {
                leastViewedEvents.add(event);
            }
        }

        // Print the least viewed events
        System.out.println("Least viewed events (less than 10% attendance):");
        if (leastViewedEvents.isEmpty()) {
            System.out.println("No events found with less than 10% attendance.");
        } else {
            int rank = 1;
            for (Event event : leastViewedEvents) {
                System.out.println(rank + ". " + event.getName() + " - Tickets sold: " + eventTicketCounts.get(event));
                rank++;
            }
            System.out.println("Would you like to remove these events? y/n");
            String answer = scanner.next();
            if (answer.equals("y")) {
                ticketSystem.getEvents().removeAll(leastViewedEvents);
                System.out.println("Successfully removed least viewed events.");
            }
        }
    }

    /**
     * Counts the number of tickets sold for the given event.
     *
     * @param event the event to count tickets for
     * @return the number of tickets sold for the event
     */
    private int countTicketsForEvent(Event event) {
        int ticketCount = 0;
        for (Map.Entry<String, Ticket> ticketEntry : ticketSystem.getTickets().entrySet()) {
            Ticket ticket = ticketEntry.getValue();
            if (ticket.getEvent().equals(event) && ticket.getTicketStatus().equals(TicketStatus.PAID)) {
                ticketCount++;
            }
        }
        return ticketCount;
    }

    /**
     * Counts the total number of tickets sold.
     *
     * @return the total number of tickets sold
     */
    private int countAllTickets() {
        int totalTickets = 0;
        for (Ticket ticket : ticketSystem.getTickets().values()) {
            if (ticket.getTicketStatus().equals(TicketStatus.PAID)) {
                totalTickets++;
            }
        }
        return totalTickets;
    }
}

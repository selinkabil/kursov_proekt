package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;
import bg.tu_varna.sit.a2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.models.EventTicketCount;

import java.util.*;

/**
 * Represents an option to display the most viewed events based on the number of tickets sold.
 */
public class MostViewedEventsOption implements MenuItem {
    private TicketHandle ticketSystem;

    /**
     * Constructs a MostViewedEventsOption object with the given TicketHandle.
     *
     * @param ticketSystem the TicketHandle object to handle tickets and events
     */
    public MostViewedEventsOption(TicketHandle ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    /**
     * Displays the most viewed events based on the number of tickets sold.
     *
     * @throws MainException if an error occurs during the operation
     */
    @Override
    public void performAction() throws MainException {
        // Map to store ticket counts for each event
        Map<Event, Integer> eventTicketCounts = new HashMap<>();
        for (Event event : ticketSystem.getEvents()) {
            int ticketCount = countTicketsForEvent(event);
            eventTicketCounts.put(event, ticketCount);
        }

        // Sort events based on ticket counts
        List<Event> sortedEvents = new ArrayList<>(ticketSystem.getEvents());
        Collections.sort(sortedEvents, new EventTicketCount(eventTicketCounts));

        // Print the most viewed events
        System.out.println("Most viewed events:");
        int rank = 1;
        for (Event event : sortedEvents) {
            System.out.println(rank + ". " + event.getName() + " - Tickets sold: " + eventTicketCounts.get(event));
            rank++;
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
}

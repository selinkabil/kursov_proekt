package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.EventTicketCount;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;

import java.util.*;

public class MostViewedEventsOption implements MenuItem {
    private TicketHandle ticketSystem;

    public MostViewedEventsOption(TicketHandle ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    @Override
    public void performAction() throws MainException {
        // Get the ticket counts for each event
        Map<Event, Integer> eventTicketCounts = new HashMap<>();
        for (Event event : ticketSystem.getEvents()) {
            int ticketCount = countTicketsForEvent(event);
            eventTicketCounts.put(event, ticketCount);
        }

        // Sort the events based on their ticket counts
        List<Event> sortedEvents = new ArrayList<>(ticketSystem.getEvents());
        Collections.sort(sortedEvents, new EventTicketCount(eventTicketCounts));

        // Print the sorted events
        System.out.println("Most viewed events:");
        int rank = 1;
        for (Event event : sortedEvents) {
            System.out.println(rank + ". " + event.getName() + " - Tickets sold: " + eventTicketCounts.get(event));
            rank++;
        }
    }

    private int countTicketsForEvent(Event event) {
        int ticketCount = 0;
        for (Map.Entry<String, Ticket> ticketEntry : ticketSystem.getTickets().entrySet()) {
            Ticket ticket = ticketEntry.getValue();
            if (ticket.getEvent().equals(event) && ticket.isPaid()) {
                ticketCount++;
            }
        }
        return ticketCount;
    }
}

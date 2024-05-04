package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import com.sun.net.httpserver.Authenticator;

import java.util.*;

public class LeastViewedEventsOption implements MenuItem {
    private TicketHandle ticketSystem;
    private final Scanner scanner;


    public LeastViewedEventsOption(TicketHandle ticketSystem,Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner=scanner;
    }

    @Override
    public void performAction() throws MainException {
        // Get the ticket counts for each event
        Map<Event, Integer> eventTicketCounts = new HashMap<>();
        for (Event event : ticketSystem.getEvents()) {
            int ticketCount = countTicketsForEvent(event);
            eventTicketCounts.put(event, ticketCount);
        }

        // Calculate the total number of tickets sold
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
            String answer=scanner.next();
            if(answer.equals("y")){
                ticketSystem.getEvents().removeAll(leastViewedEvents);
                System.out.println("Successfully removed least viewed events.");
            }
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

    private int countAllTickets() {
        int totalTickets = 0;
        for (Ticket ticket : ticketSystem.getTickets().values()) {
            if (ticket.isPaid()) {
                totalTickets++;
            }
        }
        return totalTickets;
    }
}

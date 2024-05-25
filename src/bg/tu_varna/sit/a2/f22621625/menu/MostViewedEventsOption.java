package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;
import bg.tu_varna.sit.a2.f22621625.models.EventTicketCount;

import java.util.*;

/**
 * Represents an option to display the most viewed events based on the number of tickets sold.
 */
public class MostViewedEventsOption extends MainMenuOption  {

    /**
     * Constructs a new MostViewedEventsOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered during initialization
     */
    public MostViewedEventsOption() throws InvalidArgument {
    }

    /**
     * Displays the most viewed events based on the number of tickets sold.
     *
     * @param arguments the arguments passed to the menu option (not used)
     * @throws MainException if an error occurs during the operation
     */
    @Override
    public void performAction(String arguments) throws MainException {
        // Map to store ticket counts for each event
        Map<Event, Integer> eventTicketCounts = new HashMap<>();
        for (Event event : getEventManager().getEvents()) {
            int ticketCount = countTicketsForEvent(event);
            eventTicketCounts.put(event, ticketCount);
        }

        // Sort events based on ticket counts
        List<Event> sortedEvents = new ArrayList<>(getEventManager().getEvents());
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
        for (Ticket ticket:getTicketManager().getTickets()) {
            if (ticket.getEvent().equals(event) && ticket.getTicketStatus().equals(TicketStatus.PAID)) {
                ticketCount++;
            }
        }
        return ticketCount;
    }
}

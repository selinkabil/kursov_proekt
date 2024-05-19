package bg.tu_varna.sit.a2.f22621625.models;

import java.util.Comparator;
import java.util.Map;

/**
 * Comparator for comparing events based on their ticket counts.
 */
public class EventTicketCount implements Comparator<Event> {
    private Map<Event, Integer> eventTicketCounts;

    /**
     * Constructs an EventTicketCount object with the provided event ticket counts map.
     *
     * @param eventTicketCounts the map containing event-ticket count pairs
     */
    public EventTicketCount(Map<Event, Integer> eventTicketCounts) {
        this.eventTicketCounts = eventTicketCounts;
    }

    /**
     * Compares two events based on their ticket counts.
     *
     * @param o1 the first event to compare
     * @param o2 the second event to compare
     * @return a negative integer if the ticket count of o1 is less than that of o2,
     *         zero if they are equal, and a positive integer if o1 has more tickets sold than o2
     */
    @Override
    public int compare(Event o1, Event o2) {
        int ticketCount1 = eventTicketCounts.getOrDefault(o1, 0);
        int ticketCount2 = eventTicketCounts.getOrDefault(o2, 0);
        return Integer.compare(ticketCount2, ticketCount1);
    }
}

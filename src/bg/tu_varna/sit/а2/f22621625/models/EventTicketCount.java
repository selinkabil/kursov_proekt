package bg.tu_varna.sit.à2.f22621625.models;

import java.util.Comparator;
import java.util.Map;

public class EventTicketCount implements Comparator<Event> {
    private Map<Event, Integer> eventTicketCounts;

    public EventTicketCount(Map<Event, Integer> eventTicketCounts) {
        this.eventTicketCounts = eventTicketCounts;
    }

    @Override
    public int compare(Event o1, Event o2) {
        int ticketCount1=eventTicketCounts.getOrDefault(o1,0);
        int ticketCount2 = eventTicketCounts.getOrDefault(o2,0);
        return Integer.compare(ticketCount2, ticketCount1);
    }
}

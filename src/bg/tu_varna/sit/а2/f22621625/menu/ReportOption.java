package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Hall;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReportOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public ReportOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }


    @Override
    public void performAction() {
        String from = scanner.next();
        String to = scanner.next();
        int hallNum= scanner.nextInt();

        Hall hall = ticketSystem.findHallByNumber(hallNum);
        Date fromDate = parseDate(from);
        Date toDate = parseDate(to);

        List<Event> eventsInRange = filterEventsByDate(fromDate, toDate);

        if (eventsInRange.isEmpty()) {
            System.out.println("No events found within the specified date range.");
            return;
        }

        // If a hall is specified, filter events and tickets by hall number
        if (hall != null ) {
            eventsInRange = filterEventsByHall(eventsInRange, hallNum);
        }

        // Print the report
        System.out.println("Report from " + from + " to " + to + (hall != null ? " for hall " + hall : "") + ":");

        for (Event event : eventsInRange) {
            int soldTickets = countSoldTickets(event, fromDate, toDate);
            System.out.println("Event: " + event.getName() + ", Sold tickets: " + soldTickets);
        }
    }

    // Helper method to parse date string to Date object (implement this)
    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd.MM.yyyy");
            return null;
        }
    }

    // Helper method to filter events by date range
    private List<Event> filterEventsByDate(Date fromDate, Date toDate) {
        List<Event> eventsInRange = new ArrayList<>();
        for (Event event : ticketSystem.getEvents()) {
            Date parsedEventDate= parseDate(event.getDate());

            if (parsedEventDate.after(fromDate) && parsedEventDate.before(toDate)) {
                eventsInRange.add(event);
            }
        }
        return eventsInRange;
    }

    // Helper method to filter events by hall number
    private List<Event> filterEventsByHall(List<Event> events, int hallNumber) {
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
                if (event.getHalls().getNumber() == hallNumber) {
                    filteredEvents.add(event);
                    break;
                }
        }
        return filteredEvents;
    }

    // Helper method to count sold tickets for an event within a date range
    private int countSoldTickets(Event event, Date fromDate, Date toDate) {
        int soldTickets = 0;
        for (Ticket ticket : ticketSystem.getTickets().values()) {
           if(ticket.getEvent().equals(event)){
               soldTickets++;
           }
        }
        return soldTickets;    }

}

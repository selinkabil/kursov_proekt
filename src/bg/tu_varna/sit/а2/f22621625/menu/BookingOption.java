package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingOption implements MenuItem {
    private final TicketHandle ticketSystem ;
    private final Scanner scanner;

    public BookingOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        try {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");
            if (parts.length < 2) {
                bookingsWithOneParam(parts[0]);
            } else {
                bookingsWithTwoParam(parts[0],parts[1]);
            }
        }
        catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e){
        System.out.println("Invalid input format.");
        }
    }
    private List<Event> findEventsByName(String name){
        List<Event> eventsWithGivenName = new ArrayList<>();
        for(Event event : ticketSystem.getEvents()) {
            if(event.getName().equals(name))
                eventsWithGivenName.add(event);
        }
        return eventsWithGivenName;
    }
    private void printBookedTickets(Event event) {
        for (Map.Entry<String, Ticket> ticketEntry : ticketSystem.getTickets().entrySet()) {
            Ticket ticket = ticketEntry.getValue();
            if (ticket.getEvent().equals(event) && !ticket.getTicketStatus().equals(TicketStatus.BOOKED)) {
                System.out.println(ticket);
            }
        }
    }
    private boolean isDate(String input) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private void bookingsWithTwoParam(String input1,String input2){
        Date date;
        date = ticketSystem.parseDate(input1);
        Event event = ticketSystem.findEvent(date, input2);
        if (event != null) {
            System.out.println("Booked tickets:");
            printBookedTickets(event);
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }
    private void bookingsWithOneParam(String input){
        Date date;
        String eventName;
        if (isDate(input)) {
            date = ticketSystem.parseDate(input);
            System.out.println("Booked tickets for all events on " + date + ":");
            for (Event event : ticketSystem.getEvents()) {
                if (event.getDate().equals(date)) {
                    printBookedTickets(event);
                }
            }
        }
        else {
            eventName = input;
            List<Event> eventsWitGivenName = findEventsByName(eventName);
            if (!eventsWitGivenName.isEmpty()) {
                System.out.println("Booked tickets for event " + eventName + ":");
                for (Event event : eventsWitGivenName)
                    printBookedTickets(event);
            } else {
                System.out.println("No event found with name: " + eventName);
            }
        }
    }
}

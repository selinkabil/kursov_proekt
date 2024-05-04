package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookingOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public BookingOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        String input = scanner.nextLine().trim();
        String parts[]= input.split("\\s+");
        String date,eventName;
        if(parts.length<2){
            if(isDate(parts[0])){
                date= parts[0];
                System.out.println("Booked tickets for all events on " + date + ":");
                for (Event event : ticketSystem.getEvents()) {
                    if (event.getDate().equals(date)) {
                        printBookedTickets(event);
                    }
                }
            }
            else{
                eventName= parts[0];
                List<Event> eventsWitGivenName = findEventsByName(eventName);
                if (eventsWitGivenName != null) {
                    System.out.println("Booked tickets for event " + eventName + ":");
                    for(Event event : eventsWitGivenName)
                    printBookedTickets(event);
                } else {
                    System.out.println("No event found with name: " + eventName);
                }
            }
        }
        else {
            date=parts[0];
            eventName=parts[1];
            Event event = ticketSystem.findEvent(date, eventName);
            if (event != null) {
                System.out.println("Booked tickets:");
                printBookedTickets(event);
            } else {
                System.out.println("Event not found for the given date and name.");
            }
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
            if (ticket.getEvent().equals(event) && !ticket.isPaid()) {
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
}

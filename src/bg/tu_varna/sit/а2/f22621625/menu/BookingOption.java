package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

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
        String date =scanner.next();
        String eventName= scanner.next();
        Event event = ticketSystem.findEvent(date, eventName);
        if (event != null) {
            System.out.println("Booked tickets:");
            for (Map.Entry<String, Ticket> ticketEntry : ticketSystem.getTickets().entrySet()) {
                Ticket ticket = ticketEntry.getValue();
                if (ticket.getEvent().equals(event) && !ticket.isPaid()) {
                    System.out.println(ticket);
                }
            }
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }
}

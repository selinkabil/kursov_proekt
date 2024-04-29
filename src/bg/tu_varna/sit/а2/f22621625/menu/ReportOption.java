package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Hall;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public ReportOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    // TODO: fix date comparison

    @Override
    public void performAction() {
        String to = scanner.next();
        String from = scanner.next();
        int hallnum = scanner.nextInt();
        Hall hall=ticketSystem.findHallByNumber(hallnum);
        Map<String, Integer> hallTicketsSold = new HashMap<>();
        for (Map.Entry<String, Ticket> ticketEntry : ticketSystem.getTickets().entrySet()) {
            Ticket ticket = ticketEntry.getValue();
            Event event = ticket.getEvent();
            if ((from == null || event.getDate().compareTo(from)==1) && (to == null || event.getDate().compareTo(to)==-1) && (hall == null || ticketSystem.isEventInHall(event, hall))) {
                hallTicketsSold.put(event.getName(), hallTicketsSold.getOrDefault(event.getName(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : hallTicketsSold.entrySet()) {
            System.out.println("Event: " + entry.getKey() + ", Tickets sold: " + entry.getValue());
        }
    }
}

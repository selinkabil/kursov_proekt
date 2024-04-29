package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.List;
import java.util.Scanner;

public class FreeSeatsOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public FreeSeatsOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        String date = scanner.next();
        String name= scanner.next();
        Event event = ticketSystem.findEvent(date, name);
        if (event != null) {
            System.out.println("Free seats for event: " + name + " on " + date);
            List<Seat> freeSeats = event.getHalls().getFreeSeats();
            for (Seat seat : freeSeats) {
                System.out.println("Hall " + event.getHalls().getNumber() + " Row " + seat.getRow() + " Seat " + seat.getNumber());
            }
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }

}

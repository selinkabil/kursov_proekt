package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Hall;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.exceptions.DuplicateEventException;

import java.util.Scanner;

public class AddEventOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public AddEventOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        String name = scanner.next();
        String date = scanner.next();
        int number = scanner.nextInt();
        Hall hall = ticketSystem.findHallByNumber(number);
        Event newEvent = new Event(name, date, hall);
        if (ticketSystem.getEvents().contains(newEvent)) {
            try {
                throw new DuplicateEventException("An event with the given date already exists.");
            } catch (DuplicateEventException e) {
                System.out.println(e.getMessage());
            }
        } else {
            ticketSystem.getEvents().add(newEvent);
            System.out.println("Successfully added event: " + name);
        }
    }

}

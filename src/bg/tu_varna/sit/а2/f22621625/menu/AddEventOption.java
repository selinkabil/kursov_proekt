package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.Event;
import bg.tu_varna.sit.à2.f22621625.Hall;
import bg.tu_varna.sit.à2.f22621625.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Date;
import java.util.Scanner;

public class AddEventOption implements MenuItem {
    private String  info = "";
    private TicketHandle ticketSystem;
    private Scanner scanner;
    private String content="";

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
            System.out.println("An event with the given date already exists.");
        } else {
            ticketSystem.getEvents().add(newEvent);
            System.out.println("Successfully added event: " + name);
        }
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getContent() {
        return content;
    }
}

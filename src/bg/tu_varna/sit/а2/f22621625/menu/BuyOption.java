package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class BuyOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public BuyOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        int row=scanner.nextInt();
        int seat=scanner.nextInt();
        String date=scanner.next();
        String name=scanner.next();
        String ticketKey = ticketSystem.findTicketKey((new Seat(row,seat)), date,name);
        if (ticketKey != null && ticketSystem.getTickets().get(ticketKey).getSeat().isBooked()) {
            ticketSystem.getTickets().get(ticketKey).setPaid(true);
            System.out.println("Successfully paid for booked ticket");
        } else {
            System.out.println("No booking found for specified seat and event.");
        }
    }
}

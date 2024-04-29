package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class UnbookOption implements MenuItem {
    private TicketHandle ticketSystem;
    private Scanner scanner;

    public UnbookOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        int row=scanner.nextInt();
        int seat = scanner.nextInt();
        String date= scanner.next();
        String name=scanner.next();

        String ticketKey = ticketSystem.findTicketKey(new Seat(row,seat), date,name);
        if (ticketKey != null) {
            ticketSystem.getTickets().get(ticketKey).getSeat().setBooked(false);
            ticketSystem.getTickets().get(ticketKey).getEvent().getHalls().findSeatByRowNumber(row,seat).setBooked(false);
            ticketSystem.getTickets().remove(ticketKey);
            System.out.println("Booking cancelled for seat: Row " + row + ", Seat " + seat + " at event on " + date);
        } else {
            System.out.println("No booking found for specified seat and event.");
        }
    }
}

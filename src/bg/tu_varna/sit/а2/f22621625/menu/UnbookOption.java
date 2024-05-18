package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Date;
import java.util.InputMismatchException;
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
        try{
            String[] input = scanner.nextLine().trim().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int seat = Integer.parseInt(input[1]);
        Date date = ticketSystem.parseDate(input[2]);
        String name = input[3];

        String ticketKey = ticketSystem.findTicketKey(new Seat(row, seat), date, name);
        if (ticketKey != null) {
            ticketSystem.getTickets().get(ticketKey).getSeat().setBooked(false);
            ticketSystem.getTickets().get(ticketKey).getEvent().getHalls().findSeatByRowNumber(row, seat).setBooked(false);
            ticketSystem.getTickets().remove(ticketKey);
            System.out.println("Booking cancelled for seat: Row " + row + ", Seat " + seat + " at event on " + date);
        } else {
            System.out.println("No booking found for specified seat and event.");
        }
        }catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input format.");
        }
    }
}

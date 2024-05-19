package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.a2.f22621625.models.Seat;
import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the menu option to buy a ticket.
 */
public class BuyOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    /**
     * Constructs a BuyOption with the specified TicketHandle and Scanner.
     *
     * @param ticketSystem the TicketHandle system for managing events and tickets.
     * @param scanner      the Scanner to read user input.
     */
    public BuyOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    /**
     * Performs the action of buying a ticket.
     * This method reads input from the user and marks the ticket as paid if found in the system.
     */
    @Override
    public void performAction() {
        try {
            String[] input = scanner.nextLine().trim().split("\\s+");
            int row = Integer.parseInt(input[0]);
            int seat = Integer.parseInt(input[1]);
            Date date = ticketSystem.parseDate(input[2]);
            String name = input[3];
            String ticketKey = ticketSystem.findTicketKey((new Seat(row, seat)), date, name);
            if (ticketKey != null && ticketSystem.getTickets().get(ticketKey).getSeat().isBooked()) {
                ticketSystem.getTickets().get(ticketKey).setTicketStatus(TicketStatus.PAID);
                ticketSystem.getTickets().get(ticketKey).getSeat().setBooked(false);
                System.out.println("Successfully paid for booked ticket");
            } else {
                System.out.println("No booking found for specified seat and event.");
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

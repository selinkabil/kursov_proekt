package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;
import bg.tu_varna.sit.a2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

import java.util.Map;
import java.util.Scanner;

/**
 * This class represents the menu option to check a ticket.
 */
public class CheckOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    /**
     * Constructs a CheckOption with the specified TicketHandle and Scanner.
     *
     * @param ticketSystem the TicketHandle system for managing events and tickets.
     * @param scanner      the Scanner to read user input.
     */
    public CheckOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    /**
     * Performs the action of checking a ticket.
     * This method reads input from the user and checks if a ticket exists with the given code.
     * If found, it prints the details of the corresponding seat.
     * Otherwise, it displays a message indicating that no ticket was found with the given code.
     *
     * @throws MainException if an error occurs during the operation.
     */
    @Override
    public void performAction() throws MainException {
        boolean found = false;
        String[] input = scanner.nextLine().trim().split("\\s+");
        String code = input[0];
        for (Map.Entry<String, Ticket> ticket : ticketSystem.getTickets().entrySet()) {
            if (ticket.getKey().equals(code)) {
                System.out.println(ticket.getValue().getSeat());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No ticket found with the given code");
        }
    }
}

package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * This class represents the menu option to buy a ticket.
 */
public class BuyOption extends MainMenuOption {

    /**
     * Constructs a new BuyOption.
     *
     * @throws InvalidArgument if an invalid argument is provided during construction.
     */
    public BuyOption() throws InvalidArgument {
    }

    /**
     * Performs the action of buying a ticket.
     * This method reads input from the user and marks the ticket as paid if found in the system.
     *
     * @param arguments the input arguments for buying a ticket.
     */
    @Override
    public void performAction(String arguments) {
        try {
            String[] input = arguments.trim().split("\\s+");
            int row = Integer.parseInt(input[0]);
            int seat = Integer.parseInt(input[1]);
            Date date = parseDate(input[2]);
            String name = input[3];
            Event event = getEventManager().findEvent(date, name);
            Ticket ticket = getTicketManager().findTicket(event, row, seat);
            if (ticket != null && ticket.getSeat().isBooked()) {
                ticket.setTicketStatus(TicketStatus.PAID);
                System.out.println("Successfully paid for booked ticket");
            } else {
                System.out.println("No booking found for specified seat and event.");
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

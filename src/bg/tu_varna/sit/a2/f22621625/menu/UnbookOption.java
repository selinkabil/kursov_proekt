package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * Represents an option to unbook a ticket.
 */
public class UnbookOption extends MainMenuOption {

    /**
     * Constructs a new UnbookOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered during initialization
     */
    public UnbookOption() throws InvalidArgument {
    }

    /**
     * Performs the action of unbooking a ticket.
     *
     * @param arguments the arguments provided for unbooking the ticket
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
            if (ticket != null) {
                ticket.getSeat().setBooked(false);
                getTicketManager().removeTicket(ticket);
                System.out.println("Booking cancelled for seat: Row " + row + ", Seat " + seat + " at event on " + date);
            } else {
                System.out.println("No booking found for specified seat and event.");
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

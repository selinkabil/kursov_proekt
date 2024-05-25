package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * This class represents the menu option to book a ticket.
 */
public class BookTicketOption extends MainMenuOption {

    /**
     * Constructs a new BookTicketOption.
     *
     * @throws InvalidArgument if an invalid argument is provided during construction.
     */
    public BookTicketOption() throws InvalidArgument {
        super();
    }

    /**
     * Performs the action of booking a ticket.
     * This method reads input from the user, creates a ticket, and adds it to the system if valid.
     *
     * @param arguments the input arguments for booking a ticket.
     */
    @Override
    public void performAction(String arguments) {
        try {
            String[] input = arguments.trim().split("\\s+");
            int row = Integer.parseInt(input[0]);
            int seat = Integer.parseInt(input[1]);
            Date date = parseDate(input[2]);
            String name = input[3];
            String note = input[4];

            Event event = getEventManager().findEvent(date, name);
            Ticket ticket = new Ticket(event, row, seat, note);

            if (getTicketManager().duplicateTicketCheck(ticket)) {
                System.out.println("A ticket with this code/this seat already exists.");
            } else {
                ticket.getSeat().setBooked(true);
                ticket.setTicketStatus(TicketStatus.BOOKED);
                getTicketManager().addTicket(ticket);
                System.out.println("Successfully added ticket: " + ticket.getCode());
            }
        } catch (NumberFormatException | InputMismatchException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

/**
 * This class represents the menu option to check a ticket.
 */
public class CheckOption extends MainMenuOption {

    /**
     * Constructs a new CheckOption.
     *
     * @throws InvalidArgument if an invalid argument is provided during construction.
     */
    public CheckOption() throws InvalidArgument {
    }

    /**
     * Performs the action of checking a ticket.
     * This method reads input from the user and checks if a ticket exists with the given code.
     * If found, it prints the details of the corresponding seat.
     * Otherwise, it displays a message indicating that no ticket was found with the given code.
     *
     * @param arguments the input arguments for checking a ticket.
     * @throws MainException if an error occurs during the operation.
     */
    @Override
    public void performAction(String arguments) throws MainException {
        boolean found = false;
        String[] input = arguments.trim().split("\\s+");
        String code = input[0];
        for (Ticket ticket : getTicketManager().getTickets()) {
            if (ticket.getCode().equals(code)) {
                System.out.println(ticket);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No ticket found with the given code");
        }
    }
}

package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Hall;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * This class represents the menu option to add an event.
 */
public class AddEventOption extends MainMenuOption {

    /**
     * Constructs a new AddEventOption.
     *
     * @throws InvalidArgument if an invalid argument is provided during construction.
     */
    public AddEventOption() throws InvalidArgument {
        super();
    }

    /**
     * Performs the action of adding an event.
     * This method reads input from the user, parses it, and adds a new event to the ticket system.
     *
     * @param arguments the input arguments for adding the event, expected to be in the format: "name date hallNumber".
     * @throws MainException if an error occurs during the operation.
     */
    @Override
    public void performAction(String arguments) throws MainException {
        try {
            String[] input = arguments.trim().split("\\s");
            String name = input[0];
            String date = input[1];
            Date parsedDate = parseDate(date);
            int number = Integer.parseInt(input[2]);

            Hall hall = findHallByNumber(number);

            if (getEventManager().duplicateEventCheck(parsedDate, hall)) {
                System.out.println("An event with the given date and hall already exists.");
            } else if (parsedDate != null) {
                Event newEvent = new Event(name, parsedDate, hall);
                getEventManager().addEvent(newEvent);
                System.out.println("Successfully added event: " + name + " on " + newEvent.getDate());
            } else {
                System.out.println("Could not add event due to invalid date.");
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

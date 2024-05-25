package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Seat;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Represents a menu item for displaying free seats for a specific event.
 */
public class FreeSeatsOption extends MainMenuOption {

    public FreeSeatsOption() throws InvalidArgument {
    }

    /**
     * Performs the action of displaying free seats for a specific event.
     */
    @Override
    public void performAction(String arguments) {
        try {
            String[] input = arguments.trim().split("\\s+");
            Date date = parseDate(input[0]);
            String name = input[1];
            Event event = getEventManager().findEvent(date, name);
            if (event != null) {
                System.out.println("Free seats for event: " + name + " on " + date + " in hall " + event.getHall().getNumber() );
                List<Seat> freeSeats = event.getHall().getFreeSeats();
                for (Seat seat : freeSeats) {
                    System.out.println(" Row " + seat.getRow() + " Seat " + seat.getNumber());
                }
            } else {
                System.out.println("Event not found for the given date and name.");
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }
}

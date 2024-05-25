package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Hall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract class representing a main menu option.
 */
public abstract class MainMenuOption implements MenuItem {

    // Fields
    private final EventManager eventManager;
    private final TicketManager ticketManager;
    private final List<Hall> halls;

    /**
     * Constructs a new MainMenuOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered during initialization.
     */
    public MainMenuOption() throws InvalidArgument {
        this.eventManager = new EventManager();
        this.ticketManager = new TicketManager();
        this.halls = new ArrayList<>();
        initHalls();
    }

    // Getters

    /**
     * Gets the event manager associated with this menu option.
     *
     * @return the event manager
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * Gets the ticket manager associated with this menu option.
     *
     * @return the ticket manager
     */
    public TicketManager getTicketManager() {
        return ticketManager;
    }

    /**
     * Gets the list of halls associated with this menu option.
     *
     * @return the list of halls
     */
    public List<Hall> getHalls() {
        return halls;
    }

    // Methods

    /**
     * Finds a hall by its number.
     *
     * @param number the number of the hall to find
     * @return the hall with the specified number, or null if not found
     */
    protected Hall findHallByNumber(int number) {
        for (Hall h : halls) {
            if (h.getNumber() == number) {
                return h;
            }
        }
        return null;
    }

    /**
     * Initializes the list of halls.
     *
     * @throws InvalidArgument if an invalid argument is encountered during initialization
     */
    private void initHalls() throws InvalidArgument {
        halls.add(new Hall(1, 2, 5));
        halls.add(new Hall(2, 5, 5));
        halls.add(new Hall(3, 1, 5));
        halls.add(new Hall(4, 6, 6));
    }

    /**
     * Parses a string representation of a date into a Date object.
     *
     * @param dateString the string representation of the date
     * @return the Date object parsed from the string, or null if parsing fails
     */
    protected Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd.MM.yyyy");
            return null;
        }
    }

    /**
     * Performs the action associated with this menu option.
     *
     * @param arguments the arguments passed to the menu option
     * @throws InvalidArgument if an invalid argument is encountered during execution
     * @throws MainException   if an error occurs during execution
     */
    public abstract void performAction(String arguments) throws InvalidArgument, MainException;
}

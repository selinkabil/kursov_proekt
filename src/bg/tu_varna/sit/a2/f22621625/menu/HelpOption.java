package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Menu;

/**
 * Represents an option to display help information.
 */
public class HelpOption extends MainMenuOption {

    /**
     * Constructs a new HelpOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered.
     */
    public HelpOption() throws InvalidArgument {
    }

    /**
     * Displays the list of supported commands.
     *
     * @param arguments the input arguments (not used in this method)
     * @throws MainException if an error occurs while displaying the menu
     */
    @Override
    public void performAction(String arguments) throws MainException {
        // Print the list of supported commands
        System.out.println("\nThe following commands are supported:");
        // Create a new Menu instance to display the menu
        Menu menu = new Menu();
        // Display the menu
        menu.displayMenu();
    }
}

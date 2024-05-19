package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Menu;

/**
 * Represents an option to display help information.
 */
public class HelpOption implements MenuItem {

    /**
     * Displays the list of supported commands.
     *
     * @throws MainException if an error occurs while displaying the menu
     */
    @Override
    public void performAction() throws MainException {
        System.out.println("\nThe following commands are supported");
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

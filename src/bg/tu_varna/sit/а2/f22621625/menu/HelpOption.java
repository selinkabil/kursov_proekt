package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.Menu;

public class HelpOption implements MenuItem {

    @Override
    public void performAction() throws MainException {
        System.out.println("\nThe following commands are supported");
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

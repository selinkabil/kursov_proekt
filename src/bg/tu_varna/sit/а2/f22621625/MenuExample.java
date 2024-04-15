package bg.tu_varna.sit.а2.f22621625;

import bg.tu_varna.sit.а2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.а2.f22621625.models.*;

public class MenuExample {
    public static void main(String[] args) {
        MenuItem[] menuItems = {
                new OpenOption(),
                new SaveOption(),
                new SaveAsOption(),
                new ExitOption()
        };

        Menu menu = new Menu(menuItems);

        while (true) {
            menu.displayMenu();
            menu.handleUserInput();
        }
    }
}
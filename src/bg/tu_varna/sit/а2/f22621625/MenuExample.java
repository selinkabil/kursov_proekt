package bg.tu_varna.sit.à2.f22621625;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.models.*;

public class MenuExample {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.displayMenu();
        while (true) {
            menu.handleUserInput();
        }
    }
}
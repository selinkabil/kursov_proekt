package bg.tu_varna.sit.а2.f22621625.models;

import bg.tu_varna.sit.а2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class Menu {
    private final MenuItem[] menuItems;
    private final Scanner scanner;
    public Menu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Menu Options:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i].getInfo());
        }
    }

    public void handleUserInput() {
        System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= menuItems.length) {
                System.out.print(menuItems[choice - 1].getContent());
                menuItems[choice - 1].performAction();
            } else {
                System.out.println("Invalid choice!");
            }
    }
    public void closeScanner() {
        scanner.close();
    }
}
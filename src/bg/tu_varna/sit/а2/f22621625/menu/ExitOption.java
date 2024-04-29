package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class ExitOption implements MenuItem {
    private final Scanner scanner;

    public ExitOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        System.out.println("\nExiting the program...");
        scanner.close();
        System.exit(0);
    }
}

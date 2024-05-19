package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

import java.util.Scanner;

/**
 * Represents a menu option to exit the program.
 */
public class ExitOption implements MenuItem {

    private final Scanner scanner;

    /**
     * Constructs an ExitOption with the specified Scanner.
     *
     * @param scanner the Scanner used for user input.
     */
    public ExitOption(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Performs the action of exiting the program.
     * Closes the Scanner and terminates the program with exit code 0.
     */
    @Override
    public void performAction() {
        System.out.println("\nExiting the program...");
        scanner.close();
        System.exit(0);
    }
}

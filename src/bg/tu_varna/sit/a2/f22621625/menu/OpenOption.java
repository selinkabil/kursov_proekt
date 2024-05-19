package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

import java.util.Scanner;

/**
 * Represents an option to open a file for editing.
 */
public class OpenOption implements MenuItem {
    private final FileManager fileManager;
    private final Scanner scanner;

    /**
     * Constructs an OpenOption object with the given FileManager and Scanner.
     *
     * @param fileManager the FileManager object to manage files
     * @param scanner     the Scanner object to read user input
     */
    public OpenOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
    }

    /**
     * Opens a file for editing based on user input.
     */
    @Override
    public void performAction() {
        String fileName = scanner.next();
        fileManager.openFile(fileName);
    }
}

package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

import java.util.Scanner;

/**
 * Represents an option to save the current file.
 */
public class SaveOption implements MenuItem {
    private final FileManager fileManager;
    private final Scanner scanner;

    /**
     * Constructs a SaveOption object with the given FileManager and Scanner.
     *
     * @param fileManager the FileManager object to handle file operations
     * @param scanner     the Scanner object to read user input
     */
    public SaveOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
    }

    /**
     * Performs the action of saving the current file.
     */
    @Override
    public void performAction() {
        fileManager.saveFile();
    }
}

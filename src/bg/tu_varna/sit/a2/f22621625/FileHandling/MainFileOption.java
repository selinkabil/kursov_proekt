package bg.tu_varna.sit.a2.f22621625.FileHandling;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;

/**
 * An abstract class representing a main file option in the application.
 * Implements the MenuItem interface to provide a structure for file-related menu actions.
 */
public abstract class MainFileOption implements MenuItem {
    private static FileManager fileManager = new FileManager();

    /**
     * Constructs a new MainFileOption.
     */
    public MainFileOption() {

    }

    /**
     * Gets the FileManager associated with this file option.
     *
     * @return the FileManager instance
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Performs the action associated with this menu item.
     * This method must be implemented by subclasses to define specific file operations.
     *
     * @param arguments additional arguments for the action
     * @throws MainException if an error occurs during the action
     */
    @Override
    public abstract void performAction(String arguments) throws MainException;
}

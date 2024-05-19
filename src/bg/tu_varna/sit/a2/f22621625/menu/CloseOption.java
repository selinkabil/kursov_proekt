package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;

/**
 * Represents a menu option to close the current file.
 */
public class CloseOption implements MenuItem {

    private final FileManager fileManager;

    /**
     * Constructs a CloseOption with the specified FileManager.
     *
     * @param fileManager the FileManager responsible for file management.
     */
    public CloseOption(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /**
     * Performs the action of closing the current file.
     * It delegates the operation to the FileManager associated with this option.
     */
    @Override
    public void performAction() {
        fileManager.closeCurrentFile();
    }
}

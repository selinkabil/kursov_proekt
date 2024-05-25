package bg.tu_varna.sit.a2.f22621625.FileHandling;

/**
 * Represents a menu option to close the current file.
 * This class extends MainFileOption and provides the functionality to close a file using the FileManager.
 */
public class CloseOption extends MainFileOption {

    /**
     * Constructs a new CloseOption.
     */
    public CloseOption() {
    }

    /**
     * Performs the action of closing the current file.
     * It delegates the operation to the FileManager associated with this option.
     *
     * @param arguments additional arguments for the action (not used in this case)
     */
    @Override
    public void performAction(String arguments) {
        getFileManager().closeCurrentFile();
    }
}

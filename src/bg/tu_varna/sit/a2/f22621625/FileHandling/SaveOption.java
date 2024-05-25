package bg.tu_varna.sit.a2.f22621625.FileHandling;

/**
 * Represents an option to save the current file.
 */
public class SaveOption extends MainFileOption {

    /**
     * Constructs a new SaveOption.
     * Initializes the save option.
     */
    public SaveOption() {
    }

    /**
     * Performs the action of saving the current file.
     *
     * @param arguments unused parameter, needed to match the method signature in the MenuItem interface
     */
    @Override
    public void performAction(String arguments) {
        getFileManager().saveFile();
    }
}

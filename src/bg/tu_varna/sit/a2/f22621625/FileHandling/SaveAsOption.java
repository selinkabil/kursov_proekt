package bg.tu_varna.sit.a2.f22621625.FileHandling;


/**
 * Represents an option to save the current file with a new name.
 */
public class SaveAsOption extends MainFileOption {

    /**
     * Constructs a new SaveAsOption.
     * Initializes the save-as option.
     */
    public SaveAsOption() {
    }

    /**
     * Performs the action of saving the current file with a new name.
     *
     * @param arguments the new name for the file
     */
    @Override
    public void performAction(String arguments) {
        String newFileName = arguments;
        getFileManager().saveAsFile(newFileName);
    }
}

package bg.tu_varna.sit.a2.f22621625.FileHandling;


/**
 * Represents an option to open a file for editing.
 */
public class OpenOption extends MainFileOption {

    /**
     * Constructs a new OpenOption.
     * Initializes the file opening option.
     */
    public OpenOption() {
    }

    /**
     * Opens a file for editing based on user input.
     *
     * @param arguments the name of the file to be opened
     */
    @Override
    public void performAction(String arguments) {
        String fileName = arguments;
        getFileManager().openFile(fileName);
    }
}

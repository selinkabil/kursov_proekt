package bg.tu_varna.sit.a2.f22621625.exceptions;

/**
 * The main exception class for the application.
 * Serves as a base class for other custom exceptions in the application.
 */
public class MainException extends Exception {

    /**
     * Constructs a new MainException with the specified detail message.
     *
     * @param message the detail message.
     */
    public MainException(String message) {
        super(message);
    }
}

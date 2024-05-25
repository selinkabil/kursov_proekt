package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

/**
 * Represents a menu option to exit the program.
 */
public class ExitOption extends MainMenuOption {

    /**
     * Constructs a new ExitOption.
     *
     * @throws InvalidArgument if an invalid argument is encountered.
     */
    public ExitOption() throws InvalidArgument {
    }

    /**
     * Performs the action of exiting the program.
     * Closes the Scanner and terminates the program with exit code 0.
     *
     * @param arguments any arguments passed to the option (not used)
     */
    @Override
    public void performAction(String arguments) {
        System.out.println("\nExiting the program...");
        System.exit(0);
    }
}

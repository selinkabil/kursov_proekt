package bg.tu_varna.sit.a2.f22621625.contracts;

import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;

/**
 * Represents a menu item in the application. Each menu item is expected to perform a specific action.
 */
public interface MenuItem {
    /**
     * Executes the action associated with this menu item.
     *
     * @param arguments the arguments needed to perform the action
     * @throws MainException if an error occurs during the action.
     */
    void performAction(String arguments) throws MainException;
}

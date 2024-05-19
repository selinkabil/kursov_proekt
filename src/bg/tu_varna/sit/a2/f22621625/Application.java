package bg.tu_varna.sit.a2.f22621625;

import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.models.Menu;
import bg.tu_varna.sit.a2.f22621625.models.TicketHandle;

import java.util.NoSuchElementException;

/**
 * The Application class represents the entry point of the program.
 */
public class Application {

    /**
     * The main method of the program.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {

        try {
            Menu menu = new Menu();
            TicketHandle ticketHandle = new TicketHandle();
            String date1="1.12.2023";
            String eventName1 = "Concert";
            menu.handleMenuOptions();
        }
        catch (MainException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}

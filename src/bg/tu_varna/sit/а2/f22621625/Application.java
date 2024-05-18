package bg.tu_varna.sit.à2.f22621625;

import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.*;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Application {
    /**
     *
     * @param args
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
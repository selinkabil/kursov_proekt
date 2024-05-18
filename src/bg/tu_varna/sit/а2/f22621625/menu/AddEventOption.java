package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.Event;
import bg.tu_varna.sit.à2.f22621625.models.Hall;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AddEventOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    /**
     *
     * @param ticketSystem
     * @param scanner
     */
    public AddEventOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    /**
     *
     * @throws MainException
     */
    @Override
    public void performAction() throws MainException {

        try {
            String[] input = scanner.nextLine().trim().split("\\s");
            String name = input[0];
            String date = input[1];
            Date parsedDate = ticketSystem.parseDate(date);
            int number = Integer.parseInt(input[2]);
            Hall hall = ticketSystem.findHallByNumber(number);

            if (duplicateEventCheck(parsedDate,hall)) {
                System.out.println("An event with the given date and hall already exists.");
            }
            else if(parsedDate != null) {
                Event newEvent = new Event(name, parsedDate, hall);
                ticketSystem.getEvents().add(newEvent);
                System.out.println("Successfully added event: " + name + " on " + newEvent.getDate());
            }
            else
                System.out.println("Could not add event due to invalid date");
        }
        catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input format.");
        }
    }

    private boolean duplicateEventCheck(Date date , Hall hall){
        for (Event existingEvent : ticketSystem.getEvents()) {
            if (existingEvent.getDate().equals(date) && existingEvent.getHalls().equals(hall)) {
                return true;
            }
        }
        return false;
    }

}

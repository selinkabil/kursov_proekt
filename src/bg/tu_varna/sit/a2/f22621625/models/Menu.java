package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.menu.*;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;
import bg.tu_varna.sit.a2.f22621625.menu.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Represents a menu with various options for managing the ticket system.
 */
public class Menu {
    private String currentContent;
    private File currentFile;
    TicketHandle ticketSystem = new TicketHandle();
    FileManager fileManager = new FileManager();
    Scanner scanner;
    Map<String, MenuItem> actions = new HashMap<>();
    /**
     * Constructs a Menu object and initializes its commands.
     *
     * @throws InvalidArgument if there is an invalid argument
     */
    public Menu() throws InvalidArgument {
        this.scanner = new Scanner(System.in);
        this.currentContent = "";
        this.currentFile = null;
        initializeCommands();
    }
    /**
     * Displays the menu options.
     */
    public void displayMenu() {
        title();
        System.out.println("open <file>                                 opens <file>");
        System.out.println("close                                       closes currently opened file");
        System.out.println("save                                        saves the currently open file");
        System.out.println("saveas <file>                               saves the currently open file in <file>");
        System.out.println("help                                        prints this information");
        System.out.println("exit                                        exists the program");
        System.out.println("addevent <name> <date> <hall>               adds event on date <date> called <name> at hall with number <hall>");
        System.out.println("book <row> <seat> <date> <name> <note>      books a ticket for event <name> at date <date> for row <row> and seat <seat> number, adds note");
        System.out.println("freeseats <date> <name>                     prints all free seats for event with name <name> on date <date>");
        System.out.println("buy <row> <seat> <date> <name>              buys a ticket for <row> and <seat> number for event with <name> on <date>");
        System.out.println("bookings [<date>] [<name>]                  Returns a list of reserved but unpaid tickets for a performance named <name> on <date>. If <name> is omitted, returns information about all performances on the given date. If <date> is omitted, returns information for all dates.");
        System.out.println("check <code>                                Performs a ticket validity check by extracting the seat number from the given <code> code");
        System.out.println("report <from> <to> [<hall>]                 Returns a list of purchased tickets from date <from> to date <to> in hall <hall>");
        System.out.println("mostviewedevents                            Displays statistics for the most viewed shows");
        System.out.println("leastviewedevents                           Displays statistics for shows with less than 10% attendance for a given period and allow the user to download those shows");
    }
    /**
     * Handles menu options input by the user.
     *
     * @throws MainException      if there is a main exception
     * @throws NoSuchElementException if there is no such element
     */
    public void handleMenuOptions() throws MainException, NoSuchElementException {
        displayMenu();
        while (true) {
            System.out.print("> ");

            String command = scanner.next();

            if (actions.containsKey(command)) {
                actions.get(command).performAction();
            } else {
                System.out.println("Unknown command. Try again.");
            }
        }
    }
    /**
     * Initializes the menu commands.
     */
    private void initializeCommands() {
        actions.put("open", new OpenOption(fileManager, scanner));
        actions.put("close", new CloseOption(fileManager));
        actions.put("save", new SaveOption(fileManager, scanner));
        actions.put("saveas", new SaveAsOption(fileManager,scanner));
        actions.put("help", new HelpOption());
        actions.put("exit",  new ExitOption(scanner));
        actions.put("addevent",new AddEventOption(ticketSystem, scanner));
        actions.put("book", new BookTicketOption(ticketSystem, scanner));
        actions.put("freeseats", new FreeSeatsOption(ticketSystem,scanner));
        actions.put("buy",new BuyOption(ticketSystem,scanner));
        actions.put("bookings", new BookingOption(ticketSystem,scanner));
        actions.put("check", new CheckOption(ticketSystem,scanner));
        actions.put("report", new ReportOption(ticketSystem,scanner));
        actions.put("mostviewedevents", new MostViewedEventsOption(ticketSystem));
        actions.put("leastviewedevents", new LeastViewedEventsOption(ticketSystem,scanner));
    }
    /**
     * Displays the title of the application.
     */
    private void title(){
        System.out.println(" \n" +
                ".___________. __    ______  __  ___  _______ .___________.     ______    _______  _______  __    ______  _______ \n" +
                "|           ||  |  /      ||  |/  / |   ____||           |    /  __  \\  |   ____||   ____||  |  /      ||   ____|\n" +
                "`---|  |----`|  | |  ,----'|  '  /  |  |__   `---|  |----`   |  |  |  | |  |__   |  |__   |  | |  ,----'|  |__   \n" +
                "    |  |     |  | |  |     |    <   |   __|      |  |        |  |  |  | |   __|  |   __|  |  | |  |     |   __|  \n" +
                "    |  |     |  | |  `----.|  .  \\  |  |____     |  |        |  `--'  | |  |     |  |     |  | |  `----.|  |____ \n" +
                "    |__|     |__|  \\______||__|\\__\\ |_______|    |__|         \\______/  |__|     |__|     |__|  \\______||_______|\n" +
                "                                                                                                                 \n");
    }

}
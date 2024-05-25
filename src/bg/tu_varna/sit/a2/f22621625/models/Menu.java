package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.FileHandling.*;
import bg.tu_varna.sit.a2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.a2.f22621625.enums.MenuOptions;
import bg.tu_varna.sit.a2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.a2.f22621625.menu.*;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Represents a menu with various options for managing the ticket system.
 */
public class Menu {
    Scanner scanner;
    Map<MenuOptions, MenuItem> actions = new HashMap<>();

    /**
     * Constructs a Menu object and initializes its commands.
     *
     * @throws InvalidArgument if there is an invalid argument
     */
    public Menu() throws InvalidArgument {
        this.scanner = new Scanner(System.in);
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
        System.out.println("unbook <row> <seat> <date><name>            cancels a reservation for a performance named <name> on <date> on row <row> and seat <seat>.");
        System.out.println("freeseats <date> <name>                     prints all free seats for event with name <name> on date <date>");
        System.out.println("buy <row> <seat> <date> <name>              buys a ticket for <row> and <seat> number for event with <name> on <date>");
        System.out.println("bookings [<date>] [<name>]                  returns a list of reserved but unpaid tickets for a performance named <name> on <date>. If <name> is omitted, returns information about all performances on the given date. If <date> is omitted, returns information for all dates.");
        System.out.println("check <code>                                performs a ticket validity check by extracting the seat number from the given <code> code");
        System.out.println("report <from> <to> [<hall>]                 returns a list of purchased tickets from date <from> to date <to> in hall <hall>");
        System.out.println("mostviewedevents                            displays statistics for the most viewed shows");
        System.out.println("leastviewedevents                           displays statistics for shows with less than 10% attendance for a given period and allow the user to download those shows");
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
            String commandLine = scanner.nextLine().trim();
            String[] parts = commandLine.split("\\s+", 2);

            if (parts.length == 0) {
                System.out.println("Unknown command. Please try again.");
                continue;
            }

            String command = parts[0].toUpperCase();
            String arguments = parts.length > 1 ? parts[1] : "";

            try {
                MenuOptions option = MenuOptions.valueOf(command);
                MenuItem menuItem = actions.get(option);
                if (menuItem != null) {
                    menuItem.performAction(arguments);
                } else {
                    System.out.println("Unknown command. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown command. Please try again.");
            }
        }
    }
    /**
     * Initializes the menu commands.
     */
    private void initializeCommands() throws InvalidArgument {

        actions.put(MenuOptions.OPEN, new OpenOption());
        actions.put(MenuOptions.CLOSE, new CloseOption());
        actions.put(MenuOptions.SAVE, new SaveOption());
        actions.put(MenuOptions.SAVEAS, new SaveAsOption());
        actions.put(MenuOptions.HELP, new HelpOption());
        actions.put(MenuOptions.EXIT,  new ExitOption());
        actions.put(MenuOptions.ADDEVENT,new AddEventOption());
        actions.put(MenuOptions.BOOK, new BookTicketOption());
        actions.put(MenuOptions.UNBOOK,new UnbookOption());
        actions.put(MenuOptions.FREESEATS, new FreeSeatsOption());
        actions.put(MenuOptions.BUY,new BuyOption());
        actions.put(MenuOptions.BOOKINGS, new BookingOption());
        actions.put(MenuOptions.CHECK, new CheckOption());
        actions.put(MenuOptions.REPORT, new ReportOption());
        actions.put(MenuOptions.MOSTVIEWEDEVENTS, new MostViewedEventsOption());
        actions.put(MenuOptions.LEASTVIEWEDEVENTS, new LeastViewedEventsOption());
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
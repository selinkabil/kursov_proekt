package bg.tu_varna.sit.à2.f22621625.models;

import bg.tu_varna.sit.à2.f22621625.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;
import bg.tu_varna.sit.à2.f22621625.exceptions.NoOpenedFileException;
import bg.tu_varna.sit.à2.f22621625.menu.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Runnable> commands;
    private String currentContent;
    private File currentFile;
    TicketHandle ticketSystem = new TicketHandle();
    FileManager fileManager = new FileManager();
    Scanner scanner = new Scanner(System.in);
    Map<String, MenuItem> actions = new HashMap<>();

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();
        this.currentContent = "";
        this.currentFile = null;
        initializeCommands();
    }

    public void displayMenu() {
        title();
        System.out.println("open <file>         opens <file>");
        System.out.println("close               closes currently opened file");
        System.out.println("save                saves the currently open file");
        System.out.println("saveas <file>       saves the currently open file in <file>");
        System.out.println("help                prints this information");
        System.out.println("exit                exists the program");
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

    private void initializeCommands() {
        actions.put("addevent",new AddEventOption(ticketSystem, scanner));
        actions.put("book", new BookTicketOption(ticketSystem, scanner));
        actions.put("open", new OpenOption(fileManager, scanner));
        actions.put("save", new SaveOption(fileManager, scanner));
        actions.put("exit",  new ExitOption());

        TicketHandle ticketHandle = new TicketHandle();
        commands.put("open", this::openFile);
        commands.put("close", this::close);
        commands.put("save", this::saveFile);
        commands.put("saveas", this::saveFileAs);
        commands.put("help", this::help);
        commands.put("exit", this::exit);
    }

    private void openFile() {
        String filename = scanner.nextLine();
        try {
            currentFile = new File(filename);
            if (!currentFile.exists()) {
                currentFile.createNewFile();
                System.out.println("File does not exist. A new file has been created.");
            }
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
            reader.close();
            currentContent = builder.toString();
            System.out.println("File opened successfully. Current content loaded. You can now add more text.");

            System.out.println("Type the content you wish to add (type '/' on a new line to stop):");
            while (!(line = scanner.nextLine()).equals("/")) {
                currentContent += line + System.lineSeparator();
            }
            System.out.println("New content added. Use 'save' or 'saveas' to save changes to disk.");

        } catch (IOException e) {
            System.out.println("Failed to open file: " + e.getMessage());
        }
    }

    private void saveFile()  {

        try {
            if (currentFile == null) {
            throw new NoOpenedFileException("No currently opened file");
        }
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
            writer.write(currentContent);
            writer.close();
            System.out.println("File saved successfully.");
        } catch (IOException | NoOpenedFileException e) {
            System.out.println("Failed to save file: " + e.getMessage());
        }
    }

    private void saveFileAs() {
        System.out.println("Enter new file name:");
        String filename = scanner.nextLine();
        try {
            if (currentFile == null) {
                throw new NoOpenedFileException("No currently opened file");
            }
            File file = new File(filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(currentContent);
            writer.close();
            currentFile = file;
            System.out.println("File saved as '" + filename + "' successfully.");
        } catch (IOException | NoOpenedFileException e) {
            System.out.println("Failed to save file: " + e.getMessage());
        }
    }
    private void close(){
        if(currentFile.exists())
            System.out.println("\nSuccessfully closed "+currentFile);
        else
            System.out.println("\nNo opened file");
        currentContent="";
        currentFile=null;
    }
    private void help(){
        System.out.println("\nThe following commands are supported");
        displayMenu();
    }
    private void exit(){
        System.out.println("\nExiting the program...");
        System.exit(0);
    }
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
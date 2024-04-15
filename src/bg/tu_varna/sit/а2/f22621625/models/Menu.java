package bg.tu_varna.sit.à2.f22621625.models;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class Menu {
    private final MenuItem[] menuItems= {
            new OpenOption(),
            new CloseOption(),
            new SaveOption(),
            new SaveAsOption(),
            new HelpOption(),
            new ExitOption()
    };
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println( menuItems[i].getInfo());
        }
    }

    public void handleUserInput() {
        System.out.print("Enter your choice: ");
            String choice = scanner.next();
            boolean valid=false;
            for(MenuItem a : menuItems){
                if(choice.equals(a.getContent())){
                    System.out.println("> "+a.getContent());
                    a.performAction();
                    valid=true;
                }
            }
            if (!valid) {
                System.out.println("Invalid choice!");
            }
    }
    public void closeScanner() {
        scanner.close();
    }
}
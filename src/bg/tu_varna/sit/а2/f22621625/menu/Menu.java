package bg.tu_varna.sit.а2.f22621625.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuOption> menuOptions = new ArrayList<>();
    private static Menu menuInstance;
    
    private Menu(){}

    public static Menu getInstance(){
        if(menuInstance == null){
            menuInstance = new Menu();
            menuInstance.addOptions();
        }
        return menuInstance;
    }

    private void addOptions(){
        menuOptions.add(new Open());
        menuOptions.add(new Close());
        menuOptions.add(new Save());
        menuOptions.add(new SaveAs());
        menuOptions.add(new Help());
        menuOptions.add(new Exit());
    }

    public void printOptions(){
        for (MenuOption option :menuOptions) {
            System.out.printf("%-18s%s%n", option.getName(),option.info());
        }
    }
   public void executeOption(String choice) {
        boolean found=false;
       for (MenuOption option :menuOptions) {
           if (option.getCommand().equals(choice)) {
               found=true;
               option.execute();
           }
       }
       if(!found){
           System.out.println("Not a valid command");
       }

    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice="";
        printOptions();
        System.out.print("Enter your choice: ");
        if(scanner.hasNext())
            choice=scanner.next();
        executeOption(choice);
    }


}

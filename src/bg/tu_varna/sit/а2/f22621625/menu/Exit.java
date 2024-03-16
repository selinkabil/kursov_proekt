package bg.tu_varna.sit.а2.f22621625.menu;


import java.util.Scanner;

public class Exit implements MenuOption {
    private String name= "exit";
    private String command="exit";

    public String getCommand() {
        return command;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("You selected option Exit\n");
        System.exit(0);
    }

    @Override
    public String info() {
        return "exists the program";
    }
}

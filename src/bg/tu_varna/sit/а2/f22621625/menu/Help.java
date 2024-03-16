package bg.tu_varna.sit.а2.f22621625.menu;

public class Help implements MenuOption{
    private String name= "help";
    private String command="help";

    public String getCommand() {
        return command;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("The following commands are supported:");
        Menu menu = Menu.getInstance();
        menu.run();
    }
    @Override
    public String info() {
        return "prints this information";
    }

}

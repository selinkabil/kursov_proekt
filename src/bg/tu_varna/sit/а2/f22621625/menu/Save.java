package bg.tu_varna.sit.а2.f22621625.menu;

public class Save implements MenuOption{
    private String name= "save";
    private String command="save";

    public String getCommand() {
        return command;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("You selected option Save");
    }

    @Override
    public String info() {
        return "saves the currently open file";
    }
}

package bg.tu_varna.sit.а2.f22621625.menu;

public class SaveAs implements MenuOption{
    private String name= "saveas <file>";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("You selected option Save as");
    }

    @Override
    public String info() {
        return "saves the currently open file in <file>";
    }
}

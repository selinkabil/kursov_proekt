package bg.tu_varna.sit.а2.f22621625.menu;

public class Open implements MenuOption{
    private String name= "open <file>";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("You selected option Open");
    }

    @Override
    public String info() {
        return "opens <file>";
    }
}

package bg.tu_varna.sit.а2.f22621625.menu;

public class Close implements MenuOption{
    private String name= "close";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("You selected option Close");
    }

    @Override
    public String info() {
       return "closes currently opened file";
    }
}

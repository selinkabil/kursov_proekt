package bg.tu_varna.sit.à2.f22621625.models;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

public class HelpOption extends MenuField implements MenuItem {

    private final String content = "help";
    private final String info = "help                prints this information";

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void performAction() {
        System.out.println("The following commands are supported");
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

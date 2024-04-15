package bg.tu_varna.sit.а2.f22621625.models;

import bg.tu_varna.sit.а2.f22621625.contracts.MenuItem;

public class ExitOption extends MenuField implements MenuItem {
    private final String content = "> exit";
    private final String info = "exit exists the program";

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
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}

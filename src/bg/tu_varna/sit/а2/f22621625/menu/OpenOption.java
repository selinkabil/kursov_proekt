package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class OpenOption extends MenuField implements MenuItem {
    private final String content = "open";
    private final String info = "open <file>         opens <file>";
    private FileManager fileManager;
    private Scanner scanner;

    public OpenOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
    }

    @Override
    public String getContent() {
        return content;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public void performAction() {
        System.out.print("Enter file name to open: ");
        String fileName = scanner.nextLine();
        fileManager.openFile(fileName);
    }
}

package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class SaveAsOption implements MenuItem {
    private final FileManager fileManager;
    private final Scanner scanner;

    public SaveAsOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner=scanner;
    }

    @Override
    public void performAction() {
        String newFileName=scanner.next();
        fileManager.saveAsFile(newFileName);
    }
}
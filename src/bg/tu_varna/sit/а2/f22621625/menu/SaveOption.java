package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class SaveOption implements MenuItem {
    private final FileManager fileManager;
    private final Scanner scanner;

    public SaveOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        fileManager.saveFile();
    }
}
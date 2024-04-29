package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Scanner;

public class OpenOption implements MenuItem {
    private final FileManager fileManager;
    private final Scanner scanner;

    public OpenOption(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        String fileName = scanner.next();
        fileManager.openFile(fileName);
    }
}

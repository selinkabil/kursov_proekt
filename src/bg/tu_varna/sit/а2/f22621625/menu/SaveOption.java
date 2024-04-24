package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveOption extends MenuField implements MenuItem {
    private final String content = "save";
    private final String info = "save                saves the currently open file";
    private FileManager fileManager;
    private Scanner scanner;

    public SaveOption(FileManager fileManager, Scanner scanner) {
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
        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();
        fileManager.saveFile(fileName);
    }
}
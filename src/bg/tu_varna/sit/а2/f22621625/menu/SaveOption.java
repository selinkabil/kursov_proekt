package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.io.FileWriter;
import java.io.IOException;

public class SaveOption extends MenuField implements MenuItem {
    private final String content = "save";
    private final String info = "save                saves the currently open file";

    public SaveOption() {
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
        try {
            // Save the file content from MenuField
            FileWriter writer = new FileWriter(super.getOpenedFilePath());
            writer.write(super.getOpenedFileContent());
            writer.close();
            System.out.println("\nSuccessfully saved "+super.getOpenedFilePath());
        } catch (IOException | NullPointerException e) {
            System.out.println("\nError saving file: " + e.getMessage());
        }
    }
}
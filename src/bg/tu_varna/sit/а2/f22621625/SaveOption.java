package bg.tu_varna.sit.а2.f22621625;

import java.io.FileWriter;
import java.io.IOException;

public class SaveOption extends MenuField implements MenuItem {
    private final String content = "> save";
    private final String info = "save saves the currently open file";

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
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
package bg.tu_varna.sit.а2.f22621625;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveAsOption extends MenuField implements MenuItem {
    private final String content = "> saveas ";
    private final String info = "saveas <file> saves the currently open file in <file>";

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
            Scanner scanner = new Scanner(System.in);
            super.setOpenedFilePath(scanner.nextLine());
            File file = new File(super.getOpenedFilePath());

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(super.getOpenedFilePath());
            writer.write(super.getOpenedFileContent());
            writer.close();
            System.out.println("File saved successfully!");
            } catch (IOException e) {
                System.out.println("Error saving file as: " + e.getMessage());
            }
        }
}
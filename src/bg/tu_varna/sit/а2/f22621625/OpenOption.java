package bg.tu_varna.sit.а2.f22621625;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OpenOption extends MenuField implements MenuItem {
    private final String content = "> open ";
    private final String info = "open <file> opens <file>";


    public OpenOption() {
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
            Scanner scanner = new Scanner(System.in);
            StringBuilder fileContent = new StringBuilder();
            super.setOpenedFilePath(scanner.nextLine());
            File file = new File(super.getOpenedFilePath());

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(super.getOpenedFilePath()));
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            reader.close();
            System.out.println("File opened successfully!");
            super.setOpenedFileContent(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}

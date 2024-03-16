package bg.tu_varna.sit.а2.f22621625.menu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Open implements MenuOption  {
    private String name= "open <file>";
    private String command="open";

    public String getCommand() {
        return command;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String content="";
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();
        File directory = new File("temp/");
        boolean directoryCreated = directory.mkdir();
        File file = new File(directory, fileName + ".xml");
        try {
            if (!file.exists()) {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    System.out.println("Failed to create file: " + file.getAbsolutePath());
                    return;
                }
                    content=scanner.nextLine();
                System.out.println("Successfully created "+fileName+".xml");
            }
            else{
                System.out.println("Successfully opened "+fileName+".xml");
            }

            FileReader fr = new FileReader(file);
            Scanner fileScanner = new Scanner(fr);
            String fileContent="";
            while (fileScanner.hasNextLine()) {
                 fileContent=fileScanner.nextLine();
            }
            System.out.println(content);
            fr.close();

            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
    @Override
    public String info() {
        return "opens <file>";
    }

}

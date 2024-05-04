package bg.tu_varna.sit.à2.f22621625.menu;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    private final Map<String, String> openFiles;
    private String currentFile;
    private String currentFileContent;

    public FileManager() {
        this.openFiles = new HashMap<>();
        this.currentFile = null;
    }

    public String handleFileContent(String content){
        System.out.println("Content of file:");
        System.out.println(content);

        StringBuilder updatedContent = new StringBuilder(content);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new content below (end with 'end'): ");
        String line;
        while (!(line = scanner.nextLine()).equals("end")) {
            updatedContent.append(line).append("\n");
        }
        currentFileContent=updatedContent.toString();
        return currentFileContent;
    }

    public void openFile(String fileName) {
            try {
                File file = new File(fileName);
                if (!file.exists()){
                        file.createNewFile();
                        openFiles.put(fileName, "");
                        currentFile = fileName;
                }

                StringBuilder content = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                }
                openFiles.put(fileName, content.toString());
                currentFile = fileName;
                System.out.println("Successfully opened: " + fileName);
                closeCurrentFile();
                currentFileContent=handleFileContent(content.toString());

            } catch (IOException e) {
                System.out.println("File not found.");
            }
    }



    public void closeCurrentFile() {
        if (currentFile != null && openFiles.containsKey(currentFile)) {
            openFiles.remove(currentFile);
            System.out.println("Successfully closed " + currentFile);
        }
        else
            System.out.println("No opened file to close.");
    }

    public void saveFile() {
        try {
            if (currentFile != null || currentFileContent != null) {
                FileWriter writer = new FileWriter(currentFile);
                writer.write(currentFileContent);
                writer.close();
                openFiles.put(currentFile, currentFileContent);
                System.out.println("File saved successfully as: " + currentFile);
            } else {
                System.out.println("No content to save or no opened file.");
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    public void saveAsFile(String newFileName) {
        try {
            if (currentFile != null ) {
                File file = new File(newFileName);
                if (!file.exists()){
                    file.createNewFile();
                }
                FileWriter writer = new FileWriter(newFileName);
                writer.write(currentFileContent);
                writer.close();
                openFiles.put(newFileName, currentFileContent);
                System.out.println("File saved successfully as: " + newFileName);
            } else {
                System.out.println("No opened file to save.");
            }
        } catch (IOException e) {
            System.out.println("Error saving file as: " + e.getMessage());
        }
    }
}

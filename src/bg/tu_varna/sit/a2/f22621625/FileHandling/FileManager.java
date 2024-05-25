package bg.tu_varna.sit.a2.f22621625.FileHandling;

import java.io.*;
import java.util.Scanner;

/**
 * Manages file operations such as opening, closing, saving, and saving as files.
 */
public class FileManager {
    private String currentFile;
    private String currentFileContent;


    public FileManager() {
    }
    /**
     * Handles the content of the file.
     * Prompts the user to enter new content and updates the current file content accordingly.
     *
     * @param content the current content of the file
     * @return the updated content of the file
     */
    public String handleFileContent(String content) {
        StringBuilder updatedContent = new StringBuilder(content);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new content below (end with 'end'): ");
        String line;
        while (!(line = scanner.nextLine()).equals("end")) {
            updatedContent.append(line).append("\n");
        }
        currentFileContent = updatedContent.toString();
        return currentFileContent;
    }

    /**
     * Opens a file with the specified filename.
     * If the file does not exist, creates a new empty file.
     * Reads the content of the file and updates the current file and its content.
     *
     * @param fileName the name of the file to open
     */
    public void openFile(String fileName) {
            readFromFile(fileName);
            closeCurrentFile();

    }

    /**
     * Closes the currently open file.
     */
    public void closeCurrentFile() {
        if (currentFile != null) {
            currentFileContent="";
            System.out.println("Successfully closed " + currentFile);
        } else {
            System.out.println("No opened file to close.");
        }
    }

    /**
     * Saves the content of the currently open file.
     */
    public void saveFile() {
        try {
            readFromFile(currentFile);
            handleFileContent(currentFileContent);
            if (currentFile != null && currentFileContent != null) {
                try (FileWriter writer = new FileWriter(currentFile)) {
                    writer.write(currentFileContent);
                }
                System.out.println("File saved successfully as: " + currentFile);
            } else {
                System.out.println("No content to save or no opened file.");
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    /**
     * Saves the content of the currently open file to a new file with the specified filename.
     *
     * @param newFileName the name of the new file to save as
     */
    public void saveAsFile(String newFileName) {
        try {
            readFromFile(currentFile);
            handleFileContent(currentFileContent);
            if (currentFile != null && currentFileContent != null) {
                File file = new File(newFileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                try (FileWriter writer = new FileWriter(newFileName)) {
                    writer.write(currentFileContent);
                }
                System.out.println("File saved successfully as: " + newFileName);
            } else {
                System.out.println("No opened file to save.");
            }
        } catch (IOException e) {
            System.out.println("Error saving file as: " + e.getMessage());
        }
    }

    private void readFromFile(String fileName){
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                currentFile = fileName;
            }
            StringBuilder content = new StringBuilder("");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            currentFile = fileName;
            System.out.println("Successfully opened: " + fileName);
            currentFileContent = content.toString();
            System.out.println("Content of file:");
            System.out.println(content);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

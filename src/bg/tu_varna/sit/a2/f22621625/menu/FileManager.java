package bg.tu_varna.sit.a2.f22621625.menu;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Manages file operations such as opening, closing, saving, and saving as files.
 */
public class FileManager {

    private final Map<String, String> openFiles;
    private String currentFile;
    private String currentFileContent;

    /**
     * Constructs a new FileManager object.
     * Initializes an empty map for storing open files.
     */
    public FileManager() {
        this.openFiles = new HashMap<>();
        this.currentFile = null;
    }

    /**
     * Handles the content of the file.
     * Prompts the user to enter new content and updates the current file content accordingly.
     *
     * @param content the current content of the file
     * @return the updated content of the file
     */
    public String handleFileContent(String content) {
        System.out.println("Content of file:");
        System.out.println(content);

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
        try {
            File file = new File(fileName);
            if (!file.exists()) {
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
            currentFileContent = handleFileContent(content.toString());

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Closes the currently open file.
     */
    public void closeCurrentFile() {
        if (currentFile != null && openFiles.containsKey(currentFile)) {
            openFiles.remove(currentFile);
            System.out.println("Successfully closed " + currentFile);
        } else
            System.out.println("No opened file to close.");
    }

    /**
     * Saves the content of the currently open file.
     */
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

    /**
     * Saves the content of the currently open file to a new file with the specified filename.
     *
     * @param newFileName the name of the new file to save as
     */
    public void saveAsFile(String newFileName) {
        try {
            if (currentFile != null) {
                File file = new File(newFileName);
                if (!file.exists()) {
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

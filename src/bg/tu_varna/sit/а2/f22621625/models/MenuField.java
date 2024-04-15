package bg.tu_varna.sit.à2.f22621625.models;


public class MenuField {
    private static String openedFileContent;
    private static String openedFilePath;
    private static String fileFormat=".xml";

    public static String getFileFormat() {
        return fileFormat;
    }

    public void setOpenedFileContent(String openedFileContent) {
        MenuField.openedFileContent = openedFileContent;
    }

    public String getOpenedFileContent() {
        return openedFileContent;
    }

    public void setOpenedFilePath(String openedFilePath) {
        MenuField.openedFilePath = openedFilePath+getFileFormat();
    }

    public String getOpenedFilePath() {
        return openedFilePath;
    }
}

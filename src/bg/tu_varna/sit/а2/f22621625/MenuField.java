package bg.tu_varna.sit.а2.f22621625;


public class MenuField {
    private static String openedFileContent;
    private static String openedFilePath;


    public void setOpenedFileContent(String openedFileContent) {
        MenuField.openedFileContent = openedFileContent;
    }

    public String getOpenedFileContent() {
        return openedFileContent;
    }

    public void setOpenedFilePath(String openedFilePath) {
        MenuField.openedFilePath = openedFilePath;
    }

    public String getOpenedFilePath() {
        return openedFilePath;
    }
}

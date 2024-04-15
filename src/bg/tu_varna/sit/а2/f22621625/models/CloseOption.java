package bg.tu_varna.sit.�2.f22621625.models;

import bg.tu_varna.sit.�2.f22621625.contracts.MenuItem;

public class CloseOption extends MenuField implements MenuItem {
    private final String content = "close";
    private final String info = "close               closes currently opened file";

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void performAction() {
        System.out.println("Closing the file...");
        setOpenedFileContent(null);
        setOpenedFilePath(null);
    }
}

package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

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
        if(getOpenedFilePath()!=null)
        System.out.println("\nSuccessfully closed "+super.getOpenedFilePath());
        else
            System.out.println("\nNo opened file");
        setOpenedFileContent(null);
        setOpenedFilePath(null);
    }
}

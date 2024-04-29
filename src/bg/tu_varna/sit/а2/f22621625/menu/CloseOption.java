package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

public class CloseOption implements MenuItem {

    private final FileManager fileManager;

    public CloseOption(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void performAction() {
        fileManager.closeCurrentFile();
    }
}

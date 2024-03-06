package bg.tu_varna.sit.а2.f22621625.menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuOption> menuOptions = new HashMap<>();
    private static Menu menuInstance;

    private Menu(){}

    public static Menu getInstance(){
        if(menuInstance == null){
            menuInstance = new Menu();
            menuInstance.addOptions();
        }
        return menuInstance;
    }

    private void addOptions(){
        menuOptions.put(1,new Open());
        menuOptions.put(2,new Close());
        menuOptions.put(3,new Save());
        menuOptions.put(4,new SaveAs());
        menuOptions.put(5,new Help());
        menuOptions.put(6,new Exit());
    }

    public void printOptions(){
        for (Map.Entry<Integer,MenuOption> key : menuOptions.entrySet()) {
            System.out.println(key.getKey() +". "+ key.getValue().getName());
        }
    }

}

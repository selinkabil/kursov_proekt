package bg.tu_varna.sit.а2.f22621625.menu;

public class Help implements MenuOption{
    private String name= "help";
    private String command="help";

    public String getCommand() {
        return command;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("The following commands are supported:");
        Menu menu = Menu.getInstance();
        menu.printOptions();
    }
    @Override
    public String info() {
        return "prints this information";
    }
    public void printTitle(){
        System.out.print("\n" +
                ".___________. __    ______  __  ___  _______ .___________.     ______    _______  _______  __    ______  _______ \n" +
                "|           ||  |  /      ||  |/  / |   ____||           |    /  __  \\  |   ____||   ____||  |  /      ||   ____|\n" +
                "`---|  |----`|  | |  ,----'|  '  /  |  |__   `---|  |----`   |  |  |  | |  |__   |  |__   |  | |  ,----'|  |__   \n" +
                "    |  |     |  | |  |     |    <   |   __|      |  |        |  |  |  | |   __|  |   __|  |  | |  |     |   __|  \n" +
                "    |  |     |  | |  `----.|  .  \\  |  |____     |  |        |  `--'  | |  |     |  |     |  | |  `----.|  |____ \n" +
                "    |__|     |__|  \\______||__|\\__\\ |_______|    |__|         \\______/  |__|     |__|     |__|  \\______||_______|\n" +
                "                                                                                                                 \n");


    }
}

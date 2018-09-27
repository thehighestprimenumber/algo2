package bash;

public class CommandExecuter {

    public static void execute(String command) {

        Process p;
        try {
        	if (System.getProperty("os.name").equalsIgnoreCase("Windows"))
    			command = "cmd /c start cmd.exe "+command;
    	else 
    		command= "/usr/bin/x-terminal-emulator --disable-factory -e "+ command;
            p = Runtime.getRuntime().exec(command);
//            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

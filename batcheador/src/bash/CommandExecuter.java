package bash;

import java.io.IOException;

public class CommandExecuter {

	public static void execute(String command) throws IOException {

		String os = System.getProperty("os.name");

		if (os.equalsIgnoreCase("linux"))
			command = "/usr/bin/x-terminal-emulator --disable-factory -e " + command;
		else
			command = "cmd /c start cmd.exe /K \"echo " + command + " && " + command + "\"";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e1) {
			e1.printStackTrace();
			throw e1;
		}
	}
}

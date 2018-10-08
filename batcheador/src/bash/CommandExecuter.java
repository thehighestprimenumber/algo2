package bash;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecuter {

    public static Boolean execute(String command) {

        StringBuilder output = new StringBuilder();

//        Process p;
//        try {
//            p = Runtime.getRuntime().exec(command);
//            p.waitFor();
//            BufferedReader reader =
//                    new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));
//
//            String line;
//            while ((line = reader.readLine())!= null) {
//                output.append(line);
//                output.append("\n");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
	    try{
		    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"" + command + "\"");
	    }catch (Exception e){
	    	return false;
	    }

        return true;

    }
}

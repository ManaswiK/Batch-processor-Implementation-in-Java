package ProjectOne;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example of using a JavaSE 7 ProcessBuilder to execute a 
 * command that reads from a file (randomwords.txt) and write the
 * command's output to a file (sortedwords.txt).
 */
public class CmdProcessBuilderFiles
{
	public String SortArray(String sBodyContent)
	{
		String[] sTemp = sBodyContent.split(" ");
		
		Arrays.sort(sTemp);
		StringBuilder obj = new StringBuilder();
		
		for (String stringValue : sTemp) {
			obj.append(stringValue +"\n");
		}
		//return obj.toString();

       List<String> command = new ArrayList<String>();
		command.add("SORT");
		command.add("/r");
		command.add("randomwords.txt");
		
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(command);
		builder.directory(new File("work"));
		builder.redirectError(new File("error.txt"));
		builder.redirectOutput(new File("C:/work/sortedwords.txt"));

		Process process = null;
		try {
			process = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Program terminated!");
		//return obj.toString();
		//return command;
		return obj.toString();
	}
}

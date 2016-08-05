package ProjectOne;

import java.util.HashMap;
import java.util.Map;

import ProjectOne.CommandFiles.Commands;

public class Batch {

	String workingDir = "C:/work/randomwords.txt";
	Map<String, Commands> commands;
	
	public Batch(){
		commands = new HashMap<String, Commands>();
	}
	
	public void addCommand(Commands command){
		commands.put(command.describe(),command);
	}
	
	public String getWorkingDir(){
		//return System.getProperty("user.dir");
		return workingDir;
	}
	
	public Map<String, Commands> getCommands(){
		return commands;
	}
}

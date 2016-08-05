package ProjectOne.CommandFiles;

import org.w3c.dom.Element;

public abstract class Commands {
	
	public static String sCommandtype; 

	public abstract String describe();
	
	public abstract String GetPath();
	
	public abstract Commands parse(Element element);
	
	public abstract void execute(String workingDir);
}

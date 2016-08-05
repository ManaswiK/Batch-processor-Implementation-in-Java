package ProjectOne.CommandFiles;

import org.w3c.dom.Element;

public class WDCommand extends Commands {

	private String sId;
	private String sPath;
	
	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return "WD";
	}

	@Override
	public Commands parse(Element element) {
		WDCommand obj = new WDCommand();
		obj.setsId(element.getAttribute("id"));
		obj.setsPath(element.getAttribute("path"));
		return (Commands)obj;
	}

	@Override
	public void execute(String workingDir) {
		// TODO Auto-generated method stub
		
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	String getsPath() {
		return sPath;
	}

	void setsPath(String sPath) {
		this.sPath = sPath;
	}

	@Override
	public String GetPath() {
		// TODO Auto-generated method stub
		return sPath;
	}

}

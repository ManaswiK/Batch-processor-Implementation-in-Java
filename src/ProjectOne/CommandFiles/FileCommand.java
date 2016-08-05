package ProjectOne.CommandFiles;

import org.w3c.dom.Element;

public class FileCommand extends Commands {

	private String sId;
	private String sPath;
	
	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return "File";
	}

	@Override
	public Commands parse(Element element) {
		FileCommand obj = new FileCommand();
		obj.setsId(element.getAttribute("id"));
		obj.setsPath(element.getAttribute("path"));
		return (Commands)obj;
	}

	@Override
	public void execute(String workingDir) {
		// TODO Auto-generated method stub
		
	}

	String getsId() {
		return sId;
	}

	void setsId(String sId) {
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

package ProjectOne.CommandFiles;

import java.io.IOException;

import org.w3c.dom.Element;

import ProjectOne.CmdProcessBuilderStreams;

public class CmdCommand extends Commands {

	String sId;
	String sPath;
	String args;
	String sIn;
	String sOut;
	
 	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return "CMD";
	}

	@Override
	public Commands parse(Element element) {
		CmdCommand obj = new CmdCommand();
		try {
			obj.sId = (element.getAttribute("id"));
			obj.sPath = (element.getAttribute("path"));
			obj.args= (element.getAttribute("args"));
			obj.sIn = (element.getAttribute("in"));;
			obj.sOut = (element.getAttribute("out"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (Commands)obj;
	}

	@Override
	public void execute(String workingDir) {
		switch (sPath) {
		case "cmd":
			if(args.equals("/c dir"))
			{
				CmdProcessBuilderStreams obj = new CmdProcessBuilderStreams();
				try {
					obj.SortBatch1File(workingDir);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		
		case "sort":
			// System.out.println("sort wil be called"); //added by phani
			// System.out.println(args);
			if(args.isEmpty()){
				 System.out.println("sort will be called");   //added by phani
				CmdProcessBuilderStreams obj = new CmdProcessBuilderStreams();
				try {
					obj.SortBatch1File(workingDir);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				
			}
			break;
		case "java.exe":
			
			break;
		default:
			break;
		}
	}

	@Override
	public String GetPath() {
		// TODO Auto-generated method stub
		return sPath;
	}

}

package ProjectOne;

import java.io.File;
import java.util.Map;

import ProjectOne.CommandFiles.Commands;

public class BatchProcessor {
	public static void main(String[] args) {
		BatchProcessor batProceObj = new BatchProcessor();
		BatchParser obj = new BatchParser();
		//System.out.println(System.getProperty("user.dir"));
		//File f = new File(System.getProperty("user.dir")+ "/Batch2.xml");
		File f = new File("C:/work/batch2.dos.xml");
		batProceObj.execute(obj.buildBatch(f));
	}
	
	public void execute(Batch batch){
		Map<String, Commands> obj= batch.commands;
	    //System.out.println("batch.commands"+batch.commands);
		// workingDir = obj.get("WD").GetPath();
		 String workingDir = "\\"+ obj.get("File").GetPath();
		 System.out.println(obj.values());
		 obj.get("CMD").execute(workingDir);
	}
}

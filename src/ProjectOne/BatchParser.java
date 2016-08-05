package ProjectOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ProjectOne.CommandFiles.CmdCommand;
import ProjectOne.CommandFiles.Commands;
import ProjectOne.CommandFiles.FileCommand;
import ProjectOne.CommandFiles.PipeCmdCommand;
import ProjectOne.CommandFiles.WDCommand;

public class BatchParser {

	protected Batch buildBatch(File batchFile){
		Batch batchObj = new Batch();
		
		try {						
			FileInputStream fis = new FileInputStream(batchFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fis);

			Element pnode = doc.getDocumentElement();
			NodeList nodes = pnode.getChildNodes();
			//System.out.println("nodes"+nodes); // added by phani
			for (int idx = 0; idx < nodes.getLength(); idx++) {
				Node node = nodes.item(idx);
				System.out.println("node"+node);	//added by phani
				System.out.println("node type: "+node.getNodeType());   //added by phani
				//System.out.println("nodemap "+node.getAttributes());    //added by phani
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("Node.ELEMENT_NODE: "+Node.ELEMENT_NODE);
					Element elem = (Element) node;
					System.out.println("elem "+elem);
					batchObj.addCommand(buildCommand(elem));
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return batchObj;
	}
	
	private Commands buildCommand(Element elem) throws ProcessException
	{	
		String cmdName = elem.getNodeName();
		Commands cmd = null;
		
		if (cmdName == null) {
			throw new ProcessException("unable to parse command from " + elem.getTextContent());
		}
		else if ("wd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing wd");
			cmd = new WDCommand();
			cmd = cmd.parse(elem);
			//Commands cmd = WDCommand.parse(elem);
		}
		else if ("file".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing file");
			cmd = new FileCommand();
			cmd = cmd.parse(elem);
			//Command cmd = FileCommand.parse(elem);
		}
		else if ("cmd".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing cmd");
			cmd = new CmdCommand();
			cmd = cmd.parse(elem);
			//Command cmd = CmdCommand.parse(elem);
			//parseCmd(elem); // Example of parsing a cmd element
		}
		else if ("pipe".equalsIgnoreCase(cmdName)) {
			System.out.println("Parsing pipe");
			cmd = new PipeCmdCommand();
			cmd = cmd.parse(elem);
			//Command cmd = PipeCommand.parse(elem);
		}
		else {
			throw new ProcessException("Unknown command " + cmdName + " from: " + elem.getBaseURI());
		}
		return cmd;
	}
}

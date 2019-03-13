package ParserXML;

import java.io.File;

public class TBAML_validator {
	private File myTBAMLfile;
	private File schemaFileTbaml;
	
	public TBAML_validator(File tbamlFile) {
		this.myTBAMLfile=tbamlFile;
		File schemaFileTbaml;
		
	}
	
	public boolean validateTest() {
		schemaFileTbaml = new File("/tba.xsd"); 
		//en cours...   
		return false;
	}


}

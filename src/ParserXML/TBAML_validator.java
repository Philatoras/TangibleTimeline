package ParserXML;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.net.URL;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;


//Cette classe permet de valider ou non un fichier tbaml en fonction du schéma XSD associé
public class TBAML_validator {
	private File myTBAMLfile;
	private File schemaFileTbaml;
	
	public TBAML_validator(File tbamlFile) {
		this.myTBAMLfile=tbamlFile;
		File schemaFileTbaml;
		
	}
	
	public boolean validateTest() {
		boolean isValide=false;
		schemaFileTbaml = new File("/tba.xsd"); 
		
		Source xmlFile = new StreamSource(this.myTBAMLfile);

		SchemaFactory schemaFactory = SchemaFactory
			    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			try {
			  Schema schema = schemaFactory.newSchema(schemaFileTbaml);
			  Validator validator = schema.newValidator();
			  validator.validate(xmlFile);
			  System.out.println(xmlFile.getSystemId() + " le tbaml est valide");
			  isValide=true;
			} catch (SAXException e) {
			  System.out.println(xmlFile.getSystemId() + " le tbaml n'est pas valide:" + e);
			} catch (IOException e) {}
		return isValide;
	}


}

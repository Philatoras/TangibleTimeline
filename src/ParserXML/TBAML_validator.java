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


/**
 * Cette classe permet de valider ou non un fichier tbaml en fonction du schéma XSD associé
 * @author ludovic
 *
 */
public class TBAML_validator {
	private File myTBAMLfile;
	private File schemaFileTbaml;
	
	public TBAML_validator(File tbamlFile)  {
		this.myTBAMLfile=tbamlFile;
		//File schemaFileTbaml;
		
	}
	
	public boolean validateTest() throws tbamlFormatException{
		boolean isValide=false;
		schemaFileTbaml = new File("./tba.xsd"); 
		Schema schema=null;
		Source xmlFile = new StreamSource(this.myTBAMLfile);

		SchemaFactory schemaFactory = SchemaFactory
			    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			schema = schemaFactory.newSchema(schemaFileTbaml);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
			  Validator validator = schema.newValidator();
			  validator.validate(xmlFile);
			  System.out.println(xmlFile.getSystemId() + " le tbaml est valide");
			  isValide=true;
			} catch (SAXException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				throw new tbamlFormatException(schema);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				throw new tbamlFormatException(schema);
			}
		return isValide;
	}


}

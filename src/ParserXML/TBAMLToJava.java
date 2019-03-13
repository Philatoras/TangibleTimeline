package ParserXML;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import blocs.CodingBlock;
import blocs.PionBlock;
import serveur.ZoneManagerBloc;

/**
 * Classe d�di�e � la conversion des fichiers TBAML en code java
 * @author gwend
 *
 */
public class TBAMLToJava extends DefaultHandler {

	private static ZoneManagerBloc zmb;
	
	private static final String FILE_TO_CONVERT = "/test.tbaml";
	
	private Map<String,CodingBlock> codingBlocks; //Map de CodingBlocks caract�ris�s par leur ID
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName == "Link") {
			String srcId = attributes.getValue("srcId");
			String destId = attributes.getValue("destId");
			CodingBlock src = codingBlocks.get(srcId);
			CodingBlock dest = codingBlocks.get(destId);
			src.addSortie(dest);
		}
		if(qName == "Pion") {
			String id = attributes.getValue("id");
			String color = attributes.getValue("color");
			String form = attributes.getValue("form");
			PionBlock pion = new PionBlock(id, color, form);
			zmb.addPion(pion);
		}
		if(qName == "Zone") {
			String id = attributes.getValue("id");
		}
	}
	
	public TBAMLToJava(){
		super();
	}
	
	/**
	 * Lance la conversion du fichier TBAML en code java
	 * @param zmb ZoneManager utilis� pour le programme
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void convert(ZoneManagerBloc zmb) throws ParserConfigurationException,
	SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		TBAMLToJava.zmb = zmb;
		saxParser.parse(new File(FILE_TO_CONVERT),new TBAMLToJava());
		
	}
}

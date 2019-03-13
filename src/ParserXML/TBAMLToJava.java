package ParserXML;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import blocs.CodingBlock;
import serveur.ZoneManagerBloc;

/**
 * Classe dédiée à la conversion des fichiers TBAML en code java
 * @author gwend
 *
 */
public class TBAMLToJava extends DefaultHandler {

	private static ZoneManagerBloc zmb;
	
	private static final String FILE_TO_CONVERT = "/test.tbaml";
	
	private Map<String,CodingBlock> codingBlocks; //Map de CodingBlocks caractérisés par leur ID
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName == "Link") {
			String srcId = attributes.getValue("srcId");
			String destId = attributes.getValue("destId");
			CodingBlock src = codingBlocks.get(srcId);
			CodingBlock dest = codingBlocks.get(destId);
			src.addSortie(dest);
		}
	}
	
	public TBAMLToJava(){
		super();
	}
	
	public static void convert(ZoneManagerBloc zmb) throws ParserConfigurationException,
	SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		TBAMLToJava.zmb = zmb;
		saxParser.parse(new File(FILE_TO_CONVERT),new TBAMLToJava());
		
	}
}

package ParserXML;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import blocs.Attributs;
import blocs.CodingBlock;
import blocs.ConditionBlock;
import blocs.GroupBlock;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.TextBlock;
import blocs.ZoneBlock;
import serveur.ZoneManagerBloc;

/**
 * Classe dédiée à la conversion des fichiers TBAML en code java
 * @author gwend
 *
 */
public class TBAMLToJava extends DefaultHandler {

	private static ZoneManagerBloc zmb;
	
	private static String FILE_TO_CONVERT = "/test.tbaml";
	
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
		if(qName == "Pion") {
			String id = attributes.getValue("id");
			String color = attributes.getValue("color");
			String form = attributes.getValue("form");
			PionBlock pionBlock = new PionBlock(id, color, form);
			zmb.addPion(pionBlock);
			codingBlocks.put(id, pionBlock);
		}
		if(qName == "Zone") {
			String id = attributes.getValue("id");
			//String form = attributes.getValue("form");
			String x = attributes.getValue("x");
			String y = attributes.getValue("y");
			String width = attributes.getValue("width");
			String height = attributes.getValue("height");
			String texte = attributes.getValue("texte");
			ZoneBlock zoneBlock = new ZoneBlock(id,Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(width),Integer.parseInt(height), texte);
			zmb.addZone(zoneBlock);
			codingBlocks.put(id,zoneBlock);
		}
		if(qName == "Text") {
			String id = attributes.getValue("id");
			String texte = attributes.getValue("texte");
			TextBlock textBlock = new TextBlock(texte);
			codingBlocks.put(id, textBlock);
		}
		if(qName == "Cond") {
			String id = attributes.getValue("id");
			String attribut = attributes.getValue("att");
			String valeur = attributes.getValue("valCible");
			ConditionBlock textBlock = new ConditionBlock(Attributs.valueOf(attribut), valeur);
			codingBlocks.put(id, textBlock);
		}
		if(qName == "Tts") {
			String id = attributes.getValue("id");
			TTSBlock tts = new TTSBlock();
			codingBlocks.put(id, tts);
		}
		if(qName == "ZoneGroup") {
			String id = attributes.getValue("id");
			GroupBlock group = new GroupBlock(id);
			codingBlocks.put(id, group);
		}
	}
	
	public TBAMLToJava(){
		super();
	}
	
	//charger une nouvelle application Tangible Box à partir de .tbaml
	protected void changeTbamlFile() {
		XML_finder graphicFinder=new XML_finder();
		File nouveauTbaml=graphicFinder.fileChooser();
		TBAMLToJava.FILE_TO_CONVERT=nouveauTbaml.getAbsolutePath();
	}
	
	/**
	 * Lance la conversion du fichier TBAML en code java
	 * @param zmb ZoneManager utilisé pour le programme
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void convert(ZoneManagerBloc zmb) throws ParserConfigurationException,
	SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		TBAMLToJava.zmb = zmb;
		File myTbaml=new File(FILE_TO_CONVERT);
		TBAML_validator tbamlValidator=new TBAML_validator(myTbaml);
		try {
			tbamlValidator.validateTest();
		} catch (tbamlFormatException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}

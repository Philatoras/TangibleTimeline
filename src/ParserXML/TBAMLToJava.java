package ParserXML;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
	
	private static String fileToConvert;
	
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
	
	/**
	 * Lance le parsing grâce à SAX
	 */
	public TBAMLToJava(){
		super();
		this.codingBlocks = new HashMap<String, CodingBlock>();
	}
	
	/**
	 * charger une nouvelle application Tangible Box à partir de .tbaml
	 */
	protected void changeTbamlFile() {
		XML_finder graphicFinder=new XML_finder();
		File nouveauTbaml=graphicFinder.fileChooser();
		TBAMLToJava.fileToConvert=nouveauTbaml.getAbsolutePath();
	}
	
	/**
	 * Lance la conversion du fichier TBAML en code java
	 * @param in_zmb ZoneManager utilisé pour le programme
	 * @param in_fileToConvert path du fichier à convertir
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void convert(ZoneManagerBloc in_zmb, String in_fileToConvert) throws ParserConfigurationException,
	SAXException, IOException {
		fileToConvert = in_fileToConvert;
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		TBAMLToJava.zmb = in_zmb;
		
		File myTbaml=new File(fileToConvert);
		TBAML_validator tbamlValidator=new TBAML_validator(myTbaml);
		//try {
			//tbamlValidator.validateTest();
			saxParser.parse(myTbaml, new TBAMLToJava());
		//} catch (tbamlFormatException e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
		//}
		
	}
}

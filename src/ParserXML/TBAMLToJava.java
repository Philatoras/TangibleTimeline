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
import blocs.ConditionVariableBlock;
import blocs.GroupBlock;
import blocs.PionBlock;
import blocs.PlaySongBlock;
import blocs.SongBlock;
import blocs.SwitchBlock;
import blocs.TTSBlock;
import blocs.TextBlock;
import blocs.VariableBlock;
import blocs.ZoneBlock;
import serveur.ZoneManagerBloc;

/**
 * Classe d�di�e � la conversion des fichiers TBAML en code java
 * 
 * @author gwend
 *
 */
public class TBAMLToJava extends DefaultHandler {

	private static ZoneManagerBloc zmb;

	private static String fileToConvert;

	private Map<String, CodingBlock> codingBlocks; // Map de CodingBlocks caract�ris�s par leur ID

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName == "Link") {
			String srcId = attributes.getValue("srcId");
			String destId = attributes.getValue("destId");
			String port = attributes.getValue("port");
			System.out.println("Lien : " + srcId + " vers " + destId);
			CodingBlock dest = codingBlocks.get(destId);
			if (dest == null)
				throw new NullPointerException("erreur destination");
			//Cas par defaut
			if(port == null) {
				CodingBlock src = codingBlocks.get(srcId);					
				src.addSortie(dest);
			}
			//Cas d'un block condition avec else
			else {
				
				switch(port) {
					case "else":
						ConditionBlock srcCond = (ConditionBlock) codingBlocks.get(srcId);
						srcCond.addSortieFalse(dest);
						break;
					case "entered":
						ZoneBlock srcZEnt = (ZoneBlock) codingBlocks.get(srcId);
						srcZEnt.addSortieEntree(dest);
						break;
					case "exited":
						ZoneBlock srcZExit = (ZoneBlock) codingBlocks.get(srcId);
						srcZExit.addSortieSortie(dest);
						break;
					default:
						SwitchBlock srcSwitch = (SwitchBlock) codingBlocks.get(srcId);
						srcSwitch.addInMap(port, dest);
						break;
				}
				
			}
			
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
		if(qName == "VarCond") {
			String id = attributes.getValue("id");
			String variable = attributes.getValue("variable");
			String valeur = attributes.getValue("valCible");
			ConditionVariableBlock block = new ConditionVariableBlock(variable, valeur);
			codingBlocks.put(id, block);
		}
		if(qName == "Var") {
			String id = attributes.getValue("id");
			VariableBlock block = new VariableBlock(id);
			codingBlocks.put(id, block);
		}
		if(qName == "CondSwitch") {
			String id = attributes.getValue("id");
			String attribut = attributes.getValue("att");
			SwitchBlock switchBlock = new SwitchBlock(id, Attributs.valueOf(attribut));
			codingBlocks.put(id, switchBlock);
		}
		if(qName == "Song") {
			String id = attributes.getValue("id");
			String songName = attributes.getValue("songName");
			SongBlock songBlock = new SongBlock(songName);
			codingBlocks.put(id, songBlock);
		}
		if(qName == "SongPlayer") {
			String id = attributes.getValue("id");
			PlaySongBlock playSongBlock = new PlaySongBlock();
			codingBlocks.put(id, playSongBlock);
		}
	}

	/**
	 * Lance le parsing gr�ce � SAX
	 */
	public TBAMLToJava() {
		super();
		this.codingBlocks = new HashMap<String, CodingBlock>();
	}

	/**
	 * charger une nouvelle application Tangible Box � partir de .tbaml
	 */
	protected void changeTbamlFile() {
		XML_finder graphicFinder = new XML_finder();
		File nouveauTbaml = graphicFinder.fileChooser();
		TBAMLToJava.fileToConvert = nouveauTbaml.getAbsolutePath();
	}

	/**
	 * Lance la conversion du fichier TBAML en code java
	 * 
	 * @param in_zmb           ZoneManager utilis� pour le programme
	 * @param in_fileToConvert path du fichier � convertir
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void convert(ZoneManagerBloc in_zmb, String in_fileToConvert)
			throws ParserConfigurationException, SAXException, IOException {
		fileToConvert = in_fileToConvert;

		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		TBAMLToJava.zmb = in_zmb;

		File myTbaml = new File(fileToConvert);
		TBAML_validator tbamlValidator = new TBAML_validator(myTbaml);
		try {
			tbamlValidator.validateTest();
			saxParser.parse(myTbaml, new TBAMLToJava());
		} catch (tbamlFormatException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}

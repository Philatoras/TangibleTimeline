package serveur;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ParserXML.TBAMLToJava;
import ParserXML.TBAML_validator;
import blocs.Attributs;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.ZoneBlock;

public class SocketInputBloc implements Runnable
{
	Socket client;
	ParserBloc parser;
	ZoneManagerBloc zmb;
	

	public SocketInputBloc(Socket client, ServeurBloc s, String fileToConvert)

	
	{

		zmb = new ZoneManagerBloc();
		this.client = client;		
		this.zmb = new ZoneManagerBloc();

		//ScenarioBloc scenar = new ScenarioQuad();
		//ScenarioBloc scenar = new ScenarioMenuBlock();
		//scenar.initScenario(zmb);
		try {
			TBAMLToJava.convert(zmb, fileToConvert);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.parser = new ParserBloc(zmb);
	}
	
	public void run() 
	{
		try {
			BufferedReader plec = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean socketOuvert = true;
			while (socketOuvert) {
				try{
					String input = plec.readLine();
					if(input != null && input != "")
					{
						if(input.startsWith("Deconnexion"))
							socketOuvert=false;
						//System.out.println(input);
						parser.parseInput(input);
					}
				}catch(SocketException se){
					socketOuvert=false;
				}
			}
			plec.close();
			client.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
}

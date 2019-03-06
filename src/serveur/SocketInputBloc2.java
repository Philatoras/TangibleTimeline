package serveur;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

import blocs.Attributs;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.ZoneBlock;

public class SocketInputBloc2 implements Runnable
{
	Socket client;
	ParserBloc parser;
	ZoneManagerBloc zmb;
	
	public SocketInputBloc2(Socket client, ServeurBloc serveurBloc)
	{
		this.client = client;
		this.zmb = new ZoneManagerBloc();
		ScenarioBloc scenar = new ScenarioQuad();
		scenar.initScenario(zmb);
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

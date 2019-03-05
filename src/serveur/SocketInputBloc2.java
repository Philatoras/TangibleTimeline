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
	
	public SocketInputBloc2(Socket client, ServeurBloc2 s)
	{
		zmb = new ZoneManagerBloc();
		this.client = client;		
		this.zmb = new ZoneManagerBloc();
		PionBlock pb = new PionBlock("P1", "dark", "Cercle");
		this.zmb.addPion(pb);		
		ZoneBlock zone = new ZoneBlock("Z1", 50, 50, 200, 200, "Bonjour");
		this.zmb.addZone(zone);
		TTSBlock tts = new TTSBlock();
		pb.addSortie(zone);
		zone.addSortie(tts);
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
					if(input != null)
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

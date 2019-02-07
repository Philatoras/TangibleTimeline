package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class SocketInput implements Runnable
{
	EventZoneManager ezm;
	Parser parser;
	Socket client;

	public SocketInput(Socket client, Serveur s)
	{
		this.parser = new Parser(ezm);
		this.client = client;
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
						System.out.println(input);
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

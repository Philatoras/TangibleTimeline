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

public class SocketInputBloc implements Runnable
{
	Socket client;
	ZoneManagerBloc zmb;

	public SocketInputBloc(Socket client, ServeurBloc s)
	{
		this.client = client;
		ScenarioBloc scenar = new ScenarioQuad();
		zmb = new ZoneManagerBloc();
		scenar.initScenario(zmb);
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
						String[] cmd = input.split("=");
						switch(cmd[0])
						{
							case "pions":
								String[] msgPion = cmd[1].split("_");
								for(String s: msgPion)
								{
									String[] valeurs = s.split(":");
									String couleur = valeurs[0].trim().toLowerCase();
									for (PionBlock pb : zmb.getPions()) {
										if(couleur.equals(pb.getAttributs().get(Attributs.COULEUR)))
										{
											System.out.println("dark "+s);
											int x = 0;
											if(!valeurs[1].equals("None"))
												x = (int)(Double.parseDouble(valeurs[1]));
											int y = 0;
											if(!valeurs[2].equals("None"))
												y = (int)(Double.parseDouble(valeurs[2]));
											HashMap<Attributs, Object> attributs = new HashMap<Attributs, Object>();
											attributs.put(Attributs.X, x);
											attributs.put(Attributs.Y, y);
											pb.receipt(attributs);
										}
									}
								}
							break;
						}
						if(input.startsWith("Deconnexion"))
							socketOuvert=false;
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

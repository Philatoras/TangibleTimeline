package serveur;

import java.util.HashMap;
import java.util.List;

import blocs.Attributs;
import blocs.PionBlock;

/**
 * Classe ayant pour but de parser les sorties écrites de la tangible box en instructions
 * @author gwend
 *
 */
public class ParserBloc {
	
	private ZoneManagerBloc zmb;
	
	public ParserBloc(ZoneManagerBloc in_zmb) {
		this.zmb = in_zmb; 
	}
	
	/**
	 * Convertit la sortie réseau de la tangible box en instructions utilisables
	 * @param input
	 */
	public void parseInput(String input) {
		List<PionBlock> pions = zmb.getPions();
		String[] cmd = input.split("=");
		switch(cmd[0])
		{
			case "pions":
				String[] msgPion = cmd[1].split("_");
				for(String s: msgPion)
				{
					String[] valeurs = s.split(":");
					String couleur = valeurs[0].trim().toLowerCase();
					if(couleur.equals(pions.get(0).getAttributs().get(Attributs.COULEUR)))
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
						pions.get(0);
						
					}
				}
			break;				
		}		
		
	}
	
}

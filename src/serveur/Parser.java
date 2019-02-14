package serveur;

/**
 * Classe ayant pour but de parser les sorties écrites de la tangible box en instructions
 * @author gwend
 *
 */
public class Parser {
	
	private ZoneManager ezm;
	
	public Parser(ZoneManager in_ezm) {
		this.ezm = in_ezm; 
	}
	
	/**
	 * Convertit la sortie réseau de la tangible box en instructions utilisables
	 * @param input
	 */
	public void parseInput(String input) {
		//Séparation de la taille du plateau et des zones
		String[] inputGlob = input.split("=");
		switch(inputGlob[0]){
			case "init":
				String coordBrut = inputGlob[1]; 
				String[] temp = coordBrut.split(":");
				int longueur = Integer.valueOf(temp[0]);
				int hauteur = Integer.valueOf(temp[1]);						
				break;
			case "pions":
				//separations des pions par un underscore _
				String[] pions = inputGlob[1].split("_");
				for(int i = 0; i < pions.length ; i++){
					String[] pion = pions[i].split(":");
					String couleur = pion[0];
					int x = Integer.valueOf(pion[1]);
					int y = Integer.valueOf(pion[2]);					
					Coordinate coord = new Coordinate(x, y);
					ezm.checkEventTrigger(coord, couleur);
				}
				
				break;
				
		}
		//OBSOLETE, A SUPPRIMER
		/*String plateauBrut = input1[0];
		String zonesBrut = input1[1];
		String pionsBrut = input1[2];
		//Taille du plateau
		String[] temp = plateauBrut.split("=");
		plateauBrut = temp[1]; //temp[0] = "init" 
		temp = plateauBrut.split(":");
		int longeur = Integer.valueOf(temp[0]);
		int hauteur = Integer.valueOf(temp[1]);*/
		//Zones
		/*String[] zones = zonesBrut.split("_");
		for(int i = 0; i < zones.length ; i++){
			//Recuperation des donnees de la zone
			String[] donneesZone = zonesBrut.split(":");
			//Zone zone = new RectangularZone(new Coordinate(donneesZone[1], donneesZone[2]))
			ezm.addZone(zone)
		}*/
		//Pions
		
		
	}
	
}

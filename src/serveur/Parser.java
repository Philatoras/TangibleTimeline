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
		String[] inputGlob = input.split("!");
		String[] inputSub = inputGlob[0].split("=");
		switch(inputSub[0]){
			case "init":
				String coordBrut = inputSub[1]; 
				String[] temp = coordBrut.split(":");
				int longeur = Integer.valueOf(temp[0]);
				int hauteur = Integer.valueOf(temp[1]);				
				break;
			case "pions":
				break;
				
		}
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

package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe g�rant l'ensemble des zones du plateau, c�t� serveur
 * @author gwend
 *
 */
public class ZoneManager {

	/**
	 * Liste des zones
	 */
	private List<Zone> zones;
	
	/**
	 * Cr�e un EventZonesManager vide
	 * @param in_zones
	 */
	public ZoneManager() {
		this.zones = new ArrayList<>();
	}
	
	/**
	 * Cr�e un EventZonesManager avec une liste de zones
	 * @param in_zones
	 */
	public ZoneManager(List<Zone> in_zones) {
		this.zones = in_zones;
	}
	
	/**
	 * Re�oit des coordonn�es et un ensemble de param�tres depuis le parser, 
	 * et si les coordonn�es correspondent � une zone, effectue son action
	 * en lui transmettant les param�tres
	 * @param coord Coordonn�es � tester
	 * @param params Param�tres pour la zone
	 */
	public void checkEventTrigger(Coordinate coord, Object... params) {
		for(Zone z : this.zones) {
			if (z.PointOnZone(coord)) {
				z.doAction(params);
			}
		}
	}
	
	/**
	 * Ajoute une zone au manager
	 * @param zone Zone � ajouter
	 */
	public void addZone(EventZone zone) {
		this.zones.add(zone);
	}
	
}

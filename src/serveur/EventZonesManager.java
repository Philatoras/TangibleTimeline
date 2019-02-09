package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe g�rant l'ensemble des zones du plateau, c�t� serveur
 * @author gwend
 *
 */
public class EventZonesManager {

	/**
	 * Liste des zones
	 */
	private List<EventZone> zones;
	
	/**
	 * Cr�e un EventZonesManager vide
	 * @param in_zones
	 */
	public EventZonesManager() {
		this.zones = new ArrayList<>();
	}
	
	/**
	 * Cr�e un EventZonesManager avec une liste de zones
	 * @param in_zones
	 */
	public EventZonesManager(List<EventZone> in_zones) {
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
		for(EventZone ez : this.zones) {
			if (ez.PointOnZone(coord)) {
				ez.doAction(params);
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

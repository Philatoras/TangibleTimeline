package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe gérant l'ensemble des zones du plateau, côté serveur
 * @author gwend
 *
 */
public class EventZonesManager {

	/**
	 * Liste des zones
	 */
	private List<EventZone> zones;
	
	/**
	 * Crée un EventZonesManager vide
	 * @param in_zones
	 */
	public EventZonesManager() {
		this.zones = new ArrayList<>();
	}
	
	/**
	 * Crée un EventZonesManager avec une liste de zones
	 * @param in_zones
	 */
	public EventZonesManager(List<EventZone> in_zones) {
		this.zones = in_zones;
	}
	
	/**
	 * Reçoit des coordonnées et un ensemble de paramètres depuis le parser, 
	 * et si les coordonnées correspondent à une zone, effectue son action
	 * en lui transmettant les paramètres
	 * @param coord Coordonnées à tester
	 * @param params Paramètres pour la zone
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
	 * @param zone Zone à ajouter
	 */
	public void addZone(EventZone zone) {
		this.zones.add(zone);
	}
	
}

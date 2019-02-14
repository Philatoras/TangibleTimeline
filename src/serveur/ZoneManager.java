package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe gérant l'ensemble des zones du plateau, côté serveur
 * @author gwend
 *
 */
public class ZoneManager {

	/**
	 * Liste des zones
	 */
	private List<Zone> zones;
	
	/**
	 * Crée un EventZonesManager vide
	 * @param in_zones
	 */
	public ZoneManager() {
		this.zones = new ArrayList<>();
	}
	
	/**
	 * Crée un EventZonesManager avec une liste de zones
	 * @param in_zones
	 */
	public ZoneManager(List<Zone> in_zones) {
		this.zones = in_zones;
	}
	
	/**
	 * Reçoit des coordonnées et un ensemble de paramètres depuis le parser, 
	 * et si les coordonnées correspondent à une zone, effectue son action
	 * en lui transmettant les paramètres
	 * @param coord Coordonnées à tester
	 * @param params Paramètres pour la zone
	 */
	public void checkEventTrigger(Coordinate coord, String couleur) {
		for(Zone z : this.zones) {
			Pion pion = new Pion(couleur, coord, couleur); //Pour l'instant, fait passer l'id du pion pour sa couleur
			ZoneEvent zoneEvent = new ZoneEvent(pion, 0l, ""); //Pour l'instant, pas de time
			if (z.PointOnZone(coord) && !z.getIdPions().contains(pion.getIdPion())) {
				z.doEnterAction(zoneEvent);
			}
			if (!z.PointOnZone(coord) && z.getIdPions().contains(pion.getIdPion())) {
				z.doExitAction(zoneEvent);
			}
		}
	}
	
	/**
	 * Ajoute une zone au manager
	 * @param zone Zone à ajouter
	 */
	public void addZone(Zone zone) {
		this.zones.add(zone);
	}
	
}

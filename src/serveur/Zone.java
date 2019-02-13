package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface pour représenter les zones du plateau
 * @author gwend
 *
 */
public abstract class Zone {
	
	/**
	 * Listeners de la zone
	 */
	private List<ZoneListener> listeners;
	
	/**
	 * Pions dans la zone
	 */
	private List<String> idPions;
	
	public Zone() {
		this.listeners = new ArrayList<>();
		this.idPions = new ArrayList<>();
	}
	
	/**
	 * Ajoute un listener à la zone
	 * @param zl listener à ajouter
	 */
	public void addListener(ZoneListener zl) {
		this.listeners.add(zl);
	}
	
	/**
	 * Renvoie si des coordonnées appartiennent à la zone
	 * @param c Coordonnées à tester
	 * @return 
	 */
	public abstract boolean PointOnZone(Coordinate c);
	
	/**
	 * Effectue l'action correspondante à l'entrée sur cette case lorsqu'un pion y pénètre.
	 * @param params Paramètres de l'action (Ex : couleur)
	 */
	public void doEnterAction(ZoneEvent zoneEvent) {
		for (ZoneListener zl : this.listeners) {
			this.idPions.add(zoneEvent.getPion().idPion);
			zl.zoneEntered(zoneEvent);
		}
	}
	
	/**
	 * Effectue l'action correspondante à la sortie sur cette case lorsqu'un pion y pénètre.
	 * @param params Paramètres de l'action (Ex : couleur)
	 */
	public void doExitAction(ZoneEvent zoneEvent) {
		for (ZoneListener zl : this.listeners) {
			this.idPions.remove(zoneEvent.getPion().idPion);
			zl.zoneExited(zoneEvent);
		}
	}
	
	/**
	 * Renvoie l'ID de la case
	 * @return ID de la case
	 */
	public abstract String getId();
	
	public List<String> getIdPions() {
		return idPions;
	}
	
}

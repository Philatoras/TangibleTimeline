package serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface pour repr�senter les zones du plateau
 * @author gwend
 *
 */
public abstract class Zone {
	
	private String id;
	/**
	 * Listeners de la zone
	 */
	private List<ZoneListener> listeners;
	
	/**
	 * Pions dans la zone
	 */
	private List<String> idPions;
	
	public Zone(String id) {
		this.id = id;
		this.listeners = new ArrayList<>();
		this.idPions = new ArrayList<>();
	}
	
	/**
	 * Ajoute un listener � la zone
	 * @param zl listener � ajouter
	 */
	public void addListener(ZoneListener zl) {
		this.listeners.add(zl);
	}
	
	/**
	 * Renvoie si des coordonn�es appartiennent � la zone
	 * @param c Coordonn�es � tester
	 * @return 
	 */
	public abstract boolean PointOnZone(Coordinate c);
	
	/**
	 * Effectue l'action correspondante � l'entr�e sur cette case lorsqu'un pion y p�n�tre.
	 * @param params Param�tres de l'action (Ex : couleur)
	 */
	public void doEnterAction(ZoneEvent zoneEvent) {
		ZoneEvent event = new ZoneEvent(zoneEvent.getPion(), zoneEvent.getTime(), this.getId());
		for (ZoneListener zl : this.listeners) {
			this.idPions.add(zoneEvent.getPion().getIdPion());
			zl.zoneEntered(zoneEvent);
		}
	}
	
	/**
	 * Effectue l'action correspondante � la sortie sur cette case lorsqu'un pion y p�n�tre.
	 * @param params Param�tres de l'action (Ex : couleur)
	 */
	public void doExitAction(ZoneEvent zoneEvent) {
		ZoneEvent event = new ZoneEvent(zoneEvent.getPion(), zoneEvent.getTime(), this.getId());
		for (ZoneListener zl : this.listeners) {
			this.idPions.remove(zoneEvent.getPion().getIdPion());
			zl.zoneExited(zoneEvent);
		}
	}
	
	/**
	 * Renvoie l'ID de la case
	 * @return ID de la case
	 */
	public String getId() {
		return this.id;
	}
	
	public List<String> getIdPions() {
		return idPions;
	}
	
}

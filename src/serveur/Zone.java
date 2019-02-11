package serveur;

/**
 * Interface pour représenter les zones du plateau
 * @author gwend
 *
 */
public interface Zone {
	
	/**
	 * Renvoie si des coordonnées appartiennent à la zone
	 * @param c Coordonnées à tester
	 * @return 
	 */
	public boolean PointOnZone(Coordinate c);
	
	/**
	 * Effectue l'action correspondante à cette case lorsqu'un pion y pénètre.
	 * @param params Paramètres de l'action (Ex : couleur)
	 */
	public void doAction(Object... params);
	
	/**
	 * Renvoie l'ID de la case
	 * @return ID de la case
	 */
	public String getId();
	
}

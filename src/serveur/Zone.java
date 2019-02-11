package serveur;

/**
 * Interface pour repr�senter les zones du plateau
 * @author gwend
 *
 */
public interface Zone {
	
	/**
	 * Renvoie si des coordonn�es appartiennent � la zone
	 * @param c Coordonn�es � tester
	 * @return 
	 */
	public boolean PointOnZone(Coordinate c);
	
	/**
	 * Effectue l'action correspondante � cette case lorsqu'un pion y p�n�tre.
	 * @param params Param�tres de l'action (Ex : couleur)
	 */
	public void doAction(Object... params);
	
	/**
	 * Renvoie l'ID de la case
	 * @return ID de la case
	 */
	public String getId();
	
}

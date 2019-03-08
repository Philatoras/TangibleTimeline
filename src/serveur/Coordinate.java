package serveur;

/**
 * !!! A remplacer par la case dimension !!!
 * Classe gérant les coordonnées des points côté serveur
 * @author gwend
 *
 */
public class Coordinate {

	/**
	 * Abscisse des coordonées
	 */
	private int c_x;
	
	/**
	 * Ordonnée des coordonnées
	 */
	private int c_y;
	
	/**
	 * Crée une coordonnée
	 * @param in_x Abscisse de la coordonée
	 * @param in_y Ordonnée de la coordonnée
	 */
	public Coordinate(int in_x, int in_y) {
		this.c_x = in_x;
		this.c_y = in_y;
	}
	
	public int getC_x() {
		return c_x;
	}
	
	public int getC_y() {
		return c_y;
	}
	
	public void setC_x(int c_x) {
		this.c_x = c_x;
	}
	
	public void setC_y(int c_y) {
		this.c_y = c_y;
	}
	
}

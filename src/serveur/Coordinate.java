package serveur;

/**
 * !!! A remplacer par la case dimension !!!
 * Classe g�rant les coordonn�es des points c�t� serveur
 * @author gwend
 *
 */
public class Coordinate {

	/**
	 * Abscisse des coordon�es
	 */
	private int c_x;
	
	/**
	 * Ordonn�e des coordonn�es
	 */
	private int c_y;
	
	/**
	 * Cr�e une coordonn�e
	 * @param in_x Abscisse de la coordon�e
	 * @param in_y Ordonn�e de la coordonn�e
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

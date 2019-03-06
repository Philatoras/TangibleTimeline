package serveur;

/**
 * Zone � �venement en forme de cercle
 * @author gwend
 *
 */
public class CircularZone extends Zone {
	
	private Coordinate center;
	
	private float radius;
	
	public CircularZone(Coordinate in_center,float in_radius, String id ) {
		super(id);
		this.center = in_center;
		this.radius = in_radius;
	}
	
	@Override
	public boolean PointOnZone(Coordinate c) {
		float x = c.getC_x() - center.getC_x();
		float y = c.getC_y() - center.getC_y();
		return Math.sqrt(x*x + y*y) <= this.radius ;
	}
}
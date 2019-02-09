package serveur;

/**
 * Zone à évenement en forme de cercle
 * @author gwend
 *
 */
public class CircleEventZone extends DetailledEventZone implements EventZone {
	
	private Coordinate center;
	
	private float radius;
	
	public CircleEventZone(DetailledEvent in_detailledEvent, Coordinate in_center,float in_radius ) {
		super(in_detailledEvent);
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

package serveur;


/**
 * Zone à évenement en forme de rectangle
 * @author Xcarr
 *
 */
public class RectangularZone extends Zone {
	
	private Coordinate coin1;
	private Coordinate coin2;
	
	public RectangularZone(Coordinate in_coin1,Coordinate in_coin2, String id ) {
		super(id);
		this.coin1 = in_coin1;
		this.coin2 = in_coin2;
	}
	
	@Override
	public boolean PointOnZone(Coordinate c) {
		float x1 = c.getC_x() - coin1.getC_x();
		float y1 = c.getC_y() - coin1.getC_y();
		float x2 = c.getC_x() - coin2.getC_x();
		float y2 = c.getC_y() - coin2.getC_y();
		boolean absi = Math.abs((x2-x1))>0;
		boolean ordo = Math.abs((y1-y2))>0;
		return (absi && ordo);
	}
}

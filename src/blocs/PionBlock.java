package blocs;

import java.util.HashMap;

public class PionBlock extends CodingBlock{
	
	private final int DELAI_TICK = 100;
	
	private int LastX;
	private int LastY;
	private int deltaT;

	public PionBlock(String id, String couleur, String forme) {
		super();
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.COULEUR, couleur);
		getAttributs().put(Attributs.FORME, forme);
		LastX = 0;
		LastY = 0;
		deltaT = 0;
	}
	
	@Override
	public void receipt(HashMap<Attributs, Object> atts) {
		//Si le pion est immobile, on incrémente son delta_t
		if ((Integer)atts.get(Attributs.X) == LastX && (Integer)atts.get(Attributs.Y) == LastY) {
			deltaT += DELAI_TICK;
		} else {
			deltaT = 0;
		}
		atts.put(Attributs.COULEUR, getAttributs().get(Attributs.COULEUR));
		atts.put(Attributs.FORME, getAttributs().get(Attributs.FORME));
		atts.put(Attributs.ID, getAttributs().get(Attributs.ID));
		atts.put(Attributs.DELTA_T, deltaT);
		sendAttributs(atts);
	}

	
}

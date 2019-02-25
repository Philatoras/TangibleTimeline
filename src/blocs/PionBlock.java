package blocs;

import java.util.HashMap;

public class PionBlock extends CodingBlock{

	public PionBlock(String id, String couleur, String forme) {
		super();
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.COULEUR, couleur);
		getAttributs().put(Attributs.FORME, forme);
	}
	
	@Override
	public void receipt(HashMap<Attributs, Object> atts) {
		getAttributs().put(Attributs.X, atts.get(Attributs.X));
		getAttributs().put(Attributs.Y, atts.get(Attributs.Y));
		sendAttributs();
	}

	
}

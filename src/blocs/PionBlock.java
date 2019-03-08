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
		atts.put(Attributs.COULEUR, getAttributs().get(Attributs.COULEUR));
		atts.put(Attributs.FORME, getAttributs().get(Attributs.FORME));
		atts.put(Attributs.ID, getAttributs().get(Attributs.ID));
		sendAttributs(atts);
	}

	
}

package blocs;

import java.util.HashMap;

public class ZoneBlock extends CodingBlock{

	public ZoneBlock(String id, int x, int y, int l, int h, String texte) {
		super();
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.X, x);
		getAttributs().put(Attributs.Y, y);
		getAttributs().put(Attributs.LONGUEUR, l);
		getAttributs().put(Attributs.HAUTEUR, h);
		getAttributs().put(Attributs.TEXTE, texte);
	}
	
	public ZoneBlock(String id, int x, int y, int l, int h, HashMap<String, String> texteMap) {
		super();
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.X, x);
		getAttributs().put(Attributs.Y, y);
		getAttributs().put(Attributs.LONGUEUR, l);
		getAttributs().put(Attributs.HAUTEUR, h);
		getAttributs().put(Attributs.TEXTE, texteMap);
	}
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		int x = (Integer)getAttributs().get(Attributs.X);
		int y = (Integer)getAttributs().get(Attributs.Y);
		int l = (Integer)getAttributs().get(Attributs.LONGUEUR);
		int h = (Integer)getAttributs().get(Attributs.HAUTEUR);
		int xRecu = (Integer)atts.get(Attributs.X);
		int yRecu = (Integer)atts.get(Attributs.Y);
		if(xRecu>x && xRecu<(x+l) && yRecu>y && yRecu<(y+h))
			sendAttributs();
	}

}

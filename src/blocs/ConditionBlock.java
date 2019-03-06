package blocs;

import java.util.ArrayList;
import java.util.HashMap;

public class ConditionBlock extends CodingBlock {

	private Attributs attributTest;
	
	private String valeurCible;
	
	private ArrayList<CodingBlock> listeSortieFaux;

	public ConditionBlock(Attributs att, String valeur) {
		super();
		this.attributTest = att;
		this.valeurCible = valeur;
		this.listeSortieFaux = new ArrayList<>();
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		this.setAllAttributs(atts);
		String valeurActuelle = (String)atts.get(attributTest);
		if (valeurActuelle.equals(valeurCible)) {
			sendAttributs(atts);
		} else {
			sendAttributsFaux();
		}
			
	}
	
	void sendAttributsFaux() {
		for(CodingBlock c : listeSortieFaux)
			c.receipt(this.getAttributs());
	}
	

}

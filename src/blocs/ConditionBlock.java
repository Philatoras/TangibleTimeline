package blocs;

import java.util.ArrayList;
import java.util.HashMap;

//Bloc de condition
//Entr�e : un attribut (texte)
//Sortie : send � la liste par d�faut si true, � la listeSortieFaux si false

public class ConditionBlock extends CodingBlock {
	//Attribut test�, par exemple Attributs.TEXTE
	private Attributs attributTest;
	//Valeur cible pour que le test soit true
	private String valeurCible;
	//Liste des blocs qui vont � qui on envoie si false
	private ArrayList<CodingBlock> listeSortieFaux;

	public ConditionBlock(Attributs att, String valeurCible) {
		super();
		this.attributTest = att;
		this.valeurCible = valeurCible;
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
	
	public void addSortieFalse(CodingBlock cb) {
			listeSortieFaux.add(cb);
	}
	

}

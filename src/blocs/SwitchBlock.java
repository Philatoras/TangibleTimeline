package blocs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Bloc agissant comme un switch case, permettant d'avoir plus de 2 listes en sortie (par rapport au bloc Condition)
//Entr�e : attribut � tester, par exemple COULEUR
//Sortie : selon la valeur, on send � la liste correpondante 

public class SwitchBlock extends CodingBlock {
	//Attribut test�
	private Attributs attributTest;
	//Map avec une valeur de l'attribut en cl� et la liste des blocs correspondante en valeur.	
	private Map<String, ArrayList<CodingBlock>> mapSorties;	

	public SwitchBlock(String id, Attributs att) {
		super();
		this.attributTest = att;		
		mapSorties = new HashMap<String, ArrayList<CodingBlock>>();		
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		this.setAllAttributs(atts);
		String valeurActuelle = (String)atts.get(attributTest);	
		if (mapSorties.containsKey(valeurActuelle)) {
			sendAttributsALaBonneListe(valeurActuelle);
		}
			
	}
	
	public void sendAttributsALaBonneListe(String val) {
		for(CodingBlock c : mapSorties.get(val))
			c.receipt(this.getAttributs());
	}
	
	public Map<String, ArrayList<CodingBlock>> getMap() {
		return this.mapSorties;
	}
	
	public void addInMap(String val, CodingBlock cb) {
		ArrayList<CodingBlock> liste = mapSorties.get(val);
		if(liste == null) {
			liste = new ArrayList<CodingBlock>();
		}
		liste.add(cb);
		mapSorties.put(val, liste);
	}
	
	
	

}

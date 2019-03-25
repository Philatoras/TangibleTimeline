package blocs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwitchBlock extends CodingBlock {

	private Attributs attributTest;
	
	private List<String> valeursPossibles ;
	
	private Map<String, ArrayList<CodingBlock>> mapSorties;	

	public SwitchBlock(Attributs att, List<String> valeurs) {
		super();
		this.attributTest = att;
		this.valeursPossibles = valeurs;
		mapSorties = new HashMap<String, ArrayList<CodingBlock>>();
		for(String val : valeursPossibles) {
			mapSorties.put(val, new ArrayList<CodingBlock>());
		}
		
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
		liste.add(cb);
		mapSorties.put(val, liste);
	}
	
	
	

}

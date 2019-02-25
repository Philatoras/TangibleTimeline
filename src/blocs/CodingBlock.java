package blocs;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CodingBlock {
	private ArrayList<CodingBlock> listeSortie;
	private HashMap<Attributs, Object> attributs;
	
	public CodingBlock(){
		listeSortie = new ArrayList<CodingBlock>();
		attributs = new HashMap<Attributs, Object>();
	}
	
	public void addSortie(CodingBlock cb){
		listeSortie.add(cb);
	}
	
	abstract void receipt(HashMap<Attributs, Object> atts);
	
	void sendAttributs(){
		for(CodingBlock c : listeSortie)
			c.receipt(attributs);
	}

	public ArrayList<CodingBlock> getListeSortie() {
		return listeSortie;
	}

	public HashMap<Attributs, Object> getAttributs() {
		return attributs;
	}
	
	
	
}

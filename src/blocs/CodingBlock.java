package blocs;

import java.util.ArrayList;
import java.util.HashMap;

//Classe abstraite, tous les autres types de blocs en héritent

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
	
	void sendAttributs(HashMap<Attributs, Object> atts){
		for(CodingBlock c : listeSortie)
			c.receipt(atts);
	}

	public ArrayList<CodingBlock> getListeSortie() {
		return listeSortie;
	}

	public HashMap<Attributs, Object> getAttributs() {
		return attributs;
	}
	
	protected void setAttributs(Attributs att, String val) {
		this.attributs.put(att, val);
	}
	
	protected void setAllAttributs(HashMap<Attributs, Object> atts) {
		this.attributs = atts;
	}
	
}

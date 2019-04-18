package blocs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZoneBlock extends CodingBlock{
	
	private String idGroup;
	//Liste des blocs auxquels le flux sera transmis en cas d'entree du pion dans la zone
	private ArrayList<CodingBlock> listeSortieEntreeZone;
	//Liste des blocs auxquels le flux sera transmis en cas de sortie du pion de la zone
	private ArrayList<CodingBlock> listeSortieSortieZone;
	//dictionnaire pour stocker les coordonnes precedentes de chaque pion
	private Map<String, Integer[]> pionMap;
	
	public ZoneBlock(String id, int x, int y, int l, int h, String texte) {
		super();		
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.X, x);
		getAttributs().put(Attributs.Y, y);
		getAttributs().put(Attributs.LONGUEUR, l);
		getAttributs().put(Attributs.HAUTEUR, h);
		getAttributs().put(Attributs.TEXTE, texte);		
		listeSortieEntreeZone = new ArrayList<CodingBlock>();
		listeSortieSortieZone = new ArrayList<CodingBlock>();
		pionMap = new HashMap<String, Integer[]>();
		
	}
	
	public ZoneBlock(String id, int x, int y, int l, int h, String texte, String idGroup) {
		super();
		getAttributs().put(Attributs.ID, id);
		getAttributs().put(Attributs.X, x);
		getAttributs().put(Attributs.Y, y);
		getAttributs().put(Attributs.LONGUEUR, l);
		getAttributs().put(Attributs.HAUTEUR, h);
		getAttributs().put(Attributs.TEXTE, texte);
		this.idGroup = idGroup;		
		listeSortieEntreeZone = new ArrayList<CodingBlock>();
		listeSortieSortieZone = new ArrayList<CodingBlock>();
		pionMap = new HashMap<String, Integer[]>();
		
	}	

	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		
		int x = (Integer)getAttributs().get(Attributs.X);
		int y = (Integer)getAttributs().get(Attributs.Y);
		int l = (Integer)getAttributs().get(Attributs.LONGUEUR);
		int h = (Integer)getAttributs().get(Attributs.HAUTEUR);
		int xRecu = (Integer)atts.get(Attributs.X);
		int yRecu = (Integer)atts.get(Attributs.Y);
		String idPion = (String) atts.get(Attributs.ID);
		atts.put(Attributs.TEXTE, this.getAttributs().get(Attributs.TEXTE));
		Integer coordPrec [] = new Integer[2];
		if(pionMap.get(idPion) == null) {
			coordPrec[0] = -1000;
			coordPrec[1] = -1000;
			pionMap.put(idPion, coordPrec);
		}
		if(pionMap.get(idPion)[0] != -1000 && pionMap.get(idPion)[0] != -1000) {
			//Recuperation des coordonnees precedent du pion recu
			int xPrec = pionMap.get(idPion)[0];
			int yPrec = pionMap.get(idPion)[1];
			//Le pion est actuellement dans la zone
			if(xRecu>x && xRecu<(x+l) && yRecu>y && yRecu<(y+h)) {			
				
				if(xPrec>x && xPrec<(x+l) && yPrec>y && yPrec<(y+h)) {
					sendAttributs(atts);
				}
				//Cas entree du pion
				else {
					
					sendAttributsEntree(atts);
				}			
			}
			//Le pion n'est pas actuellement dans la zone
			else {
				//Cas sortie du pion
				if(xPrec>x && xPrec<(x+l) && yPrec>y && yPrec<(y+h)) {
					sendAttributsSortie(atts);
				}			
			}
		}
		
		//Stockage des coordonnees pour test a t+1
		
		coordPrec[0] = xRecu;
		coordPrec[1] = yRecu;
		pionMap.put(idPion, coordPrec);
		
	}
	//envoi des attributs a liste pour l'event entree dans zone
	void sendAttributsEntree(HashMap<Attributs, Object> atts){
		for(CodingBlock c : listeSortieEntreeZone)
			c.receipt(atts);
	}
	//envoie des attributs a liste pour l'event sortie de zone
	void sendAttributsSortie(HashMap<Attributs, Object> atts){
		for(CodingBlock c : listeSortieSortieZone)
			c.receipt(atts);
	}
	
	public void addSortieEntree(CodingBlock cb){
		listeSortieEntreeZone.add(cb);
	}
	
	public void addSortieSortie(CodingBlock cb){
		listeSortieSortieZone.add(cb);
	}
	
	

}


package serveur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blocs.PionBlock;
import blocs.ZoneBlock;


public class ZoneManagerBloc {

	/**
	 * Singleton map pour stocker les variables
	 */
	private static Map<String,String> variablesMap;
	
	/**
	 * Renvoie la liste des variables, et la crée si besoin
	 * @return Liste des variables
	 */
	public static Map<String, String> getVariablesMap() {
		if (variablesMap == null) {
			variablesMap = new HashMap<>();
		}
		return variablesMap;
	}
	
	/**
	 * Affecte à une variable la valeur en paramètre
	 * @param nomVariable Variable à assigner
	 * @param value Valeur à assigner
	 */
	public static void putVariable(String nomVariable, String value) {
		ZoneManagerBloc.getVariablesMap().put(nomVariable, value);
	}
	
	/**
	 * Renvoie la valeur de la variable en paramètre
	 * @param nomVariable variable
	 * @return valeur de la variable
	 */
	public static String getValueVariable(String nomVariable) {
		String r = ZoneManagerBloc.getVariablesMap().get(nomVariable);
		if (r == null)
			r = "";
		return r;
	}
	
	/**
	 * Liste des zones
	 */
	private List<ZoneBlock> zones;
	
	/**
	 * Liste des zones
	 */
	private List<PionBlock> pions;
	
	/**
	 * Crée un EventZonesManager vide
	 * @param in_zones
	 */
	public ZoneManagerBloc() {
		this.zones = new ArrayList<>();
		this.pions = new ArrayList<>();
	}
	
	/**
	 * Crée un EventZonesManager avec une liste de zones
	 * @param in_zones
	 */
	public ZoneManagerBloc(List<ZoneBlock> in_zones, List<PionBlock> in_pions) {
		this.zones = in_zones;
		this.pions = in_pions;
	}
	
	
	/**
	 * Ajoute une zone au manager
	 * @param zone Zone à ajouter
	 */
	public void addZone(ZoneBlock zone) {
		this.zones.add(zone);
	}
	
	public void addPion(PionBlock pion) {
		this.pions.add(pion);
	}

	public List<ZoneBlock> getZones() {
		return zones;
	}

	public List<PionBlock> getPions() {
		return pions;
	}

	public void setZones(List<ZoneBlock> zones) {
		this.zones = zones;
	}

	public void setPions(List<PionBlock> pions) {
		this.pions = pions;
	}
	
	
	
	
	
}

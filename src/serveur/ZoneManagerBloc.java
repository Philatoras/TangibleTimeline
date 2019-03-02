package serveur;

import java.util.ArrayList;
import java.util.List;

import blocs.PionBlock;
import blocs.ZoneBlock;


public class ZoneManagerBloc {

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

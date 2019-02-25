package serveur;

import java.awt.Color;

public class Pion {
	private String idPion;
	//Forme form;
	private String color;
	private Coordinate coordinate;
	
	public Pion(String idPion, Coordinate coordinate, String color) {
		this.idPion = idPion;
		this.color = color;
		this.coordinate = coordinate;
	}
	
	public String getColor() {
		return color;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public String getIdPion() {
		return idPion;
	}
	
}

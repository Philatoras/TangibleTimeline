package serveur;

import java.awt.Color;

public class Pion {
	private String idPion;
	//Forme form;
	private Color color;
	private Coordinate coordinate;
	
	public Pion(String idPion, Coordinate coordinate, Color color) {
		this.idPion = idPion;
		this.color = color;
		this.coordinate = coordinate;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public String getIdPion() {
		return idPion;
	}
	
}

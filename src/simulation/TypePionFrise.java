package simulation;

import java.awt.Color;

public enum TypePionFrise 
{
	PIONF("PionF", "pionf", "blue", new Color(164,164,164)), MENU("Menu", "menu", "red", new Color(250,0,0)),
	PIONJ("PionJ", "pionj", "yellow", new Color(250,250,0)),PIONR("PionR", "pionr", "red", new Color(250,0,0));
	
	private String libelle, nom, couleurJeton;
	private Color couleur;
	
	private TypePionFrise(String l, String n, String cj, Color c){libelle=l;nom=n;couleurJeton=cj;couleur=c;}

	public Color getCouleur(){return couleur;}
	public String getCouleurJeton(){return couleurJeton;}
	public String getLibelle(){return libelle;}
	public String getNom(){return nom;}
}

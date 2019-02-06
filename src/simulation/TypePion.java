package simulation;

import java.awt.Color;

public enum TypePion 
{
	LOUP("Loup", "loup", "blue", new Color(164,164,164)),
	CHAPERON("Chap", "chaperon", "red", new Color(250,50,50)),
	REPET("Rep", "répétition", "pink", new Color(0,200,240)),
	JOKER("Joker", "joker", "dark", new Color(60,240,100)),
	PANIER("Pan", "panier", "yellow", new Color(240,255,80)),
	CARTE("Carte", "carte", "green", new Color(240,80,255));
	
	private String libelle, nom, couleurJeton;
	private Color couleur;
	
	private TypePion(String l, String n, String cj, Color c){libelle=l;nom=n;couleurJeton=cj;couleur=c;}

	public Color getCouleur(){return couleur;}
	public String getCouleurJeton(){return couleurJeton;}
	public String getLibelle(){return libelle;}
	public String getNom(){return nom;}
}

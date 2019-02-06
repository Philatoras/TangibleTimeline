package simulation;

public class Transformation 
{
	public static final int LONGUEUR_BASE = 380;
	public static final int HAUTEUR_BASE = 250;

	public static int getHauteur(int longueur)
	{
		return (longueur*HAUTEUR_BASE)/LONGUEUR_BASE;
	}
	
	public static double normaliseAbscisse(double x)
	{
		return x/LONGUEUR_BASE;
	}
	
	public static double transformeAbscisse(double x)
	{
		return normaliseAbscisse(x)*PanneauJeu.LONGUEUR_PLATEAU;
	}
	
	public static double normaliseOrdonnee(double y)
	{
		return y/HAUTEUR_BASE;
	}
	
	public static double transformeOrdonnee(double y)
	{
		return normaliseOrdonnee(y)*PanneauJeu.HAUTEUR_PLATEAU;
	}
}

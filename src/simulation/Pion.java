package simulation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pion extends Ellipse2D.Double
{
	public static final double TAILLE = Transformation.transformeAbscisse(20);
	double centreX, centreY;
	String nom, commande;
	Color couleur;
	boolean survol, selected;
	
	int posX, posY;
	
	public Pion(String n, String commande, double x, double y, Color c)
	{
		super(x,y,TAILLE,TAILLE);
		calculCentre();
		nom = n;
		couleur = c;
		this.commande = commande;
		survol = false;
		selected = false;
	}
	
	public void calculCentre()
	{
		centreX = x + (TAILLE/2);
		centreY = y + (TAILLE/2);
	}
	
	public void deplacer(int x, int y)
	{
		super.x += (x-posX);
		super.y += (y-posY);
		posX = x;
		posY = y;
		calculCentre();
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer(commande);
		buf.append(":");
		buf.append(Math.round((double)(centreX-PanneauJeu.BORDURE-PanneauJeu.ZONE_GAUCHE-PanneauJeu.BORDURE)));
		buf.append(":");
		buf.append(Math.round((double)(centreY-PanneauJeu.BORDURE)));
		return buf.toString();
	}
	
	public String pionVersStream() {
		StringBuffer buf = new StringBuffer(commande);
		buf.append(":");
		buf.append(Math.round((double)(Transformation.transformeAbscisseInverse(centreX-PanneauJeu.BORDURE-PanneauJeu.ZONE_GAUCHE-PanneauJeu.BORDURE))));
		buf.append(":");
		buf.append(Math.round((double)(Transformation.transformeOrdonneeInverse(centreY-PanneauJeu.BORDURE))));
		return buf.toString();
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(couleur);
		g2.fill(this);
		if(selected)
			g2.setColor(Color.WHITE);
		else
			g2.setColor(Color.BLACK);
		if(survol)
			g2.setStroke(new BasicStroke(2.0f));
		else
			g2.setStroke(new BasicStroke(1.0f));
		g2.draw(this);
		afficheTexte(g2);
	}
	
	public void afficheTexte(Graphics2D g2)
	{
		Font f = new Font("Verdana Ref",Font.BOLD,12);
		
		Rectangle2D box = getBounds2D();
		
		// Mesure la fonte et le message
		FontRenderContext frc = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(nom,frc);
		LineMetrics metrics = f.getLineMetrics(nom,frc);
		float width = (float)bounds.getWidth(); // Largeur du texte
		float lineheight = metrics.getHeight(); // Hauteur total de la ligne
		float ascent = metrics.getAscent();     // Du haut à la ligne de base
	
		// Affiche le message centré horizontalement et verticalement dans la boite
		float x0 = (float)(box.getX() + (box.getWidth() - width)/2);
		float y0 = (float)(box.getY() + (box.getHeight() - lineheight)/2 + ascent);
		g2.setFont(f);
		g2.drawString(nom,x0,y0);
	}
	
	public void contains(Point p)
	{
		if(super.contains(p))
			survol = true;
		else
		{
			survol = false;
			selected = false;
		}
	}
	
	public void setSelection(boolean s){selected=s;}
	
	public void selection(int x, int y)
	{
		selected = true;
		posX = x;
		posY = y;
	}
}
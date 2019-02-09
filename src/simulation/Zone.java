package simulation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

public class Zone extends Rectangle2D.Double
{
	private static final long serialVersionUID = 1L;
	double centreX, centreY;
	public String texte;
	
	public Zone(String t, double x, double y, double l, double h)
	{
		super(x,y,l,h);
		texte = t;
		centreX = x + (l/2);
		centreY = y + (h/2);
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(new Color(255,230,180));
		g2.fill(this);
		g2.setStroke(new BasicStroke(2.5f));
		g2.setColor(Color.BLACK);
		g2.draw(this);
		afficheTexte(g2);
	}
	
	public void afficheTexte(Graphics2D g2)
	{
		Font f = new Font("Verdana Ref",Font.BOLD,16);
		
		Rectangle2D box = getBounds2D();
		
		// Mesure la fonte et le message
		FontRenderContext frc = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(texte,frc);
		LineMetrics metrics = f.getLineMetrics(texte,frc);
		float width = (float)bounds.getWidth(); // Largeur du texte
		float lineheight = metrics.getHeight(); // Hauteur total de la ligne
		float ascent = metrics.getAscent();     // Du haut à la ligne de base
	
		// Affiche le message centré horizontalement et verticalement dans la boite
		float x0 = (float)(box.getX() + (box.getWidth() - width)/2);
		float y0 = (float)(box.getY() + (box.getHeight() - lineheight)/2 + ascent);
		g2.setFont(f);
		g2.drawString(texte,x0,y0);
	}
	public double getCentreX(){
		return this.centreX;
	}
	
	public double getCentreY(){
		return this.centreY;
	}
	
}

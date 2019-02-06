package simulation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

public class Case extends Zone
{
	private static final long serialVersionUID = 1L;
	public boolean chaumiere;

	public Case(String t, double x, double y, double l, double h, boolean c)
	{
		super(t,x,y,l,h);
		this.chaumiere = c;
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(1.5f));
		g2.setColor(Color.BLACK);
		if(chaumiere)
			g2.drawRoundRect((int)x, (int)y, (int)width, (int)height, (int)Transformation.transformeAbscisse(5), (int)Transformation.transformeOrdonnee(5));
		else
			g2.drawOval((int)x, (int)y, (int)width, (int)height);
		afficheTexte(g2);
	}
}

package simulation;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.*;

public class PanneauJeu extends JComponent implements MouseInputListener
{
	public static final int LONGUEUR_PLATEAU = 800;
	public static final int HAUTEUR_PLATEAU = Transformation.getHauteur(LONGUEUR_PLATEAU);
	
	public static final int BORDURE = 20;
	public static final int ZONE_GAUCHE = 150;
	
	int x0, y0;
	
	ArrayList<Case> caseLoupDepart, caseLoupFin, caseChaperonDepart, caseChaperonFin;
	ArrayList<Zone> zones;
	Hashtable<TypePion, Pion> listePions;
	
	public PanneauJeu(String fileName)
	{
		super();

		addMouseListener(this);
		addMouseMotionListener(this);
		
		int longueurPanneau = LONGUEUR_PLATEAU + ZONE_GAUCHE + (3*BORDURE);
		int hauteurPanneau = HAUTEUR_PLATEAU + (2*BORDURE);
		
		setPreferredSize(new Dimension(longueurPanneau, hauteurPanneau));
		x0 = BORDURE + ZONE_GAUCHE + BORDURE;
		y0 = BORDURE;
		
		caseChaperonDepart = new ArrayList<Case>();
		caseChaperonFin = new ArrayList<Case>();
		caseLoupDepart = new ArrayList<Case>();
		caseLoupFin = new ArrayList<Case>();
		zones = new ArrayList<Zone>();

		int espacementPions = 10;
		int nb=0;
		listePions = new Hashtable<TypePion, Pion>();
		TypePion lp = TypePion.CHAPERON;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),837,214, lp.getCouleur()));
		lp = TypePion.LOUP;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),668,109, lp.getCouleur()));
		lp = TypePion.CARTE;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),430,22, lp.getCouleur()));
		lp = TypePion.JOKER;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),195,500, lp.getCouleur()));
		lp = TypePion.PANIER;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),205,25, lp.getCouleur()));
		lp = TypePion.REPET;
		listePions.put(lp, new Pion(lp.getLibelle(),lp.getCouleurJeton(),945,465, lp.getCouleur()));
		
		try 
		{
		   BufferedReader buf = new BufferedReader(new FileReader(fileName));
		   
		   buf.readLine(); // Première ligne : Titre des colonnes ...
		   
		   String line = buf.readLine();
		   
		   while(line != null)
		   {
		      String[] val = line.split(";");
		      switch(val[5])
		      {
		      	case "Pioche":
		      	case "Panier":
		      	case "Joker":
		      	case "Carte":
		      	case "Zone":
		      		zones.add(creerZone(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2])));
		    	break;
		      	case "caseLoupDepart":
		      		caseLoupDepart.add(creerCase(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2]),false));
		    	break;
		      	case "caseLoupFin":
		      		caseLoupFin.add(creerCase(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2]),false));
		    	break;
		      	case "caseChaperonDepart":
		      		caseChaperonDepart.add(creerCase(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2]),false));
		    	break;
		      	case "caseChaperonFin":
		      		caseChaperonFin.add(creerCase(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2]),false));
		    	break;
		      	case "caseChaumiereLoup":
		      	case "caseChaumiereChaperon":
		      		Case chaumiere = creerCase(val[0], Double.parseDouble(val[3]), Double.parseDouble(val[4]), Double.parseDouble(val[1]), Double.parseDouble(val[2]),true);
		      		caseLoupFin.add(chaumiere);
		      		caseChaperonFin.add(chaumiere);
		    	break;
		      	default:
		    	break;
		      }
		      line = buf.readLine();
		   }
		   buf.close();
		} 
		catch (IOException ioe) 
		{
		   ioe.printStackTrace();
		}
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer("pions=");
		for(TypePion tp: listePions.keySet())
		{
			buf.append(listePions.get(tp));
			buf.append("_");
		}
		return buf.toString();
	}
	
	public Case creerCase(String t, double x, double y, double l, double h, boolean c)
	{
		x = x0 + Transformation.transformeAbscisse(x);
		y = y0 + Transformation.transformeOrdonnee(y);
		l = Transformation.transformeAbscisse(l);
		h = Transformation.transformeOrdonnee(h);
		return new Case(t,x,y,l,h,c);
	}
	
	public Zone creerZone(String t, double x, double y, double l, double h)
	{
		x = x0 + Transformation.transformeAbscisse(x);
		y = y0 + Transformation.transformeOrdonnee(y);
		l = Transformation.transformeAbscisse(l);
		h = Transformation.transformeOrdonnee(h);
		return new Zone(t,x,y,l,h);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.WHITE);
		g2.fillRect(x0, y0, LONGUEUR_PLATEAU, HAUTEUR_PLATEAU);
		g2.setColor(Color.BLACK);
		g2.drawRect(x0, y0, LONGUEUR_PLATEAU, HAUTEUR_PLATEAU);
		
		g2.setColor(Color.WHITE);
		g2.fillRect(BORDURE, BORDURE, ZONE_GAUCHE, HAUTEUR_PLATEAU);
		g2.setColor(Color.BLACK);
		g2.drawRect(BORDURE, BORDURE, ZONE_GAUCHE, HAUTEUR_PLATEAU);

		for(int i=0;i<zones.size();i++)
			zones.get(i).paint(g2);
		
		for(int i=0;i<caseLoupDepart.size();i++)
			caseLoupDepart.get(i).paint(g2);
		
		for(int i=0;i<caseLoupFin.size();i++)
			caseLoupFin.get(i).paint(g2);
		
		for(int i=0;i<caseChaperonDepart.size();i++)
			caseChaperonDepart.get(i).paint(g2);

		for(int i=0;i<caseChaperonFin.size();i++)
			caseChaperonFin.get(i).paint(g2);
		
		for(Pion p : listePions.values())
			p.paint(g2);
	}

	public void mouseClicked(MouseEvent arg0){}
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0){}

	public void mousePressed(MouseEvent arg0)
	{
		for(Pion p : listePions.values())
			if(p.survol==true)
				p.selection(arg0.getX(), arg0.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent arg0)
	{
		for(Pion p : listePions.values())
		{
//			if(p.selected==true)
//				p.envoiMessage();
			p.setSelection(false);
		}
		repaint();
	}
	
	public void mouseMoved(MouseEvent arg0)
	{
		Point p = arg0.getPoint();
		for(Pion pi : listePions.values())
			pi.contains(p);
		repaint();
	}
	
	public void mouseDragged(MouseEvent arg0)
	{
		for(Pion p : listePions.values())
			if(p.selected==true)
			{
				p.deplacer(arg0.getX(), arg0.getY());
//				if(p.commande.equals(TypePion.PIOCHE.name()) || p.commande.equals(TypePion.PANIER.name()))
//					p.envoiMessage();
			}
		repaint();
	}
}

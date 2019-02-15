package simulation;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public interface PanneauJeuI {
	public String toString();
	public Case creerCase(String t, double x, double y, double l, double h, boolean c);
	public Zone creerZone(String t, double x, double y, double l, double h);
	public boolean checkPionZone(Pion pion, Zone zone);
	public void paintComponent(Graphics g);
	public void mouseClicked(MouseEvent arg0);
	public void mouseEntered(MouseEvent arg0);
	public void mouseExited(MouseEvent arg0);
	public void mousePressed(MouseEvent arg0);
	public void mouseReleased(MouseEvent arg0);
	public void mouseMoved(MouseEvent arg0);
	public void mouseDragged(MouseEvent arg0);
	public ArrayList<Zone> getCasesTimeline();
}

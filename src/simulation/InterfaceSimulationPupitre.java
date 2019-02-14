package simulation;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;

public class InterfaceSimulationPupitre extends JFrame
{
	Comm com;
	
	public InterfaceSimulationPupitre(String fileName, Comm com)
	{
		super("Simulation pupitre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		PanneauJeuFrise pj = new PanneauJeuFrise(fileName);
		add(pj,BorderLayout.CENTER);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) 
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
					com.envoiMessage("clavier=X");	
				if(ke.getKeyCode()==KeyEvent.VK_NUMPAD0)
					com.envoiMessage("clavier=0");	
			}
		});
		pack();
		setLocation(0, 0);
		setVisible(true);
		
		this.com = com;
		com.setPanneauJeu(pj);
		com.envoiMessage("init="+PanneauJeuFrise.LONGUEUR_PLATEAU+":"+PanneauJeuFrise.HAUTEUR_PLATEAU);
		String messageZones = "zones=";
		ArrayList<Zone> zones = pj.getCasesTimeline();
		for(int i = 0; i < zones.size(); i++){
			messageZones += "_" + zones.get(i).getTexte() + "/" + zones.get(i).getX() + ";" + zones.get(i).getY();
		}
		com.envoiMessage(messageZones);
	}
	
	public static void main(String[] args)
	{
		Comm com = new Comm();
		if(com.open()){
			new InterfaceSimulationPupitre("plateaufrise.csv",com);
		}
	}
}

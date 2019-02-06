package simulation;
import java.awt.BorderLayout;
import java.awt.event.*;

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
		PanneauJeu pj = new PanneauJeu(fileName);
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
		com.envoiMessage("init="+PanneauJeu.LONGUEUR_PLATEAU+":"+PanneauJeu.HAUTEUR_PLATEAU);
	}
	
	public static void main(String[] args)
	{
		Comm com = new Comm();
		if(com.open()){
			new InterfaceSimulationPupitre("plateau.csv",com);
		}
	}
}

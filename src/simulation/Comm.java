package simulation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.Timer;
import java.io.*;
public class Comm 
{
	
	private static final int PORT = 8952;
	Socket soc;
	PrintWriter pred;
	Timer t;
	PanneauJeuFrise pj;
	
	
	public Comm()
	{
		t = new Timer(200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pred.println(pj);
				//Multiplier par la base 800*526 diviser par 380*250
			}
		});
	}
	
	public void envoiMessage(String msg)
	{
		pred.println(msg);
	}
	
		
	
	
	public void setPanneauJeu(PanneauJeuFrise pj2){
		this.pj = pj2;
	}
	
	
	public boolean open()
	{
		try {
			soc = new Socket(InetAddress.getLocalHost(), PORT);
			pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
			t.start();
			return true;
		} catch (IOException e) {
			System.out.println("Le serveur n'est pas lancé ...");
			return false;
		}
	}
	
	public void close()
	{
		t.stop();
		pred.close();
		try {
			soc.close();
		} catch (IOException e){e.printStackTrace();}
	}
}

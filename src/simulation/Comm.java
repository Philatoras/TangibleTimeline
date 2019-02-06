package simulation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.Timer;

public class Comm 
{
	private static final int PORT = 8952;
	Socket soc;
	PrintWriter pred;
	Timer t;
	PanneauJeu pj;
	
	public Comm()
	{
		t = new Timer(200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pred.println(pj);
			}
		});
	}
	
	public void envoiMessage(String msg)
	{
		pred.println(msg);
	}
	
	public void setPanneauJeu(PanneauJeu pj){
		this.pj = pj;
	}
	
	
	public boolean open()
	{
		try {
			soc = new Socket(InetAddress.getLocalHost(), PORT);
			pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
			t.start();
			return true;
		} catch (IOException e) {
			System.out.println("Le serveur n'est pas lanc� ...");
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
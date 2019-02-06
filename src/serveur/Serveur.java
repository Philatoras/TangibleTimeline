package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable
{
	private static final int PORT = 8952;
	ServerSocket server;
	SocketInput input;

	public void run() 
	{
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true)
		{
			try {
				Socket client = server.accept();
				input = new SocketInput(client, this);
				Thread t = new Thread(input);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Serveur s = new Serveur();
		Thread t = new Thread(s);
		t.start();
	}
}
package serveur;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurBloc implements Runnable
{
	private static final int PORT = 8952;
	ServerSocket server;
	SocketInputBloc input;
	String fileToConvert = "./scenarioSalleSwitch.tbaml";

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
				System.out.println("accepté");
				input = new SocketInputBloc(client, this,fileToConvert);
				Thread t = new Thread(input);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		ServeurBloc s = new ServeurBloc();
		Thread t = new Thread(s);
		t.start();
	}
}

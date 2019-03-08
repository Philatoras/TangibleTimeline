package serveur;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurBloc2 implements Runnable
{
	private static final int PORT = 8952;
	ServerSocket server;
	SocketInputBloc2 input;

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
				input = new SocketInputBloc2(client, this);
				Thread t = new Thread(input);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		ServeurBloc2 s = new ServeurBloc2();
		Thread t = new Thread(s);
		t.start();
	}
}

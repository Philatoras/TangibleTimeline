package serveur;

public class DetailledEventConsole implements DetailledEvent {

	String message;
	
	public DetailledEventConsole(String message) {
		this.message = message;
	}
	
	@Override
	public void trigger(Object... params) {
		System.out.println(message);
	}

}

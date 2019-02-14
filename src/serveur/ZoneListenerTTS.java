package serveur;

public class ZoneListenerTTS implements ZoneListener {

	private String messageEntree;
	
	private String messageSortie;
	
	public ZoneListenerTTS(String messageEntree, String messageSortie) {
		this.messageEntree = messageEntree;
		this.messageSortie = messageSortie;
	}
	
	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		TextToSpeech tts = new TextToSpeech();
		tts.lireMessage(messageEntree);
	}

	@Override
	public void zoneExited(ZoneEvent zoneExited) {
		TextToSpeech tts = new TextToSpeech();
		tts.lireMessage(messageEntree);
	}

}

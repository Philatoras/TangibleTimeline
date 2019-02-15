package serveur;

public class ZoneListenerTTS implements ZoneListener {

	private String messageEntree;

	private String messageSortie;
	// Mode permettant de savoir si le contenu de la zone doit être joué (dans
	// le cas
	// de contenu multiple
	private String mode;

	public ZoneListenerTTS(String messageEntree, String messageSortie, String mode) {
		this.messageEntree = messageEntree;
		this.messageSortie = messageSortie;
		this.mode = mode;
	}

	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		if (mode.equals(ModeMenu.mode)) {
			// TextToSpeech tts = new TextToSpeech();
			// tts.lireMessage(messageEntree);
			System.out.println(messageEntree);
		}

	}

	@Override
	public void zoneExited(ZoneEvent zoneExited) {
		if (mode.equals(ModeMenu.mode)) {
			// TextToSpeech tts = new TextToSpeech();
			// tts.lireMessage(messageEntree);
			System.out.println(messageSortie);
		}
	}

}

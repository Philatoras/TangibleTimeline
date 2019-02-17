package serveur;

public class ZoneListenerTTSPion extends ZoneListenerTTS {

	private String couleurTrigger;	
	
	public ZoneListenerTTSPion(String messageEntree, String messageSortie, String couleurTrigger) {
		super(messageEntree, messageSortie, "");
		this.couleurTrigger = couleurTrigger;
	}
	
	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		if (zoneEvent.getPion().getColor().equals(this.couleurTrigger)) {
			//TextToSpeech tts = new TextToSpeech();
			//tts.lireMessage(messageEntree);
			System.out.println(getMessageEntree());
		}
	}
	
	@Override
	public void zoneExited(ZoneEvent zoneEvent) {
		if (zoneEvent.getPion().getColor().equals(this.couleurTrigger)) {
			//TextToSpeech tts = new TextToSpeech();
			//tts.lireMessage(messageEntree);
			System.out.println(getMessageSortie());
		}
	}

}

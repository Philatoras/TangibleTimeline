package serveur;

public class ZoneListenerMenu implements ZoneListener {

	private String mode;
	
	public ZoneListenerMenu(String mode) {
		this.mode = mode;
	}
	
	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		if(zoneEvent.getPion().getColor() == "red"){
			ModeMenu.mode = mode;
		}
	}

	@Override
	public void zoneExited(ZoneEvent zoneExited) {
		if(zoneExited.getPion().getColor() == "red"){
			ModeMenu.mode = "";
		}

	}

}

package serveur;

public class ZoneListenerMenu implements ZoneListener {

	private String mode;
	
	public ZoneListenerMenu(String mode) {
		this.mode = mode;
	}
	
	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		if(zoneEvent.getPion().getColor().equals("red")){
			ModeMenu.setMode(mode);
		}
	}

	@Override
	public void zoneExited(ZoneEvent zoneExited) {
		if(zoneExited.getPion().getColor().equals("red")){
			ModeMenu.setMode("");
		}

	}

}

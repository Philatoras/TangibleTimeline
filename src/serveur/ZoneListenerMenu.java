package serveur;

public class ZoneListenerMenu implements ZoneListener {

	@Override
	public void zoneEntered(ZoneEvent zoneEvent) {
		if(zoneEvent.getPion().getColor() == "red"){
			
		}
	}

	@Override
	public void zoneExited(ZoneEvent zoneExited) {
		if(zoneExited.getPion().getColor() == "red"){
			
		}

	}

}

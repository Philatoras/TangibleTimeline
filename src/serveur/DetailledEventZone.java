package serveur;

public abstract class DetailledEventZone implements EventZone {

	private DetailledEvent detailledEvent;
	

	public DetailledEventZone(DetailledEvent in_detailledEvent) {
		this.detailledEvent = in_detailledEvent;
	}


	@Override
	public void doAction(Object... params) {
		detailledEvent.trigger(params);
	}

}

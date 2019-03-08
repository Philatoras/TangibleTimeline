package serveur;

public class ZoneEvent {
	private String idSource;
	private long time;
	private Pion pion;
	
	public ZoneEvent(Pion pion, long time, String idSource) {
		this.idSource = idSource;
		this.pion = pion;
		this.time = time;
	}
	
	public Pion getPion() {
		return pion;
	}
	
	public String getIdSource() {
		return idSource;
	}
	
	public long getTime() {
		return time;
	}
}

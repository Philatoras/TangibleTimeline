package serveur;

public class ScenarioSimple implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "");
		Zone zonePleiade = new RectangularZone(new Coordinate(95, 90),new Coordinate(125, 110), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "");
		Zone zoneBaroque = new RectangularZone(new Coordinate(125, 90),new Coordinate(155, 110), "zoneBaroque&classicisme");
		zonePleiade.addListener(ttsBaroque);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "");
		Zone zoneLumiere = new RectangularZone(new Coordinate(155, 90),new Coordinate(185, 110), "zoneLumiere");
		zonePleiade.addListener(ttsLumiere);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(185, 90),new Coordinate(215, 110), "zoneRomantisme");
		zonePleiade.addListener(ttsRomantisme);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(185, 90),new Coordinate(215, 110), "zoneSurrealisme");
		zonePleiade.addListener(ttsSurrealisme);
		zoneManager.addZone(zoneSurrealisme);
	}

}

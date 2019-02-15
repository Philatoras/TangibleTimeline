package serveur;

public class ScenarioSimple implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "", "mvt");
		Zone zonePleiade = new RectangularZone(new Coordinate(95, 90),new Coordinate(125, 110), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "", "mvt");
		Zone zoneBaroque = new RectangularZone(new Coordinate(125, 90),new Coordinate(155, 110), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroque);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "", "mvt");
		Zone zoneLumiere = new RectangularZone(new Coordinate(155, 90),new Coordinate(185, 110), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiere);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "", "mvt");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(185, 90),new Coordinate(215, 110), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantisme);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "", "mvt");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(215, 90),new Coordinate(245, 110), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealisme);
		zoneManager.addZone(zoneSurrealisme);
	}

}
package serveur;

public class ScenarioSimple implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		ModeMenu.mode = "mvt"; //type de contenu mouvement
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "", "mvt");
		Zone zonePleiade = new RectangularZone(new Coordinate(110, 100),new Coordinate(140, 120), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "", "mvt");
		Zone zoneBaroque = new RectangularZone(new Coordinate(140, 100),new Coordinate(170, 120), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroque);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "", "mvt");
		Zone zoneLumiere = new RectangularZone(new Coordinate(170, 100),new Coordinate(200, 120), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiere);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "", "mvt");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(200, 100),new Coordinate(230, 120), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantisme);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "", "mvt");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(230, 100),new Coordinate(260, 120), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealisme);
		zoneManager.addZone(zoneSurrealisme);
	}

}
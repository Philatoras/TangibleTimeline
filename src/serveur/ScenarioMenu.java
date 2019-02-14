package serveur;

public class ScenarioMenu implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "");
		ZoneListenerTTS ttsRonsard = new ZoneListenerTTS("Pierre de Ronsard", "");
		Zone zonePleiade = new RectangularZone(new Coordinate(95, 90),new Coordinate(125, 110), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zonePleiade.addListener(ttsRonsard);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "");
		ZoneListenerTTS ttsCorneille = new ZoneListenerTTS("Pierre Corneille", "");
		Zone zoneBaroque = new RectangularZone(new Coordinate(125, 90),new Coordinate(155, 110), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroque);
		zoneBaroque.addListener(ttsCorneille);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "");
		ZoneListenerTTS ttsRousseau = new ZoneListenerTTS("Jean Jacques Rousseau", "");
		Zone zoneLumiere = new RectangularZone(new Coordinate(155, 90),new Coordinate(185, 110), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiere);
		zoneLumiere.addListener(ttsRousseau);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "");
		ZoneListenerTTS ttsHugo = new ZoneListenerTTS("Victor Hugo", "");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(185, 90),new Coordinate(215, 110), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantisme);
		zoneRomantisme.addListener(ttsHugo);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "");
		ZoneListenerTTS ttsEluard = new ZoneListenerTTS("Paul Eluard", "");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(215, 90),new Coordinate(245, 110), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealisme);
		zoneSurrealisme.addListener(ttsEluard);
		zoneManager.addZone(zoneSurrealisme);
	}

}

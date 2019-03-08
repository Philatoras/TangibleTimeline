package serveur;

public class ScenarioQuad implements Scenario{
	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiadeA = new ZoneListenerTTSPion("Humanisme:Rabelais", "","red");
		ZoneListenerTTS ttsPleiadeP = new ZoneListenerTTSPion("Humanisme:Leonard de Vinci", "","yellow");
		Zone zonePleiade = new RectangularZone(new Coordinate(110, 100),new Coordinate(140, 120), "zonePleiade");
		zonePleiade.addListener(ttsPleiadeA);
		zonePleiade.addListener(ttsPleiadeP);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroqueA = new ZoneListenerTTSPion("Baroque et classicisme:Christofle de Beaujeu", "","red");
		ZoneListenerTTS ttsBaroqueP = new ZoneListenerTTSPion("Baroque et classicisme:Rembrandt", "","yellow");
		Zone zoneBaroque = new RectangularZone(new Coordinate(140, 100),new Coordinate(170, 120), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroqueA);
		zoneBaroque.addListener(ttsBaroqueP);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiereA = new ZoneListenerTTSPion("Lumières:Voltaire", "","red");
		ZoneListenerTTS ttsLumiereP = new ZoneListenerTTSPion("Lumières:Joseph Aved", "","yellow");
		Zone zoneLumiere = new RectangularZone(new Coordinate(170, 100),new Coordinate(200, 120), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiereA);
		zoneLumiere.addListener(ttsLumiereP);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantismeA = new ZoneListenerTTSPion("Romantisme:Victor Hugo", "","red");
		ZoneListenerTTS ttsRomantismeP = new ZoneListenerTTSPion("Romantisme:Théodore Géricault", "","yellow");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(200, 100),new Coordinate(230, 120), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantismeA);
		zoneRomantisme.addListener(ttsRomantismeP);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealismeA = new ZoneListenerTTSPion("Surrealisme:Guillaume Apollinaire", "","red");
		ZoneListenerTTS ttsSurrealismeP = new ZoneListenerTTSPion("Surrealisme:Picasso", "","yellow");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(230, 100),new Coordinate(260, 120), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealismeA);
		zoneSurrealisme.addListener(ttsSurrealismeP);
		zoneManager.addZone(zoneSurrealisme);
	}
}

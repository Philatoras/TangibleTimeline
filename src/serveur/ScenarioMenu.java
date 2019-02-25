package serveur;

public class ScenarioMenu implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "", "mvt");
		ZoneListenerTTS ttsRonsard = new ZoneListenerTTS("Pierre de Ronsard", "", "aut");
		Zone zonePleiade = new RectangularZone(new Coordinate(110, 100),new Coordinate(140, 120), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zonePleiade.addListener(ttsRonsard);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "", "mvt");
		ZoneListenerTTS ttsCorneille = new ZoneListenerTTS("Pierre Corneille", "", "aut");
		Zone zoneBaroque = new RectangularZone(new Coordinate(140, 100),new Coordinate(170, 120), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroque);
		zoneBaroque.addListener(ttsCorneille);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "", "mvt");
		ZoneListenerTTS ttsRousseau = new ZoneListenerTTS("Jean Jacques Rousseau", "", "aut");
		Zone zoneLumiere = new RectangularZone(new Coordinate(170, 100),new Coordinate(200, 120), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiere);
		zoneLumiere.addListener(ttsRousseau);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "", "mvt");
		ZoneListenerTTS ttsHugo = new ZoneListenerTTS("Victor Hugo", "", "aut");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(200, 100),new Coordinate(230, 120), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantisme);
		zoneRomantisme.addListener(ttsHugo);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "", "mvt");
		ZoneListenerTTS ttsEluard = new ZoneListenerTTS("Paul Eluard", "", "aut");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(230, 100),new Coordinate(260, 120), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealisme);
		zoneSurrealisme.addListener(ttsEluard);
		zoneManager.addZone(zoneSurrealisme);
		
		//Zones du menu
		ZoneListenerMenu listMenuMouv = new ZoneListenerMenu("mvt");
		Zone zoneMenuMouv = new RectangularZone(new Coordinate(110, 130),new Coordinate(140, 150), "zoneMenuMouv");//Coord a changer
		zoneMenuMouv.addListener(listMenuMouv);		
		zoneManager.addZone(zoneMenuMouv);
		ZoneListenerMenu listMenuAut = new ZoneListenerMenu("aut");
		Zone zoneMenuAut = new RectangularZone(new Coordinate(140, 130),new Coordinate(170, 150), "zoneMenuAut");//Coord a changer
		zoneMenuAut.addListener(listMenuAut);		
		zoneManager.addZone(zoneMenuAut);
		
	}

}

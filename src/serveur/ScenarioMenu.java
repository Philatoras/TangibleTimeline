package serveur;

public class ScenarioMenu implements Scenario {

	@Override
	public void initScenario(ZoneManager zoneManager) {
		
		ZoneListenerTTS ttsPleiade = new ZoneListenerTTS("Pléiade", "", "mvt");
		ZoneListenerTTS ttsRonsard = new ZoneListenerTTS("Pierre de Ronsard", "", "aut");
		Zone zonePleiade = new RectangularZone(new Coordinate(95, 90),new Coordinate(125, 110), "zonePleiade");
		zonePleiade.addListener(ttsPleiade);
		zonePleiade.addListener(ttsRonsard);
		zoneManager.addZone(zonePleiade);
		
		ZoneListenerTTS ttsBaroque = new ZoneListenerTTS("Baroque et classicisme", "", "mvt");
		ZoneListenerTTS ttsCorneille = new ZoneListenerTTS("Pierre Corneille", "", "aut");
		Zone zoneBaroque = new RectangularZone(new Coordinate(125, 90),new Coordinate(155, 110), "zoneBaroque&classicisme");
		zoneBaroque.addListener(ttsBaroque);
		zoneBaroque.addListener(ttsCorneille);
		zoneManager.addZone(zoneBaroque);
		
		ZoneListenerTTS ttsLumiere = new ZoneListenerTTS("Lumières", "", "mvt");
		ZoneListenerTTS ttsRousseau = new ZoneListenerTTS("Jean Jacques Rousseau", "", "aut");
		Zone zoneLumiere = new RectangularZone(new Coordinate(155, 90),new Coordinate(185, 110), "zoneLumiere");
		zoneLumiere.addListener(ttsLumiere);
		zoneLumiere.addListener(ttsRousseau);
		zoneManager.addZone(zoneLumiere);
		
		ZoneListenerTTS ttsRomantisme = new ZoneListenerTTS("Romantisme", "", "mvt");
		ZoneListenerTTS ttsHugo = new ZoneListenerTTS("Victor Hugo", "", "aut");
		Zone zoneRomantisme = new RectangularZone(new Coordinate(185, 90),new Coordinate(215, 110), "zoneRomantisme");
		zoneRomantisme.addListener(ttsRomantisme);
		zoneRomantisme.addListener(ttsHugo);
		zoneManager.addZone(zoneRomantisme);
		
		ZoneListenerTTS ttsSurrealisme = new ZoneListenerTTS("Surrealisme", "", "mvt");
		ZoneListenerTTS ttsEluard = new ZoneListenerTTS("Paul Eluard", "", "aut");
		Zone zoneSurrealisme = new RectangularZone(new Coordinate(215, 90),new Coordinate(245, 110), "zoneSurrealisme");
		zoneSurrealisme.addListener(ttsSurrealisme);
		zoneSurrealisme.addListener(ttsEluard);
		zoneManager.addZone(zoneSurrealisme);
		
		//Zones du menu
		ZoneListenerMenu listMenuMouv = new ZoneListenerMenu("mvt");
		Zone zoneMenuMouv = new RectangularZone(new Coordinate(215, 120),new Coordinate(245, 130), "zoneMenuMouv");//Coord a changer
		zoneMenuMouv.addListener(listMenuMouv);		
		zoneManager.addZone(zoneMenuMouv);
		ZoneListenerMenu listMenuAut = new ZoneListenerMenu("aut");
		Zone zoneMenuAut = new RectangularZone(new Coordinate(245, 120),new Coordinate(275, 130), "zoneMenuAut");//Coord a changer
		zoneMenuAut.addListener(listMenuAut);		
		zoneManager.addZone(zoneMenuAut);
		
	}

}

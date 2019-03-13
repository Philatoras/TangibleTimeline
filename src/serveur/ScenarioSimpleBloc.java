package serveur;


import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.TextBlock;
import blocs.ZoneBlock;

public class ScenarioSimpleBloc implements ScenarioBloc {

	@Override
	public void initScenario(ZoneManagerBloc zoneManager) {
		PionBlock pionAuteur = new PionBlock("auteur","red","rond");
		
		ZoneBlock zonePleiade = new ZoneBlock("zonePleiade",110, 100,30,20,"Pléïade");
		pionAuteur.addSortie(zonePleiade);
		
		ZoneBlock zoneBaroque = new ZoneBlock("zoneBaroque",140, 100,30,20,"Baroque");
		pionAuteur.addSortie(zoneBaroque);
		
		ZoneBlock zoneLumieres = new ZoneBlock("zoneLumieres",170, 100,30,20,"Lumieres");
		pionAuteur.addSortie(zoneLumieres);
		
		ZoneBlock zoneRomantisme = new ZoneBlock("zoneRomantisme",200, 100,30,20,"Romantisme");
		pionAuteur.addSortie(zoneRomantisme);
		
		ZoneBlock zoneSurrealisme = new ZoneBlock("zoneSurrealisme",230, 100,30,20,"Surrealisme");
		pionAuteur.addSortie(zoneSurrealisme);

		TextBlock textAuteurBaroque = new TextBlock("Christofle de Beaujeu");
		TextBlock textAuteurPleiade = new TextBlock("Rabelais");
		TextBlock textAuteurRomantisme = new TextBlock("Victor Hugo");
		TextBlock textAuteurLumiere = new TextBlock("Voltaire");
		TextBlock textAuteurSurrealisme = new TextBlock("André Breton");
		
		zonePleiade.addSortie(textAuteurPleiade);
		zoneBaroque.addSortie(textAuteurBaroque);
		zoneRomantisme.addSortie(textAuteurRomantisme);
		zoneSurrealisme.addSortie(textAuteurSurrealisme);
		zoneLumieres.addSortie(textAuteurLumiere);
		
		TTSBlock tts = new TTSBlock();
		textAuteurBaroque.addSortie(tts);
		textAuteurPleiade.addSortie(tts);
		textAuteurLumiere.addSortie(tts);
		textAuteurRomantisme.addSortie(tts);
		textAuteurSurrealisme.addSortie(tts);
		
		zoneManager.addZone(zoneBaroque);
		zoneManager.addZone(zonePleiade);
		zoneManager.addZone(zoneSurrealisme);
		zoneManager.addZone(zoneRomantisme);
		zoneManager.addZone(zoneLumieres);
		
		zoneManager.addPion(pionAuteur);
	}

}

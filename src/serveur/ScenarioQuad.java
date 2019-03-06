package serveur;

import blocs.Attributs;
import blocs.ConditionBlock;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.TextBlock;
import blocs.ZoneBlock;

public class ScenarioQuad implements ScenarioBloc{
	@Override
	public void initScenario(ZoneManagerBloc zoneManager) {
				
		PionBlock pionAuteur = new PionBlock("auteur","red","rond");
		PionBlock pionPeintre = new PionBlock("peintre","yellow","rond");
		
		
		ZoneBlock zonePleiade = new ZoneBlock("zonePleiade",110, 100,30,20,"Pléïade");
		pionAuteur.addSortie(zonePleiade);
		pionPeintre.addSortie(zonePleiade);
		
		ZoneBlock zoneBaroque = new ZoneBlock("zoneBaroque",140, 100,30,20,"Baroque");
		pionAuteur.addSortie(zoneBaroque);
		pionPeintre.addSortie(zoneBaroque);
		
		ZoneBlock zoneLumieres = new ZoneBlock("zoneLumieres",170, 100,30,20,"Lumieres");
		pionAuteur.addSortie(zoneLumieres);
		pionPeintre.addSortie(zoneLumieres);
		
		ZoneBlock zoneRomantisme = new ZoneBlock("zoneRomantisme",200, 100,30,20,"Romantisme");
		pionAuteur.addSortie(zoneRomantisme);
		pionPeintre.addSortie(zoneRomantisme);
		
		ZoneBlock zoneSurrealisme = new ZoneBlock("zoneSurrealisme",200, 100,30,20,"Surrealisme");
		pionAuteur.addSortie(zoneSurrealisme);
		pionPeintre.addSortie(zoneSurrealisme);
		
		
		ConditionBlock conditionAuteurPleiade = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintrePleiade = new ConditionBlock(Attributs.COULEUR, "yellow");
		ConditionBlock conditionAuteurBaroque = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintreBaroque = new ConditionBlock(Attributs.COULEUR, "yellow");
		ConditionBlock conditionAuteurSurrealisme = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintreSurrealisme = new ConditionBlock(Attributs.COULEUR, "yellow");
		ConditionBlock conditionAuteurLumieres = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintreLumieres = new ConditionBlock(Attributs.COULEUR, "yellow");
		ConditionBlock conditionAuteurRomantisme = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintreRomantisme = new ConditionBlock(Attributs.COULEUR, "yellow");
		
		zonePleiade.addSortie(conditionAuteurPleiade);
		zonePleiade.addSortie(conditionPeintrePleiade);
		zoneBaroque.addSortie(conditionAuteurBaroque);
		zoneBaroque.addSortie(conditionPeintreBaroque);
		zoneRomantisme.addSortie(conditionAuteurRomantisme);
		zoneRomantisme.addSortie(conditionPeintreRomantisme);
		zoneSurrealisme.addSortie(conditionAuteurSurrealisme);
		zoneSurrealisme.addSortie(conditionPeintreSurrealisme);
		zoneLumieres.addSortie(conditionAuteurLumieres);
		zoneLumieres.addSortie(conditionPeintreLumieres);
		
		
		TextBlock textPeintreBaroque = new TextBlock("Rembrandt");
		TextBlock textPeintrePleiade = new TextBlock("Leonard De Vinci");
		TextBlock textAuteurBaroque = new TextBlock("Christofle de Beaujeu");
		TextBlock textAuteurPleiade = new TextBlock("Rabelais");
		TextBlock textPeintreRomantisme = new TextBlock("Théodore Géricault");
		TextBlock textAuteurRomantisme = new TextBlock("Victor Hugo");
		TextBlock textPeintreLumiere = new TextBlock("Jean-Antoine Watteau");
		TextBlock textAuteurLumiere = new TextBlock("Voltaire");
		TextBlock textPeintreSurrealisme = new TextBlock("Salvador Dali");
		TextBlock textAuteurSurrealisme = new TextBlock("André Breton");
		
		conditionAuteurBaroque.addSortie(textAuteurBaroque);
		conditionAuteurPleiade.addSortie(textAuteurPleiade);
		conditionPeintreBaroque.addSortie(textPeintreBaroque);
		conditionPeintrePleiade.addSortie(textPeintrePleiade);
		conditionAuteurLumieres.addSortie(textAuteurLumiere);
		conditionAuteurRomantisme.addSortie(textAuteurRomantisme);
		conditionAuteurSurrealisme.addSortie(textAuteurSurrealisme);
		conditionPeintreRomantisme.addSortie(textPeintreRomantisme);
		conditionPeintreSurrealisme.addSortie(textPeintreSurrealisme);
		conditionPeintreLumieres.addSortie(textPeintreLumiere);
		
		TTSBlock tts = new TTSBlock();
		textPeintreBaroque.addSortie(tts);
		textPeintrePleiade.addSortie(tts);
		textAuteurBaroque.addSortie(tts);
		textAuteurPleiade.addSortie(tts);
		textAuteurLumiere.addSortie(tts);
		textAuteurRomantisme.addSortie(tts);
		textAuteurSurrealisme.addSortie(tts);
		textPeintreLumiere.addSortie(tts);
		textPeintreRomantisme.addSortie(tts);
		textPeintreSurrealisme.addSortie(tts);
		
		zoneManager.addZone(zoneBaroque);
		zoneManager.addZone(zonePleiade);
		zoneManager.addZone(zoneSurrealisme);
		zoneManager.addZone(zoneRomantisme);
		zoneManager.addZone(zoneLumieres);
		
		zoneManager.addPion(pionPeintre);
		zoneManager.addPion(pionAuteur);
	}
}

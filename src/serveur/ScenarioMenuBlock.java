package serveur;

import blocs.Attributs;
import blocs.ConditionVariableBlock;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.ZoneBlock;
import blocs.TextBlock;
import blocs.VariableBlock;

public class ScenarioMenuBlock implements ScenarioBloc {

	@Override
	public void initScenario(ZoneManagerBloc zoneManager) {
		
		PionBlock pionFrise = new PionBlock("frise","red","rond");
		PionBlock pionMenu = new PionBlock("menu","yellow","rond");
		
		VariableBlock varMenu = new VariableBlock("varMenu");
		
		//Initialisation a auteur
		ZoneManagerBloc.putVariable("valMenu", "peintre");
		
		ZoneBlock zonePleiade = new ZoneBlock("zonePleiade",110, 100,30,20,"Pléïade");
		pionFrise.addSortie(zonePleiade);
			
		ZoneBlock zoneBaroque = new ZoneBlock("zoneBaroque",140, 100,30,20,"Baroque");
		pionFrise.addSortie(zoneBaroque);		
		
		ZoneBlock zoneLumieres = new ZoneBlock("zoneLumieres",170, 100,30,20,"Lumieres");
		pionFrise.addSortie(zoneLumieres);
				
		ZoneBlock zoneRomantisme = new ZoneBlock("zoneRomantisme",200, 100,30,20,"Romantisme");
		pionFrise.addSortie(zoneRomantisme);
				
		ZoneBlock zoneSurrealisme = new ZoneBlock("zoneSurrealisme",230, 100,30,20,"Surrealisme");
		pionFrise.addSortie(zoneSurrealisme);
		
		ZoneBlock zoneMenuAuteur = new ZoneBlock("zoneMenuAuteur",140, 130,30,20,"auteur");
		pionMenu.addSortie(zoneMenuAuteur);
		
		ZoneBlock zoneMenuPeintre = new ZoneBlock("zoneMenuPeintre",110, 130,30,20,"peintre");
		pionMenu.addSortie(zoneMenuPeintre);
		
		ConditionVariableBlock conditionAuteurPleiade = new ConditionVariableBlock("valMenu", "auteur");
		ConditionVariableBlock conditionPeintrePleiade = new ConditionVariableBlock("valMenu", "peintre");
		ConditionVariableBlock conditionAuteurBaroque = new ConditionVariableBlock("valMenu", "auteur");
		ConditionVariableBlock conditionPeintreBaroque = new ConditionVariableBlock("valMenu", "peintre");
		ConditionVariableBlock conditionAuteurSurrealisme = new ConditionVariableBlock("valMenu", "auteur");
		ConditionVariableBlock conditionPeintreSurrealisme = new ConditionVariableBlock("valMenu", "peintre");
		ConditionVariableBlock conditionAuteurLumieres = new ConditionVariableBlock("valMenu", "auteur");
		ConditionVariableBlock conditionPeintreLumieres = new ConditionVariableBlock("valMenu", "peintre");
		ConditionVariableBlock conditionAuteurRomantisme = new ConditionVariableBlock("valMenu", "auteur");
		ConditionVariableBlock conditionPeintreRomantisme = new ConditionVariableBlock("valMenu", "peintre");
		
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
		
		conditionAuteurPleiade.addSortie(textAuteurPleiade);
		conditionPeintrePleiade.addSortie(textPeintrePleiade);
		conditionAuteurBaroque.addSortie(textAuteurBaroque);
		conditionPeintreBaroque.addSortie(textPeintreBaroque);
		conditionAuteurSurrealisme.addSortie(textAuteurSurrealisme);
		conditionPeintreSurrealisme.addSortie(textPeintreSurrealisme);
		conditionAuteurLumieres.addSortie(textAuteurLumiere);
		conditionPeintreLumieres.addSortie(textPeintreLumiere);
		conditionAuteurRomantisme.addSortie(textAuteurRomantisme);
		conditionPeintreRomantisme.addSortie(textPeintreRomantisme);
		
		zoneMenuAuteur.addSortie(varMenu);
		zoneMenuPeintre.addSortie(varMenu);		
		
		zoneManager.addZone(zoneBaroque);
		zoneManager.addZone(zonePleiade);
		zoneManager.addZone(zoneSurrealisme);
		zoneManager.addZone(zoneRomantisme);
		zoneManager.addZone(zoneLumieres);
		zoneManager.addZone(zoneMenuAuteur);
		zoneManager.addZone(zoneMenuPeintre);
		
		zoneManager.addPion(pionFrise);
		zoneManager.addPion(pionMenu);
		
	}
		

}

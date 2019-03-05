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
				
		PionBlock pionAuteur = new PionBlock("auteur","rouge","rond");
		PionBlock pionPeintre = new PionBlock("peintre","jaune","rond");
		
		ZoneBlock zonePleiade = new ZoneBlock("zonePleiade",110, 100,30,20,"Pléïade");
		pionAuteur.addSortie(zonePleiade);
		pionPeintre.addSortie(pionPeintre);
		
		ZoneBlock zoneBaroque = new ZoneBlock("zoneBaroque",140, 100,30,20,"Baroque");
		pionAuteur.addSortie(zoneBaroque);
		pionPeintre.addSortie(zoneBaroque);
		
		ConditionBlock conditionAuteurPleiade = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintrePleiade = new ConditionBlock(Attributs.COULEUR, "jaune");
		ConditionBlock conditionAuteurBaroque = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionPeintreBaroque = new ConditionBlock(Attributs.COULEUR, "jaune");
		zonePleiade.addSortie(conditionAuteurPleiade);
		zonePleiade.addSortie(conditionPeintrePleiade);
		zoneBaroque.addSortie(conditionAuteurBaroque);
		zoneBaroque.addSortie(conditionPeintreBaroque);
		
		TextBlock textPeintreBaroque = new TextBlock("Rembrandt");
		TextBlock textPeintrePleiade = new TextBlock("Leonard De Vinci");
		TextBlock textAuteurBaroque = new TextBlock("Christofle de Beaujeu");
		TextBlock textAuteurPleiade = new TextBlock("Rabelais");
		conditionAuteurBaroque.addSortie(textAuteurBaroque);
		conditionAuteurPleiade.addSortie(textAuteurPleiade);
		conditionPeintreBaroque.addSortie(textPeintreBaroque);
		conditionPeintrePleiade.addSortie(textPeintrePleiade);
		
		TTSBlock tts = new TTSBlock();
		textPeintreBaroque.addSortie(tts);
		textPeintrePleiade.addSortie(tts);
		textAuteurBaroque.addSortie(tts);
		textAuteurPleiade.addSortie(tts);
	}
}

package serveur;

import blocs.Attributs;
import blocs.ConditionBlock;
import blocs.PionBlock;
import blocs.TTSBlock;
import blocs.TextBlock;
import blocs.ZoneBlock;

public class ScenarioSalle implements ScenarioBloc{
	@Override
	public void initScenario(ZoneManagerBloc zoneManager) {
				
		PionBlock pionChaise = new PionBlock("chaise","red","rond");
		PionBlock pionArmoire = new PionBlock("armoire","yellow","rond");
		
		
		ZoneBlock zoneChaise1 = new ZoneBlock("zoneChaise1",110, 100,30,20,"Chaise");
		pionChaise.addSortie(zoneChaise1);
		pionArmoire.addSortie(zoneChaise1);
		
		ZoneBlock zoneChaise2 = new ZoneBlock("zoneChaise2",140, 100,30,20,"Chaise");
		pionChaise.addSortie(zoneChaise2);
		pionArmoire.addSortie(zoneChaise2);
		
		ZoneBlock zoneChaise3 = new ZoneBlock("zoneChaise3",170, 100,30,20,"Chaise");
		pionChaise.addSortie(zoneChaise3);
		pionArmoire.addSortie(zoneChaise3);
		
		ZoneBlock zoneArmoire1 = new ZoneBlock("zoneArmoire1",200, 100,30,20,"Armoire");
		pionChaise.addSortie(zoneArmoire1);
		pionArmoire.addSortie(zoneArmoire1);
		
		ZoneBlock zoneArmoire2 = new ZoneBlock("zoneArmoire2",230, 100,30,20,"Armoire");
		pionChaise.addSortie(zoneArmoire2);
		pionArmoire.addSortie(zoneArmoire2);
		
		
		ConditionBlock conditionChaise = new ConditionBlock(Attributs.COULEUR, "red");
		ConditionBlock conditionArmoire = new ConditionBlock(Attributs.COULEUR, "yellow");

		zoneChaise1.addSortie(conditionChaise);
		zoneChaise2.addSortie(conditionChaise);
		zoneChaise3.addSortie(conditionChaise);
		zoneArmoire1.addSortie(conditionArmoire);
		zoneArmoire2.addSortie(conditionArmoire);
		
		TextBlock textChaiseOK = new TextBlock("Chaise OK");
		TextBlock textChaiseKO = new TextBlock("Chaise KO");
		TextBlock textArmoireOK = new TextBlock("Armoire OK");
		TextBlock textArmoireKO = new TextBlock("Armoire KO");
		
		conditionChaise.addSortie(textChaiseOK);
		conditionChaise.addSortie(textChaiseKO);
		conditionArmoire.addSortie(textArmoireOK);
		conditionArmoire.addSortie(textArmoireKO);
				
		TTSBlock tts = new TTSBlock();
		textChaiseOK.addSortie(tts);
		textChaiseKO.addSortie(tts);
		textArmoireOK.addSortie(tts);
		textArmoireKO.addSortie(tts);
	
		
		zoneManager.addZone(zoneChaise1);
		zoneManager.addZone(zoneChaise2);
		zoneManager.addZone(zoneChaise3);
		zoneManager.addZone(zoneArmoire1);
		zoneManager.addZone(zoneArmoire2);
		
		zoneManager.addPion(pionChaise);
		zoneManager.addPion(pionArmoire);
	}
}

package blocs;

import java.util.HashMap;

import serveur.ZoneManagerBloc;

//Bloc permettant de tester une variable
//Entrée : nom de la variable
//Sortie : send aux blocs de la liste de sortie par défaut si true (pas de else implémenté)


public class ConditionVariableBlock extends CodingBlock {
	//Valeur souhaitée pour que le test soit true
	String valeurCible;
	//Nom de la variable à tester
	String variable;
	
	public ConditionVariableBlock(String variable, String valeurCible) {
		super();
		this.valeurCible = valeurCible;
		this.variable = variable;
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		this.setAllAttributs(atts);
		String valeurVar = ZoneManagerBloc.getValueVariable(variable);
		if(valeurVar.equals(valeurCible)) {
			sendAttributs(atts);						
		}

	}

}

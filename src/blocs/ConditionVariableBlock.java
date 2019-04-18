package blocs;

import java.util.HashMap;

import serveur.ZoneManagerBloc;

//Bloc permettant de tester une variable
//Entr�e : nom de la variable
//Sortie : send aux blocs de la liste de sortie par d�faut si true (pas de else impl�ment�)


public class ConditionVariableBlock extends CodingBlock {
	//Valeur souhait�e pour que le test soit true
	String valeurCible;
	//Nom de la variable � tester
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

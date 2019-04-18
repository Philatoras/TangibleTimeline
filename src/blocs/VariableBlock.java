package blocs;

import java.util.HashMap;

import serveur.ZoneManagerBloc;

//Bloc permettant de changer la valeur d'une variable de l'environnement
//Entrée : nouvelle valeur de la variable
//Sortie : rien

public class VariableBlock extends CodingBlock {
	
	//Nom de la variable qui sera modifiée
	String variableAChanger;

	public VariableBlock(String variableAChanger) {
		super();
		this.variableAChanger = variableAChanger;		
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		ZoneManagerBloc.putVariable(variableAChanger, (String) atts.get(Attributs.TEXTE));
		sendAttributs(atts);

	}

}

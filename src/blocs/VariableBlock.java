package blocs;

import java.util.HashMap;

import serveur.ZoneManagerBloc;

public class VariableBlock extends CodingBlock {
	
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

package blocs;

import java.util.HashMap;

import serveur.ZoneManagerBloc;

public class ConditionVariableBlock extends CodingBlock {

	String valeurCible;
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

package blocs;

import java.util.HashMap;

public class VariableBlock extends CodingBlock {
	
	String variableAChanger;

	public VariableBlock(String id, String variableAChanger) {
		super();
		getAttributs().put(Attributs.ID, id);
		this.variableAChanger = variableAChanger;
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		getAttributs().put(Attributs.TEXTE, atts.get(Attributs.TEXTE));
		sendAttributs();

	}

}

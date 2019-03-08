package blocs;

import java.util.HashMap;

public class GroupBlock extends CodingBlock {

	public GroupBlock(String id) {
		super();
		getAttributs().put(Attributs.ID, id);
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		

	}

}

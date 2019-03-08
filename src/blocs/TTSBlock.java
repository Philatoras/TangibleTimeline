package blocs;

import java.util.HashMap;

public class TTSBlock extends CodingBlock{

	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		System.out.println(atts.get(Attributs.TEXTE));
	}

}

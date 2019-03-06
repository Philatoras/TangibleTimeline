package blocs;

import java.util.HashMap;

public class TextBlock extends CodingBlock {

	private String textePerso;
	
	public TextBlock(String textePerso) {
		super();
		this.textePerso = textePerso;
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		atts.put(Attributs.TEXTE, textePerso);
		this.sendAttributs(atts);
	}

}

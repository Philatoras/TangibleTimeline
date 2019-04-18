package blocs;

import java.util.HashMap;

//Bloc lisant le texte en entr�e avec la TTS (ici System.out pour le debug)
//Entr�e : texte � lire
//Sortie : Son

public class TTSBlock extends CodingBlock{

	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		System.out.println(atts.get(Attributs.TEXTE));
	}

}

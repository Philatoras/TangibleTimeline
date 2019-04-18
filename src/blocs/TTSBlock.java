package blocs;

import java.util.HashMap;

//Bloc lisant le texte en entrée avec la TTS (ici System.out pour le debug)
//Entrée : texte à lire
//Sortie : Son

public class TTSBlock extends CodingBlock{

	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		System.out.println(atts.get(Attributs.TEXTE));
	}

}

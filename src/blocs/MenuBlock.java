package blocs;

import java.util.HashMap;

public class MenuBlock extends CodingBlock {
	public static String mode;
	
	public static void setMode(String mode){
		MenuBlock.mode = mode;
	}
	
	public String getMode(){
		return mode;
	}

	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		//re�oit le nom (ou le type de contenu) de la zone menu activ�e
		String modeRecu = (String)getAttributs().get(Attributs.TEXTE);
		mode = modeRecu;
		atts.put(Attributs.TEXTE, modeRecu);
		sendAttributs(atts);		
		
	}
}


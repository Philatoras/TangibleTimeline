package serveur;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import t2s.son.LecteurTexte;


// classe qui contient toutes les fonctions de lecture audio à partir d'un texte (String)
// ou d'un fichier texte 
public class TextToSpeech {
	private LecteurTexte lecteur ;
	
	//construit un objet TextToSpeech
	public TextToSpeech() {
		this.lecteur=new LecteurTexte();
	}
	
	//lecture audio d'un string
	public void lireMessage(String message) {
		this.lecteur.setTexte(message);
		this.lecteur.playAll();
	}
	
	
	//lecture audio d'un fichier texte 
	public void lireFichier(String filePath) {
		 String content = "";
		    try
		    {
		        content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace();
		    }
		    this.lireMessage(content);
	}
}

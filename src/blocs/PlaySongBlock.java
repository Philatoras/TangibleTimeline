package blocs;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Bloc permettant de jouer un fichier son
//Entrée : nom du fichier sous forme de String
//Sortie : son


public class PlaySongBlock extends CodingBlock{
	
	
	@Override
	void receipt(HashMap<Attributs, Object> atts)  {
		System.out.println("lecture d'un son ");
		 try
		    {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(
		        		new File((String)atts.get(Attributs.SONG_NAME))));
		        clip.start();
		        Thread.sleep( 5000);// obligatoire pour assurer que isrunning() fonctionne
		        while (clip.isRunning())  
		            //la lecture etant assynchrone, sans ce while, la lecture serait stoper avant 
		        	//même d'avoir commencé 
		        Thread.sleep(10);
		        clip.stop(); clip.close();
		    }
		    catch (Exception exc)
		    {
		    	System.out.println("ERREUR -> lecture d'un son ->");
		        exc.printStackTrace();
		    }
	}
	
	
}

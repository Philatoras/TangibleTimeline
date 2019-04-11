package blocs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;


public class SongBlock extends CodingBlock{
	
	String songFilePath;

	public SongBlock(String songname) {
		super();
		// open the sound file as a Java input stream
	    songFilePath = System.getProperty("user.dir")+"\\donnees\\songs\\"+songname;
	    
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts)  {
		System.out.println("lecture d'un son ");
		 try
		    {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File(songFilePath)));
		        clip.start();
		        Thread.sleep( 5000);
		        while (clip.isRunning())  
		            
		        Thread.sleep(10);
		        clip.stop(); clip.close();
		    }
		    catch (Exception exc)
		    {
		    	System.out.println("ERREUR -> lecture d'un son ->");
		        exc.printStackTrace();
		    }
	}
	
	//    Test Read Song
	//public static void main (String[] args){
	//	SongBlock mysongbloc =new SongBlock("gagne.wav");
	//  System.out.println(mysongbloc.songFilePath);
	//	mysongbloc.receipt(null);
	//	}

}

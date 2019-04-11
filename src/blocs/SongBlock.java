package blocs;
import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.util.HashMap;

public class SongBlock extends CodingBlock {

	private String songName;
	
	public SongBlock(String songname) {
		super();
		this.songName = songname;
	}
	
	@Override
	void receipt(HashMap<Attributs, Object> atts) {
		atts.put(Attributs.SONG_NAME, System.getProperty("user.dir")+"\\donnees\\songs\\"+songName);
		this.sendAttributs(atts);
	
	}

}

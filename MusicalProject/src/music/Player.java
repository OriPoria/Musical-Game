package music;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Player {
	private Clip clip;
	private HashMap<String,AudioInputStream> notesMap = new HashMap<String, AudioInputStream>();
	public Player() {
		try {
			clip = AudioSystem.getClip();
	        File IS1 = new File("src\\sounds\\Do1.wav");
	        AudioInputStream Do1 = AudioSystem.getAudioInputStream(IS1);
	        notesMap.put("do", Do1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void play(String note) {
	

		
		
	}

}

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

import database.Database;
import gui.GUI;
public class Main {
	public static void main(String [] args) {
		doSomework();
		System.out.println("Welcome to the musical game!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
	}

	
	//Empty sound to open the file with the sounds
	public static void doSomework() {
        try {
            Clip clip = AudioSystem.getClip();
            File IS1 = new File("src\\sounds\\empty.wav");
            AudioInputStream Do1 = AudioSystem.getAudioInputStream(IS1);
            clip.open(Do1);
            clip.start();
        } catch (Exception e) {
        	
        }
	}
}

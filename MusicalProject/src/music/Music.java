package music;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public static Clip playMusic(int c) {

        try {
            Clip clip = AudioSystem.getClip();
            switch (c) {
                case 1:
                    File IS1 = new File("src\\sounds\\Do1.wav");
                    AudioInputStream Do1 = AudioSystem.getAudioInputStream(IS1);
                    clip.open(Do1);
                    break;
                case 2:
                    File IS2 = new File("src\\sounds\\Re1.wav");
                    AudioInputStream Re1 = AudioSystem.getAudioInputStream(IS2);
                    clip.open(Re1);
                    break;
                case 3:
                    File IS3 = new File("src\\sounds\\Mi1.wav");
                    AudioInputStream Mi1 = AudioSystem.getAudioInputStream(IS3);
                    clip.open(Mi1);
                    break;
                case 4:
                    File IS4 = new File("src\\sounds\\Fa1.wav");
                    AudioInputStream Fa1 = AudioSystem.getAudioInputStream(IS4);
                    clip.open(Fa1);
                    break;
                case 5:
                    File IS5 = new File("src\\sounds\\Sol1.wav");
                    AudioInputStream Sol1 = AudioSystem.getAudioInputStream(IS5);
                    clip.open(Sol1);
                    break;
                case 6:
                    File IS6 = new File("src\\sounds\\La1.wav");
                    AudioInputStream La1 = AudioSystem.getAudioInputStream(IS6);
                    clip.open(La1);
                    break;
                case 7:
                    File IS7 = new File("src\\sounds\\Si1.wav");
                    AudioInputStream Si1 = AudioSystem.getAudioInputStream(IS7);
                    clip.open(Si1);
                    break;
                case 8:
                    File IS8 = new File("src\\sounds\\Do2.wav");
                    AudioInputStream Do2 = AudioSystem.getAudioInputStream(IS8);
                    clip.open(Do2);
                    break;

                	
            }
            clip.start();


            return clip;


        } catch (Exception e) {
            System.out.println(e);
        }

        return null;



    }
}

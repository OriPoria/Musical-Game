package game;

import java.awt.Color;
import java.util.ArrayList;

public class Game1Factory implements GameFactory {

	@Override
	public ArrayList<Level> create() {
		LevelFunctionality levelFunctionality = new LevelFunctionality();
		ArrayList<Note> notes = new ArrayList<Note>();
		ArrayList<Note> notes2 = new ArrayList<Note>();
		Note note = new Note("do2", Color.cyan, 8);
		Note note2 = new Note("si", Color.pink, 7);
		Note note3 = new Note("fa", Color.green, 4);
		Note note4 = new Note("mi", Color.red, 3);
		Note note5 = new Note("re", Color.yellow, 2);
		notes2.add(note3);
		notes2.add(note4);
		notes2.add(note5);
		note5.setRythm(120);
		note.setRythm(480);
		note2.setRythm(480);
		note3.setRythm(480);
		note4.setRythm(240);
		notes.add(note);
		notes.add(note2);
		
		levelFunctionality.setSections(notes, notes2);

		ArrayList<Level> allf = new ArrayList<Level>();
		allf.add(levelFunctionality);
		return allf;
	}

}

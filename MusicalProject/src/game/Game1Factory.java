package game;

import java.awt.Color;
import java.util.ArrayList;

public class Game1Factory implements GameFactory {

	@Override
	public ArrayList<Level> create() {
		LevelFunctionality levelFunctionality = new LevelFunctionality("number 1");
		LevelFunctionality levelFunctionality2 = new LevelFunctionality("number 2");
		LevelFunctionality levelFunctionality3 = new LevelFunctionality("number 2");
		LevelFunctionality levelFunctionality4 = new LevelFunctionality("number 2");

		ArrayList<Note> notes = new ArrayList<Note>();
		ArrayList<Note> notes2 = new ArrayList<Note>();
		ArrayList<Note> notes3 = new ArrayList<Note>();
		
		Note note = new Note("do2", Color.cyan, 5);
		Note note2 = new Note("si", Color.pink, 7);
		Note note3 = new Note("fa", Color.green, 4);
		Note note4 = new Note("mi", Color.green, 3);
		Note note5 = new Note("re", Color.yellow, 1);
		notes2.add(note3);
		notes3.add(note4);
		notes2.add(note4);
		notes2.add(note5);
		note5.setRythm(120);
		note.setRythm(240);
		note2.setRythm(480);
		note3.setRythm(480);
		note4.setRythm(480);
		notes.add(note);
		notes.add(note2);
		
		levelFunctionality.setSections(notes, notes2);
		levelFunctionality.setAnswer(LevelFunctionality.SIMILAR);
		levelFunctionality2.setSections(notes3, notes);
		levelFunctionality2.setAnswer(LevelFunctionality.DIFFERENT);
		levelFunctionality3.setSections(notes3, notes);
		levelFunctionality3.setAnswer(LevelFunctionality.DIFFERENT);
		levelFunctionality4.setSections(notes3, notes);
		levelFunctionality4.setAnswer(LevelFunctionality.DIFFERENT);
		ArrayList<Level> allf = new ArrayList<Level>();
		allf.add(levelFunctionality2);
		allf.add(levelFunctionality);
		allf.add(levelFunctionality3);
		allf.add(levelFunctionality4);
		
		return allf;
	}

}

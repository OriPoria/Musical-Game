package game;

import java.awt.Color;
import java.util.ArrayList;

public class Game1Factory implements GameFactory {

	@Override
	public ArrayList<Level> create() {
		LevelFunctionality levelFunctionality = new LevelFunctionality("number 1");
		LevelFunctionality levelFunctionality2 = new LevelFunctionality("number 2");


		ArrayList<Note> notes = new ArrayList<Note>();
		ArrayList<Note> notes2 = new ArrayList<Note>();
		ArrayList<Note> notes3 = new ArrayList<Note>();
		ArrayList<Note> notes4 = new ArrayList<Note>();
		
		NotesPool notesPool = new NotesPool();
		Note note = notesPool.getMap().get("do");
		Note note2 = notesPool.getMap().get("re");
		Note note3 = notesPool.getMap().get("mi");
		Note note4 = notesPool.getMap().get("fa");
		Note note5 = notesPool.getMap().get("sol");

		note.setRythm(480);
		note2.setRythm(960);
		note3.setRythm(960);
		note4.setRythm(480);
		note5.setRythm(480);

		notes3.add(note4);
		notes4.add(note5);
		notes2.add(note3);


		notes.add(note);
		notes.add(note2);
		
		levelFunctionality.setSections(notes, notes2);
		levelFunctionality.setAnswer(LevelFunctionality.SIMILAR);
		levelFunctionality2.setSections(notes3, notes4);
		levelFunctionality2.setAnswer(LevelFunctionality.SIMILAR);

		ArrayList<Level> allf = new ArrayList<Level>();
		allf.add(levelFunctionality2);
		allf.add(levelFunctionality);


		
		return allf;
	}

}

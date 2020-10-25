package game;

import java.awt.Color;
import java.util.HashMap;

public class NotesPool {
	private HashMap<String, Note> notesMap = new HashMap<String, Note>();
	public NotesPool() {
		notesMap.put("do", new Note("do", Color.blue, 1));
		notesMap.put("re", new Note("re", Color.yellow, 2));
		notesMap.put("mi", new Note("mi", Color.red, 3));
		notesMap.put("fa", new Note("fa", Color.green, 4));
		notesMap.put("sol", new Note("sol", Color.magenta, 5));
		notesMap.put("la", new Note("la", Color.orange, 6));
		notesMap.put("si", new Note("si", Color.pink, 7));
		notesMap.put("do2", new Note("do2", Color.cyan, 8));
	}
	public HashMap<String, Note> getMap() {
		return notesMap;
	}
}

package game;

import java.util.ArrayList;

import gui.Level;

public class LevelEngine {
	private ArrayList<Level> levels = new ArrayList<Level>();
	public LevelEngine(Level l) {
		levels.add(l);
	}
	public void run() {
		while (true) {
				levels.get(0).repaint();
			
		}
	}
	
}

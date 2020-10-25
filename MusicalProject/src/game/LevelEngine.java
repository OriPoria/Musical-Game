package game;

import java.util.ArrayList;

import gui.Game1View;

public class LevelEngine {
	private ArrayList<Game1View> levels = new ArrayList<Game1View>();
	public LevelEngine(Game1View l) {
		levels.add(l);
	}
	public void run() {
		while (true) {
				levels.get(0).repaint();
			
		}
	}
	
}

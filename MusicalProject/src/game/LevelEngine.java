package game;

import java.util.ArrayList;

import gui.Game1View;
import gui.GameAnimation;
import gui.PanelManager;
import gui.ResponseLevelPanel;

public class LevelEngine {
	private ArrayList<GameAnimation> levels = new ArrayList<GameAnimation>();
	
	public void addAnimation(GameAnimation ga) {
		levels.add(ga);
	}
	
	public synchronized void run() {

		while (true) {
			while (levels.get(0).isAnimationRunning()) {
				levels.get(0).repaint();

			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}

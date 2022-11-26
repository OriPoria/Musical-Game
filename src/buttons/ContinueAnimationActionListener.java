package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.LevelEngine;
import gui.Game1View;
import gui.PanelManager;
import gui.ResponseLevelPanel;

public class ContinueAnimationActionListener implements ActionListener {

	private LevelEngine levelEngine;

	public ContinueAnimationActionListener(LevelEngine le) {
		levelEngine = le;

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		synchronized (levelEngine) {
			levelEngine.notify();
		}

	}
	

}

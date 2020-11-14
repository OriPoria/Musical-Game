package gui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import buttons.ContinueAnimationActionListener;
import buttons.ContinueAnimationButton;
import game.GameDetails;
import game.LevelEngine;
import game.MyGameDetails;

@SuppressWarnings("serial")
public abstract class GameAnimation extends GameJPanel {
	protected boolean isRunning;
	protected GameDetails gameDetails;
	protected LevelEngine levelEngine;
	protected ContinueAnimationButton continueButton;
	public GameAnimation(GridBagLayout gridBagLayoutl, LevelEngine le) {
		super(gridBagLayoutl);
		gameDetails = new MyGameDetails();
		levelEngine = le;
		continueButton = new ContinueAnimationButton(new ContinueAnimationActionListener(levelEngine));
		continueButton.setText("To next level");

	}
	public boolean isAnimationRunning() {
		return isRunning;
	}
	abstract public void resetGame();
	
	public int getScoreToDraw() {
		return gameDetails.getScore();
	}
}

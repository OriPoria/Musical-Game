package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttons.DetailsChanger;
import game.GameDetails;
import game.LevelFunctionality;

public class ResponseLevelPanel extends JPanel {
	
	private JButton similar;
	private JButton different;
	private GameAnimation gameAnimation;
	private GameDetails gameDetails;
	
	public ResponseLevelPanel() {
		similar = new JButton("similar");
		different = new JButton("different");
		add(similar);
		add(different);
	}
	public void setAnimationContext(GameAnimation ga) {
		gameAnimation = ga;
	}
	public void setGameDetails(GameDetails gd) {
		gameDetails = gd;
	}
	public void setAnswer(int a) {
		if (a == LevelFunctionality.SIMILAR) {
			addActionListenerSimilar(new DetailsChanger(gameDetails));
		} else {
			addActionListenerDifferent(new DetailsChanger(gameDetails));
		}
	}
	public void addAllButtonsAction(ActionListener actionListener) {
		similar.addActionListener(actionListener);
		different.addActionListener(actionListener);
	}
	
	
	
	
	
	private void addActionListenerSimilar(ActionListener actionListener) {
		similar.addActionListener(actionListener);

	}
	private void addActionListenerDifferent(ActionListener actionListener) {
		different.addActionListener(actionListener);
	}
	public void removeListeners() {

	}

}

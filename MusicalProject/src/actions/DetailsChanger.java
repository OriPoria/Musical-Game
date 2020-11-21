package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.GameDetails;

public class DetailsChanger implements ActionListener {
	private GameDetails details;
	
	public DetailsChanger(GameDetails gd) {
		details = gd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		details.setScore(details.getScore()+1);
		
	}

}

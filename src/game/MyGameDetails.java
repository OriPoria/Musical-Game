package game;

import observer.*;

public class MyGameDetails extends GameDetails{

	private int score = 0;
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
		notifyObservers();
		
	}

}

package game;

import observer.*;

public abstract class GameDetails extends Observable  {
	public abstract int getScore();
	public abstract void setScore(int score);
	

}

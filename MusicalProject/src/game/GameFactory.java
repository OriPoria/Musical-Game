package game;

import java.util.ArrayList;


public interface GameFactory {

	// each game has several levels
	public ArrayList<Level> create();
}

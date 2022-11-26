package game;

import java.awt.Graphics;

public interface Level {
	/**
	 * @param g the graphic to draw the stream of each level
	 */
	public void drawLevel(Graphics g);
	public void playMusic();
	public void setSizeRec(int x1, int y1, int x2, int y2, int h);
	public boolean isEnd();
	public int getAnswer();
	public void restartLevel();
}

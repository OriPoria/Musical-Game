package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class LevelFunctionality {
	private ArrayList<Integer> intsArrayList = new ArrayList<Integer>();
	private int ptr = 0;
	public LevelFunctionality() {
		intsArrayList.add(30);
		intsArrayList.add(100);
		intsArrayList.add(200);
	}
	public void drawLevel(Graphics g) {
		g.drawRect(intsArrayList.get(ptr), 20, 40, intsArrayList.get(ptr));
		ptr++;
		ptr = ptr % 3;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}

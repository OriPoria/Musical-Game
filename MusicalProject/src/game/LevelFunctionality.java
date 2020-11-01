package game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

import music.Music;

public class LevelFunctionality implements Level {
	public final static int SIMILAR = 1;
	public final static int DIFFERENT = 0;
	

	private ArrayList<Note> firstSection = new ArrayList<Note>();
	private ArrayList<Note> secondSection = new ArrayList<Note>();
	private int firstSectionSize;
	private int secondSectionSize;
	private boolean isFirstSection = true;
	private int XpositionGaps;
	
	private String name;
	
	private Clip clip;
	
	private boolean isEndLevel = false;
	private int answer;
	

	private int lastSuspension = 0;
	
	private int startXfirstRec;
	private int startYfirstRec;
	private int startXSecRec;
	private int startHeight;
	private int notesPointer = 0;
	public LevelFunctionality(String s) {
		name = s;
	}
	@Override
	public void drawLevel(Graphics g) {
		suspend(lastSuspension);
		if (notesPointer == secondSectionSize && !isFirstSection) {
			resetLevel();
			suspend(300);
			clip.close();
			return;
		}
		Note note = getNote(notesPointer);
		g.setColor(note.getColor());
		

		int height = note.getSound();
		height = 8 - height;
		int startXposition = 0;
		if (isFirstSection) {
			startXposition = startXfirstRec + XpositionGaps;
			
		} else {
			startXposition = startXSecRec + XpositionGaps;
		}	
		XpositionGaps = XpositionGaps+(note.getRythm()/10);

		g.fillRect(startXposition, startYfirstRec + (height*startHeight)/8, note.getRythm()/10 , startHeight/8);

		if (notesPointer == 0 && !isFirstSection) {
			suspend(1000);
		}

		clip = Music.playMusic(note.getSound());
		
		lastSuspension = note.getRythm();

		notesPointer++;
		if (notesPointer == firstSectionSize && isFirstSection) {
			notesPointer = 0;
			isFirstSection = false;
			XpositionGaps = 0;
		}
		

	}
	/**
	 * @param x1 the x position of the start of the first rectangle
	 * @param y1 the y position of the start of the first rectangle
	 * @param x2 the x position of the start of the second rectangle
	 * @param y2 the y position of the start of the second rectangle
	 * @param h the height of both rectangles
	 */
	@Override
	public void setSizeRec(int x1, int y1, int x2, int y2, int h) {
		startXfirstRec = x1;
		startYfirstRec = y1;
		startXSecRec = x2;
		startHeight = h;
	}
	public void setSections(ArrayList<Note> fs, ArrayList<Note> ss) {
		firstSection = fs;
		secondSection = ss;
		firstSectionSize = fs.size();
		secondSectionSize = ss.size();
	}
	
	public Note getNote(int ptr) {
		if (isFirstSection)
			return firstSection.get(ptr);
		else {
			return secondSection.get(ptr);
		}
	}
	@Override
	public boolean isEnd() {
		return isEndLevel;
	}
	
	private void suspend(int s) {
		try {
			Thread.sleep(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void resetLevel() {
		notesPointer = 0;
		isFirstSection = true;
		isEndLevel = true;
		XpositionGaps = 0;
	}
	@Override
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int a) {
		this.answer = a;
	}
	@Override
	public void restartLevel() {
		isEndLevel = false;
	}
	
	

}

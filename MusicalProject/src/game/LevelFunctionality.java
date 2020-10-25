package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import music.Music;

public class LevelFunctionality implements Level {
	private ArrayList<Note> firstSection = new ArrayList<Note>();
	private ArrayList<Note> secondSection = new ArrayList<Note>();
	private int firstSectionSize;
	private int secondSectionSize;
	private boolean isFirstSection = true;
	private int XpositionGaps;
	
	private boolean isEndLevel = false;
	
	
	
	private int startXfirstRec;
	private int startYfirstRec;
	private int startXSecRec;
	private int startYSecRec;
	private int startHeight;
	private boolean first = true;
	private int notesPointer = 0;
	public LevelFunctionality() {

	}
	@Override
	public void drawLevel(Graphics g) {
		Note note = getNote(notesPointer);
		g.setColor(note.getColor());
		int height = note.getSound();
		height = 8 - height;
		int startXposition = 0;
		if (isFirstSection) {
			startXposition = startXfirstRec + (note.getRythm()/10)*notesPointer + XpositionGaps;
			
		} else {
			startXposition = startXSecRec + (note.getRythm()/10)*notesPointer + XpositionGaps;
		}	
		XpositionGaps = XpositionGaps+(note.getRythm()/10)*notesPointer ;
		
		g.fillRect(startXposition, startYfirstRec + (height*startHeight)/8, note.getRythm()/10 , startHeight/8);

		try {
			Thread.sleep(note.getRythm());
			if (notesPointer == 0 && !isFirstSection)
				Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Music.playMusic(note.getSound());

		notesPointer++;
		if (notesPointer == firstSectionSize && isFirstSection) {
			notesPointer = 0;
			isFirstSection = false;
			XpositionGaps = 0;
		} else if (notesPointer == secondSectionSize && !isFirstSection) {
			notesPointer = 0;
			isFirstSection = true;
			isEndLevel = true;
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
		startYSecRec = y2;
		startHeight = h;
	}
	public void setSections(ArrayList<Note> fs, ArrayList<Note> ss) {
		firstSection = fs;
		secondSection = ss;
		firstSectionSize = fs.size();
		secondSectionSize = ss.size();
	}
	
	public Note getNote(int prt) {
		if (isFirstSection)
			return firstSection.get(prt);
		else {
			return secondSection.get(prt);
		}
	}
	public boolean isEnd() {
		return isEndLevel;
	}
	
	

}

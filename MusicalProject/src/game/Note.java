package game;

import java.awt.Color;

public class Note {
	private String name;
	private Color color;
	private int rythm;
	private int sound;
	public Note(String n, Color c, int s) {
		name = n;
		color = c;
		sound = s; 
	}
	public String getName() {
		return name;
	}
	public Color getColor() {
		return color;
	}
	public int getSound() {
		return sound;
	}
	public int getRythm() {
		return rythm;
	}
	public void setRythm(int r) {
		rythm = r;
	}
}

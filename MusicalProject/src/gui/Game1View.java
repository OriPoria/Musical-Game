package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Level;
import game.LevelFunctionality;

@SuppressWarnings("serial")
public class Game1View extends JPanel {
	private int x= 0;
	private boolean firstPaint = true;
	private int startX;
	private int startY;
	private int startHeight;
	private ArrayList<Level> levels;
	public Game1View(ArrayList<Level> g) {
		super(new GridBagLayout());
		levels = g;
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		startX = getX();
		startY = getY();
		int width = getWidth();
		
		startHeight = getHeight();
		
		
		g.drawRect(startX + width/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);
		g.drawRect(startX + (6*width)/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);

		if (!firstPaint) {
			levels.get(0).setSizeRec(startX + width/10, startY + startHeight/10, startX + (6*width)/10, startY + startHeight/10,  (3*startHeight)/4);
			levels.get(0).drawLevel(g);			
		}
		
		firstPaint = false;

		
	}

}

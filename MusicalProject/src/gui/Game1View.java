package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Level;
import game.LevelFunctionality;

@SuppressWarnings("serial")
public class Game1View extends JPanel {
	private int startX;
	private int startY;
	private int startHeight;
	private ArrayList<Level> levels;
	private int levelPtr = 0;
	private JButton similar;
	private JButton different;
	private JButton relisten;
	private int score = 0;
	private boolean endDrawing = false;
	public Game1View(ArrayList<Level> g) {
		super(new GridBagLayout());
		levels = g;
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
		similar = new JButton("similar");
		different = new JButton("different");
		relisten = new JButton("relisten");
		resetView();
		setButtons();
		add(similar);
		add(different);
		add(relisten);
		similar.setVisible(false);
		different.setVisible(false);
		relisten.setVisible(false);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		startX = getX();
		startY = getY();
		int width = getWidth();
		
		startHeight = getHeight();
	
		g.drawString("score: " + score, startX+ 30, startY +30);
		g.drawRect(startX + width/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);
		g.drawRect(startX + (6*width)/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);


		levels.get(levelPtr).setSizeRec(startX + width/10, startY + startHeight/10,
				startX + (6*width)/10, startY + startHeight/10,  (3*startHeight)/4);
		if (!levels.get(levelPtr).isEnd()) {
			levels.get(levelPtr).drawLevel(g);		
			
		} else {
			endDrawing = true;
			similar.setVisible(true);
			different.setVisible(true);
			relisten.setVisible(true);
		}


		
	}
	public void setButtons() {
		relisten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				score--;
				levels.get(levelPtr).restartLevel();
				
			}
		});
		if (levels.get(levelPtr).getAnswer() == LevelFunctionality.SIMILAR) {
			similar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					score++;
				}
			});
		} else if (levels.get(levelPtr).getAnswer() == LevelFunctionality.DIFFERENT) {
			different.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					score++;					
				}
			});
		}
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (levelPtr < levels.size()-1)
					levelPtr++;	
				
				resetView();
			}
		};
		similar.addActionListener(al);
		different.addActionListener(al);
		relisten.addActionListener(al);
		
	}
	public boolean isEndDrawing() {
		return endDrawing;
	}
	private void resetView() {
		endDrawing = false;
		similar.setVisible(false);
		different.setVisible(false);
		relisten.setVisible(false);
	}
}

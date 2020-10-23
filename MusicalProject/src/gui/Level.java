package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.LevelFunctionality;

public class Level extends JPanel {
	private int x= 0;
	private boolean firstPaint = true;
	private LevelFunctionality lf;
	public Level() {
		super(new GridBagLayout());
		lf = new LevelFunctionality();
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 10;
		c.gridy = 1;
		c.gridx = 2;
		add(new JLabel("heelo"), c);
		c.gridy = 9;
		add(new JLabel("heelo2"), c);
		c.gridy = 12;
		add(new JLabel("heelo3"), c);
		for (int i = 0; i < 50; i ++) {
			c.gridy = (13+i);
			add(new JLabel("hello"), c);
		}

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		int x = getX();
		int y = getY();
		int width = getWidth();
		
		int height = getHeight();

		g.drawRect(x + width/10, y + height/10 ,(3*width)/10, (3*height)/4);
		g.drawRect(x + (6*width)/10, y + height/10 ,(3*width)/10, (3*height)/4);

		//g.drawRect(x, y, width, height);
		if (!firstPaint) {
			lf.drawLevel(g);			
		}
		
		firstPaint = false;

		
	}
	public void move() {
		x+=10;
	}

}

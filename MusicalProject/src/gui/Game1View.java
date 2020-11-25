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

import actions.DetailsChanger;
import buttons.ContinueAnimationActionListener;
import buttons.ContinueAnimationButton;
import game.Level;
import game.LevelEngine;
import game.LevelFunctionality;
import util.Fonts;

@SuppressWarnings("serial")
public class Game1View extends GameAnimation {
	private int startX;
	private int startY;
	private int startHeight;
	private ArrayList<Level> levels;
	private int numberLevels;
	private int levelPtr = 0;
	private boolean lock = true;
	private Thread musicPlayerThread;
	
	
	//each game has its own response logic
	private ResponseLevelPanel responsePanel = new ResponseLevelPanel();
	
		
	public Game1View(ArrayList<Level> g, LevelEngine le) {
		super(new GridBagLayout(), le);
		levels = g;
		numberLevels = levels.size();

		responsePanelSetup();

		isRunning = true;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateScreen(g);
		if (!levels.get(levelPtr).isEnd()) {
			levels.get(levelPtr).drawLevel(g);
			
			if (lock) {
				lock = false;
				
				//TODO: next need to inject the runnable
				musicPlayerThread = new Thread() {
					private int counterPlay = 0;
					@Override
					public void run() {
						while (!levels.get(levelPtr).isEnd()) {
							levels.get(levelPtr).playMusic();	
							counterPlay++;
						}
					
				}
				};
				musicPlayerThread.start();
			}
			
			
		}
		
		
		else if (levels.get(levelPtr).isEnd()) {
		
			//block the animation
			isRunning = false;
			

			responsePanel.setAnswer(levels.get(levelPtr).getAnswer());

			//prepare for the next level
			resetGame();
			
			changePanel(responsePanel);
		}



		
	}
	public void updateScreen(Graphics g) {
		g.setColor(Color.black);
		startX = getX();
		startY = getY();
		int width = getWidth();
		
		startHeight = getHeight();
	
		g.setFont(Fonts.result);
		g.drawString("score: " + getScoreToDraw(), startX+ 30, startY +35);
		g.drawRect(startX + width/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);
		g.drawRect(startX + (6*width)/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);


		levels.get(levelPtr).setSizeRec(startX + width/10, startY + startHeight/10,
				startX + (6*width)/10, startY + startHeight/10,  (3*startHeight)/4);
	}
	
	private void responsePanelSetup() {
		responsePanel.setAnimationContext(this);
		responsePanel.setGameDetails(gameDetails);
		responsePanel.continueAnimationAction(new ContinueAnimationActionListener(levelEngine));
		Game1View game1View = this;
		responsePanel.continueAnimationAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//PanelManager.changePanel(responsePanel, game1View);
				responsePanel.changePanel(game1View);
			}
		});
	}


	@Override
	public void resetGame() {
		isRunning = true;
		levelPtr++;
		lock = true;
		
		if (levelPtr == numberLevels) {
			responsePanel.setForFinishLevel();
		}

	}

}


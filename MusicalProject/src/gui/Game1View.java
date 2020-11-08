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

import buttons.ContinueAnimationActionListener;
import buttons.ContinueAnimationButton;
import buttons.DetailsChanger;
import game.Level;
import game.LevelEngine;
import game.LevelFunctionality;

@SuppressWarnings("serial")
public class Game1View extends GameAnimation {
	private int startX;
	private int startY;
	private int startHeight;
	private ArrayList<Level> levels;
	private int levelPtr = 0;
	private boolean lock = true;
	
	
	//each game has its own response logic
	private ResponseLevelPanel responsePanel = new ResponseLevelPanel();
	
		
	public Game1View(ArrayList<Level> g, LevelEngine le) {
		super(new GridBagLayout(), le);
		levels = g;
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
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
				//TODO: next need to inject the runnable
				new Thread() {
					@Override
					public void run() {
						while (!levels.get(levelPtr).isEnd()) {
							levels.get(levelPtr).playMusic();		
						}
					
				}
				}.start();
				lock = false;
				}
		}
		
		
		//TODO: need to notify
		else if (levels.get(levelPtr).isEnd()) {
		
			//block the animation
			isRunning = false;
			responsePanel.setAnswer(levels.get(levelPtr).getAnswer());
			System.out.println("before change to respone");
//			Game1View game1View = this;
//			continueButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					PanelManager.changePanel(questionPanel, game1View);
//					
//				}
//			});
			resetGame();
			PanelManager.changePanel(this, responsePanel);
		}



		
	}
	public void updateScreen(Graphics g) {
		g.setColor(Color.black);
		startX = getX();
		startY = getY();
		int width = getWidth();
		
		startHeight = getHeight();
	
		g.drawString("score: " + getScoreToDraw(), startX+ 30, startY +30);
		g.drawRect(startX + width/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);
		g.drawRect(startX + (6*width)/10, startY + startHeight/10 ,(3*width)/10, (3*startHeight)/4);


		levels.get(levelPtr).setSizeRec(startX + width/10, startY + startHeight/10,
				startX + (6*width)/10, startY + startHeight/10,  (3*startHeight)/4);
	}
	
	private void responsePanelSetup() {
		responsePanel.setAnimationContext(this);
		responsePanel.setGameDetails(gameDetails);
		responsePanel.addAllButtonsAction(new ContinueAnimationActionListener(levelEngine));
		Game1View game1View = this;
		responsePanel.addAllButtonsAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelManager.changePanel(responsePanel, game1View);
				
			}
		});
	}


	@Override
	public void resetGame() {
		isRunning = true;
		levelPtr++;
		lock = true;

	}

}

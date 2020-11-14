package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import game.Game1Factory;
import game.GameFactory;
import game.Level;
import game.LevelEngine;
import util.Fonts;
import util.Strings;

@SuppressWarnings("serial")
public class InstructionsPanel extends GameJPanel {
	public InstructionsPanel() {
		super();
		JLabel label = new JLabel(Strings.instructions);
		label.setFont(Fonts.instructions);
		
		JButton button = new JButton("start!");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFactory gf = new Game1Factory();
				ArrayList<Level> levels = gf.create();
				LevelEngine levelEngine = new LevelEngine();

				
				GameAnimation levelAnimation = new Game1View(levels, levelEngine);
				
				levelEngine.addAnimation(levelAnimation);
				
				changePanel(levelAnimation);
				new Thread() {
					@Override
					public void run() {
						levelEngine.run();
					}
				}.start();
				
			}
		});
		add(label);
		add(button);

	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.User;
import game.Level;
import game.Game1Factory;
import game.GameFactory;
import game.LevelEngine;
import game.LevelFunctionality;

@SuppressWarnings("serial")
public class SecondaryMenu extends JPanel {
	private User user;

	public SecondaryMenu () {
		super(new GridBagLayout());
		
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
	}
	public void setUser(User u) {
		user = u;
		setPage();

	}
	public void setPage() {
		JLabel welcome = new JLabel("Welcome "+user.getName());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
		c.weighty = 1;
		welcome.setFont(new Font("David", Font.BOLD, 40));
		welcome.setForeground(Color.white);
		add(welcome,c);
		welcome = new JLabel("your top score is " + user.getTopScore());
		welcome.setFont(new Font("David", Font.BOLD, 25));
		welcome.setForeground(Color.white);
		c.gridy = 1;
		add(welcome,c);
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		JButton button = new JButton("start a game!");
		JPanel wrapper = this;
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameFactory gf = new Game1Factory();
				ArrayList<Level> levels = gf.create();
				LevelEngine levelEngine = new LevelEngine();

				
				GameAnimation levelAnimation = new Game1View(levels, levelEngine);
				
				levelEngine.addAnimation(levelAnimation);
				
				
				PanelManager.changePanel(wrapper, levelAnimation);
				new Thread() {
					@Override
					public void run() {
						levelEngine.run();
					}
				}.start();
			}
		});
		add(button, c);
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_START;
		add(new JButton("score table"), c);
	}

}

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
import util.Fonts;
import util.Strings;

@SuppressWarnings("serial")
public class SecondaryMenu extends GameJPanel {
	private User user;

	public SecondaryMenu () {
		super(new GridBagLayout());
	}
	public void setUser(User u) {
		user = u;
		setPage();

	}
	private void setPage() {
		JLabel welcome = new JLabel();
		if (user.getName() != null) {
			welcome.setText("Welcome "+user.getName());
		} else {
			welcome.setText(Strings.generalWelcome);
		}
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
		c.weighty = 1;
		welcome.setFont(Fonts.title);
		welcome.setForeground(Color.white);
		add(welcome,c);
		if (user.getName() != null) {
			JLabel subwelcome = new JLabel("your top score is " + user.getTopScore());
			subwelcome .setFont(new Font("David", Font.BOLD, 25));
			subwelcome .setForeground(Color.white);
			c.gridy = 1;
			add(subwelcome ,c);
		}

		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		JButton button = new JButton("start a game!");
		GameJPanel wrapper = this;
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wrapper.changePanel(new InstructionsPanel());
			}
		});
		add(button, c);
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_START;
		add(new JButton("score table"), c);
	}

}

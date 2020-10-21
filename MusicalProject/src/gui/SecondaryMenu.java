package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.User;

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
		add(new JButton("start a game!"), c);
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_START;
		add(new JButton("score table"), c);
	}

}

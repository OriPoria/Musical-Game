package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JPanel {

	public MainMenu() {
		super(new GridLayout(3,3));
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
		JLabel title = new JLabel("Welcome to the musical game!", JLabel.CENTER);
        title.setFont(new java.awt.Font("David", 1, 40));
        title.setForeground(Color.white);
		add(title);
		add(new CenterMenu(this));

	}

}

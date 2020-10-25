package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {

	public MainMenu() {
		super(new GridLayout(3,3));
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
		JLabel title = new JLabel("Welcome to the musical game!", JLabel.CENTER);
        title.setFont(new java.awt.Font("David", 1, 40));
        title.setForeground(Color.white);
		add(title);
		try {
			add(new CenterMenu(this));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

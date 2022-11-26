package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Fonts;
import util.Strings;

@SuppressWarnings("serial")
public class MainMenu extends GameJPanel {

	public MainMenu() {
		super(new GridLayout(3,3));
		JLabel title = new JLabel(Strings.welcome , JLabel.CENTER);
        title.setFont(Fonts.title);
        title.setForeground(Color.white);
		add(title);
		add(new CenterMenu(this));

	}

}

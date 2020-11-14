package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameJPanel extends JPanel {
	
	public GameJPanel(GridLayout gridLayout) {
		super(gridLayout);
		setBackground();
	}
	public GameJPanel(GridBagLayout gridBagLayout) {
		super(gridBagLayout);
		setBackground();
	}
	public GameJPanel() {
		super();
		setBackground();
	}
	private void setBackground() {
		setBackground(Color.gray);
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
		
	}
	public void changePanel(GameJPanel to) {
		PanelManager.changePanel(this, to);
	}

}

package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	private JFrame frame;
	
	
	public GUI() {
		frame = new JFrame();
		PanelManager.setJFrame(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("my game");

		frame.setBounds(100,100,800,600);
		frame.setVisible(true);
		frame.add(new MainMenu());
		
	}
	

	public void changePanel(JPanel panel) {
		frame.add(panel);
		panel.setVisible(true);
	}

}

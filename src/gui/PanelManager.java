package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelManager {
	private static JFrame frame;
	
	public static void changePanel(JPanel from, JPanel to) {
		from.setVisible(false);
		frame.add(to);
		to.setVisible(true);
	}
	public static void setJFrame(JFrame f) {
		frame = f;
	}

}

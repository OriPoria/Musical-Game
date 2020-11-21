package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ShowResult implements ActionListener {
	private JLabel label;
	private String str;
	public ShowResult(JLabel l, String s) {
		label = l;
		str = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText(str);
		label.setVisible(true);
		
	}

}

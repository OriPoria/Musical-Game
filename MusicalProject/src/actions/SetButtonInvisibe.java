package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class SetButtonInvisibe implements ActionListener{
	private ArrayList<JButton> myButtons;
	
	public SetButtonInvisibe(ArrayList<JButton> btns) {
		myButtons = btns;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JButton btn : myButtons) {
			btn.setVisible(false);
		}
		
	}

}

package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.GameAnimation;

public class PanelChangerButton extends JButton {
	public PanelChangerButton(String string ,GameAnimation gameAnimation) {
		super(string);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

package buttons;

import javax.swing.JButton;

public class ContinueAnimationButton extends JButton {

	public ContinueAnimationButton(ContinueAnimationActionListener al) {
		super();
		addActionListener(al);
	}
}

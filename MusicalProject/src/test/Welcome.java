package test;

import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class Welcome extends JComponent {
	
	public Welcome() {
	}
	@Override
    public void paint(Graphics g){
        g.drawString("Hello Text!", 10, 10);
    }

}

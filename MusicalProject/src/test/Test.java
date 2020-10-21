package test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Test extends JPanel {
	public Test() {
		add(new JButton("from test"));

		add(new Welcome());
		//setVisible(true);
		Thread currentThread = Thread.currentThread();
		System.out.println("Executing thread in Test C'tor: " + currentThread.getName()) ;
		
	}
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("in paintComponent");
		Thread currentThread = Thread.currentThread();
		System.out.println("Executing thread in paintComponent: " + currentThread.getName()) ;
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(0, 0, 500, 500);

		
	}


}

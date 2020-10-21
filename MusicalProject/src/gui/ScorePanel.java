package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import test.Test;

public class ScorePanel extends JPanel {
	
	
	public ScorePanel() {
	      String[][] rec = {
	    	         { "1", "Steve", "AUS" },
	    	         { "2", "Virat", "IND" },
	    	         { "3", "Kane", "NZ" },
	    	         { "4", "David", "AUS" },
	    	         { "5", "Ben", "ENG" },
	    	         { "6", "Eion", "ENG" },
	    	      };
	    	      String[] header = { "Rank", "Player", "Country" };
	    	      JTable table = new JTable(rec, header);
	    	      this.add(new JScrollPane(table));
		this.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		this.setLayout(new GridLayout(0, 1));
		setBackground(Color.blue);
		setVisible(true);
	}

}

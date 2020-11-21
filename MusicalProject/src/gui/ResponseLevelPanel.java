package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.DetailsChanger;
import actions.ShowResult;
import game.GameDetails;
import game.LevelFunctionality;
import util.Fonts;
import util.Strings;

@SuppressWarnings("serial")
public class ResponseLevelPanel extends GameJPanel {
	
	private JButton similar;
	private JButton different;
	private JButton next;
	private JLabel result;
	private JPanel bottomJPanel; 
	private GameAnimation gameAnimation;
	private GameDetails gameDetails;
	
	public ResponseLevelPanel() {
		super(new GridLayout(5,1));
		JLabel qJLabel = new JLabel(Strings.question, (int)CENTER_ALIGNMENT);
		qJLabel.setFont(Fonts.title);
		qJLabel.setBackground(Color.black);
		similar = new JButton("similar");
		different = new JButton("different");
		add(qJLabel);
		JPanel jPanel = new JPanel();
		bottomJPanel = new JPanel();
		jPanel.setBackground(null);
		bottomJPanel.setBackground(null);
		jPanel.add(similar);
		jPanel.add(different);
		jPanel.setAlignmentY(BOTTOM_ALIGNMENT);
		add(jPanel);
		result = new JLabel("result", (int)TOP_ALIGNMENT);
		result.setFont(Fonts.result);
		add(result);
		result.setVisible(false);
		next = new JButton("next level");
		JPanel jPanel0 = new JPanel();
		jPanel0.setBackground(null);
		add(jPanel0);
		bottomJPanel.add(next);
		add(bottomJPanel);

	}
	public void setAnimationContext(GameAnimation ga) {
		gameAnimation = ga;
	}
	public void setGameDetails(GameDetails gd) {
		gameDetails = gd;
	}
	public void setAnswer(int a) {
		if (a == LevelFunctionality.SIMILAR) {
			similar.addActionListener(new DetailsChanger(gameDetails));
			similar.addActionListener(new ShowResult(result, Strings.correctAnswer));
			different.addActionListener(new ShowResult(result, Strings.wrongAnswer));

		} else {
			different.addActionListener(new DetailsChanger(gameDetails));
			similar.addActionListener(new ShowResult(result, Strings.wrongAnswer));
			different.addActionListener(new ShowResult(result, Strings.correctAnswer));
		}
	}
	public void continueAnimationAction(ActionListener actionListener) {
		next.addActionListener(actionListener);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setVisible(false);
			}
		});
	}
	public void setForFinishLevel() {
		bottomJPanel.remove(next);
		bottomJPanel.add(new JButton("End level"));
		
	}
	public void removeListeners() {
	}

}

package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import controller.DatabaseController;
import database.Database;
import database.User;

@SuppressWarnings("serial")
public class CenterMenu extends JPanel {
	private JTextField userNameField;
	private JButton okButton;
	private JButton adminButton;
	private JPanel wrapper;
	private Insets myInsets;
	
	public CenterMenu(JPanel w) {
		wrapper = w;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBackground(Color.gray);
		myInsets = new Insets(0, 0, 0, 5);
		c.insets = myInsets;
		c.gridwidth = 2;
		userNameField = new JTextField("ori", 15);
		add(userNameField, c);
		okButton = new JButton("ok");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DatabaseController dbc = new DatabaseController();
				SecondaryMenu sm = new SecondaryMenu();
				
				new SwingWorker<User, Object>() {
				       @Override
				       public User doInBackground() {
				           return dbc.getUser(userNameField.getText());
				       }
				       @Override
				       protected void done() {
				           try {
								sm.setUser(get());
								PanelManager.changePanel(wrapper, sm);
				           } catch (Exception ignore) {
				           }
				       }
				}.execute();
			}
		});
			

		add(okButton);
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		myInsets.set(10, 0, 0, 0);
		c.insets = myInsets;
		adminButton = new JButton("I'm adim");
		add(adminButton, c);
	}

}

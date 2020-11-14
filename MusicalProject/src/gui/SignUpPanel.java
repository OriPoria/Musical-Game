package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import components.HintTextField;
import database.Database;
import database.User;

@SuppressWarnings("serial")
public class SignUpPanel extends GameJPanel {
	public SignUpPanel() {
		super(new GridBagLayout());
		JTextField username = new HintTextField("select your username", 15);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String string = username.getText();
				new SwingWorker<Object, Object>() {
					User newUser = null;

					@Override
					protected Object doInBackground() throws Exception {
						if (Database.get(string) != null) {
							System.out.println("user already exist");
							throw new Exception("user already exist");
						}
						Database.post(string, 0);
						newUser = Database.get(string);
						return null;
					}
					@Override
				    protected void done() {
			        	if (newUser != null) {
			        		changePanel(new MainMenu());
			        	}
					}
					
				}.execute();
				
			}
		});
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		add(username, c);
		c.gridx = 1;
		add(okButton, c);
		
	}

}

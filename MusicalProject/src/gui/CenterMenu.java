package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import components.HintTextField;
import database.Database;
import database.User;
import util.Fonts;

@SuppressWarnings("serial")
public class CenterMenu extends JPanel {
	private JTextField userNameField;
	private JButton loginButton;
	private JButton signupButton;
	private JButton playFreeButton;
	private JLabel userNotFound;
	
	private GameJPanel wrapper;
	
	private SecondaryMenu secondaryMenu = new SecondaryMenu();
	
	
	public CenterMenu(GameJPanel w) {
		wrapper = w;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBackground(Color.gray);
		userNameField = new HintTextField("username", 15);
		userNameField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	userNotFound.setVisible(false);
	            }
	    });
		loginButton = new JButton("login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SwingWorker<User, Object>() {
				       @Override
				       public User doInBackground() {
				           return Database.get(userNameField.getText());
				       }
				       @Override
				       protected void done() {
				           try {
								secondaryMenu.setUser(get());
								wrapper.changePanel(secondaryMenu);
				           } catch (Exception ignore) {
				        	   userNotFound.setVisible(true);
				           }
				       }
				}.execute();
			}
		});

		signupButton = new JButton("sign up");
		signupButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wrapper.changePanel(new SignUpPanel());
				
			}
		});
		playFreeButton = new JButton("play free");
		playFreeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				secondaryMenu.setUser(new User());
				wrapper.changePanel(secondaryMenu);
				
			}
		});
		userNotFound = new JLabel("username or password incorrect");
		userNotFound.setForeground(Color.black);
		userNotFound.setFont(Fonts.errorMsg);
		ArrayList<JComponent> components = new ArrayList<JComponent>(
			Arrays.asList(userNameField, loginButton, signupButton, playFreeButton, userNotFound));
		c.gridy = 0;
		for (Component comp : components) {
			c.insets = util.Insets.bottomSpace;
			add(comp, c);
			c.gridy++;
		}
		userNotFound.setVisible(false);

			
	

	}

}

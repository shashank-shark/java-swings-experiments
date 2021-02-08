package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	private JTextField userField;
	private JPasswordField passwordField;
	
	public PrefsDialog(JFrame frame) {
		
		super(frame, "Preferences", false);
		
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		
		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		portSpinner = new JSpinner(spinnerModel);
		
		
		userField = new JTextField(10);
		passwordField = new JPasswordField(10);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Zero Row
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		
		add(new JLabel("Username: "), gc);
		gc.gridx ++;
		add(userField, gc);
		
		gc.gridx --;
		gc.gridy ++;
		add(new JLabel("Password: "), gc);
		gc.gridx ++;
		add(passwordField, gc);
		
		
		// First Row
		gc.gridx --;
		gc.gridy ++;
		gc.fill = GridBagConstraints.NONE;
		
		
		add (new JLabel("Port: "), gc);
		gc.gridx ++;
		add(portSpinner, gc);
		
		// Second Row
		gc.gridx = 0;
		gc.gridy ++;
		
		add(okButton, gc);
		
		gc.gridx ++;
		add(cancelButton, gc);
		
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = (Integer) portSpinner.getValue();
				setVisible(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setSize(400, 300);
		setLocationRelativeTo(frame);
	}

}
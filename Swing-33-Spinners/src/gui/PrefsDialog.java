package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	
	public PrefsDialog(JFrame frame) {
		
		super(frame, "Preferences", false);
		
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		
		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		portSpinner = new JSpinner(spinnerModel);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// First Row
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
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

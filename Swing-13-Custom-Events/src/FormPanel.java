import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameTextField;
	private JTextField occupationTextField;
	private JButton okButton;
	private FormListener formListener;
	
	public FormPanel() {
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameTextField = new JTextField(10);
		occupationTextField = new JTextField(10);
		okButton = new JButton("OK");
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String occupation = occupationTextField.getText();
				
				FormEvent formEvent = new FormEvent(this, name, occupation);
				
				if (formListener != null) {
					formListener.formEventOccurred(formEvent);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Simple Swings");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// space taken with relative to other cells
		gc.weightx = 1; 
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		

		////////// FIRST ROW ///////////////
		gc.weightx = 1.1; 
		gc.weighty = 0.1;
		
		gc.gridx = 0; 
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		// (top, left, bottom, right)
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1; 
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameTextField, gc);
		
		//////////Second ROW ///////////////
		gc.weightx = 1.1; 
		gc.weighty = 0.1;
		
		gc.gridy = 1; 
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		// (top, left, bottom, right)
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);
		
		gc.gridx = 1; 
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(occupationTextField, gc);
		
		//////////THIRD ROW ///////////////
		gc.weightx = 1.0; 
		gc.weighty = 2.0;
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okButton, gc);
		
	}
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

}

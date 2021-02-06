import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JList ageList;
	private JComboBox empCombo;
	
	public FormPanel() {
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameTextField = new JTextField(10);
		occupationTextField = new JTextField(10);
		okButton = new JButton("OK");
		ageList = new JList();
		empCombo = new JComboBox();
		
		// Setup Comobox
		DefaultComboBoxModel empModel = new DefaultComboBoxModel<>();
		empModel.addElement("Employed");
		empModel.addElement("Self Employed");
		empModel.addElement("Unemployed");
		empCombo.setModel(empModel);
		
		// Setup Listbox
		DefaultListModel ageModel = new DefaultListModel<>();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1,  "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 to over"));
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(110, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String occupation = occupationTextField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
				String empCat = (String) empCombo.getSelectedItem();
				
				FormEvent formEvent = new FormEvent(this, name, occupation, ageCat.getId(), empCat);
				
				if (formListener != null) {
					formListener.formEventOccurred(formEvent);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Simple Swings");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
	
	public void layoutComponents() {

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// space taken with relative to other cells
		gc.weightx = 1; 
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		

		////////// FIRST ROW ///////////////
		gc.gridy = 0;
		
		gc.weightx = 1.1; 
		gc.weighty = 0.1;
		
		gc.gridx = 0; 
		
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
		gc.gridy ++;
		
		gc.weightx = 1.1; 
		gc.weighty = 0.1;
		
	
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
		gc.gridy ++;
		
		gc.weightx = 1.0; 
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		// (top, left, bottom, right)
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Age: "), gc);
		
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gc);
		
		//////////Next ROW ///////////////
		gc.gridy ++;
		
		gc.weightx = 1.0; 
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		// (top, left, bottom, right)
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Employment: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc);
		
		//////////Next ROW ///////////////
		gc.gridy ++;
		
		gc.weightx = 1.0; 
		gc.weighty = 2.0;
		
	
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okButton, gc);
	}
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

}

class AgeCategory{
	
	private int id;
	private String text;
	
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String toString() {
		return this.text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

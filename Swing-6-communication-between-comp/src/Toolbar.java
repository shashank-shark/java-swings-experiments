import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	
	private JButton helloButton;
	private JButton goodByeButton;
	private TextPanel textPanel;
	
	public Toolbar() {
		
		helloButton = new JButton("Hello");
		goodByeButton = new JButton("Good Bye!");
		
		helloButton.addActionListener(this);
		goodByeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodByeButton);
	}
	
	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		
		if (clicked == helloButton) {
			textPanel.appendText("Hello Button from FlowLayout Clicked!\n");
		}
		
		if (clicked == goodByeButton) {
			textPanel.appendText("GoodBye Button from FlowLayout Clicked!\n");
		}
	}
}

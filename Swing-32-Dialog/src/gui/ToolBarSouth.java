package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBarSouth extends JPanel implements ActionListener {
	
	private JButton helloButton;
	private JButton goodByeButton;
	private StringListener textListener;
	
	public ToolBarSouth() {
		
		helloButton = new JButton("Hello");
		goodByeButton = new JButton("Good Bye!");
		
		helloButton.addActionListener(this);
		goodByeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodByeButton);
	}
	
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton) event.getSource();
		
		if (clicked == helloButton) {
			if (textListener != null) {
				textListener.textEmitter("Hello\n");
			}
		}
		
		if (clicked == goodByeButton) {
			if (textListener != null) {
				textListener.textEmitter("GoodBye\n");
			}
			
		}
	}
}

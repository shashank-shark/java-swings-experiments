import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	
	private JButton helloButton;
	private JButton goodByeButton;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodByeButton = new JButton("Good Bye!");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodByeButton);
	}
}

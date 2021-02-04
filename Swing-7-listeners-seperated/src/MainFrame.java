import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private JButton btn;
	private Toolbar toolBar;
	private ToolBarSouth toolBarSouth;
	
	public MainFrame() {
		super("Hello World");
		setLayout(new BorderLayout());
		
		toolBar = new Toolbar();
		textPanel = new TextPanel();
		btn = new JButton("Click Me!");
		toolBarSouth = new ToolBarSouth();
		
		// invoked from toolbar
		toolBar.setStringListener(new StringListener() {
			public void textEmitter(String text) {
				textPanel.appendText("NORTH".concat(text));
			}
		});
		
		// invoked from ToolBarSouth
		toolBarSouth.setStringListener(new StringListener() {
			public void textEmitter(String text) {
				textPanel.appendText("South".concat(text));
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello World\n");		
			}
		});
		
		add(toolBar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		add(toolBarSouth, BorderLayout.SOUTH);
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

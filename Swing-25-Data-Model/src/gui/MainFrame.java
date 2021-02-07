package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private JButton btn;
	private Toolbar toolBar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;

	public MainFrame() {

		super("Hello World");
		setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());

		toolBar = new Toolbar();
		textPanel = new TextPanel();
		btn = new JButton("Click Me!");
		formPanel = new FormPanel();
		
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		// invoked from toolbar
		toolBar.setStringListener(new StringListener() {
			public void textEmitter(String text) {
				textPanel.appendText("NORTH".concat(text));
			}
		});

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmpCat();
				String gender = e.getGender();
				textPanel.appendText(
						name + " : " + occupation + " : " + ageCat + " : " + empCat + " : " + gender + "\n");
			}
		});

		btn.setMnemonic(KeyEvent.VK_O);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello World\n");
			}
		});

		add(formPanel, BorderLayout.WEST);
		add(toolBar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data ..");
		JMenuItem importDataItem = new JMenuItem("Import Data ..");
		JMenuItem exitItem = new JMenuItem("Exit ..");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});
		
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					File[] filesSelected = fileChooser.getSelectedFiles();
					System.out.println(Arrays.toString(filesSelected));
				}
			}
			
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					
				}
			}
		});
		
		

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				String text = JOptionPane.showInputDialog(MainFrame.this,
//						"Enter your user name",
//						"Enter User Name", JOptionPane.OK_CANCEL_OPTION | JOptionPane.QUESTION_MESSAGE);
//				System.out.println(text);
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do ypu really want to exit the application ?",
						"Confirm Exit.", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}

		});

		return menuBar;
	}
}
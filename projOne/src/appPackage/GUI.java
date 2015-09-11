package appPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private List<String> values;
	
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/appPackage/calculator-icon.png")));
		setTitle("Integer Tool");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnNewMenu.add(mntmImport);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmClose = new JMenuItem("Exit");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            System.exit(0);
			}
		});
		mnNewMenu.add(mntmClose);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnNewMenu_1.add(mntmDelete);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "To be added.", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(345, 23, 89, 23);
		contentPane.add(btnBrowse);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = textField.getText();
				String[] parts = str.split(",");
				
				for (int index = 0; index < parts.length; index++) {
					parts[index] = parts[index].trim();
				}
				
				//List<String> values = Arrays.asList(parts);
				
				 List<Double> values = new ArrayList<Double>(parts.length);
				for (String value : values) {
					values.add(Double.parseDouble(value));
				}
				
			}
		});
		btnSubmit.setBounds(345, 63, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AssignmentOne findAvg = new AssignmentOne();
				findAvg.ArrayAverage(values);
			}
		});
		btnCompute.setBounds(10, 96, 89, 23);
		contentPane.add(btnCompute);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 325, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 65, 325, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 130, 424, 2);
		contentPane.add(separator);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 143, 424, 96);
		contentPane.add(textArea);
		
		JLabel lblTest = new JLabel(" Select a file to use as input, or...");
		lblTest.setBounds(10, 11, 325, 14);
		contentPane.add(lblTest);
		
		JLabel lblEnterNumbersTo = new JLabel(" Enter numbers to be calculated.");
		lblEnterNumbersTo.setBounds(10, 51, 325, 14);
		contentPane.add(lblEnterNumbersTo);
	}
}

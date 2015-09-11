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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private List<Double> valueD;
	private JFileChooser fc;
	
	public GUI() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/appPackage/calculator-icon.png")));
		setTitle("Integer Tool");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		//ADD DOCUMENTATION
		JMenuItem mntmImport = new JMenuItem("Import");
		mntmImport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fc.showOpenDialog(GUI.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                
	                try {
						textField.setText(file.getCanonicalPath());
					} catch (IOException ee) {
						ee.printStackTrace();
					}
				}
			}
		});
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
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		//ADD DCOUMENTATION
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String about = ("Integer Tool is an application that calculates the average, "
						      + "\nminumum, and maximum of a set of numbers. In additon, "
						      + "\nit will display those numbers in ascending order.\n\n"
						      + "Input can be taken as a text file of real numbers or entered"
						      + "\nin comma-delimited format.");
				JOptionPane.showMessageDialog(contentPane, about, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fc = new JFileChooser();
		
		//ADD DOCUMENTATION
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(GUI.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                
	                try {
						textField.setText(file.getCanonicalPath());
					} catch (IOException ee) {
						ee.printStackTrace();
					}
				}			
			}
		});
		btnBrowse.setBounds(345, 23, 89, 23);
		contentPane.add(btnBrowse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 424, 96);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		//ADD DOCUMENTATION
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String str = textField_1.getText();
				String[] parts = str.split(",");
				
				
				for (int index = 0; index < parts.length; index++) {
					parts[index] = parts[index].trim();
				}

				List<String> valueS = Arrays.asList(parts);
				
				valueD = new ArrayList<>(valueS.size());
				try {
				for (String string : valueS) {
					valueD.add(new Double(string));
				}
				} catch (NumberFormatException e2) {
					textArea.append("Please enter numbers only (in comma-delimited format).\n");
				}
			}
		});
		btnSubmit.setBounds(345, 63, 89, 23);
		contentPane.add(btnSubmit);
		
		//ADD DOCUMENTATION
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				if (!(textField.getText().equals("")) && (textField_1.getText().equals(""))) {
					try {
						Scanner s = new Scanner(new File(textField.getText()));
						ArrayList<Double> list = new ArrayList<Double>();
						try {
							while (s.hasNext()) {
								if(s.hasNextDouble()) {
									list.add(s.nextDouble());
								}
								else {
									s.next();
								}
							}
								AssignmentOne findAvg = new AssignmentOne();
								Collections.sort(list);
								
								textArea.append("Average of numbers: " + Double.toString(findAvg.ArrayAverage(list)) + "\n");
								textArea.append("Largest value: " + Collections.max(list) + "\n");
								textArea.append("Smallest value: " + Collections.min(list)+ "\n");
								textArea.append("Values in ascending order: " + list + "\n");
								
								s.close();
							
						} catch (Exception e2) {
							textArea.append("Please use a properly formatted text file.\n");
						}
					} catch (Exception e1) {
						textArea.append("Please use a properly formatted text file.\n");
					}
				}
				else {
					AssignmentOne findAvg = new AssignmentOne();
					Collections.sort(valueD);
					
					textArea.append("Average of numbers: " + Double.toString(findAvg.ArrayAverage(valueD)) + "\n");
					textArea.append("Largest value: " + Collections.max(valueD) + "\n");
					textArea.append("Smallest value: " + Collections.min(valueD)+ "\n");
					textArea.append("Values in ascending order: " + valueD + "\n");
				}
			}
		});
		btnCompute.setBounds(10, 96, 89, 23);
		contentPane.add(btnCompute);
		
		textField = new JTextField();
		textField.setEditable(false);
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
		
		JLabel lblTest = new JLabel(" Select a file to use as input, or...");
		lblTest.setBounds(10, 11, 325, 14);
		contentPane.add(lblTest);
		
		JLabel lblEnterNumbersTo = new JLabel(" Enter numbers to be calculated.");
		lblEnterNumbersTo.setBounds(10, 51, 325, 14);
		contentPane.add(lblEnterNumbersTo);
	}
}

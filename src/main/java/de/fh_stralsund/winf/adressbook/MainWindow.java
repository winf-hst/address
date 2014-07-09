package de.fh_stralsund.winf.adressbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private final JButton btnLoadButton = new JButton("Liste laden");
	private JTextField textFieldName;
	private JTextField textFieldAdress;
	private Addressbook book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		
		book = new Addressbook();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 750, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Adressverwaltung 0.1");
		
		final DefaultListModel listModel = new DefaultListModel(); 
		JList list = new JList(listModel);
		frame.getContentPane().add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		btnLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//load
				book.readList();
				listModel.removeAllElements();
				
				for (Contact c : book.getContactList()) {	
					listModel.addElement(c.getFullAddress());
				}
			}
		});
		panel.add(btnLoadButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JButton btnSaveButton = new JButton("Liste speichern");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save
				book.saveList();
			}
		});
		panel.add(btnSaveButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JLabel lblName = new JLabel("Name:");
		panel.add(lblName);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		textFieldName = new JTextField();
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		panel.add(lblAdresse);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		textFieldAdress = new JTextField();
		panel.add(textFieldAdress);
		textFieldAdress.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_5);
		
		JButton btnAdd = new JButton("Hinzufügen");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add to list
					listModel.addElement(textFieldName.getText() + " - " + textFieldAdress.getText());
				//add to gui
					book.addContact(new Contact(textFieldName.getText() + " - " + textFieldAdress.getText()));
			}
		});
		panel.add(btnAdd);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		JMenuItem mntmAbout = new JMenuItem("Über..");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Projektstudium WINF - 2014 - Wengerek");
			}
		});
		mnDatei.add(mntmAbout);
		mnDatei.add(mntmBeenden);
		
	}

}

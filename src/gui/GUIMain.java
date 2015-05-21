package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUIMain extends GUILanguage {

	protected static JPanel menuBar = new JPanel();
	private GUIActionListener actionListener = new GUIActionListener();
	
	private JScrollPane scrollPane = new JScrollPane();
	private JLayeredPane defualtPane = new JLayeredPane();

	{
		actionListener.login();
		scrollPane.setVisible(false);
		defualtPane.setVisible(false);
		add(defualtPane, BorderLayout.CENTER);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth() / 10 * 8;
		int height = (int) screenSize.getHeight() / 10 * 8;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setTitle("Menu");

		makeMenuButtons();

		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				closeSystem();
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
	}

	protected void closeSystem() {
		System.exit(1);
	}

	private void makeMenuButtons() {
		JPanel menuButtons = new JPanel();
		menuButtons.setLayout(new GridLayout(1, 3));

		JButton toMainMenu = new JButton(menuLang);
		toMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton toKunder = new JButton(clientLang);
		toKunder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showClientList();
			}
		});

		JButton makeNew = new JButton(newLang);
		makeNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNew();
			}
		});

		menuButtons.add(toKunder);
		menuButtons.add(toMainMenu);
		menuButtons.add(makeNew);
		add(menuButtons, BorderLayout.SOUTH);
	}

	protected void showClientList() 
	{   
		scrollPane.removeAll();
		defualtPane.setVisible(false);
		if (scrollPane.isVisible())
		{
			scrollPane.setVisible(false);
			return;
		} 
		else 
		{
			
			Object rowData[][] = {
					{ "Row1-Column1", "Row1-Column2", "Row1-Column3" },
					{ "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
			Object columnNames[] = { "Column One", "Column Two", "Column Three" };
			JTable table = new JTable(rowData, columnNames);

			scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			setVisible(true);
		}
	}

	protected void showNew() {
		defualtPane.removeAll();
		scrollPane.setVisible(false);
		if (defualtPane.isVisible()) {
			
			defualtPane.setVisible(false);
			return;
		}
		else 
		{	
			JLabel clientFirstName = new JLabel(clientLang + " " + firstNameLang);
			clientFirstName.setBounds(20, 10, 100, 20);
			defualtPane.add(clientFirstName);
			
			JTextField writeClientFirstName = new JTextField();
			writeClientFirstName.setBounds(20, 30, 100, 20);
			defualtPane.add(writeClientFirstName);
			
			JLabel clientLastName = new JLabel(clientLang + " " + lastNameLang);
			clientLastName.setBounds(20, 60, 100, 20);
			defualtPane.add(clientLastName);
			
			JTextField writeClientLastName = new JTextField();
			writeClientLastName.setBounds(20, 80, 100, 20);
			defualtPane.add(writeClientLastName);
			
			JLabel clientPhoneNumber = new JLabel(clientLang + " " + phoneLang);
			clientPhoneNumber.setBounds(20, 110, 100, 20);
			defualtPane.add(clientPhoneNumber);
			
			JTextField writeClientPhoneNumber = new JTextField();
			writeClientPhoneNumber.setBounds(20, 130, 100, 20);
			defualtPane.add(writeClientPhoneNumber);
			
			JLabel clientID = new JLabel(clientLang + "ID");
			clientID.setBounds(1000, 10, 100, 20);
			defualtPane.add(clientID);
			
			JLabel clientIDField= new JLabel("*Just an number*"); //Get ID from database when the record is made by the bottom click.
			clientIDField.setBounds(1000, 30, 100, 20);
			defualtPane.add(clientIDField);
			
			JButton confirm = new JButton(confirmLang);
			confirm.setBounds(1000, 600, 100, 20);
			confirm.addActionListener(actionListener.confirmChange(writeClientFirstName, writeClientPhoneNumber));
			defualtPane.add(confirm);
			
			defualtPane.setVisible(true);
			setVisible(true);
		}
	}
}

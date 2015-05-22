package gui;

import time.Timestamp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUIMain extends GUILanguage
{

	protected static JPanel menuBar = new JPanel();
	private GUIActionListener actionListener = new GUIActionListener();
	private GUIController guiController = new GUIController();

	private JScrollPane scrollPane = new JScrollPane();
	private JLayeredPane defualtPane = new JLayeredPane();
	private int paneHeight;
	private int paneWidth;

	int rectangleY;
	int rectangleX;
	int rectangleW;
	int rectangleH;
	boolean rectangleTrue;

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
			Object columnNames[] = { "Column One", "Column Two", "Column Three" };
			DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			
			ResultSet rs = guiController.caseReadAll()
					while(rs.next())
					{
						rowData.addRow(new Object[]
								{ rs.getString(1), rs.getString(2), rs.getString(3) });
					}
			JTable table = new JTable(model);

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
			setTitle(menuLang);
			return;
		}
		else 
		{	
			defualtPaneRectangleReset();
			
			defualtPane.setVisible(true);
			add(defualtPane);
			setVisible(true);
			
			paneWidth = defualtPane.getSize().width;
			paneHeight = defualtPane.getSize().height;
			
			setTitle(clientLang);
			
			JLabel clientFirstName = new JLabel(firstNameLang);
			clientFirstName.setBounds(makeRectangle());
			defualtPane.add(clientFirstName);

			JTextField writeClientFirstName = new JTextField();
			writeClientFirstName.setBounds(makeRectangle());
			defualtPane.add(writeClientFirstName);

			JLabel clientLastName = new JLabel(lastNameLang);
			clientLastName.setBounds(makeRectangle());
			defualtPane.add(clientLastName);

			JTextField writeClientLastName = new JTextField();
			writeClientLastName.setBounds(makeRectangle());
			defualtPane.add(writeClientLastName);

			JLabel clientPhoneNumber = new JLabel(phoneLang);
			clientPhoneNumber.setBounds(makeRectangle());
			defualtPane.add(clientPhoneNumber);

			JTextField writeClientPhoneNumber = new JTextField();
			writeClientPhoneNumber.setBounds(makeRectangle());
			defualtPane.add(writeClientPhoneNumber);

			JLabel clientPostNr = new JLabel(postNrLang);
			clientPostNr.setBounds(makeRectangle());
			defualtPane.add(clientPostNr);

			JTextField writeClientPostNr = new JTextField();
			writeClientPostNr.setBounds(makeRectangle());
			defualtPane.add(writeClientPostNr);

			JLabel clientAdress = new JLabel(adressLang);
			clientAdress.setBounds(makeRectangle());
			defualtPane.add(clientAdress);

			JTextField writeClientAdress = new JTextField();
			writeClientAdress.setBounds(makeRectangle());
			defualtPane.add(writeClientAdress);
			
			JLabel clientEmail = new JLabel(emailLang);
			clientEmail.setBounds(makeRectangle());
			defualtPane.add(clientEmail);

			JTextField writeClientEmail = new JTextField();
			writeClientEmail.setBounds(makeRectangle());
			defualtPane.add(writeClientEmail);

			JLabel clientID = new JLabel(IDLang); // Get ID from
																// database when
																// the record is
																// made by the
																// bottom click.
			clientID.setBounds(paneWidth - 120, 10, 100, 20);
			defualtPane.add(clientID);

			String timeNow = Timestamp.convert(Timestamp.getTimeNow());
			JLabel clientIDField = new JLabel(timeNow);
			clientIDField.setBounds(paneWidth - 150, 30, 150, 20);
			defualtPane.add(clientIDField);

			JButton confirm = new JButton(confirmLang);
			confirm.setBounds(paneWidth - 120, paneHeight - 40, 100, 20);
			confirm.addActionListener(actionListener.confirmChange(
					writeClientFirstName, writeClientPhoneNumber));
			defualtPane.add(confirm);

		}
	}

	private void defualtPaneRectangleReset()
	{
		rectangleY = 10;
		rectangleX = 20;
		rectangleW = 100;
		rectangleH = 20;
		rectangleTrue = true;
	}

	private Rectangle makeRectangle()
	{
		Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleW,
				rectangleH);
		if (rectangleTrue)
		{
			rectangleY += 20;
			rectangleTrue = false;
			if (rectangleY + 60 > paneHeight)
			{
				rectangleX += 120;
				rectangleY = 10;
				rectangleTrue = true;
			}
		}
		else
		{
			rectangleY += 30;
			rectangleTrue = true;
		}
		return r;
	}
}
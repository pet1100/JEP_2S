package gui;
//@Peter J.

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import time.Timestamp;
import dbe.Case;
import dbe.Client;
import dbe.Employee;

public class GUIMain extends GUILanguage {

	protected static JPanel menuBar = new JPanel();
	private GUILogin actionListener = new GUILogin();
	private GUIController guiController = new GUIController();

	private JScrollPane scrollPane = new JScrollPane();
	private JLayeredPane defualtPane = new JLayeredPane();
	private int paneHeight;
	private int paneWidth;

	private int rectangleY;
	private int rectangleX;
	private int rectangleW;
	private int rectangleH;
	private boolean rectangleTrue;

	{
		lookNFeel();
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
		setTitle(menuLang);

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

		defualtPane.setVisible(true);
		add(defualtPane);
		setVisible(true);

		if (paneWidth == 0 || paneHeight == 0) {
			paneWidth = defualtPane.getSize().width;
			paneHeight = defualtPane.getSize().height;
		}
		defualtPane.setVisible(false);
	}

	public static DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

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
				showMenu();
			}
		});
		
		JButton toCases = new JButton(caseLang);
		toCases.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCaseList();
			}
		});

		JButton toKunder = new JButton(clientLang);
		toKunder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showClientList();
			}
		});
		
		JButton toEmpoyee = new JButton(workLang);
		toEmpoyee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showWorkerList();
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
		menuButtons.add(toCases);
		menuButtons.add(toEmpoyee);
		menuButtons.add(toMainMenu);
		menuButtons.add(makeNew);
		add(menuButtons, BorderLayout.SOUTH);
	}

	protected void showWorkerList() {
		if(scrollPaneThere()) {
			model.setRowCount(0);
			model.setColumnIdentifiers(new Object[] { IDLang, nameLang, adressLang, postNrLang, cityLang});

			ResultSet rs = guiController.workerReadAll();
			
		
			try {
				while (rs.next()) {
					model.addRow(new Object[] {rs.getString(1), rs.getString(2) + " " + rs.getString(3), rs.getString(6), rs.getString(7), rs.getString(15)});
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JTable table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				int lastRow = -1;

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = table.rowAtPoint(evt.getPoint());

					if (lastRow == row) {
						int i = Integer.parseInt(model.getValueAt(row, 0)
								.toString());
						showOne(2, i);
					}
					lastRow = row;
				}
			});

			scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			setVisible(true);
		}
	}

	protected void showCaseList() {
		if(scrollPaneThere()) {
			model.setRowCount(0);
			model.setColumnIdentifiers(new Object[] { IDLang, cityLang, postNrLang, datoLang, caseLang + "" + adressLang, clientLang + " " + nameLang  });

			ResultSet rs = guiController.caseReadAll();
		
			try {
				while (rs.next()) {
					model.addRow(new Object[] {rs.getInt(14), rs.getString(7), rs.getShort(6), rs.getString(3), rs.getString(5), rs.getString(8) + " " + rs.getString(9) });
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JTable table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				int lastRow = -1;

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = table.rowAtPoint(evt.getPoint());

					if (lastRow == row) {
						int i = Integer.parseInt(model.getValueAt(row, 0)
								.toString());
						showOne(3, i);
					}
					lastRow = row;
				}
			});

			scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			setVisible(true);
		}
	}

	protected void showClientList() {
		if(scrollPaneThere()) {
			model.setRowCount(0);
			model.setColumnIdentifiers(new Object[] { IDLang, nameLang,
					phoneLang, emailLang, adressLang, cityLang, postNrLang,
					datoLang });

			ResultSet rs = guiController.clientReadAll();

			try {
				while (rs.next()) {
					model.addRow(new Object[] { rs.getInt(9),
							rs.getString(1) + " " + rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(8), rs.getString(7), rs.getString(6) });
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JTable table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				int lastRow = -1;

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = table.rowAtPoint(evt.getPoint());

					if (lastRow == row) {
						int i = Integer.parseInt(model.getValueAt(row, 0)
								.toString());
						showOne(1, i);
					}
					lastRow = row;
				}
			});

			scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
			scrollPane.setVisible(true);
			setVisible(true);
		}
	}

	private boolean scrollPaneThere() {
		scrollPane.removeAll();
		defualtPane.setVisible(false);
		if (scrollPane.isVisible()) {
			scrollPane.setVisible(false);
			return false;
		}
		return true;
	}

	protected void showNew() {
		defualtPane.removeAll();
		scrollPane.setVisible(false);
		if (defualtPane.isVisible() && getTitle().equals(newLang)) {

			defualtPane.setVisible(false);
			setTitle(menuLang);
			return;
		} else {
			defualtPane.setVisible(false);
			defualtPane.removeAll();
			defualtPaneRectangleReset();

			defualtPane.setVisible(true);
			add(defualtPane);
			setVisible(true);

			if (paneWidth == 0 || paneHeight == 0) {
				paneWidth = defualtPane.getSize().width;
				paneHeight = defualtPane.getSize().height;
			}

			setTitle(newLang);

			JButton newClient = new JButton(clientLang);
			newClient.setBounds(makeRectangleForNew());
			newClient.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					defualtPane.setVisible(false);
					int ID = guiController.clientCreate();
					showOne(1, ID);
				}
			});
			defualtPane.add(newClient);
			
			JButton newCase = new JButton(caseLang);
			newCase.setBounds(makeRectangleForNew());
			newCase.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					defualtPane.setVisible(false);
					int ID = guiController.caseCreate();
					showOne(3, ID);
				}
			});
			defualtPane.add(newCase);

			JButton newWorker = new JButton(workLang);
			newWorker.setBounds(makeRectangleForNew());
			newWorker.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					defualtPane.setVisible(false);
					int ID = guiController.workerCreate();
					showOne(2, ID);
				}
			});
			defualtPane.add(newWorker);

		}

	}

	private JTextField writeFirstName = null;
	private JTextField writeLastName = null;
	private JTextField writeTitleName = null;
	private JTextField writeEmail = null;
	private JTextField writeCaseType = null;
	private JTextField writePhoneNumber = null;

	protected void showOne(int type, int ID) {
		String firstNameS = "";
		String lastNameS = "";
		String titleS = "";
		String phoneS = "";
		String postNrS = "";
		String adressS = "";
		String emailS = "";
		String IDS = "";
		String caseTypeS = "";
		

		if (ID != -1) {
			switch (type) {
			case 1:
				try {
					ResultSet rs = guiController.clientRead(ID);
					if (rs.next()) {
						// ID = rs.getString(1);
						// date of creation = rs.getString(8);
						firstNameS = rs.getString(2);
						lastNameS = rs.getString(3);
						phoneS = rs.getString(4);
						emailS = rs.getString(5);
						adressS = rs.getString(6);
						postNrS = rs.getString(7);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				try{
				ResultSet rs = guiController.workerRead(ID);
				if (rs.next()) {
					firstNameS = rs.getString(2);
					lastNameS = rs.getString(3);
					adressS = rs.getString(6);
					postNrS = rs.getString(7);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				break;
			case 3:
				break;
			default:
				break;
			}
			IDS = "" + ID;
		} else {

		}
		defualtPane.removeAll();
		scrollPane.setVisible(false);
		if (defualtPane.isVisible()) {

			defualtPane.setVisible(false);
			setTitle(menuLang);
			return;
		} else {
			defualtPaneRectangleReset();
			defualtPane.setVisible(true);
			add(defualtPane);
			setVisible(true);

			setTitle(clientLang);

			if (type != 3) {
				JLabel firstName = new JLabel(firstNameLang);
				firstName.setBounds(makeRectangleForShowOne());
				defualtPane.add(firstName);

				writeFirstName = new JTextField(firstNameS);
				writeFirstName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeFirstName);

				JLabel lastName = new JLabel(lastNameLang);
				lastName.setBounds(makeRectangleForShowOne());
				defualtPane.add(lastName);

				writeLastName = new JTextField(lastNameS);
				writeLastName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeLastName);
			} else {
				JLabel titleName = new JLabel(titleLang);
				titleName.setBounds(makeRectangleForShowOne());
				defualtPane.add(titleName);

				writeTitleName = new JTextField(titleS);
				writeTitleName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeTitleName);
			}
			if(type != 2)
			{
			JLabel PhoneNumber = new JLabel(phoneLang);
			PhoneNumber.setBounds(makeRectangleForShowOne());
			defualtPane.add(PhoneNumber);
			
			writePhoneNumber = new JTextField(phoneS);
			writePhoneNumber.setBounds(makeRectangleForShowOne());
			defualtPane.add(writePhoneNumber);
			}

			JLabel postNrLabel = new JLabel(postNrLang);
			postNrLabel.setBounds(makeRectangleForShowOne());
			defualtPane.add(postNrLabel);

			JTextField writePostNr = new JTextField(postNrS);
			writePostNr.setBounds(makeRectangleForShowOne());
			defualtPane.add(writePostNr);

			JLabel Adress = new JLabel(adressLang);
			Adress.setBounds(makeRectangleForShowOne());
			defualtPane.add(Adress);

			JTextField writeAdress = new JTextField(adressS);
			writeAdress.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeAdress);
			
			if(type != 3)
			{
			JLabel Email = new JLabel(emailLang);
			Email.setBounds(makeRectangleForShowOne());
			defualtPane.add(Email);

			writeEmail = new JTextField(emailS);
			writeEmail.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeEmail);
			}
			else
			{
				JLabel caseType = new JLabel(caseTypeLang);
				caseType.setBounds(makeRectangleForShowOne());
				defualtPane.add(caseType);

				writeCaseType = new JTextField(caseTypeS);
				writeCaseType.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeCaseType);
			}

			JLabel IDLabel = new JLabel(IDLang + " : " + IDS);
			IDLabel.setBounds(paneWidth - 120, 10, 100, 20);
			defualtPane.add(IDLabel);

			String timeNow = Timestamp.convert(Timestamp.getTimeNow());
			JLabel time = new JLabel(timeNow);
			time.setBounds(paneWidth - 150, 30, 150, 20);
			defualtPane.add(time);

			JButton confirm = new JButton(confirmLang);
			confirm.setBounds(paneWidth - 120, paneHeight - 40, 100, 20);
			confirm.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int phone = Integer.parseInt(writePhoneNumber.getText());
						short postNr = (short) Integer.parseInt(writePostNr.getText());
						int departmentNr = 2;
						int employeeID = 2;
						int clientID = 2;
						if (type == 1) {
							saveClient(phone, writeFirstName.getText(),
									writeLastName.getText(), postNr,
									writeAdress.getText(),
									writeEmail.getText(), ID);
							
						} else if (type == 2) {
							saveWorker(ID, writeFirstName.getText(), writeAdress.getText(), (short) postNr, phone, writeLastName.getText());
						} else if (type == 3) {
							saveCase(ID, writeTitleName.getText(),
									writeAdress.getText(), (short) postNr, writeCaseType.getText(), (byte) departmentNr,
									employeeID, clientID);
						}
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(null,
								"Phone number is invalid");

						return;
					}
					showMenu();
				}

			});
			defualtPane.add(confirm);
		}
	}

	protected void showMenu() {
		defualtPane.setVisible(false);
		scrollPane.setVisible(false);
	}
	
	protected void saveWorker(int ID, String firstName, String address, short postNr, int phone, String lastName) {
		guiController.workerUpdate(new Employee(ID, firstName, address, postNr, phone, lastName));
	}

	protected void saveClient(int phoneNumber, String firstName,
			String lastName, short postNr, String address, String email, int ID) {
		guiController.updateClient(new Client(ID, firstName, address,
				(short) postNr, phoneNumber, lastName, email));
	}

	protected void saveCase(int ID, String title, String address, short postNr,
			String caseType, byte department, int employeeID, int clientID) {
		guiController.updateCase(new Case(ID, title, address, postNr, caseType,
				department, employeeID, clientID));
	}

	private void defualtPaneRectangleReset() {
		rectangleY = 10;
		rectangleX = 20;
		rectangleW = 100;
		rectangleH = 30;
		rectangleTrue = true;
	}

	private Rectangle makeRectangleForShowOne() {
		Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleW,
				rectangleH);
		if (rectangleTrue) {
			rectangleY += 30;
			rectangleTrue = false;
			if (rectangleY + 60 > paneHeight) {
				rectangleX += 120;
				rectangleY = 10;
				rectangleTrue = true;
			}
		} else {
			rectangleY += 40;
			rectangleTrue = true;
		}
		return r;
	}

	private Rectangle makeRectangleForNew() {
		Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleW,
				rectangleH);
		rectangleY += 30;

		if (rectangleY + 60 > paneHeight) {
			rectangleX += 120;
			rectangleY = 10;
		}
		return r;
	}
	
	//@Ellinor M.
	private void lookNFeel()
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { //ser igennem listen af instaleret look and feel
		        if ("Nimbus".equals(info.getName())) {// er look and feelet Nimbus?
		            UIManager.setLookAndFeel(info.getClassName());// hvis ja, sæt til nimbus
		        }
		    }
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// går noget galt i loopet, sæt look and feel til samme som OS
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
package gui;

import time.Timestamp;

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

	private int rectangleY;
	private int rectangleX;
	private int rectangleW;
	private int rectangleH;
	private boolean rectangleTrue;

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

		addWindowListener(new WindowListener()
		{
			@Override
			public void windowOpened(WindowEvent e)
			{
			}

			@Override
			public void windowIconified(WindowEvent e)
			{
			}

			@Override
			public void windowDeiconified(WindowEvent e)
			{
			}

			@Override
			public void windowDeactivated(WindowEvent e)
			{
			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				closeSystem();
			}

			@Override
			public void windowClosed(WindowEvent e)
			{
			}

			@Override
			public void windowActivated(WindowEvent e)
			{
			}
		});

		defualtPane.setVisible(true);
		add(defualtPane);
		setVisible(true);

		if (paneWidth == 0 || paneHeight == 0)
		{
			paneWidth = defualtPane.getSize().width;
			paneHeight = defualtPane.getSize().height;
			System.out.println(defualtPane.getSize());
		}
		defualtPane.setVisible(false);
	}

	public static DefaultTableModel model = new DefaultTableModel()
	{
		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false;
		}
	};

	protected void closeSystem()
	{
		System.exit(1);
	}

	private void makeMenuButtons()
	{
		JPanel menuButtons = new JPanel();
		menuButtons.setLayout(new GridLayout(1, 3));

		JButton toMainMenu = new JButton(menuLang);
		toMainMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});

		JButton toKunder = new JButton(clientLang);
		toKunder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				showClientList();
			}
		});

		JButton makeNew = new JButton(newLang);
		makeNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
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
			model.setRowCount(0);
			model.setColumnIdentifiers(new Object[]
			{ "ID", "Name", "Durp" });

			 ResultSet rs = guiController.caseReadAll();
			 while(rs.next())
			 {
			 model.addRow(new Object[]
			 { rs.getString(1), rs.getString(2), rs.getString(3) });
			 }
//			for (int i = 0; i < 50; i++)
//			{
//				model.addRow(new Object[]
//				{ i, "C : 2 | R : " + i, "C : 3 | R : " + i });
//			}

			JTable table = new JTable(model);
			table.addMouseListener(new MouseAdapter()
			{
				int lastRow = -1;

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt)
				{
					int row = table.rowAtPoint(evt.getPoint());

					if (lastRow == row)
					{
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

	protected void showNew()
	{
		defualtPane.removeAll();
		scrollPane.setVisible(false);
		if (defualtPane.isVisible() && getTitle().equals(newLang))
		{

			defualtPane.setVisible(false);
			setTitle(menuLang);
			return;
		}
		else
		{
			System.out.println(defualtPane.getComponentCount());
			defualtPane.setVisible(false);
			defualtPane.removeAll();
			defualtPaneRectangleReset();

			defualtPane.setVisible(true);
			add(defualtPane);
			setVisible(true);

			if (paneWidth == 0 || paneHeight == 0)
			{
				paneWidth = defualtPane.getSize().width;
				paneHeight = defualtPane.getSize().height;
			}

			setTitle(newLang);

			JButton newClient = new JButton(clientLang);
			newClient.setBounds(makeRectangleForNew());
			newClient.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					defualtPane.setVisible(false);
					showOne(1, -1);
				}
			});
			defualtPane.add(newClient);

			// makeRectangle();

			JButton newCase = new JButton(caseLang);
			newCase.setBounds(makeRectangleForNew());
			newCase.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					defualtPane.setVisible(false);
					showOne(3, -1);
				}
			});
			defualtPane.add(newCase);

			JButton newWorker = new JButton(workLang);
			newWorker.setBounds(makeRectangleForNew());
			newWorker.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					defualtPane.setVisible(false);
					showOne(2, -1);
				}
			});
			defualtPane.add(newWorker);

		}

	}

	protected void showOne(int type, int ID)
	{
		String firstNameS = "";
		String lastNameS = "";
		String titleS = "";
		String phoneS = "";
		String postNrS = "";
		String adressS = "";
		String emailS = "";
		String IDS = "";

		if (ID != -1)
		{
			IDS = "" + ID;
			switch (type)
			{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
			}
		}
		else
		{
			
		}
		defualtPane.removeAll();
		scrollPane.setVisible(false);
		if (defualtPane.isVisible())
		{

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

			setTitle(clientLang);

			if (type != 3)
			{
				JLabel firstName = new JLabel(firstNameLang);
				firstName.setBounds(makeRectangleForShowOne());
				defualtPane.add(firstName);

				JTextField writeFirstName = new JTextField(firstNameS);
				writeFirstName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeFirstName);

				JLabel lastName = new JLabel(lastNameLang);
				lastName.setBounds(makeRectangleForShowOne());
				defualtPane.add(lastName);

				JTextField writeLastName = new JTextField(lastNameS);
				writeLastName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeLastName);
			}
			else
			{
				JLabel titleName = new JLabel(titleLang);
				titleName.setBounds(makeRectangleForShowOne());
				defualtPane.add(titleName);

				JTextField writeTitleName = new JTextField(titleS);
				writeTitleName.setBounds(makeRectangleForShowOne());
				defualtPane.add(writeTitleName);
			}
			JLabel clientPhoneNumber = new JLabel(phoneLang);
			clientPhoneNumber.setBounds(makeRectangleForShowOne());
			defualtPane.add(clientPhoneNumber);

			JTextField writeClientPhoneNumber = new JTextField(phoneS);
			writeClientPhoneNumber.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeClientPhoneNumber);

			JLabel clientPostNr = new JLabel(postNrLang);
			clientPostNr.setBounds(makeRectangleForShowOne());
			defualtPane.add(clientPostNr);

			JTextField writeClientPostNr = new JTextField(phoneS);
			writeClientPostNr.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeClientPostNr);

			JLabel clientAdress = new JLabel(adressLang);
			clientAdress.setBounds(makeRectangleForShowOne());
			defualtPane.add(clientAdress);

			JTextField writeClientAdress = new JTextField(adressS);
			writeClientAdress.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeClientAdress);

			JLabel clientEmail = new JLabel(emailLang);
			clientEmail.setBounds(makeRectangleForShowOne());
			defualtPane.add(clientEmail);

			JTextField writeClientEmail = new JTextField(emailS);
			writeClientEmail.setBounds(makeRectangleForShowOne());
			defualtPane.add(writeClientEmail);

			JLabel clientID = new JLabel(IDLang + " : " + IDS); // Get ID from
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
			// confirm.addActionListener(actionListener.confirmChange(
			// writeClientFirstName, writeClientPhoneNumber));
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

	private Rectangle makeRectangleForShowOne()
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

	private Rectangle makeRectangleForNew()
	{
		Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleW,
				rectangleH);
		rectangleY += 30;

		if (rectangleY + 60 > paneHeight)
		{
			rectangleX += 120;
			rectangleY = 10;
		}
		return r;
	}
}
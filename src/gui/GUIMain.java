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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIMain extends GUILanguage {

	protected static JPanel menuBar = new JPanel();

	private JScrollPane scrollPane = new JScrollPane();
	private JLayeredPane lp = new JLayeredPane();

	{
		scrollPane.setVisible(false);
		lp.setVisible(false);
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
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 3));

		JButton toMainMenu = new JButton(menu);
		toMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton toKunder = new JButton(client);
		toKunder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showClientList();
			}
		});

		JButton makeNew = new JButton(newSomething);
		makeNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNew();
			}
		});

		buttons.add(toKunder);
		buttons.add(toMainMenu);
		buttons.add(makeNew);
		add(buttons, BorderLayout.SOUTH);
	}

	protected void showClientList() 
	{
		if (scrollPane.isVisible())
		{
			scrollPane.removeAll();
			scrollPane.setVisible(false);
			return;
		} 
		else 
		{
			lp.setVisible(false);
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
		if (lp.isVisible()) {
			lp.setVisible(false);
			return;
		}
		else 
		{
			scrollPane.setVisible(false);
			JButton top = new JButton();
			top.setBackground(Color.green);
			top.setBounds(20, 20, 50, 50);
			lp.add(top, new Integer(1));
			add(lp, BorderLayout.CENTER);
			lp.setVisible(true);
			setVisible(true);
		}
	}
}

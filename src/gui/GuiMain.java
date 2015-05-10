package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTable;

public class GuiMain extends Guilanguage {

	// Har ændret navnet mainFram til mainFrame
	private static JFrame mainFrame = new JFrame();
	private static JTable table = new JTable();

	// Sætter mainframed.
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth()/10*8;
		int height = (int) screenSize.getHeight()/10*8;
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Needs an int, so
															// closeSystem() now
															// returns an int.
		mainFrame.setSize(width, height);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

	public void makeMenuBar() {
		throw new UnsupportedOperationException();
	}

	public void DefaultTableModel() {
		throw new UnsupportedOperationException();
	}

	public void toMainMenu() {
		throw new UnsupportedOperationException();
	}

	public void toGUIKunder() {
		throw new UnsupportedOperationException();
	}

	public int closeSystem() {
		System.out.println("closing!");
		return 3; // Same as the standard mainFrame.EXIT_ON_CLOSE
	}

	public void makeNew() {
		throw new UnsupportedOperationException();
	}
}
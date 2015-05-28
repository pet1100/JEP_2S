package gui;
//@Peter J.

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//The login function (not fully implemented)
public class GUILogin {

	//The login GUI (doesn't do shit.)
	public void login() {
		JTextField userName = new JTextField(5);
		JTextField password = new JTextField(5);
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(2, 2));
		login.add(new JLabel("Username"));
		login.add(userName);
		login.add(new JLabel("password"));
		login.add(password);
		boolean loginTrue;
		do {
		int result = JOptionPane.showConfirmDialog(null, login,
				"Please Enter login info", JOptionPane.OK_CANCEL_OPTION);

		
			if (result == JOptionPane.OK_OPTION && userName.getText().equals("")
					&& password.getText().equals("")) {
				loginTrue = true;
			}
			else if(result == JOptionPane.OK_OPTION)
			{
				loginTrue = false;
			}
			else {
				System.exit(1);
				loginTrue = false;
			}
		} while (!loginTrue);
	}
	
}

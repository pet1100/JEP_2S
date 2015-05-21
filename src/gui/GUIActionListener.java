package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Contains all action listener except for the ones there is in makeMenuButtons in GUIMain
 */

public class GUIActionListener {

	public ActionListener confirmChange(JTextField writeClientFirstName,
			JTextField writeClientPhoneNumber) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				try {
					int clientPhone = Integer.parseInt(writeClientPhoneNumber
							.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Phone number is invalid");
					return;
				}
				System.out.println("No return");

			}
		};
	}

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

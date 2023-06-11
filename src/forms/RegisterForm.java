package forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JTextField password;
	private JTextField reEnterPassword;
	private JTextField username;
	private JLabel notice;

	public RegisterForm() {
		setBackground(Color.BLACK);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(710, 233, 500, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		notice = new JLabel("");
		notice.setVisible(false);
		notice.setIcon(new ImageIcon(RegisterForm.class.getResource("/resources/noticePasswordReEnter.png")));
		notice.setHorizontalAlignment(SwingConstants.RIGHT);
		notice.setBounds(228, 265, 243, 51);
		contentPane.add(notice);

		username = new JTextField();
		username.setOpaque(false);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Montserrat", Font.PLAIN, 13));
		username.setColumns(10);
		username.setBorder(null);
		username.setBounds(242, 361, 216, 27);
		contentPane.add(username);

		password = new JTextField();
		password.setOpaque(false);
		password.setFont(new Font("Montserrat", Font.PLAIN, 13));
		password.setForeground(Color.WHITE);
		password.setBorder(null);
		password.setBounds(242, 415, 216, 27);
		contentPane.add(password);
		password.setColumns(10);

		reEnterPassword = new JTextField();
		reEnterPassword.setOpaque(false);
		reEnterPassword.setBackground(Color.BLACK);
		reEnterPassword.setFont(new Font("Montserrat", Font.PLAIN, 13));
		reEnterPassword.setForeground(Color.WHITE);
		reEnterPassword.setBorder(null);
		reEnterPassword.setColumns(10);
		reEnterPassword.setBounds(242, 466, 216, 27);
		contentPane.add(reEnterPassword);

		JLabel createBtn = new JLabel("");

		createBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveAccountToFile();
				setVisible(false);
				new LoginForm().setVisible(true);
			}
		});

		createBtn.setBounds(356, 544, 114, 40);
		contentPane.add(createBtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegisterForm.class.getResource("/resources/createMaskNew1.png")));
		lblNewLabel.setBounds(0, 0, 500, 612);
		contentPane.add(lblNewLabel);
	}

	private void saveAccountToFile() {
		String usernameText = username.getText();
		String passwordText = password.getText();
		String reEnterPasswordText = reEnterPassword.getText();

		if (usernameText.isEmpty() || passwordText.isEmpty() || reEnterPasswordText.isEmpty()) {
			notice.setVisible(true);
			return;
		}

		if (!passwordText.equals(reEnterPasswordText)) {
			notice.setVisible(true);
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", true))) {
			writer.write(usernameText + ":" + passwordText);
			writer.newLine();
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
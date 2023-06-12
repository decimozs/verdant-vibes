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

		username = createTextField(242, 361, 216, 27);
		password = createTextField(242, 415, 216, 27);
		reEnterPassword = createTextField(242, 466, 216, 27);

		JLabel createBtn = new JLabel("");
		createBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!password.getText().equals(reEnterPassword.getText())) {
					notice.setVisible(true);
				} else {
					saveAccountToFile();
					setVisible(false);
					new LoginForm().setVisible(true);
					notice.setVisible(false);
				}
			}
		});

		createBtn.setBounds(356, 544, 114, 40);
		contentPane.add(createBtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegisterForm.class.getResource("/resources/createMaskNew1.png")));
		lblNewLabel.setBounds(0, 0, 500, 612);
		contentPane.add(lblNewLabel);
	}

	private JTextField createTextField(int x, int y, int width, int height) {
		JTextField textField = new JTextField();
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Montserrat", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(x, y, width, height);
		contentPane.add(textField);
		return textField;
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

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
			writer.write(usernameText + ":" + passwordText);
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

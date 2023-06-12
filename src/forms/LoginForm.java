package forms;

import components.LoadingScreen;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JLabel notice;

	public LoginForm() {
		setBackground(Color.BLACK);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(710, 233, 500, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		notice = new JLabel("");
		notice.setVisible(false);
		notice.setHorizontalAlignment(SwingConstants.RIGHT);
		notice.setIcon(new ImageIcon(LoginForm.class.getResource("/resources/noticeInvalidUsernamePassowrd.png")));
		notice.setBounds(232, 328, 243, 51);
		contentPane.add(notice);
		
		username = new JTextField();
		username.setOpaque(false);
		username.setFont(new Font("Montserrat", Font.PLAIN, 13));
		username.setForeground(Color.WHITE);
		username.setBorder(null);
		username.setBounds(242, 415, 216, 27);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setOpaque(false);
		password.setBackground(Color.BLACK);
		password.setFont(new Font("Montserrat", Font.PLAIN, 13));
		password.setForeground(Color.WHITE);
		password.setBorder(null);
		password.setColumns(10);
		password.setBounds(242, 466, 216, 27);
		contentPane.add(password);
		
		JLabel loginBtn = new JLabel("");
		loginBtn.addMouseListener(new MouseAdapter() {
			private boolean accountFound = true;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(accountFound){
					login();
				}
			}
		});
		loginBtn.setBounds(356, 544, 114, 40);
		contentPane.add(loginBtn);
		
		JLabel createBtn = new JLabel("");
		createBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterForm lf = new RegisterForm();
				lf.setVisible(true);
				setVisible(false);
			}
		});
		createBtn.setBounds(232, 544, 114, 40);
		contentPane.add(createBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/resources/loginMaskNew.png")));
		lblNewLabel.setBounds(0, 0, 500, 612);
		contentPane.add(lblNewLabel);
	
	}
	
	private void login() {
		String enteredUsername = username.getText();
	    char[] enteredPasswordChars = password.getPassword();
	    String enteredPassword = new String(enteredPasswordChars);
	    password.setText("");
		
        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            boolean accountFound = false;

            while ((line = reader.readLine()) != null) {
                String[] account = line.split(":");

                if (account.length == 2 && account[0].equals(enteredUsername) && account[1].equals(enteredPassword)) {
                    accountFound = true;
                    break;
                }
            }

            if (accountFound) {
                new LoadingScreen().setVisible(true);
				setVisible(false);
				System.out.println("Account found!");
            } else {
        		notice.setVisible(true);
				System.out.println("Account not found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
			System.out.println("Theres a problem in the stream (Account is not working)");
        }
    }
}

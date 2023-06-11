package modals;

import java.awt.Rectangle;
import javax.swing.JPanel;
import components.Home;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class purchaseGreetings extends JPanel {

	private Home home;
	
	public purchaseGreetings(Home home) {
		this.home = home;
		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(null);
		setLayout(null);
		setBounds(new Rectangle(0, 0, 504, 252));
		setBounds(0, 0, 504, 252);
		
		JLabel exit = new JLabel("");
		exit.setBackground(Color.BLACK);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.pgs.setVisible(false);
				home.thanksPane.setVisible(false);
				repaint();
		        revalidate();
			}
		});

		exit.setIcon(new ImageIcon(purchaseGreetings.class.getResource("/resources/paymentExit.png")));
		exit.setBounds(454, 20, 30, 28);
		add(exit);
		
		JLabel lblNewLabel_1 = new JLabel("Thank you for your purchase!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 24));
		lblNewLabel_1.setBounds(68, 104, 369, 29);
		add(lblNewLabel_1);
		
		JLabel lblYourOrderOf = new JLabel(" Your order of plant products has been successfully placed.");
		lblYourOrderOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderOf.setForeground(Color.WHITE);
		lblYourOrderOf.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblYourOrderOf.setBounds(56, 131, 393, 16);
		add(lblYourOrderOf);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(purchaseGreetings.class.getResource("/resources/greetingsMask.png")));
		lblNewLabel.setBounds(0, 0, 504, 252);
		add(lblNewLabel);
	}
}

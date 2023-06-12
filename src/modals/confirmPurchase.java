package modals;

import components.Home;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class confirmPurchase extends JPanel {

	private JPanel contentPane;
	private Home home;
	public JLabel recieverName;
	public JLabel modeOfPayment;
	public JLabel streetDetails;
	public JLabel cityCountry;
	public JLabel totalAmount;
	public int testSum;
	public JLabel lblOrderNo;
	public JLabel merchandeFinalSubtotalAmount;
	public JLabel shippingSubtotalAmount;

	public confirmPurchase(Home home) {
		setOpaque(false);
		this.home = home;
		setBackground(Color.BLACK);
		setBorder(null);

		setBounds(new Rectangle(0, 0, 504, 252));
		setBounds(0, 0, 652, 492);
		setLayout(null);

		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					home.cpPane.setVisible(false);
					repaint();
					revalidate();
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});

		exit.setIcon(new ImageIcon(confirmPurchase.class.getResource("/resources/paymentExit.png")));
		exit.setBounds(588, 26, 30, 28);
		add(exit);

		JLabel paymentLabel = new JLabel("Payment");
		paymentLabel.setForeground(Color.WHITE);
		paymentLabel.setFont(new Font("Montserrat", Font.BOLD, 38));
		paymentLabel.setBounds(35, 26, 182, 47);
		add(paymentLabel);

		JLabel lblTransactionDetails = new JLabel("Transaction Details");
		lblTransactionDetails.setForeground(Color.WHITE);
		lblTransactionDetails.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblTransactionDetails.setBounds(35, 94, 182, 16);
		add(lblTransactionDetails);

		long orderNoId = home.auth.orderNumberGenerator();

		lblOrderNo = new JLabel("Order no: " + orderNoId);
		lblOrderNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderNo.setForeground(Color.WHITE);
		lblOrderNo.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblOrderNo.setBounds(265, 94, 353, 16);
		add(lblOrderNo);

		recieverName = new JLabel();
		recieverName.setForeground(Color.WHITE);
		recieverName.setFont(new Font("Montserrat", Font.BOLD, 13));
		recieverName.setBounds(208, 170, 286, 16);
		add(recieverName);

		modeOfPayment = new JLabel("Cash on Delivery");
		modeOfPayment.setForeground(Color.WHITE);
		modeOfPayment.setFont(new Font("Montserrat", Font.BOLD, 13));
		modeOfPayment.setBounds(208, 220, 410, 16);
		add(modeOfPayment);

		streetDetails = new JLabel("");
		streetDetails.setForeground(Color.WHITE);
		streetDetails.setFont(new Font("Montserrat", Font.BOLD, 13));
		streetDetails.setBounds(208, 270, 410, 16);
		add(streetDetails);

		cityCountry = new JLabel("");
		cityCountry.setForeground(Color.WHITE);
		cityCountry.setFont(new Font("Montserrat", Font.BOLD, 13));
		cityCountry.setBounds(208, 289, 410, 16);
		add(cityCountry);

		JLabel lblNewLabel = new JLabel("Receiver:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 170, 114, 16);
		add(lblNewLabel);

		JLabel lblModeOfPayment = new JLabel("Mode of payment:");
		lblModeOfPayment.setForeground(Color.WHITE);
		lblModeOfPayment.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblModeOfPayment.setBounds(35, 220, 119, 16);
		add(lblModeOfPayment);

		JLabel lblDeliveryAddress = new JLabel("Delivery Address:");
		lblDeliveryAddress.setForeground(Color.WHITE);
		lblDeliveryAddress.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lblDeliveryAddress.setBounds(35, 270, 112, 16);
		add(lblDeliveryAddress);

		JLabel lblNewLabel_1 = new JLabel("Total Amount");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(35, 369, 165, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Merchandise Subtotal");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(35, 395, 98, 11);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Shipping Subtotal");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.PLAIN, 9));
		lblNewLabel_1_1_1.setBounds(35, 413, 98, 11);
		add(lblNewLabel_1_1_1);

		totalAmount = new JLabel();
		totalAmount.setForeground(Color.WHITE);
		totalAmount.setFont(new Font("Montserrat", Font.BOLD, 22));
		totalAmount.setBounds(35, 443, 254, 27);
		add(totalAmount);

		JLabel cpBtn = new JLabel("");
		cpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmingPurchase();
			}
		});
		cpBtn.setIcon(new ImageIcon(confirmPurchase.class.getResource("/resources/cpBtn.png")));
		cpBtn.setBounds(328, 419, 325, 73);
		add(cpBtn);

		merchandeFinalSubtotalAmount = new JLabel("₱   0");
		merchandeFinalSubtotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		merchandeFinalSubtotalAmount.setForeground(Color.WHITE);
		merchandeFinalSubtotalAmount.setFont(new Font("Montserrat", Font.BOLD, 9));
		merchandeFinalSubtotalAmount.setBounds(208, 392, 81, 14);
		add(merchandeFinalSubtotalAmount);

		shippingSubtotalAmount = new JLabel("₱   0");
		shippingSubtotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		shippingSubtotalAmount.setForeground(Color.WHITE);
		shippingSubtotalAmount.setFont(new Font("Montserrat", Font.BOLD, 9));
		shippingSubtotalAmount.setBounds(208, 413, 81, 14);
		add(shippingSubtotalAmount);

		JLabel mask = new JLabel("");
		mask.setBackground(Color.BLACK);
		mask.setIcon(new ImageIcon(confirmPurchase.class.getResource("/resources/paymentMaskUpdt.png")));
		mask.setBounds(0, 0, 652, 492);
		add(mask);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	private void confirmingPurchase() {
		try {
			int duration = 2;
			long generateOrderNo = home.auth.orderNumberGenerator();

			lblOrderNo.setText("Order no: " + generateOrderNo);
			home.checkout.shippingSubtotalAmount.setText("₱   0");
			home.checkout.merchandiseSubtotalAmount.setText("₱   0");
			home.checkout.amount.setText("₱   0");
			merchandeFinalSubtotalAmount.setText("₱   0");
			shippingSubtotalAmount.setText("₱   0");
			home.table.getTableModel().setRowCount(0);
			home.shoppingCart.removeAllCartPanes();
			home.cpPane.setVisible(false);
			home.thanksPane.add(home.pgs);
			home.getContentPane().setComponentZOrder(home.thanksPane, 0);
			home.thanksPane.setVisible(true);
			home.pgs.setVisible(true);
			home.shippingNumberSetter.setText("1");
			home.shippingIndicatorMask.setVisible(true);
			home.shipPane.setVisible(true);
			home.noParcelPending.setVisible(false);
			home.cancelShipBtn.setVisible(true);
			home.noticeShippingStatus.setVisible(true);
			home.notified.setVisible(true);

			new Thread(() -> {
				try {
					Thread.sleep(duration * 4000);
				} catch (InterruptedException err) {
					err.printStackTrace();
				}
				home.noticeShippingStatus.setVisible(false);
				home.notified.setVisible(false);

			}).start();

			System.out.println("Confirming purchase successful");
			repaint();
			revalidate();
		} catch (Exception err) {
			err.printStackTrace();
			System.out.println("Failed to confirm the purchase!");
		}
	}
}

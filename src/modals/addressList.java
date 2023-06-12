package modals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import components.Home;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addressList extends JFrame {

	private JPanel contentPane;
	public int numRows = 0;
	private Home home;
	public JPanel panel;
	public JLabel addressItem;
	public String firstname;
	public String initial;
	public String lastname;
	public JPanel createAddress;

	public addressList(Home home) {
		if (home == null) {
			throw new IllegalArgumentException("Home object cannot be null");
		}

		setBackground(Color.BLACK);
		setUndecorated(true);
		this.home = home;

		setUndecorated(true);
		setBounds(1107, 670, 462, 211);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.BLACK);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(26, 17, 50, 15);
		addressLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
		contentPane.add(addressLabel);

		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		exit.setBounds(429, 18, 21, 6);
		exit.setIcon(new ImageIcon(addressList.class.getResource("/resources/rect25.png")));
		contentPane.add(exit);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.BLACK);
		panel.setBounds(26, 43, 410, 168);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(addressList.class.getResource("/resources/addressListMask.png")));
		lblNewLabel.setBounds(0, 0, 462, 211);
		contentPane.add(lblNewLabel);

	}

	public void addAddress() {
		int newRow = home.addressTable.table.getRowCount() - 1;
		JPanel address = createAddress(newRow);
		address.setVisible(true);
		address.setBackground(Color.BLACK);
		address.setOpaque(false);
		panel.add(address);
		numRows++;
		address.setPreferredSize(new Dimension(462, 24 * numRows));
		address.revalidate();
		address.repaint();
		System.out.println("Rows added: " + numRows);
	}

	public JPanel createAddress(int row) {
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 1));
		address.setBounds(0, 37, 462, 45);
		address.setVisible(true);

		JLabel addressItem = new JLabel(home.addressTable.table.getValueAt(row, 0) + " " +
				home.addressTable.table.getValueAt(row, 1) + " " +
				home.addressTable.table.getValueAt(row, 2));
		addressItem.setBounds(26, 11, 145, 23);
		addressItem.setForeground(Color.BLACK);
		addressItem.setFont(new Font("Montserrat", Font.BOLD, 15));
		address.add(addressItem);

		address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					home.checkout.firstname.setText(home.addressTable.table.getValueAt(row, 0).toString());
					home.checkout.lastname.setText(home.addressTable.table.getValueAt(row, 1).toString());
					home.checkout.initial.setText(home.addressTable.table.getValueAt(row, 2).toString());
					home.checkout.addressChoice.setText("" + home.addressTable.table.getValueAt(row, 3) + " "
							+ home.addressTable.table.getValueAt(row, 4) + " "
							+ home.addressTable.table.getValueAt(row, 5));
					home.cps.streetDetails.setText("" + home.addressTable.table.getValueAt(row, 3));
					home.cps.cityCountry.setText(home.addressTable.table.getValueAt(row, 4) + " "
							+ home.addressTable.table.getValueAt(row, 5));
					System.out.println("Retrieved Data");
					System.out.println("Name: " + home.addressTable.table.getValueAt(row, 0) + " "
							+ home.addressTable.table.getValueAt(row, 1) + " "
							+ home.addressTable.table.getValueAt(row, 2));
					setVisible(false);
				} catch (Exception err) {
					err.printStackTrace();
					System.out.println("Failed to retrieve data address");
				}
			}
		});
		return address;
	}
}

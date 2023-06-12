package components;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Point;

public class Cart extends JPanel {

	private JLabel checkoutBtn;
	private JLabel bg;
	public JLabel cartNamePane;
	private Home home;
	public int numRows = 0;
	public JPanel mainPanel;
	public JButton addRowButton;
	public JButton removeButton;
	private int rowGap = 10;
	public List<JPanel> cartPanes = new ArrayList<>();
	private JLabel notice;
	private JScrollPane scrollPane;
	private JLabel plantNameLabel;
	private JLabel plantQuantity;
	private JLabel plantPrice;
	private JLabel plantImage;

	public Cart(Home home) {
		if (home == null) {
			throw new IllegalArgumentException("Home object cannot be null");
		}	

		this.home = home;

		setBounds(new Rectangle(0, 0, 517, 759));
		setPreferredSize(new Dimension(517, 759));
		setMinimumSize(new Dimension(517, 759));
		setMaximumSize(new Dimension(517, 759));
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);

		notice = new JLabel("");
		notice.setVisible(false);

		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setBounds(60, 119, 397, 544);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, rowGap));

		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);

		scrollPane.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Point viewPosition = scrollPane.getViewport().getViewPosition();
				viewPosition.y += e.getUnitsToScroll() * e.getScrollAmount();

				int minY = 0;
				if (viewPosition.y < minY) {
					viewPosition.y = minY;
				}

				scrollPane.getViewport().setViewPosition(viewPosition);
			}
		});

		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(60, 119, 397, 544);
		scrollPane.setBorder(null);
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setOpaque(false);
		verticalScrollBar.setBorder(null);
		verticalScrollBar.setUnitIncrement(20);
		verticalScrollBar.setBlockIncrement(100);
		add(scrollPane);

		notice.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartNotice.png")));
		notice.setBounds(272, 76, 185, 32);
		add(notice);

		cartNamePane = new JLabel("Cart");
		cartNamePane.setForeground(Color.WHITE);
		cartNamePane.setFont(new Font("Montserrat", Font.BOLD, 49));
		cartNamePane.setBounds(33, 19, 345, 60);
		add(cartNamePane);

		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					notice.setVisible(false);
					home.cartPane.setVisible(false);
					home.shoppingCart.setVisible(false);
					repaint();
					revalidate();
				} catch (Exception err) {
					err.printStackTrace();
					System.out.println("Failed to exit");
				}
			}
		});

		exit.setIcon(new ImageIcon(Cart.class.getResource("/resources/exit.png")));
		exit.setBounds(457, 19, 39, 36);
		add(exit);

		checkoutBtn = new JLabel("");
		checkoutBtn.setIcon(new ImageIcon(Cart.class.getResource("/resources/checkoutbtn.png")));
		checkoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (home.table.getTableModel().getRowCount() == 0) {
					emptyCart();
				} else {
					showCheckoutPane();
				}
			}
		});
		checkoutBtn.setBounds(285, 693, 233, 66);
		add(checkoutBtn);

		bg = new JLabel("");
		bg.setIcon(new ImageIcon(Cart.class.getResource("/resources/maskPaneBg.png")));
		bg.setBounds(0, 0, 517, 759);
		add(bg);
	}

	public void addCartPane(String plantName, String quantity, String retailPrice) {
		JPanel cartPane = createCartPane(plantName, quantity, retailPrice);
		cartPanes.add(cartPane);
		cartPane.setVisible(true);
		mainPanel.add(cartPane);
		numRows++;
		mainPanel.setPreferredSize(new Dimension(397, 107 * numRows));
		mainPanel.revalidate();
		mainPanel.repaint();
		home.checkout.updateTestSum();
		shippingFee();
		System.out.println("Rows added: " + numRows);
	}

	private void removeCartPane(JPanel mainPanel, JPanel cartPaneToRemove) {
		cartPanes.remove(cartPaneToRemove);
		mainPanel.remove(cartPaneToRemove);
		home.checkout.updateTestSum();
		home.pdc.cartCountNumber--;
		home.cartNumberSetter.setText(Integer.toString(home.pdc.cartCountNumber));
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	public JPanel createCartPane(String plantName, String quantity, String retailPrice) {
		JPanel cartPane = new JPanel();
		cartPane.setVisible(true);
		cartPane.setLayout(null);
		cartPane.setOpaque(false);
		cartPane.setBackground(Color.BLACK);
		cartPane.setPreferredSize(new Dimension(397, 107));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartCardMask (1).png")));
		lblNewLabel_1.setBounds(0, 0, 397, 107);
		cartPane.add(lblNewLabel_1);

		plantNameLabel = new JLabel(plantName);
		plantNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		plantNameLabel.setForeground(Color.WHITE);
		plantNameLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
		plantNameLabel.setBounds(215, 12, 159, 18);
		cartPane.add(plantNameLabel);

		plantQuantity = new JLabel("x" + quantity);
		plantQuantity.setForeground(new Color(255, 255, 255));
		plantQuantity.setFont(new Font("Montserrat", Font.BOLD, 12));
		plantQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		plantQuantity.setBounds(98, 74, 20, 14);
		cartPane.add(plantQuantity);

		plantPrice = new JLabel(retailPrice);
		plantPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		plantPrice.setForeground(Color.WHITE);
		plantPrice.setFont(new Font("Montserrat", Font.BOLD, 22));
		plantPrice.setBounds(148, 49, 225, 27);
		cartPane.add(plantPrice);

		plantImage = new JLabel("");
		plantImage.setBounds(23, 12, 69, 77);

		if (home.pdc.extractPlantName == "Hydrangea") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/hydrangeaCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Sage") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/sageCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Rosemary") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/rosemaryCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Pine") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/pineCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Conifers") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/conifersCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Wisteria") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/wisteriaCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Star Jasmine") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/starjasmineCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Devil's ivy") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/devilsivtCartIcon.png")));
		} else if (home.pdc.extractPlantName == "English ivy") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/englishivyCartIcon.png")));
		} else if (home.pdc.extractPlantName == "Forsythia") {
			plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/forsythiaCartIcon.png")));
		} else {
			System.out.println("Plant image invalid!");
		}

		cartPane.add(plantImage);

		JButton removeButton = new JButton("");
		removeButton.setBounds(311, 78, 63, 15);
		removeButton.setOpaque(false);
		removeButton.setBackground(Color.BLACK);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JButton sourceButton = (JButton) e.getSource();
					JPanel cartPaneToRemove = (JPanel) sourceButton.getParent();
					int rowIndex = mainPanel.getComponentZOrder(cartPaneToRemove);
					String plantName = extractPlantNameFromCartPane(cartPaneToRemove);
					home.pdc.model.removeRow(rowIndex);
					removeCartPane(mainPanel, cartPaneToRemove);
					System.out.println("A cart has been removed: " + plantName);
					System.out.println("The total sum now is: " + home.table.calculateTotalSum());
				} catch (Exception err) {
					err.printStackTrace();
					System.out.println("Failed to remove a cart");
				}
			}
		});
		cartPane.add(removeButton);

		return cartPane;
	}

	private String extractPlantNameFromCartPane(JPanel cartPane) {
		Component[] components = cartPane.getComponents();
		if (components.length >= 1 && components[1] instanceof JLabel) {
			JLabel plantNameLabel = (JLabel) components[1];
			return plantNameLabel.getText();
		}
		return null;
	}

	public void removeAllCartPanes() {
		for (JPanel cartPane : cartPanes) {
			mainPanel.remove(cartPane);
		}
		cartPanes.clear();
		numRows = 0;
		mainPanel.setPreferredSize(new Dimension(397, 107));
		mainPanel.revalidate();
		mainPanel.repaint();
		home.pdc.cartCountNumber = 0; 
		home.cartNumberSetter.setText("0");
		System.out.println("All items have been removed from the cart");
	}

	public int shippingFee() {
		if (cartPanes.size() > 0) {
			home.checkout.shippingSubtotalAmount.setText("₱   100");
			home.cps.shippingSubtotalAmount.setText("₱   100");
			return 100;
		}
		return 0;
	}

	private void emptyCart() {
		System.out.println("Your cart is empty. Cannot proceed to checkout.");
		notice.setVisible(true);
	}

	private void showCheckoutPane() {
		notice.setVisible(false);
		home.paymentPane.add(home.checkout);
		home.getContentPane().setComponentZOrder(home.paymentPane, 0);
		home.cartPane.setVisible(false);
		home.paymentPane.setVisible(true);
		home.checkout.setVisible(true);
		System.out.println("Total price is :" + home.table.calculateTotalSum());
		repaint();
		revalidate();
	}
}

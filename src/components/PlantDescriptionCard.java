package components;

import java.net.URL;

import java.awt.EventQueue;

import components.Home;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import backend.Table;

public class PlantDescriptionCard extends JPanel {

	public JLabel exit;
	public JLabel bg;
	public JLabel retailPrice;
	public JLabel priceLabel;
	public JLabel plantDescription;
	public JLabel plantIcon;
	public JLabel familyName;
	public JLabel categoryName;
	public JLabel plantName;
	private Home home;
	private JLabel buyBtn;
	public JButton addToCartBtn;
	private JLabel lblNewLabel;
	private JLabel incrementBtn;
	private JLabel decrementBtn;
	private JLabel quantityNumber;
	private int count = 0;
	private int updatedNumber = 0;
	public int cartCountNumber = 0;
	private int cartUpdatedCount = 0;
	private Table table = new Table();
	private int numRows = 0;
	private Cart cart;
	public double extractPrice;
	public String extractRetailPrice;
	public String extractPlantName;
	public String extractQuantityNumber;
	public ImageIcon extractPlantIcon;
	public int extractQuantity;
	
	public PlantDescriptionCard(Home home) {
		this.home = home;
		cart = new Cart(home);
		
		new JPanel();
		setBounds(new Rectangle(0, 0, 517, 759));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.plantDescriptionPane.setVisible(false);
				System.out.println("Close na bai");
			}

		});
		
		addToCartBtn = new JButton();
		addToCartBtn.setOpaque(false);
		addToCartBtn.setBackground(new Color(0, 0, 0));
		addToCartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				extractPlantName = plantName.getText();
				extractRetailPrice = retailPrice.getText();
		        String numericPrice = extractRetailPrice.replaceAll("[^0-9.]", "");
		        extractPrice = Double.parseDouble(numericPrice);
		        String extractFamilyName = familyName.getText();
		        String extractCategoryName = categoryName.getText();
		        ImageIcon extractPlantIcon = (ImageIcon) plantIcon.getIcon();
		        ImageIcon extractPlantDescription = (ImageIcon) plantDescription.getIcon();
		        extractQuantityNumber = quantityNumber.getText();
		        extractQuantity = Integer.parseInt(extractQuantityNumber);
		        
		        int price = (int) (extractQuantity * extractPrice);
		        
		        DefaultTableModel model = (DefaultTableModel) table.getTableModel();
		        model.addRow(new Object[]{extractPlantIcon, extractPlantName, extractPrice, extractQuantity, price});

		        count = 0;
		        updatedNumber = 0;
		        extractQuantity = 0;
		        quantityNumber.setText("0");
		        
		        cartCountNumber++;
		        home.cartNumberSetter.setText(Integer.toString(cartCountNumber));
		        
		        home.shoppingCart.addCartPane();
		        
		        System.out.println(extractPlantIcon);
		        System.out.println(extractPlantName);
			}
		});
		
		incrementBtn = new JLabel("");
		incrementBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				updatedNumber = count;
				quantityNumber.setText(Integer.toString(updatedNumber));
			}
		});
		
		
		incrementBtn.setBounds(104, 644, 32, 26);
		add(incrementBtn);
		
		decrementBtn = new JLabel("");
		decrementBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (updatedNumber > 0) {
		            updatedNumber--;
		            quantityNumber.setText(Integer.toString(updatedNumber));
		        }
			}
		});
		decrementBtn.setBounds(24, 644, 28, 26);
		add(decrementBtn);
		
		quantityNumber = new JLabel("0");
		quantityNumber.setForeground(Color.WHITE);
		quantityNumber.setFont(new Font("Montserrat", Font.BOLD, 14));
		quantityNumber.setHorizontalAlignment(SwingConstants.CENTER);
		quantityNumber.setBounds(24, 643, 112, 27);
		add(quantityNumber);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource("/resources/quantityItem (1).png")));
		lblNewLabel.setBounds(23, 643, 113, 27);
		add(lblNewLabel);
		
		addToCartBtn.setBounds(226, 686, 177, 73);
		add(addToCartBtn);
		
		buyBtn = new JLabel("");
		buyBtn.setBounds(403, 686, 114, 73);
		add(buyBtn);
		
		exit.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource("/resources/exit.png")));
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setBounds(457, 19, 39, 36);
		add(exit);
		
		retailPrice = new JLabel("");
		retailPrice.setHorizontalAlignment(SwingConstants.LEFT);
		retailPrice.setForeground(Color.WHITE);
		retailPrice.setFont(new Font("Montserrat", Font.BOLD, 22));
		retailPrice.setBounds(24, 709, 192, 27);
		add(retailPrice);
		
		priceLabel = new JLabel("Price");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
		priceLabel.setBounds(23, 690, 90, 14);
		add(priceLabel);
		
		plantDescription = new JLabel("");
		plantDescription.setHorizontalAlignment(SwingConstants.CENTER);
		plantDescription.setForeground(Color.WHITE);
		plantDescription.setFont(new Font("Montserrat", Font.PLAIN, 15));
		plantDescription.setBounds(53, 503, 411, 129);
		add(plantDescription);
		
		plantIcon = new JLabel("");
		plantIcon.setHorizontalAlignment(SwingConstants.CENTER);
		plantIcon.setForeground(Color.WHITE);
		plantIcon.setFont(new Font("Montserrat", Font.BOLD, 50));
		plantIcon.setBounds(120, 161, 283, 317);
		add(plantIcon);
		
		familyName = new JLabel("");
		familyName.setFont(new Font("Montserrat", Font.BOLD, 14));
		familyName.setForeground(Color.WHITE);
		familyName.setHorizontalAlignment(SwingConstants.LEFT);
		familyName.setBounds(24, 42, 412, 17);
		add(familyName);
		
		categoryName = new JLabel("");
		categoryName.setFont(new Font("Montserrat", Font.BOLD, 14));
		categoryName.setForeground(Color.WHITE);
		categoryName.setHorizontalAlignment(SwingConstants.LEFT);
		categoryName.setBounds(24, 20, 412, 17);
		add(categoryName);
		
		plantName = new JLabel("");
		plantName.setHorizontalAlignment(SwingConstants.CENTER);
		plantName.setForeground(Color.WHITE);
		plantName.setFont(new Font("Montserrat", Font.BOLD, 50));
		plantName.setBounds(0, 90, 517, 60);
		add(plantName);
		
		bg = new JLabel("");
		bg.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource("/resources/plantDescriptionMask.png")));
		bg.setBounds(0, 0, 518, 759);
		add(bg);
	}
	
	
}
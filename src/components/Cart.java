package components;

import javax.swing.JPanel;
import constants.Plant;
import java.awt.event.ActionListener;
import components.PlantDescriptionCard;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;

import javax.swing.BoxLayout;
import java.awt.Component;
import backend.Table;
import components.PlantDescriptionCard;

public class Cart extends JPanel {
	
	private JLabel checkoutBtn;
	private JLabel bg;
	public JLabel cartNamePane;
	private Home home;
	private JLabel quantity;
	private JLabel cancel;
	private JLabel plantIcon;
	public int numRows = 0;
	public Table table = new Table();
	private JLabel lblNewLabel_1;
	private JLabel plantQuantity;
	private JLabel plantPrice;
	private JLabel plantImage;
	public JPanel mainPanel;
	public JButton addRowButton;
	private JButton removeButton;
	private int rowGap = 10;
	private PlantDescriptionCard pdc;
	
	public Cart(Home home) {
		this.home = home;
		
		new JPanel();
		setBounds(new Rectangle(0, 0, 517, 759));
		setPreferredSize(new Dimension(517, 759));
		setMinimumSize(new Dimension(517, 759));
		setMaximumSize(new Dimension(517, 759));
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setBounds(60, 119, 397, 544);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, rowGap));
		add(mainPanel);
		
		cartNamePane = new JLabel("Cart");
		cartNamePane.setForeground(Color.WHITE);
		cartNamePane.setFont(new Font("Montserrat", Font.BOLD, 49));
		cartNamePane.setBounds(33, 19, 345, 60);
		add(cartNamePane);
		
		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.cartPane.setVisible(false);
			}
		});
		
		exit.setIcon(new ImageIcon(Cart.class.getResource("/resources/exit.png")));
		exit.setBounds(457, 19, 39, 36);
		add(exit);
		
		checkoutBtn = new JLabel("");
		checkoutBtn.setBounds(284, 688, 233, 71);
		add(checkoutBtn);
		
		bg = new JLabel("");
		bg.setIcon(new ImageIcon(Cart.class.getResource("/resources/CartCard.png")));
		bg.setBounds(0, 0, 517, 759);
		add(bg);
	}
	
	public void addCartPane() {
		JPanel cartPane = createCartPane();
        cartPane.setVisible(true);
        mainPanel.add(cartPane);
        numRows++;
        mainPanel.setPreferredSize(new Dimension(397, 107 * numRows));
        mainPanel.revalidate();
        mainPanel.repaint();
        
        System.out.println("Rows added: " + numRows);
    }
	
	private void removeCartPane(JPanel mainPanel, JPanel cartPaneToRemove) {
		mainPanel.remove(cartPaneToRemove);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	public JPanel createCartPane() {
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
        
        JLabel plantName = new JLabel(home.pdc.extractPlantName);
        plantName.setHorizontalAlignment(SwingConstants.RIGHT);
        plantName.setForeground(Color.WHITE);
        plantName.setFont(new Font("Montserrat", Font.BOLD, 14));
        plantName.setBounds(215, 12, 159, 18);
        cartPane.add(plantName);

        JLabel plantQuantity = new JLabel("Quantity: x" + home.pdc.extractQuantityNumber);
        plantQuantity.setForeground(new Color(255, 255, 255));
        plantQuantity.setFont(new Font("Montserrat", Font.PLAIN, 9));
        plantQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
        plantQuantity.setBounds(148, 30, 225, 14);
        cartPane.add(plantQuantity);

        JLabel plantPrice = new JLabel(home.pdc.extractRetailPrice);
        plantPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        plantPrice.setForeground(Color.WHITE);
        plantPrice.setFont(new Font("Montserrat", Font.BOLD, 22));
        plantPrice.setBounds(148, 49, 225, 27);
        cartPane.add(plantPrice);

        JLabel plantImage = new JLabel("");
        plantImage.setBounds(23, 12, 69, 77); 
    	
        if(home.pdc.extractPlantName == "Hydrangea") {
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/hydrangeaCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Sage"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/sageCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Rosemary"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/rosemaryCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Pine"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/pineCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Conifers"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/conifersCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Wisteria"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/wisteriaCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Star Jasmine"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/starjasmineCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Devil's ivy"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/devilsivtCartIcon.png")));
        }else if(home.pdc.extractPlantName == "English ivy"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/englishivyCartIcon.png")));
        }else if(home.pdc.extractPlantName == "Forsythia"){
        	plantImage.setIcon(new ImageIcon(Cart.class.getResource("/resources/cartIcon/forsythiaCartIcon.png")));
        }else {
        	System.out.println("Plant image invalid!");
        }
        
        cartPane.add(plantImage);
        
        JButton removeButton = new JButton("");
        removeButton.setBounds(311, 78, 63, 15);
        removeButton.setOpaque(false);
        removeButton.setBackground(Color.BLACK);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCartPane(cartPane);
            }
        });
        cartPane.add(removeButton);

        return cartPane;
    }
	
	private void removeCartPane(JPanel cartPane) {
        mainPanel.remove(cartPane);
        numRows--;
        mainPanel.setPreferredSize(new Dimension(397 * numRows, 107));
        mainPanel.revalidate();
        mainPanel.repaint();
        home.pdc.cartCountNumber--;
        home.cartNumberSetter.setText(Integer.toString(home.pdc.cartCountNumber));
        System.out.println("Row removed: " + numRows);
    }
}
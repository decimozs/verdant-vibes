package modals;

import components.Home;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addAddress extends JFrame {

	private Home home;
	private JPanel contentPane;
	public JTextField firstname;
	public JTextField lastname;
	public JTextField initial;
	public JTextField streetnumber;
	public JTextField city;
	public JTextField postalcode;
	public JTextField country;
	public JTextField streetaddress;
	public String setFirstName = "";
	public String setLastName = "";
	public String setInitial = "";
	public String setStreetNumber = "";
	public String setStreetAddress = "";
	public String setCity = "";
	public String setCountry = "";
	public String setPostalCode = "";
	public JLabel addBtn;
	public String extractedfName;
	public String updateFname;
	public String updateInit;
	public String updateLname;
	public String updateStreetAddress;
	public String updateCity;
	public String updateCountry;
	public DefaultTableModel model;
	public JLabel notice;
	
	public addAddress(Home home) {
		this.home = home;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(702, 238, 517, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		country = new JTextField();
		
		country.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setCountry = home.auth.capitalizeFirstLetter(country.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setCountry = home.auth.capitalizeFirstLetter(country.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setCountry = home.auth.capitalizeFirstLetter(country.getText());
        		updateAddBtnText();
            }
        });
		
		notice = new JLabel("");
		notice.setVisible(false);
		notice.setIcon(new ImageIcon(addAddress.class.getResource("/resources/noticeFillForms.png")));
		notice.setBounds(277, 80, 218, 32);
		contentPane.add(notice);
		
		country.setForeground(Color.WHITE);
		country.setFont(new Font("Montserrat", Font.PLAIN, 18));
		country.setBorder(null);
		country.setOpaque(false);
		country.setBackground(Color.BLACK);
		country.setColumns(10);
		country.setBounds(313, 385, 167, 44);
		contentPane.add(country);
		
		streetnumber = new JTextField();
		
		streetnumber.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setStreetNumber = home.auth.capitalizeFirstLetter(streetnumber.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setStreetNumber = home.auth.capitalizeFirstLetter(streetnumber.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setStreetNumber = home.auth.capitalizeFirstLetter(streetnumber.getText());
        		updateAddBtnText();
            }
        });
		
		streetnumber.setForeground(Color.WHITE);
		streetnumber.setFont(new Font("Montserrat", Font.PLAIN, 18));
		streetnumber.setBorder(null);
		streetnumber.setOpaque(false);
		streetnumber.setBackground(Color.BLACK);
		streetnumber.setColumns(10);
		streetnumber.setBounds(50, 312, 65, 44);
		contentPane.add(streetnumber);
		
		city = new JTextField();
		
		city.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setCity = home.auth.capitalizeFirstLetter(city.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setCity = home.auth.capitalizeFirstLetter(city.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setCity = home.auth.capitalizeFirstLetter(city.getText());
        		updateAddBtnText();
            }
        });
		
		city.setForeground(Color.WHITE);
		city.setFont(new Font("Montserrat", Font.PLAIN, 18));
		city.setBorder(null);
		city.setOpaque(false);
		city.setBackground(Color.BLACK);
		city.setColumns(10);
		city.setBounds(50, 385, 198, 44);
		contentPane.add(city);
		
		lastname = new JTextField();
		
		lastname.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setLastName = home.auth.capitalizeFirstLetter(lastname.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setLastName = home.auth.capitalizeFirstLetter(lastname.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setLastName = home.auth.capitalizeFirstLetter(lastname.getText());
        		updateAddBtnText();
            }
        });
		
		lastname.setForeground(Color.WHITE);
		lastname.setFont(new Font("Montserrat", Font.PLAIN, 18));
		lastname.setBorder(null);
		lastname.setOpaque(false);
		lastname.setBackground(Color.BLACK);
		lastname.setColumns(10);
		lastname.setBounds(50, 195, 250, 44);
		contentPane.add(lastname);
		
		firstname = new JTextField();
		
		firstname.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setFirstName = home.auth.capitalizeFirstLetter(firstname.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setFirstName = home.auth.capitalizeFirstLetter(firstname.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setFirstName = home.auth.capitalizeFirstLetter(firstname.getText());
        		updateAddBtnText();
            }
        });
		
		firstname.setForeground(Color.WHITE);
		firstname.setFont(new Font("Montserrat", Font.PLAIN, 18));
		firstname.setBorder(null);
		firstname.setOpaque(false);
		firstname.setBackground(Color.BLACK);
		firstname.setBounds(50, 121, 413, 44);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		initial = new JTextField();
		
		initial.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setInitial = home.auth.capitalizeFirstLetter(initial.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setInitial = home.auth.capitalizeFirstLetter(initial.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setInitial = home.auth.capitalizeFirstLetter(initial.getText());
        		updateAddBtnText();
            }
        });
		
		initial.setForeground(Color.WHITE);
		initial.setFont(new Font("Montserrat", Font.PLAIN, 18));
		initial.setBorder(null);
		initial.setOpaque(false);
		initial.setBackground(Color.BLACK);
		initial.setColumns(10);
		initial.setBounds(377, 195, 98, 44);
		contentPane.add(initial);
		
		postalcode = new JTextField();
		
		postalcode.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setPostalCode = home.auth.capitalizeFirstLetter(postalcode.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setPostalCode = home.auth.capitalizeFirstLetter(postalcode.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setPostalCode = home.auth.capitalizeFirstLetter(postalcode.getText());
        		updateAddBtnText();
            }
        });
		
		postalcode.setForeground(Color.WHITE);
		postalcode.setFont(new Font("Montserrat", Font.PLAIN, 18));
		postalcode.setBorder(null);
		postalcode.setOpaque(false);
		postalcode.setBackground(Color.BLACK);
		postalcode.setColumns(10);
		postalcode.setBounds(46, 458, 65, 44);
		contentPane.add(postalcode);
		
		streetaddress = new JTextField();
		
		streetaddress.getDocument().addDocumentListener(new DocumentListener() {
        	@Override
            public void insertUpdate(DocumentEvent e) {
        		setStreetAddress = home.auth.capitalizeFirstLetter(streetaddress.getText());
        		updateAddBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	setStreetAddress = home.auth.capitalizeFirstLetter(streetaddress.getText());
            	updateAddBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	setStreetAddress = home.auth.capitalizeFirstLetter(streetaddress.getText());
        		updateAddBtnText();
            }
        });
		
		streetaddress.setForeground(Color.WHITE);
		streetaddress.setFont(new Font("Montserrat", Font.PLAIN, 18));
		streetaddress.setBorder(null);
		streetaddress.setOpaque(false);
		streetaddress.setBackground(Color.BLACK);
		streetaddress.setColumns(10);
		streetaddress.setBounds(179, 312, 298, 44);
		contentPane.add(streetaddress);
		
		JLabel initialLabel = new JLabel("Initial (Optional)");
		initialLabel.setForeground(Color.WHITE);
		initialLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		initialLabel.setBounds(354, 172, 108, 14);
		contentPane.add(initialLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lastNameLabel.setBounds(28, 172, 108, 14);
		contentPane.add(lastNameLabel);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setForeground(Color.WHITE);
		firstNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		firstNameLabel.setBounds(28, 99, 108, 14);
		contentPane.add(firstNameLabel);
		
		JLabel firstNameMask = new JLabel("");
		firstNameMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/firstNameMask.png")));
		firstNameMask.setBounds(28, 121, 464, 44);
		contentPane.add(firstNameMask);
		
		JLabel initialMask = new JLabel("");
		initialMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/initialMask.png")));
		initialMask.setBounds(353, 195, 142, 44);
		contentPane.add(initialMask);
		
		JLabel lastNameMask = new JLabel("");
		lastNameMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/lastNameMask.png")));
		lastNameMask.setBounds(28, 195, 289, 44);
		contentPane.add(lastNameMask);
		
		JLabel streetNumberMask = new JLabel("");
		streetNumberMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/streetNumberMask.png")));
		streetNumberMask.setBounds(28, 312, 98, 44);
		contentPane.add(streetNumberMask);
		
		JLabel cityMask = new JLabel("");
		cityMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/cityMask.png")));
		cityMask.setBounds(28, 385, 237, 44);
		contentPane.add(cityMask);
		
		JLabel countryMask = new JLabel("");
		countryMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/countryMask.png")));
		countryMask.setBounds(297, 385, 198, 44);
		contentPane.add(countryMask);
		
		JLabel streetAddressMask = new JLabel("");
		streetAddressMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/streetAddressMask.png")));
		streetAddressMask.setBounds(159, 312, 336, 44);
		contentPane.add(streetAddressMask);
		
		JLabel postalCodeMask = new JLabel("");
		postalCodeMask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/postalCodeMask.png")));
		postalCodeMask.setBounds(28, 458, 98, 44);
		contentPane.add(postalCodeMask);
		
		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		exit.setIcon(new ImageIcon(addAddress.class.getResource("/resources/exit.png")));
		exit.setBounds(457, 19, 38, 36);
		contentPane.add(exit);
		
		JLabel addAddressLabel = new JLabel("Add address");
		addAddressLabel.setForeground(Color.WHITE);
		addAddressLabel.setFont(new Font("Montserrat", Font.BOLD, 49));
		addAddressLabel.setBounds(28, 19, 323, 60);
		contentPane.add(addAddressLabel);
		
		JLabel deliveryAddressLabel = new JLabel("Delivery Address");
		deliveryAddressLabel.setForeground(Color.WHITE);
		deliveryAddressLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
		deliveryAddressLabel.setBounds(28, 268, 137, 16);
		contentPane.add(deliveryAddressLabel);
		
		JLabel streetNumberLabel = new JLabel("Street Number");
		streetNumberLabel.setForeground(Color.WHITE);
		streetNumberLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		streetNumberLabel.setBounds(28, 290, 108, 14);
		contentPane.add(streetNumberLabel);
		
		JLabel streetAddress = new JLabel("Street Address");
		streetAddress.setForeground(Color.WHITE);
		streetAddress.setFont(new Font("Montserrat", Font.PLAIN, 13));
		streetAddress.setBounds(159, 290, 201, 14);
		contentPane.add(streetAddress);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setForeground(Color.WHITE);
		cityLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		cityLabel.setBounds(28, 363, 46, 14);
		contentPane.add(cityLabel);
		
		JLabel countryLabel = new JLabel("Country");
		countryLabel.setForeground(Color.WHITE);
		countryLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		countryLabel.setBounds(297, 363, 167, 14);
		contentPane.add(countryLabel);
		
		JLabel postalCodeLabel = new JLabel("Postal Code (Optional)");
		postalCodeLabel.setForeground(Color.WHITE);
		postalCodeLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
		postalCodeLabel.setBounds(28, 436, 237, 14);
		contentPane.add(postalCodeLabel);
		
		addBtn = new JLabel("");
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newAddressAdded();
			}
		});
		
		addBtn.setIcon(new ImageIcon(addAddress.class.getResource("/resources/addBtn.png")));
		addBtn.setBounds(285, 537, 232, 66);
		contentPane.add(addBtn);
		
		JLabel mask = new JLabel("");
		mask.setIcon(new ImageIcon(addAddress.class.getResource("/resources/maskPaneBg.png")));
		mask.setBounds(0, 0, 517, 603);
		contentPane.add(mask);
	}
	
	private void updateAddBtnText() {
	    addBtn.setText("[New Address Added] - Name: " + setFirstName + " " + setInitial + " " + setLastName + " " + " Address: " + setStreetNumber + " " + setStreetAddress + " " + setCity + " " + setCountry + " " + setPostalCode);
	}
	
	public String addNewAddress() {
		String extractedfname = firstname.getText();
		String initialLetter = initial.getText();
		String extractedlname = lastname.getText();
		
		return extractedfname + " " + initialLetter + " " + extractedlname;
	}

	private void newAddressAdded(){
		System.out.println(addBtn.getText());
			    home.checkout.firstname.setText(setFirstName);
			    home.checkout.lastname.setText(setLastName);
			    home.checkout.initial.setText(setInitial);
			    updateFname = home.auth.capitalizeFirstLetter(firstname.getText());
			    updateInit = home.auth.capitalizeFirstLetter(initial.getText());
			    updateLname = home.auth.capitalizeFirstLetter(lastname.getText());
			    updateStreetAddress = home.auth.capitalizeFirstLetter(streetnumber.getText()) + " " + home.auth.capitalizeFirstLetter(streetaddress.getText());
			    updateCity = home.auth.capitalizeFirstLetter(city.getText());
			    updateCountry = home.auth.capitalizeFirstLetter(country.getText());
			    extractedfName = updateFname + " " + updateInit + " " + updateLname; 
				
			    model = (DefaultTableModel) home.addressTable.getTableModel();
			    model.addRow(new Object[] {
			    		updateFname, 
			    		updateLname, 
			    		updateInit, 
			    		updateStreetAddress, 
			    		updateCity, 
			    		updateCountry
			    		});
			    
			    firstname.setText("");
			    lastname.setText("");
			    initial.setText("");
			    streetnumber.setText("");
			    streetaddress.setText("");
			    city.setText("");
			    country.setText("");
			    postalcode.setText("");
			    notice.setVisible(false);
			    home.address.addAddress();
                setVisible(false);
                repaint();
                revalidate();
	}
}
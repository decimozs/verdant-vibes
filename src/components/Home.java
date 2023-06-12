package components;

import java.awt.Dimension;
import modals.purchaseGreetings;
import modals.confirmPurchase;
import backend.AddressTable;
import modals.addressList;
import modals.addAddress;
import authentication.Authentication;
import backend.Table;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import hooks.Hooks;
import constants.Constants;

public class Home extends JFrame {

	private Constants plant = new Constants();
	public JPanel contentPane;
	public JPanel cpPane;
	private JLabel hamburgerMenu;
	private JLabel background;
	private JLabel cart;
	private JLabel search;
	private JLabel herbs;
	private JLabel shrubs;
	private JLabel creepers;
	private JLabel climbers;
	private JLabel trees;
	public JLabel explore;
	public JLabel discoverMorePlants;
	public JLabel mostLoved;
	public JLabel popular;
	public JPanel mostLovedMenu;
	private JLabel lblNewLabel_1;
	private JLabel mlplants1_1;
	private JLabel mlplants1;
	private JLabel mlplants2;
	private JLabel mlplants3;
	private JLabel mlplants5;
	public JPanel popularMenu;
	private JLabel mlplants5_1;
	private JLabel mlplants2_1;
	private JLabel mlplants1_2;
	private JLabel mlplants1_3;
	private JLabel mlplants2_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblExploreMoreHerb;
	private JLabel h1;
	private JLabel h2;
	public JPanel shrubsMenu;
	private JLabel s2;
	private JLabel s1;
	private JLabel lblExploreMoreHerb_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	public JPanel herbsMenu;
	public JPanel creepersMenu;
	private JLabel creepers2;
	private JLabel creepers1;
	private JLabel lblNewLabel;
	private JLabel lblExploreMoreHerb_2;
	private JLabel lblNewLabel_8;
	private JLabel navigator;
	public JPanel climbersMenu;
	private JLabel c1;
	private JLabel c2;
	private JLabel lblExploreMoreClimber;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	public JPanel treesMenu;
	private JLabel t1;
	private JLabel t2;
	private JLabel lblExploreMoreTree;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField searchItem;
	private JLabel climbersHeartReact2;
	private JLabel shrubsHeartReact1;
	private JLabel shrubsHeartReact2;
	private JLabel climbersHeartReact1;
	private JLabel creepersHeartReact1;
	private JLabel creepersHeartReact2;
	private JLabel treesHeartReact1;
	private JLabel treesHeartReact2;
	private JLabel herbsHeartReact1;
	private JLabel herbsHeartReact2;
	private JLabel lblNewLabel_13;
	public JPanel categoryMenu;
	public AddressTable addressTable;
	public addressList address;
	public Authentication auth;
	public JPanel plantDescriptionPane;
	public PlantDescriptionCard pdc;
	public Payment checkout;
	public Table table;
	public Cart shoppingCart;
	public JPanel paymentPane;
	public JPanel cartPane;
	public JLabel cartNumberSetter;
	public addAddress createAddress;
	public confirmPurchase cps;
	public JPanel thanksPane;
	public purchaseGreetings pgs;
	public JPanel suggestionsMenu;
	public JLabel shipPane;
	private JLabel exit;
	public JLabel back;
	public JLabel shipping;
	public JLabel shippingIndicatorMask;
	public JLabel shippingNumberSetter;
	public JLabel noticeShippingStatus;
	public JLabel noticeCartAdded;
	public JLabel notified;
	private JPanel shippingMenu;
	public JLabel cancelShipBtn;
	public JLabel noParcelPending;
	public Hooks customHooks;

	public Home() {
		customHooks = new Hooks();
		addressTable = new AddressTable(this);
		table = new Table(this);
		pdc = new PlantDescriptionCard(this);
		checkout = new Payment(this);
		shoppingCart = new Cart(this);
		auth = new Authentication(this);
		createAddress = new addAddress(this);
		address = new addressList(this);
		cps = new confirmPurchase(this);
		pgs = new purchaseGreetings(this);

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(325, 160, 1271, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		hamburgerMenu = new JLabel("");
		hamburgerMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleHamburgerMenu();
			}
		});

		searchItem = new JTextField();
		searchItem.setEnabled(false);

		searchItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchItem.setEnabled(true);
				searchItem.requestFocusInWindow();
			}
		});

		searchItem.setDisabledTextColor(new Color(109, 109, 109));
		searchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = searchItem.getText().toLowerCase();
				if (input.equals("shrubs")) {
					searchShrubs();
				} else if (input.equals("herbs")) {
					searchHerbs();
				} else if (input.equals("creepers")) {
					searchCreepers();
				} else if (input.equals("climbers")) {
					searchClimbers();
				} else if (input.equals("trees")) {
					searchTrees();
				} else {
					itemNotFound();
				}
			}
		});

		exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.out.println("System closed!");
			}
		});

		shippingNumberSetter = new JLabel("0");
		shippingNumberSetter.setVisible(true);

		noticeShippingStatus = new JLabel("");
		noticeShippingStatus.setVisible(false);

		shippingMenu = new JPanel();
		shippingMenu.setOpaque(false);
		shippingMenu.setVisible(false);
		shippingMenu.setBackground(Color.BLACK);
		shippingMenu.setBounds(118, 167, 301, 251);
		contentPane.add(shippingMenu);
		shippingMenu.setLayout(null);

		shipPane = new JLabel("");
		shipPane.setVisible(false);

		noParcelPending = new JLabel("New label");
		noParcelPending.setIcon(new ImageIcon(Home.class.getResource("/resources/No pending parcels..png")));
		noParcelPending.setBounds(70, 116, 161, 19);
		shippingMenu.add(noParcelPending);
		shipPane.setIcon(new ImageIcon(Home.class.getResource("/resources/shipPane.png")));
		shipPane.setBounds(21, 60, 260, 58);
		shippingMenu.add(shipPane);

		cancelShipBtn = new JLabel("");
		cancelShipBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelShip();
			}
		});

		cancelShipBtn.setIcon(new ImageIcon(Home.class.getResource("/resources/cancelShipBtn.png")));
		cancelShipBtn.setVisible(false);
		cancelShipBtn.setBounds(176, 125, 105, 31);
		shippingMenu.add(cancelShipBtn);

		JLabel lblNewLabel_14 = new JLabel("Parcel Status");
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("Montserrat", Font.BOLD, 26));
		lblNewLabel_14.setBounds(21, 14, 219, 32);
		shippingMenu.add(lblNewLabel_14);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/resources/shippingMask.png")));
		lblNewLabel_2.setBounds(0, 0, 301, 251);
		shippingMenu.add(lblNewLabel_2);
		noticeShippingStatus.setIcon(new ImageIcon(Home.class.getResource("/resources/noticeShipping.png")));
		noticeShippingStatus.setBounds(559, 23, 162, 44);
		contentPane.add(noticeShippingStatus);

		notified = new JLabel("");
		notified.setVisible(false);
		notified.setIcon(new ImageIcon(Home.class.getResource("/resources/green.png")));
		notified.setBounds(549, 20, 20, 20);
		contentPane.add(notified);

		noticeCartAdded = new JLabel("");
		noticeCartAdded.setVisible(false);
		noticeCartAdded.setIcon(new ImageIcon(Home.class.getResource("/resources/noticeCartAdded.png")));
		noticeCartAdded.setBounds(559, 23, 162, 44);
		contentPane.add(noticeCartAdded);

		shippingNumberSetter.setHorizontalAlignment(SwingConstants.CENTER);
		shippingNumberSetter.setFont(new Font("Montserrat", Font.BOLD, 12));
		shippingNumberSetter.setForeground(Color.WHITE);
		shippingNumberSetter.setBounds(76, 157, 20, 20);
		contentPane.add(shippingNumberSetter);

		shippingIndicatorMask = new JLabel("");
		shippingIndicatorMask.setVisible(true);
		shippingIndicatorMask.setIcon(new ImageIcon(Home.class.getResource("/resources/Ellipse 4.png")));
		shippingIndicatorMask.setBounds(76, 157, 20, 20);
		contentPane.add(shippingIndicatorMask);

		shipping = new JLabel("");
		shipping.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					toggleShippingMenuPane();
				} else {
					closeShippingMenuPane();
				}
				toggle = !toggle;
			}
		});

		shipping.setVisible(true);
		shipping.setIcon(new ImageIcon(Home.class.getResource("/resources/shippingIcon.png")));
		shipping.setBounds(52, 167, 39, 37);
		contentPane.add(shipping);

		exit.setIcon(new ImageIcon(Home.class.getResource("/resources/exit.png")));
		exit.setBounds(51, 665, 39, 36);
		contentPane.add(exit);

		explore = new JLabel("Explore");
		explore.setForeground(Color.WHITE);
		explore.setFont(new Font("Montserrat", Font.BOLD, 33));
		explore.setBounds(160, 143, 133, 41);
		contentPane.add(explore);

		mostLovedMenu = new JPanel();
		mostLovedMenu.setOpaque(false);
		mostLovedMenu.setBackground(Color.BLACK);
		mostLovedMenu.setBounds(133, 464, 940, 232);
		contentPane.add(mostLovedMenu);
		mostLovedMenu.setLayout(null);

		mlplants5 = new JLabel("");
		mlplants5.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showPine();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants5.setIcon(new ImageIcon(Home.class.getResource("/resources/mostLovedPine.png")));
		mlplants5.setPreferredSize(new Dimension(172, 193));
		mlplants5.setMinimumSize(new Dimension(172, 193));
		mlplants5.setMaximumSize(new Dimension(172, 193));
		mlplants5.setBounds(754, 11, 172, 193);
		mostLovedMenu.add(mlplants5);

		mlplants3 = new JLabel("");
		mlplants3.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showRosemary();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants3.setIcon(new ImageIcon(Home.class.getResource("/resources/mostLovedRosemary.png")));
		mlplants3.setPreferredSize(new Dimension(172, 193));
		mlplants3.setMinimumSize(new Dimension(172, 193));
		mlplants3.setMaximumSize(new Dimension(172, 193));
		mlplants3.setBounds(391, 11, 172, 193);
		mostLovedMenu.add(mlplants3);

		mlplants2 = new JLabel("");
		mlplants2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showSage();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants2.setIcon(new ImageIcon(Home.class.getResource("/resources/mostLovedSage.png")));
		mlplants2.setPreferredSize(new Dimension(172, 193));
		mlplants2.setMinimumSize(new Dimension(172, 193));
		mlplants2.setMaximumSize(new Dimension(172, 193));
		mlplants2.setBounds(209, 11, 172, 193);
		mostLovedMenu.add(mlplants2);

		mlplants1 = new JLabel("");
		mlplants1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showHydrangea();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants1.setIcon(new ImageIcon(Home.class.getResource("/resources/MostLovedCard.png")));
		mlplants1.setPreferredSize(new Dimension(172, 193));
		mlplants1.setMinimumSize(new Dimension(172, 193));
		mlplants1.setMaximumSize(new Dimension(172, 193));
		mlplants1.setBounds(27, 11, 172, 193);
		mostLovedMenu.add(mlplants1);

		mlplants1_1 = new JLabel("");
		mlplants1_1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showDevilsIvy();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants1_1.setIcon(new ImageIcon(Home.class.getResource("/resources/mostLovedDevilsIvy.png")));
		mlplants1_1.setPreferredSize(new Dimension(172, 193));
		mlplants1_1.setMinimumSize(new Dimension(172, 193));
		mlplants1_1.setMaximumSize(new Dimension(172, 193));
		mlplants1_1.setBounds(573, 11, 172, 193);
		mostLovedMenu.add(mlplants1_1);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(0, 0, 952, 232);
		mostLovedMenu.add(lblNewLabel_1);

		popularMenu = new JPanel();
		popularMenu.setVisible(false);
		popularMenu.setOpaque(false);
		popularMenu.setBackground(Color.BLACK);
		popularMenu.setLayout(null);
		popularMenu.setBounds(133, 464, 940, 232);
		contentPane.add(popularMenu);

		mlplants5_1 = new JLabel("");
		mlplants5_1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showStarJasmine();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants5_1.setIcon(new ImageIcon(Home.class.getResource("/resources/popularStarJasmine.png")));
		mlplants5_1.setPreferredSize(new Dimension(172, 193));
		mlplants5_1.setMinimumSize(new Dimension(172, 193));
		mlplants5_1.setMaximumSize(new Dimension(172, 193));
		mlplants5_1.setBounds(754, 11, 172, 193);
		popularMenu.add(mlplants5_1);

		mlplants2_1 = new JLabel("");
		mlplants2_1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showPine();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants2_1.setIcon(new ImageIcon(Home.class.getResource("/resources/popularPine.png")));
		mlplants2_1.setPreferredSize(new Dimension(172, 193));
		mlplants2_1.setMinimumSize(new Dimension(172, 193));
		mlplants2_1.setMaximumSize(new Dimension(172, 193));
		mlplants2_1.setBounds(209, 11, 172, 193);
		popularMenu.add(mlplants2_1);

		mlplants1_2 = new JLabel("");
		mlplants1_2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showHydrangea();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants1_2.setIcon(new ImageIcon(Home.class.getResource("/resources/PopularCard.png")));
		mlplants1_2.setPreferredSize(new Dimension(172, 193));
		mlplants1_2.setMinimumSize(new Dimension(172, 193));
		mlplants1_2.setMaximumSize(new Dimension(172, 193));
		mlplants1_2.setBounds(27, 11, 172, 193);
		popularMenu.add(mlplants1_2);

		mlplants1_3 = new JLabel("");
		mlplants1_3.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showSage();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		mlplants1_3.setIcon(new ImageIcon(Home.class.getResource("/resources/popularSage.png")));
		mlplants1_3.setPreferredSize(new Dimension(172, 193));
		mlplants1_3.setMinimumSize(new Dimension(172, 193));
		mlplants1_3.setMaximumSize(new Dimension(172, 193));
		mlplants1_3.setBounds(573, 11, 172, 193);
		popularMenu.add(mlplants1_3);

		mlplants2_2 = new JLabel("");
		mlplants2_2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showForsythia();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});
		mlplants2_2.setIcon(new ImageIcon(Home.class.getResource("/resources/popularSythia.png")));
		mlplants2_2.setPreferredSize(new Dimension(172, 193));
		mlplants2_2.setMinimumSize(new Dimension(172, 193));
		mlplants2_2.setMaximumSize(new Dimension(172, 193));
		mlplants2_2.setBounds(391, 11, 172, 193);
		popularMenu.add(mlplants2_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setBounds(0, 0, 940, 232);
		popularMenu.add(lblNewLabel_3);

		cartNumberSetter = new JLabel("0");
		cartNumberSetter.setFont(new Font("Montserrat", Font.BOLD, 12));
		cartNumberSetter.setForeground(new Color(255, 255, 255));
		cartNumberSetter.setHorizontalAlignment(SwingConstants.CENTER);
		cartNumberSetter.setBounds(76, 99, 20, 20);
		contentPane.add(cartNumberSetter);

		JLabel cartNumber = new JLabel("");
		cartNumber.setIcon(new ImageIcon(Home.class.getResource("/resources/Ellipse 4.png")));
		cartNumber.setHorizontalAlignment(SwingConstants.CENTER);
		cartNumber.setBounds(76, 99, 20, 20);
		contentPane.add(cartNumber);

		categoryMenu = new JPanel();
		categoryMenu.setOpaque(false);
		categoryMenu.setBackground(Color.BLACK);
		categoryMenu.setBounds(118, 219, 927, 212);
		contentPane.add(categoryMenu);
		searchItem.setBorder(null);
		searchItem.setForeground(Color.WHITE);
		searchItem.setFont(new Font("Montserrat", Font.PLAIN, 18));
		searchItem.setOpaque(false);
		searchItem.setBounds(995, 51, 180, 37);
		contentPane.add(searchItem);
		searchItem.setColumns(10);

		hamburgerMenu.setIcon(new ImageIcon(Home.class.getResource("/resources/hamburgerMenu.png")));
		hamburgerMenu.setHorizontalAlignment(SwingConstants.CENTER);
		hamburgerMenu.setBounds(51, 51, 39, 37);
		contentPane.add(hamburgerMenu);

		navigator = new JLabel("Home");
		navigator.setForeground(new Color(255, 255, 255));
		navigator.setFont(new Font("Montserrat", Font.PLAIN, 18));
		navigator.setHorizontalAlignment(SwingConstants.CENTER);
		navigator.setBounds(100, 51, 68, 37);
		contentPane.add(navigator);

		popular = new JLabel("Popular");
		popular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPopularText();
			}
		});

		popular.setHorizontalAlignment(SwingConstants.CENTER);
		popular.setForeground(Color.WHITE);
		popular.setFont(new Font("Montserrat", Font.PLAIN, 14));
		popular.setBounds(249, 442, 79, 18);
		contentPane.add(popular);

		mostLoved = new JLabel("Most loved");
		mostLoved.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMostLovedText();
			}
		});

		mostLoved.setForeground(Color.WHITE);
		mostLoved.setFont(new Font("Montserrat", Font.BOLD, 14));
		mostLoved.setBounds(160, 442, 79, 18);
		contentPane.add(mostLoved);

		discoverMorePlants = new JLabel("Discover more plants");
		discoverMorePlants.setForeground(Color.GRAY);
		discoverMorePlants.setFont(new Font("Montserrat", Font.PLAIN, 14));
		discoverMorePlants.setBounds(160, 183, 172, 25);
		contentPane.add(discoverMorePlants);

		climbers = new JLabel("");
		climbers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showClimbersMenu();
			}
		});
		categoryMenu.setLayout(null);
		climbers.setIcon(new ImageIcon(Home.class.getResource("/resources/climbers.png")));
		climbers.setPreferredSize(new Dimension(277, 90));
		climbers.setMinimumSize(new Dimension(277, 90));
		climbers.setMaximumSize(new Dimension(277, 90));
		climbers.setHorizontalAlignment(SwingConstants.CENTER);
		climbers.setBounds(43, 5, 277, 90);
		categoryMenu.add(climbers);

		shrubs = new JLabel("");
		shrubs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showShrubsMenu();
			}
		});

		shrubs.setIcon(new ImageIcon(Home.class.getResource("/resources/shrubs.png")));
		shrubs.setPreferredSize(new Dimension(277, 90));
		shrubs.setMinimumSize(new Dimension(277, 90));
		shrubs.setMaximumSize(new Dimension(277, 90));
		shrubs.setHorizontalAlignment(SwingConstants.CENTER);
		shrubs.setBounds(330, 5, 277, 90);
		categoryMenu.add(shrubs);

		herbs = new JLabel("");
		herbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHerbsMenu();
			}
		});
		herbs.setIcon(new ImageIcon(Home.class.getResource("/resources/herbs.png")));
		herbs.setHorizontalAlignment(SwingConstants.CENTER);
		herbs.setBounds(617, 5, 277, 90);
		herbs.setPreferredSize(new Dimension(277, 90));
		herbs.setMinimumSize(new Dimension(277, 90));
		herbs.setMaximumSize(new Dimension(277, 90));
		categoryMenu.add(herbs);

		trees = new JLabel("");
		trees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTreesMenu();
			}
		});
		trees.setIcon(new ImageIcon(Home.class.getResource("/resources/trees.png")));
		trees.setPreferredSize(new Dimension(277, 90));
		trees.setMinimumSize(new Dimension(277, 90));
		trees.setMaximumSize(new Dimension(277, 90));
		trees.setHorizontalAlignment(SwingConstants.CENTER);
		trees.setBounds(43, 111, 277, 90);
		categoryMenu.add(trees);

		creepers = new JLabel("");
		creepers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCreepersMenu();
			}
		});

		creepers.setIcon(new ImageIcon(Home.class.getResource("/resources/creepers.png")));
		creepers.setPreferredSize(new Dimension(277, 90));
		creepers.setMinimumSize(new Dimension(277, 90));
		creepers.setMaximumSize(new Dimension(277, 90));
		creepers.setHorizontalAlignment(SwingConstants.CENTER);
		creepers.setBounds(330, 111, 277, 90);
		categoryMenu.add(creepers);

		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBackground(Color.BLACK);
		lblNewLabel_13.setIcon(null);
		lblNewLabel_13.setBounds(0, 0, 927, 212);
		categoryMenu.add(lblNewLabel_13);

		cart = new JLabel("");
		cart.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					toggleCartPane();
				} else {
					closeCartPane();
				}
				toggle = !toggle;
			}
		});

		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setIcon(new ImageIcon(Home.class.getResource("/resources/cart.png")));
		cart.setBounds(51, 109, 39, 37);
		cart.setPreferredSize(new Dimension(38, 36));
		cart.setMinimumSize(new Dimension(38, 36));
		cart.setMaximumSize(new Dimension(38, 36));
		contentPane.add(cart);

		search = new JLabel("New label");
		search.setIcon(new ImageIcon(Home.class.getResource("/resources/searchPane.png")));
		search.setBounds(970, 51, 244, 37);
		search.setPreferredSize(new Dimension(244, 37));
		search.setMinimumSize(new Dimension(244, 37));
		search.setMaximumSize(new Dimension(244, 37));
		contentPane.add(search);

		treesMenu = new JPanel();
		treesMenu.setBackground(Color.BLACK);
		treesMenu.setOpaque(false);
		treesMenu.setBounds(133, 143, 562, 553);
		treesMenu.setVisible(false);
		contentPane.add(treesMenu);
		treesMenu.setLayout(null);

		treesHeartReact1 = new JLabel("");
		customHooks.HeartReact(treesHeartReact1, 21, 21, 38, 87, "/resources/heart.png");
		treesMenu.add(treesHeartReact1);

		treesHeartReact2 = new JLabel("");
		customHooks.HeartReact(treesHeartReact2, 21, 21, 225, 87, "/resources/heart.png");
		treesMenu.add(treesHeartReact2);

		t1 = new JLabel("");
		t1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showPine();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		t1.setIcon(new ImageIcon(Home.class.getResource("/resources/pine.png")));
		t1.setPreferredSize(new Dimension(172, 193));
		t1.setMinimumSize(new Dimension(172, 193));
		t1.setMaximumSize(new Dimension(172, 193));
		t1.setBounds(28, 77, 172, 193);
		treesMenu.add(t1);

		t2 = new JLabel("");
		t2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showCornifers();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		t2.setIcon(new ImageIcon(Home.class.getResource("/resources/conifers.png")));
		t2.setPreferredSize(new Dimension(172, 193));
		t2.setMinimumSize(new Dimension(172, 193));
		t2.setMaximumSize(new Dimension(172, 193));
		t2.setBounds(215, 77, 172, 193);
		treesMenu.add(t2);

		lblExploreMoreTree = new JLabel("Explore more tree greeneries");
		lblExploreMoreTree.setForeground(Color.GRAY);
		lblExploreMoreTree.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblExploreMoreTree.setBounds(28, 41, 250, 25);
		treesMenu.add(lblExploreMoreTree);

		lblNewLabel_11 = new JLabel("Trees");
		lblNewLabel_11.setPreferredSize(new Dimension(133, 41));
		lblNewLabel_11.setMinimumSize(new Dimension(133, 41));
		lblNewLabel_11.setMaximumSize(new Dimension(133, 41));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Montserrat", Font.BOLD, 33));
		lblNewLabel_11.setBounds(28, 0, 172, 41);
		treesMenu.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(null);
		lblNewLabel_12.setBounds(0, 0, 563, 553);
		treesMenu.add(lblNewLabel_12);

		shrubsMenu = new JPanel();
		shrubsMenu.setBackground(Color.BLACK);
		shrubsMenu.setOpaque(false);
		shrubsMenu.setLayout(null);
		shrubsMenu.setBounds(133, 143, 562, 553);
		shrubsMenu.setVisible(false);
		contentPane.add(shrubsMenu);

		shrubsHeartReact1 = new JLabel("");
		customHooks.HeartReact(shrubsHeartReact1, 21, 21, 38, 87, "/resources/heart.png");
		shrubsMenu.add(shrubsHeartReact1);

		shrubsHeartReact2 = new JLabel("");
		customHooks.HeartReact(shrubsHeartReact2, 21, 21, 225, 87, "/resources/heart.png");
		shrubsMenu.add(shrubsHeartReact2);

		s2 = new JLabel("");
		s2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showForsythia();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		s2.setIcon(new ImageIcon(Home.class.getResource("/resources/forsythia.png")));
		s2.setPreferredSize(new Dimension(172, 193));
		s2.setMinimumSize(new Dimension(172, 193));
		s2.setMaximumSize(new Dimension(172, 193));
		s2.setBounds(215, 77, 172, 193);
		shrubsMenu.add(s2);

		s1 = new JLabel("");
		s1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showHydrangea();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		s1.setIcon(new ImageIcon(Home.class.getResource("/resources/hydrangea.png")));
		s1.setPreferredSize(new Dimension(172, 193));
		s1.setMinimumSize(new Dimension(172, 193));
		s1.setMaximumSize(new Dimension(172, 193));
		s1.setBounds(28, 77, 172, 193);
		shrubsMenu.add(s1);

		lblExploreMoreHerb_1 = new JLabel("Explore more shrub greeneries");
		lblExploreMoreHerb_1.setForeground(Color.GRAY);
		lblExploreMoreHerb_1.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblExploreMoreHerb_1.setBounds(28, 41, 235, 25);
		shrubsMenu.add(lblExploreMoreHerb_1);

		lblNewLabel_6 = new JLabel("Shrubs");
		lblNewLabel_6.setPreferredSize(new Dimension(133, 41));
		lblNewLabel_6.setMinimumSize(new Dimension(133, 41));
		lblNewLabel_6.setMaximumSize(new Dimension(133, 41));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Montserrat", Font.BOLD, 33));
		lblNewLabel_6.setBounds(28, 0, 133, 41);
		shrubsMenu.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(null);
		lblNewLabel_7.setBounds(0, 0, 563, 553);
		shrubsMenu.add(lblNewLabel_7);

		paymentPane = new JPanel();
		paymentPane.setOpaque(false);
		paymentPane.setBackground(new Color(0, 0, 0));
		paymentPane.setBounds(754, 0, 517, 759);
		contentPane.add(paymentPane);
		paymentPane.setLayout(null);

		plantDescriptionPane = new JPanel();
		plantDescriptionPane.setOpaque(false);
		plantDescriptionPane.setBackground(Color.BLACK);
		plantDescriptionPane.setBounds(754, 0, 517, 759);
		contentPane.add(plantDescriptionPane);
		plantDescriptionPane.setVisible(false);
		plantDescriptionPane.setLayout(null);

		cartPane = new JPanel();
		cartPane.setOpaque(false);
		cartPane.setBackground(Color.BLACK);
		cartPane.setVisible(false);
		cartPane.setBounds(754, 0, 517, 759);
		contentPane.add(cartPane);
		cartPane.setLayout(null);

		creepersMenu = new JPanel();
		creepersMenu.setBackground(Color.BLACK);
		creepersMenu.setOpaque(false);
		creepersMenu.setBounds(133, 143, 562, 553);
		creepersMenu.setVisible(false);
		contentPane.add(creepersMenu);
		creepersMenu.setLayout(null);

		creepersHeartReact1 = new JLabel("");
		customHooks.HeartReact(creepersHeartReact1, 21, 21, 38, 87, "/resources/heart.png");
		creepersMenu.add(creepersHeartReact1);

		creepersHeartReact2 = new JLabel("");
		customHooks.HeartReact(creepersHeartReact2, 21, 21, 225, 87, "/resources/heart.png");
		creepersMenu.add(creepersHeartReact2);

		creepers2 = new JLabel("");
		creepers2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showEnglishIvy();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		creepers2.setPreferredSize(new Dimension(172, 193));
		creepers2.setIcon(new ImageIcon(Home.class.getResource("/resources/english ivy.png")));
		creepers2.setMinimumSize(new Dimension(172, 193));
		creepers2.setMaximumSize(new Dimension(172, 193));
		creepers2.setBounds(215, 77, 172, 193);
		creepersMenu.add(creepers2);

		creepers1 = new JLabel("");
		creepers1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showDevilsIvy();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		creepers1.setBounds(215, 77, 172, 193);
		creepers1.setIcon(new ImageIcon(Home.class.getResource("/resources/devil's ivy.png")));
		creepers1.setPreferredSize(new Dimension(172, 193));
		creepers1.setMinimumSize(new Dimension(172, 193));
		creepers1.setMaximumSize(new Dimension(172, 193));
		creepers1.setBounds(28, 77, 172, 193);
		creepersMenu.add(creepers1);

		lblExploreMoreHerb_2 = new JLabel("Explore more creeper greeneries");
		lblExploreMoreHerb_2.setForeground(Color.GRAY);
		lblExploreMoreHerb_2.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblExploreMoreHerb_2.setBounds(28, 41, 235, 25);
		creepersMenu.add(lblExploreMoreHerb_2);

		lblNewLabel_8 = new JLabel("Creepers");
		lblNewLabel_8.setPreferredSize(new Dimension(133, 41));
		lblNewLabel_8.setMinimumSize(new Dimension(133, 41));
		lblNewLabel_8.setMaximumSize(new Dimension(133, 41));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Montserrat", Font.BOLD, 33));
		lblNewLabel_8.setBounds(28, 0, 159, 41);
		creepersMenu.add(lblNewLabel_8);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(0, 0, 563, 553);
		creepersMenu.add(lblNewLabel);

		thanksPane = new JPanel();
		thanksPane.setVisible(false);
		thanksPane.setOpaque(false);
		thanksPane.setBackground(Color.BLACK);
		thanksPane.setBounds(383, 229, 504, 252);
		contentPane.add(thanksPane);
		thanksPane.setLayout(null);

		cpPane = new JPanel();
		cpPane.setOpaque(false);
		cpPane.setBackground(Color.BLACK);
		cpPane.setBounds(309, 119, 653, 492);
		contentPane.add(cpPane);
		cpPane.setLayout(null);

		herbsMenu = new JPanel();
		herbsMenu.setBackground(Color.BLACK);
		herbsMenu.setOpaque(false);
		herbsMenu.setBounds(133, 143, 562, 553);
		herbsMenu.setVisible(false);
		contentPane.add(herbsMenu);
		herbsMenu.setLayout(null);

		herbsHeartReact1 = new JLabel("");
		customHooks.HeartReact(herbsHeartReact1, 21, 21, 38, 87, "/resources/heart.png");
		herbsMenu.add(herbsHeartReact1);

		herbsHeartReact2 = new JLabel("");
		customHooks.HeartReact(herbsHeartReact2, 21, 21, 225, 87, "/resources/heart.png");
		herbsMenu.add(herbsHeartReact2);

		h2 = new JLabel("");
		h2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showSage();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		h2.setIcon(new ImageIcon(Home.class.getResource("/resources/sage.png")));
		h2.setPreferredSize(new Dimension(172, 193));
		h2.setMinimumSize(new Dimension(172, 193));
		h2.setMaximumSize(new Dimension(172, 193));
		h2.setBounds(215, 77, 172, 193);
		herbsMenu.add(h2);

		h1 = new JLabel("");
		h1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showRosemary();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		h1.setIcon(new ImageIcon(Home.class.getResource("/resources/rosemary.png")));
		h1.setPreferredSize(new Dimension(172, 193));
		h1.setMinimumSize(new Dimension(172, 193));
		h1.setMaximumSize(new Dimension(172, 193));
		h1.setBounds(28, 77, 172, 193);
		herbsMenu.add(h1);

		lblExploreMoreHerb = new JLabel("Explore more herb greeneries");
		lblExploreMoreHerb.setForeground(Color.GRAY);
		lblExploreMoreHerb.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblExploreMoreHerb.setBounds(28, 41, 208, 25);
		herbsMenu.add(lblExploreMoreHerb);

		lblNewLabel_5 = new JLabel("Herbs");
		lblNewLabel_5.setPreferredSize(new Dimension(133, 41));
		lblNewLabel_5.setMinimumSize(new Dimension(133, 41));
		lblNewLabel_5.setMaximumSize(new Dimension(133, 41));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Montserrat", Font.BOLD, 33));
		lblNewLabel_5.setBounds(28, 0, 133, 41);
		herbsMenu.add(lblNewLabel_5);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(null);
		lblNewLabel_4.setBounds(0, 0, 563, 553);
		herbsMenu.add(lblNewLabel_4);

		climbersMenu = new JPanel();
		climbersMenu.setBackground(Color.BLACK);
		climbersMenu.setOpaque(false);
		climbersMenu.setBounds(133, 143, 562, 553);
		climbersMenu.setVisible(false);
		contentPane.add(climbersMenu);
		climbersMenu.setLayout(null);

		climbersHeartReact1 = new JLabel("");
		customHooks.HeartReact(climbersHeartReact1, 21, 21, 38, 87, "/resources/heart.png");
		climbersMenu.add(climbersHeartReact1);

		climbersHeartReact2 = new JLabel("");
		customHooks.HeartReact(climbersHeartReact2, 21, 21, 225, 87, "/resources/heart.png");
		climbersMenu.add(climbersHeartReact2);

		c1 = new JLabel("");
		c1.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showWisteria();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		c1.setIcon(new ImageIcon(Home.class.getResource("/resources/wisteria.png")));
		c1.setPreferredSize(new Dimension(172, 193));
		c1.setMinimumSize(new Dimension(172, 193));
		c1.setMaximumSize(new Dimension(172, 193));
		c1.setBounds(28, 77, 172, 193);
		climbersMenu.add(c1);

		c2 = new JLabel("");
		c2.addMouseListener(new MouseAdapter() {
			private boolean toggle = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggle) {
					togglePlantDescriptionPane();
					showStarJasmine();
				} else {
					closePlantDescriptionPane();
				}
				toggle = !toggle;
			}
		});

		c2.setIcon(new ImageIcon(Home.class.getResource("/resources/star jasmine.png")));
		c2.setPreferredSize(new Dimension(172, 193));
		c2.setMinimumSize(new Dimension(172, 193));
		c2.setMaximumSize(new Dimension(172, 193));
		c2.setBounds(215, 77, 172, 193);
		climbersMenu.add(c2);

		lblExploreMoreClimber = new JLabel("Explore more climber greeneries");
		lblExploreMoreClimber.setForeground(Color.GRAY);
		lblExploreMoreClimber.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblExploreMoreClimber.setBounds(28, 41, 250, 25);
		climbersMenu.add(lblExploreMoreClimber);

		lblNewLabel_9 = new JLabel("Climbers");
		lblNewLabel_9.setPreferredSize(new Dimension(133, 41));
		lblNewLabel_9.setMinimumSize(new Dimension(133, 41));
		lblNewLabel_9.setMaximumSize(new Dimension(133, 41));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Montserrat", Font.BOLD, 33));
		lblNewLabel_9.setBounds(28, 0, 156, 41);
		climbersMenu.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(null);
		lblNewLabel_10.setBounds(0, 0, 563, 553);
		climbersMenu.add(lblNewLabel_10);

		back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleBack();
			}
		});

		back.setVisible(false);
		back.setIcon(new ImageIcon(Home.class.getResource("/resources/backBtnMask.png")));
		back.setBounds(51, 608, 38, 36);
		contentPane.add(back);

		suggestionsMenu = new JPanel();
		suggestionsMenu.setOpaque(false);
		suggestionsMenu.setVisible(false);
		suggestionsMenu.setBackground(Color.BLACK);
		suggestionsMenu.setBounds(171, 168, 930, 402);
		contentPane.add(suggestionsMenu);
		suggestionsMenu.setLayout(null);

		JLabel smShrubs = new JLabel("");
		smShrubs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchShrubs();
			}
		});
		smShrubs.setBounds(165, 209, 139, 40);
		suggestionsMenu.add(smShrubs);

		JLabel smCreepers = new JLabel("");
		smCreepers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchCreepers();
			}
		});
		smCreepers.setBounds(400, 260, 158, 32);
		suggestionsMenu.add(smCreepers);

		JLabel smTrees = new JLabel("");
		smTrees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchTrees();
			}
		});
		smTrees.setBounds(325, 209, 139, 40);
		suggestionsMenu.add(smTrees);

		JLabel smClimbers = new JLabel("");
		smClimbers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchClimbers();
			}
		});
		smClimbers.setBounds(474, 209, 166, 40);
		suggestionsMenu.add(smClimbers);

		JLabel smHerbs = new JLabel("");
		smHerbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchHerbs();
			}
		});

		smHerbs.setBounds(654, 209, 123, 40);
		suggestionsMenu.add(smHerbs);

		JLabel mask = new JLabel("New label");
		mask.setBackground(Color.BLACK);
		mask.setIcon(new ImageIcon(Home.class.getResource("/resources/suggestedSearch.png")));
		mask.setBounds(0, 0, 930, 402);
		suggestionsMenu.add(mask);

		background = new JLabel("");
		background.setOpaque(false);
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(Home.class.getResource("/resources/homeMaskScreen1.png")));
		background.setBounds(0, 0, 1271, 759);
		background.setPreferredSize(new Dimension(38, 36));
		background.setMinimumSize(new Dimension(38, 36));
		background.setMaximumSize(new Dimension(38, 36));
		contentPane.add(background);
	}

	private void searchShrubs() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		shrubsMenu.setVisible(true);
		herbsMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		creepersMenu.setVisible(false);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void searchHerbs() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		herbsMenu.setVisible(true);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		creepersMenu.setVisible(false);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void searchCreepers() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		herbsMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		creepersMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void searchClimbers() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		herbsMenu.setVisible(false);
		climbersMenu.setVisible(true);
		treesMenu.setVisible(false);
		creepersMenu.setVisible(false);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void searchTrees() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		herbsMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(true);
		creepersMenu.setVisible(false);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void itemNotFound() {
		back.setVisible(true);
		suggestionsMenu.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		herbsMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		creepersMenu.setVisible(false);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		repaint();
		revalidate();
	}

	private void showClimbersMenu() {
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		climbersMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(climbersMenu, 0);
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		back.setVisible(true);
		repaint();
		revalidate();
	}

	private void showShrubsMenu() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		shrubsMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(shrubsMenu, 0);
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
	}

	private void showHerbsMenu() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		herbsMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(herbsMenu, 0);
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
	}

	private void showTreesMenu() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		treesMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(treesMenu, 0);
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
	}

	private void showCreepersMenu() {
		back.setVisible(true);
		navigator.setText("Shop");
		popularMenu.setVisible(false);
		creepersMenu.setVisible(true);
		explore.setVisible(false);
		discoverMorePlants.setVisible(false);
		categoryMenu.setVisible(false);
		popular.setVisible(false);
		mostLoved.setVisible(false);
		mostLovedMenu.setVisible(false);
		contentPane.setComponentZOrder(creepersMenu, 0);
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
	}

	private void toggleHamburgerMenu() {
		navigator.setText("Home");
		popularMenu.setVisible(false);
		explore.setVisible(true);
		discoverMorePlants.setVisible(true);
		categoryMenu.setVisible(true);
		popular.setVisible(true);
		mostLoved.setVisible(true);
		mostLovedMenu.setVisible(true);
		herbsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		creepersMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		back.setVisible(false);
		mostLoved.setFont(new Font("Montserrat", Font.BOLD, 14));
		popular.setFont(new Font("Montserrat", Font.PLAIN, 14));
		repaint();
		revalidate();
	}

	private void toggleBack() {
		back.setVisible(false);
		navigator.setText("Home");
		popularMenu.setVisible(false);
		explore.setVisible(true);
		discoverMorePlants.setVisible(true);
		categoryMenu.setVisible(true);
		popular.setVisible(true);
		mostLoved.setVisible(true);
		mostLovedMenu.setVisible(true);
		herbsMenu.setVisible(false);
		shrubsMenu.setVisible(false);
		creepersMenu.setVisible(false);
		climbersMenu.setVisible(false);
		treesMenu.setVisible(false);
		suggestionsMenu.setVisible(false);
		mostLoved.setFont(new Font("Montserrat", Font.BOLD, 14));
		popular.setFont(new Font("Montserrat", Font.PLAIN, 14));
		repaint();
		revalidate();
	}

	private void togglePlantDescriptionPane() {
		System.out.println("Nice bai!");
		plantDescriptionPane.add(pdc);
		contentPane.setComponentZOrder(plantDescriptionPane, 0);
		plantDescriptionPane.setComponentZOrder(pdc, 0);
		plantDescriptionPane.setVisible(true);
		pdc.setVisible(true);
		cartPane.setVisible(false);
		checkout.setVisible(false);
		repaint();
		revalidate();
	}

	private void closePlantDescriptionPane() {
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
		System.out.println("Failed");
	}

	private void toggleCartPane() {
		System.out.println("Nice bai!");
		cartPane.add(shoppingCart);
		contentPane.setComponentZOrder(cartPane, 0);
		cartPane.setComponentZOrder(shoppingCart, 0);
		plantDescriptionPane.setVisible(false);
		cartPane.setVisible(true);
		shoppingCart.setVisible(true);
		plantDescriptionPane.setVisible(false);
		pdc.setVisible(false);
		repaint();
		revalidate();
	}

	private void closeCartPane() {
		cartPane.setVisible(false);
		shoppingCart.setVisible(false);
		System.out.println("Failed");
	}

	private void toggleShippingMenuPane() {
		shippingMenu.setVisible(true);
		contentPane.setComponentZOrder(shippingMenu, 0);
		repaint();
		revalidate();
	}

	private void closeShippingMenuPane() {
		shippingMenu.setVisible(false);
		repaint();
		revalidate();
	}

	private void cancelShip() {
		try {
			shipPane.setVisible(false);
			cancelShipBtn.setVisible(false);
			noParcelPending.setVisible(true);
			shippingNumberSetter.setText("0");
			System.out.println("Parcel cancelled successfully");
			repaint();
			revalidate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to cancel the parcel!");
		}
	}

	private void setMostLovedText() {
		mostLovedMenu.setVisible(true);
		popularMenu.setVisible(false);
		mostLoved.setFont(new Font("Montserrat", Font.BOLD, 14));
		popular.setFont(new Font("Montserrat", Font.PLAIN, 14));
	}

	private void setPopularText() {
		popularMenu.setVisible(true);
		mostLovedMenu.setVisible(false);
		popular.setFont(new Font("Montserrat", Font.BOLD, 14));
		mostLoved.setFont(new Font("Montserrat", Font.PLAIN, 14));
	}

	private void showHydrangea() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createHydrangea().getName(),
				plant.createHydrangea().getDescription(),
				plant.createHydrangea().getCategory(),
				plant.createHydrangea().getFamily(),
				plant.createHydrangea().getPrice(),
				plant.createHydrangea().getImage());
	}

	private void showWisteria() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createWisteria().getName(),
				plant.createWisteria().getDescription(),
				plant.createWisteria().getCategory(),
				plant.createWisteria().getFamily(),
				plant.createWisteria().getPrice(),
				plant.createWisteria().getImage());
	}

	private void showRosemary() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createRosemary().getName(),
				plant.createRosemary().getDescription(),
				plant.createRosemary().getCategory(),
				plant.createRosemary().getFamily(),
				plant.createRosemary().getPrice(),
				plant.createRosemary().getImage());
	}

	private void showSage() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createSage().getName(),
				plant.createSage().getDescription(),
				plant.createSage().getCategory(),
				plant.createSage().getFamily(),
				plant.createSage().getPrice(),
				plant.createSage().getImage());
	}

	private void showDevilsIvy() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createDevilsIvy().getName(),
				plant.createDevilsIvy().getDescription(),
				plant.createDevilsIvy().getCategory(),
				plant.createDevilsIvy().getFamily(),
				plant.createDevilsIvy().getPrice(),
				plant.createDevilsIvy().getImage());
	}

	private void showEnglishIvy() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createEnglishIvy().getName(),
				plant.createEnglishIvy().getDescription(),
				plant.createEnglishIvy().getCategory(),
				plant.createEnglishIvy().getFamily(),
				plant.createEnglishIvy().getPrice(),
				plant.createEnglishIvy().getImage());
	}

	private void showForsythia() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createForsythia().getName(),
				plant.createForsythia().getDescription(),
				plant.createForsythia().getCategory(),
				plant.createForsythia().getFamily(),
				plant.createForsythia().getPrice(),
				plant.createForsythia().getImage());
	}

	private void showCornifers() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createConifers().getName(),
				plant.createConifers().getDescription(),
				plant.createConifers().getCategory(),
				plant.createConifers().getFamily(),
				plant.createConifers().getPrice(),
				plant.createConifers().getImage());
	}

	private void showPine() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createPine().getName(),
				plant.createPine().getDescription(),
				plant.createPine().getCategory(),
				plant.createPine().getFamily(),
				plant.createPine().getPrice(),
				plant.createPine().getImage());
	}

	private void showStarJasmine() {
		customHooks.setPlantItemCardProperties(
				pdc,
				plant.createStarJasmine().getName(),
				plant.createStarJasmine().getDescription(),
				plant.createStarJasmine().getCategory(),
				plant.createStarJasmine().getFamily(),
				plant.createStarJasmine().getPrice(),
				plant.createStarJasmine().getImage());
	}
}

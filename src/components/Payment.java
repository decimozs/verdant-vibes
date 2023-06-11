package components;

import java.awt.Color;
import components.Home;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Payment extends JPanel {

    public JTextField lastname;
    private Home home;
    public JTextField initial;
    public JTextField firstname;
    private JLabel cashOnDelivery;
    private JLabel creditCard;
    private JLabel debitCard;
    private JLabel digitalWallet;
    private JPanel creditDebitCardMenu;
    private JPanel digitalWalletMenu;
    public JTextField cardNumber;
    public JTextField cvv;
    public JTextField cardHolder;
    public JTextField day;
    public JTextField month;
    public JTextField year;
    private JPanel codMenu;
    public JTextField username;
    public JTextField passwordPin;
    public JTextField accessCode;
    public JLabel amount;
    private JLabel payBtn;
    public int testSum;
    public JLabel addressChoice;
    public String fname = "";
    public String lname = "";
    public String init = "";
    public String cardholdername;
    public String cardnumber;
    public String noDays;
    public String noMonth;
    public String noYears;
    public String cvvPin;
    public JLabel merchandiseSubtotalAmount;
    private JLabel wallet;
    private JLabel funding;
    private JPanel walletMenu;
    private JPanel fundingSourceMenu;
    public String walletsChoice;
    public String fundingsChoice;
    public String rsWallet;
    public String rsFundingChoice;
    public JLabel shippingSubtotalAmount;
    public JLabel notice;

    public Payment(Home home) {
        this.home = home;

        setVisible(false);
        setBounds(new Rectangle(0, 0, 517, 759));
        setPreferredSize(new Dimension(517, 759));
        setMinimumSize(new Dimension(517, 759));
        setMaximumSize(new Dimension(517, 759));
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        setLayout(null);

        JLabel exit = new JLabel("");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.paymentPane.setVisible(false);
                setVisible(false);
            }
        });

        notice = new JLabel("");
        notice.setVisible(false);

        digitalWalletMenu = new JPanel();
        digitalWalletMenu.setLayout(null);
        digitalWalletMenu.setOpaque(false);
        digitalWalletMenu.setBackground(Color.BLACK);
        digitalWalletMenu.setBounds(0, 172, 517, 235);
        digitalWalletMenu.setVisible(false);

        codMenu = new JPanel();
        codMenu.setOpaque(false);
        codMenu.setBackground(Color.BLACK);
        codMenu.setBounds(0, 172, 517, 183);
        add(codMenu);
        codMenu.setLayout(null);

        lastname = new JTextField();
        lastname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lname = home.auth.capitalizeFirstLetter(lastname.getText());
                updatePayBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lname = home.auth.capitalizeFirstLetter(lastname.getText());
                updatePayBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lname = home.auth.capitalizeFirstLetter(lastname.getText());
                updatePayBtnText();
            }
        });

        lastname.setFont(new Font("Montserrat", Font.PLAIN, 18));
        lastname.setForeground(Color.WHITE);
        lastname.setBorder(null);
        lastname.setOpaque(false);
        lastname.setColumns(10);
        lastname.setBackground(Color.BLACK);
        lastname.setBounds(50, 118, 250, 44);
        codMenu.add(lastname);

        initial = new JTextField();
        initial.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                init = home.auth.capitalizeFirstLetter(initial.getText());
                updatePayBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                init = home.auth.capitalizeFirstLetter(initial.getText());
                updatePayBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                init = home.auth.capitalizeFirstLetter(initial.getText());
                updatePayBtnText();
            }
        });

        initial.setFont(new Font("Montserrat", Font.PLAIN, 18));
        initial.setForeground(Color.WHITE);
        initial.setOpaque(false);
        initial.setColumns(10);
        initial.setBorder(null);
        initial.setBackground(Color.BLACK);
        initial.setBounds(366, 118, 105, 44);
        codMenu.add(initial);

        firstname = new JTextField();
        firstname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fname = home.auth.capitalizeFirstLetter(firstname.getText());
                updatePayBtnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fname = home.auth.capitalizeFirstLetter(firstname.getText());
                updatePayBtnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fname = home.auth.capitalizeFirstLetter(firstname.getText());
                updatePayBtnText();
            }
        });

        firstname.setFont(new Font("Montserrat", Font.PLAIN, 18));
        firstname.setForeground(Color.WHITE);
        firstname.setOpaque(false);
        firstname.setColumns(10);
        firstname.setBorder(null);
        firstname.setBackground(Color.BLACK);
        firstname.setBounds(50, 44, 421, 44);
        codMenu.add(firstname);

        JLabel lastNameMask = new JLabel("");
        lastNameMask.setFont(new Font("Montserrat", Font.PLAIN, 18));
        lastNameMask.setForeground(Color.WHITE);
        lastNameMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/lastNameMask.png")));
        lastNameMask.setBounds(28, 118, 289, 44);
        codMenu.add(lastNameMask);

        JLabel initialMask = new JLabel("");
        initialMask.setFont(new Font("Montserrat", Font.PLAIN, 18));
        initialMask.setForeground(Color.WHITE);
        initialMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/initialMask.png")));
        initialMask.setBounds(348, 118, 142, 44);
        codMenu.add(initialMask);

        JLabel firstNameMask = new JLabel("");
        firstNameMask.setFont(new Font("Montserrat", Font.PLAIN, 18));
        firstNameMask.setForeground(Color.WHITE);
        firstNameMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/firstNameMask.png")));
        firstNameMask.setBounds(28, 44, 462, 44);
        codMenu.add(firstNameMask);

        JLabel cardInfomationLabel = new JLabel("Personal Information");
        cardInfomationLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
        cardInfomationLabel.setForeground(Color.WHITE);
        cardInfomationLabel.setBounds(28, 0, 158, 14);
        codMenu.add(cardInfomationLabel);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        lastNameLabel.setBounds(28, 95, 71, 16);
        codMenu.add(lastNameLabel);

        JLabel initialLabel = new JLabel("Initial (Optional)");
        initialLabel.setForeground(Color.WHITE);
        initialLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        initialLabel.setBounds(349, 95, 141, 16);
        codMenu.add(initialLabel);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        firstNameLabel.setBounds(28, 22, 73, 16);
        codMenu.add(firstNameLabel);
        add(digitalWalletMenu);

        fundingSourceMenu = new JPanel();
        fundingSourceMenu.setOpaque(false);
        fundingSourceMenu.setVisible(false);
        fundingSourceMenu.setBackground(Color.BLACK);
        fundingSourceMenu.setBounds(229, 27, 261, 161);
        digitalWalletMenu.add(fundingSourceMenu);
        fundingSourceMenu.setLayout(null);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(Payment.class.getResource("/resources/fundingSourceMenuMask.png")));
        lblNewLabel_2_1.setBounds(0, 0, 261, 164);
        fundingSourceMenu.add(lblNewLabel_2_1);

        JLabel wallets = new JLabel("");
        wallets.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                funding.setText("Wallet");
                fundingSourceMenu.setVisible(false);
                rsFundingChoice = "Wallet";
            }
        });

        wallets.setBounds(10, 54, 170, 14);
        fundingSourceMenu.add(wallets);

        JLabel giftCard = new JLabel("");
        giftCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                funding.setText("Gift Card");
                fundingSourceMenu.setVisible(false);
                rsFundingChoice = "Gift Card";
            }
        });

        giftCard.setBounds(10, 79, 84, 14);
        fundingSourceMenu.add(giftCard);

        JLabel creditCards = new JLabel("");
        creditCards.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                funding.setText("Credit Card");
                fundingSourceMenu.setVisible(false);
                rsFundingChoice = "Credit Card";
            }
        });

        creditCards.setBounds(10, 101, 74, 14);
        fundingSourceMenu.add(creditCards);

        JLabel debitCards = new JLabel("");
        debitCards.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                funding.setText("Debit Card");
                fundingSourceMenu.setVisible(false);
                rsFundingChoice = "Debit Card";
            }
        });

        debitCards.setBounds(10, 125, 84, 14);
        fundingSourceMenu.add(debitCards);

        JLabel exitFs = new JLabel("");
        exitFs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fundingSourceMenu.setVisible(false);
                fundingSourceMenu.setVisible(false);
            }
        });

        exitFs.setBounds(225, 11, 26, 24);
        fundingSourceMenu.add(exitFs);

        walletMenu = new JPanel();
        walletMenu.setVisible(false);
        walletMenu.setOpaque(false);
        walletMenu.setBackground(Color.BLACK);
        walletMenu.setBounds(28, 27, 171, 162);
        digitalWalletMenu.add(walletMenu);
        walletMenu.setLayout(null);

        JLabel wmask = new JLabel("");
        wmask.setIcon(new ImageIcon(Payment.class.getResource("/resources/walletMenuMask.png")));
        wmask.setBounds(0, 0, 171, 164);
        walletMenu.add(wmask);

        JLabel gcash = new JLabel("");
        gcash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                wallet.setText("Gcash");
                walletMenu.setVisible(false);
                rsWallet = "GCash";
            }
        });

        gcash.setBounds(10, 50, 96, 22);
        walletMenu.add(gcash);

        JLabel paymaya = new JLabel("");
        paymaya.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                wallet.setText("Maya");
                walletMenu.setVisible(false);
                rsWallet = "PayMaya";
            }
        });

        paymaya.setBounds(0, 82, 106, 22);
        walletMenu.add(paymaya);

        JLabel paypal = new JLabel("");
        paypal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                wallet.setText("PayPal");
                walletMenu.setVisible(false);
                rsWallet = "PayPal";
            }
        });

        paypal.setBounds(0, 115, 106, 22);
        walletMenu.add(paypal);

        JLabel exitWallet = new JLabel("");
        exitWallet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                walletMenu.setVisible(false);
            }
        });

        exitWallet.setBounds(137, 11, 24, 22);
        walletMenu.add(exitWallet);

        JLabel accountUsernameLabel = new JLabel("Account Username");
        accountUsernameLabel.setForeground(Color.WHITE);
        accountUsernameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        accountUsernameLabel.setBounds(28, 76, 144, 16);
        digitalWalletMenu.add(accountUsernameLabel);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Payment.class.getResource("/resources/firstNameMask.png")));
        lblNewLabel.setBounds(28, 101, 462, 44);
        digitalWalletMenu.add(lblNewLabel);

        JLabel pinLabel = new JLabel("Account Password / PIN");
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        pinLabel.setBounds(28, 154, 176, 16);
        digitalWalletMenu.add(pinLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Payment.class.getResource("/resources/pinMask.png")));
        lblNewLabel_1.setBounds(28, 179, 255, 44);
        digitalWalletMenu.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(Payment.class.getResource("/resources/codeMask.png")));
        lblNewLabel_1_1.setBounds(315, 179, 176, 44);
        digitalWalletMenu.add(lblNewLabel_1_1);

        JLabel lblAccessCode = new JLabel("Access Code");
        lblAccessCode.setForeground(Color.WHITE);
        lblAccessCode.setFont(new Font("Montserrat", Font.PLAIN, 13));
        lblAccessCode.setBounds(315, 157, 176, 16);
        digitalWalletMenu.add(lblAccessCode);

        JLabel lblFundingSource = new JLabel("Funding Source");
        lblFundingSource.setForeground(Color.WHITE);
        lblFundingSource.setFont(new Font("Montserrat", Font.PLAIN, 13));
        lblFundingSource.setBounds(229, 0, 176, 16);
        digitalWalletMenu.add(lblFundingSource);

        username = new JTextField();
        username.setOpaque(false);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Montserrat", Font.PLAIN, 18));
        username.setColumns(10);
        username.setBorder(null);
        username.setBackground(Color.BLACK);
        username.setBounds(48, 101, 426, 44);
        digitalWalletMenu.add(username);

        passwordPin = new JTextField();
        passwordPin.setOpaque(false);
        passwordPin.setForeground(Color.WHITE);
        passwordPin.setFont(new Font("Montserrat", Font.PLAIN, 18));
        passwordPin.setColumns(10);
        passwordPin.setBorder(null);
        passwordPin.setBackground(Color.BLACK);
        passwordPin.setBounds(48, 179, 218, 44);
        digitalWalletMenu.add(passwordPin);

        accessCode = new JTextField();
        accessCode.setOpaque(false);
        accessCode.setForeground(Color.WHITE);
        accessCode.setFont(new Font("Montserrat", Font.PLAIN, 18));
        accessCode.setColumns(10);
        accessCode.setBorder(null);
        accessCode.setBackground(Color.BLACK);
        accessCode.setBounds(332, 179, 144, 44);
        digitalWalletMenu.add(accessCode);

        JLabel lblDigitalWallet = new JLabel("Wallet");
        lblDigitalWallet.setForeground(Color.WHITE);
        lblDigitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        lblDigitalWallet.setBounds(28, 0, 144, 16);
        digitalWalletMenu.add(lblDigitalWallet);

        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setIcon(new ImageIcon(Payment.class.getResource("/resources/digitalWalletMask.png")));
        lblNewLabel_1_2.setBounds(28, 27, 176, 44);
        digitalWalletMenu.add(lblNewLabel_1_2);

        JLabel fundingSourceMask = new JLabel("");
        fundingSourceMask.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fundingSourceMenu.setVisible(true);
                repaint();
                revalidate();
            }
        });
        fundingSourceMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/fundingSourceMask.png")));
        fundingSourceMask.setBounds(229, 27, 261, 44);
        digitalWalletMenu.add(fundingSourceMask);

        JLabel walletChoice = new JLabel("");
        walletChoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                walletMenu.setVisible(true);
                repaint();
                revalidate();
            }
        });

        walletChoice.setForeground(Color.WHITE);
        walletChoice.setFont(new Font("Montserrat", Font.BOLD, 13));
        walletChoice.setBounds(48, 27, 118, 44);
        digitalWalletMenu.add(walletChoice);

        JLabel fundingSourceChoice = new JLabel("");
        fundingSourceChoice.setForeground(Color.WHITE);
        fundingSourceChoice.setFont(new Font("Montserrat", Font.BOLD, 13));
        fundingSourceChoice.setBounds(249, 27, 204, 44);
        digitalWalletMenu.add(fundingSourceChoice);

        wallet = new JLabel("");
        wallet.setForeground(Color.WHITE);
        wallet.setFont(new Font("Montserrat", Font.BOLD, 18));
        wallet.setBounds(48, 27, 118, 44);
        digitalWalletMenu.add(wallet);

        funding = new JLabel("");
        funding.setForeground(Color.WHITE);
        funding.setFont(new Font("Montserrat", Font.BOLD, 18));
        funding.setBounds(249, 27, 204, 44);
        digitalWalletMenu.add(funding);

        creditDebitCardMenu = new JPanel();
        creditDebitCardMenu.setOpaque(false);
        creditDebitCardMenu.setBackground(Color.BLACK);
        creditDebitCardMenu.setBounds(0, 172, 517, 287);
        creditDebitCardMenu.setVisible(false);
        add(creditDebitCardMenu);
        creditDebitCardMenu.setLayout(null);

        day = new JTextField();
        day.setHorizontalAlignment(SwingConstants.CENTER);

        day.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateNoDays();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateNoDays();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateNoDays();
            }
        });

        day.setOpaque(false);
        day.setForeground(Color.WHITE);
        day.setFont(new Font("Montserrat", Font.PLAIN, 18));
        day.setColumns(10);
        day.setBorder(null);
        day.setBackground(Color.BLACK);
        day.setBounds(238, 235, 61, 44);
        creditDebitCardMenu.add(day);

        month = new JTextField();
        month.setHorizontalAlignment(SwingConstants.CENTER);

        month.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                noMonth = home.auth.months(month.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(month, 2);
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                noMonth = home.auth.months(month.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(month, 2);
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                noMonth = home.auth.months(month.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(month, 2);
                });
            }
        });

        month.setOpaque(false);
        month.setForeground(Color.WHITE);
        month.setFont(new Font("Montserrat", Font.PLAIN, 18));
        month.setColumns(10);
        month.setBorder(null);
        month.setBackground(Color.BLACK);
        month.setBounds(48, 235, 118, 44);
        creditDebitCardMenu.add(month);

        year = new JTextField();
        year.setHorizontalAlignment(SwingConstants.CENTER);

        year.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                noYears = home.auth.years(year.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(year, 4);
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                noYears = home.auth.years(year.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(year, 4);
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                noYears = home.auth.years(year.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(year, 4);
                });
            }
        });

        year.setOpaque(false);
        year.setForeground(Color.WHITE);
        year.setFont(new Font("Montserrat", Font.PLAIN, 18));
        year.setColumns(10);
        year.setBorder(null);
        year.setBackground(Color.BLACK);
        year.setBounds(365, 235, 114, 44);
        creditDebitCardMenu.add(year);

        cvv = new JTextField();
        cvv.setHorizontalAlignment(SwingConstants.CENTER);

        cvv.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cvvPin = home.auth.containDigits(cvv.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cvv, 4);
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cvvPin = home.auth.containDigits(cvv.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cvv, 4);
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cvvPin = home.auth.containDigits(cvv.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cvv, 4);
                });
            }
        });

        cvv.setOpaque(false);
        cvv.setForeground(Color.WHITE);
        cvv.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cvv.setColumns(10);
        cvv.setBorder(null);
        cvv.setBackground(Color.BLACK);
        cvv.setBounds(365, 118, 114, 44);
        creditDebitCardMenu.add(cvv);

        cardHolder = new JTextField();

        cardHolder.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cardholdername = home.auth.capitalizeFirstLetter(cardHolder.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cardholdername = home.auth.capitalizeFirstLetter(cardHolder.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cardholdername = home.auth.capitalizeFirstLetter(cardHolder.getText());
            }
        });

        cardHolder.setOpaque(false);
        cardHolder.setForeground(Color.WHITE);
        cardHolder.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cardHolder.setColumns(10);
        cardHolder.setBorder(null);
        cardHolder.setBackground(Color.BLACK);
        cardHolder.setBounds(48, 44, 424, 44);
        creditDebitCardMenu.add(cardHolder);

        cardNumber = new JTextField();

        cardNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cardnumber = home.auth.cardNumbers(cardNumber.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cardNumber, 16);
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cardnumber = home.auth.cardNumbers(cardNumber.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cardNumber, 16);
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cardnumber = home.auth.cardNumbers(cardNumber.getText());
                SwingUtilities.invokeLater(() -> {
                    home.auth.limitInput(cardNumber, 16);
                });
            }
        });

        cardNumber.setOpaque(false);
        cardNumber.setForeground(Color.WHITE);
        cardNumber.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cardNumber.setColumns(10);
        cardNumber.setBorder(null);
        cardNumber.setBackground(Color.BLACK);
        cardNumber.setBounds(48, 118, 251, 44);
        creditDebitCardMenu.add(cardNumber);

        JLabel cardInformationLabel = new JLabel("Card Information");
        cardInformationLabel.setForeground(Color.WHITE);
        cardInformationLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
        cardInformationLabel.setBounds(28, 0, 144, 16);
        creditDebitCardMenu.add(cardInformationLabel);

        JLabel lblCvvCvc = new JLabel("CVV / CVC");
        lblCvvCvc.setForeground(Color.WHITE);
        lblCvvCvc.setFont(new Font("Montserrat", Font.PLAIN, 13));
        lblCvvCvc.setBounds(349, 95, 141, 16);
        creditDebitCardMenu.add(lblCvvCvc);

        JLabel cardNumberLabel = new JLabel("Card Number");
        cardNumberLabel.setForeground(Color.WHITE);
        cardNumberLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        cardNumberLabel.setBounds(28, 95, 114, 16);
        creditDebitCardMenu.add(cardNumberLabel);

        JLabel cvvMask = new JLabel("");
        cvvMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/initialMask.png")));
        cvvMask.setForeground(Color.WHITE);
        cvvMask.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cvvMask.setBounds(348, 118, 142, 44);
        creditDebitCardMenu.add(cvvMask);

        JLabel cardHolderNameLabel = new JLabel("Card Holder Name");
        cardHolderNameLabel.setForeground(Color.WHITE);
        cardHolderNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        cardHolderNameLabel.setBounds(28, 22, 144, 16);
        creditDebitCardMenu.add(cardHolderNameLabel);

        JLabel cardHolderName = new JLabel("");
        cardHolderName.setIcon(new ImageIcon(Payment.class.getResource("/resources/firstNameMask.png")));
        cardHolderName.setForeground(Color.WHITE);
        cardHolderName.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cardHolderName.setBounds(28, 44, 462, 44);
        creditDebitCardMenu.add(cardHolderName);

        JLabel cardNumberMask = new JLabel("");
        cardNumberMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/lastNameMask.png")));
        cardNumberMask.setForeground(Color.WHITE);
        cardNumberMask.setFont(new Font("Montserrat", Font.PLAIN, 18));
        cardNumberMask.setBounds(28, 118, 289, 44);
        creditDebitCardMenu.add(cardNumberMask);

        JLabel daysLabel = new JLabel("Month");
        daysLabel.setForeground(Color.WHITE);
        daysLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        daysLabel.setBounds(28, 213, 114, 16);
        creditDebitCardMenu.add(daysLabel);

        JLabel monthLabel = new JLabel("Day");
        monthLabel.setForeground(Color.WHITE);
        monthLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        monthLabel.setBounds(220, 213, 114, 16);
        creditDebitCardMenu.add(monthLabel);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setForeground(Color.WHITE);
        yearLabel.setFont(new Font("Montserrat", Font.PLAIN, 13));
        yearLabel.setBounds(349, 213, 114, 16);
        creditDebitCardMenu.add(yearLabel);

        JLabel yearMask = new JLabel("");
        yearMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/yearMask.png")));
        yearMask.setBounds(349, 235, 141, 44);
        creditDebitCardMenu.add(yearMask);

        JLabel dayMask = new JLabel("");
        dayMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/maskMaskNew.png")));
        dayMask.setBounds(28, 235, 158, 44);
        creditDebitCardMenu.add(dayMask);

        JLabel monthMask = new JLabel("");
        monthMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/dayMaskNew.png")));
        monthMask.setBounds(220, 235, 97, 44);
        creditDebitCardMenu.add(monthMask);

        JLabel expDateLabel = new JLabel("Expiration Date");
        expDateLabel.setForeground(Color.WHITE);
        expDateLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
        expDateLabel.setBounds(28, 191, 141, 16);
        creditDebitCardMenu.add(expDateLabel);
        notice.setHorizontalAlignment(SwingConstants.RIGHT);
        notice.setIcon(new ImageIcon(Payment.class.getResource("/resources/noticeFillForms.png")));
        notice.setBounds(272, 85, 218, 32);
        add(notice);

        shippingSubtotalAmount = new JLabel(" ₱ 0");
        shippingSubtotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        shippingSubtotalAmount.setForeground(Color.WHITE);
        shippingSubtotalAmount.setFont(new Font("Montserrat", Font.BOLD, 11));
        shippingSubtotalAmount.setBounds(149, 653, 109, 14);
        add(shippingSubtotalAmount);

        merchandiseSubtotalAmount = new JLabel(" ₱ 0");
        merchandiseSubtotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        merchandiseSubtotalAmount.setForeground(Color.WHITE);
        merchandiseSubtotalAmount.setFont(new Font("Montserrat", Font.BOLD, 11));
        merchandiseSubtotalAmount.setBounds(149, 634, 109, 14);
        add(merchandiseSubtotalAmount);

        addressChoice = new JLabel("");
        addressChoice.setBackground(Color.BLACK);
        addressChoice.setFont(new Font("Montserrat", Font.PLAIN, 13));
        addressChoice.setForeground(Color.WHITE);
        addressChoice.setBounds(49, 510, 392, 44);
        add(addressChoice);

        JLabel addressMask = new JLabel("");

        addressMask.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.address.setVisible(true);
            }
        });

        addressMask.setIcon(new ImageIcon(Payment.class.getResource("/resources/deliveryAddressMask.png")));
        addressMask.setBounds(28, 510, 462, 44);
        add(addressMask);

        JLabel addAddressBtn = new JLabel("");
        addAddressBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.createAddress.setVisible(true);
            }
        });

        addAddressBtn.setIcon(new ImageIcon(Payment.class.getResource("/resources/addAddressMask.png")));
        addAddressBtn.setBounds(369, 564, 121, 44);
        add(addAddressBtn);

        JLabel deliveryAddressLabel = new JLabel("Delivery Address");
        deliveryAddressLabel.setForeground(Color.WHITE);
        deliveryAddressLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
        deliveryAddressLabel.setBounds(28, 480, 230, 14);
        add(deliveryAddressLabel);

        amount = new JLabel();
        amount.setText(" ₱ 0");
        amount.setBounds(24, 709, 254, 27);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Montserrat", Font.BOLD, 22));
        add(amount);

        exit.setIcon(new ImageIcon(Payment.class.getResource("/resources/exit.png")));
        exit.setBounds(457, 19, 38, 36);
        add(exit);

        JLabel checkoutLabel = new JLabel("Checkout");
        checkoutLabel.setFont(new Font("Montserrat", Font.BOLD, 49));
        checkoutLabel.setForeground(Color.WHITE);
        checkoutLabel.setBounds(28, 19, 250, 60);
        add(checkoutLabel);

        JLabel paymentMethodLabel = new JLabel("Payment Method");
        paymentMethodLabel.setFont(new Font("Montserrat", Font.BOLD, 18));
        paymentMethodLabel.setForeground(Color.WHITE);
        paymentMethodLabel.setBounds(28, 95, 167, 22);
        add(paymentMethodLabel);

        cashOnDelivery = new JLabel("Cash on Delivery");
        cashOnDelivery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paymentCashOnDelivery();
            }
        });

        cashOnDelivery.setFont(new Font("Montserrat", Font.BOLD, 13));
        cashOnDelivery.setForeground(Color.WHITE);
        cashOnDelivery.setBounds(28, 133, 124, 16);
        cashOnDelivery.setVisible(true);
        add(cashOnDelivery);

        creditCard = new JLabel("Credit Card");
        creditCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paymentCreditCard();
            }
        });

        creditCard.setBounds(176, 133, 82, 16);
        creditCard.setForeground(Color.WHITE);
        creditCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        add(creditCard);

        debitCard = new JLabel("Debit Card");
        debitCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paymentDebitCard();
            }
        });
        debitCard.setBounds(285, 133, 94, 16);
        debitCard.setForeground(Color.WHITE);
        debitCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        add(debitCard);

        walletsChoice = rsWallet;
        fundingsChoice = rsFundingChoice;

        digitalWallet = new JLabel("Digital Wallet");
        digitalWallet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paymentDigitalWallet();
            }
        });

        digitalWallet.setBounds(396, 133, 99, 16);
        digitalWallet.setForeground(Color.WHITE);
        digitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        add(digitalWallet);

        JLabel paymentDetailsLabel = new JLabel("Payment Details");
        paymentDetailsLabel.setBounds(24, 610, 99, 14);
        paymentDetailsLabel.setForeground(Color.WHITE);
        paymentDetailsLabel.setFont(new Font("Montserrat", Font.BOLD, 11));
        add(paymentDetailsLabel);

        JLabel mercandiseSubtotal = new JLabel("Merchandise Subtotal");
        mercandiseSubtotal.setBounds(24, 633, 135, 14);
        mercandiseSubtotal.setForeground(Color.WHITE);
        mercandiseSubtotal.setFont(new Font("Montserrat", Font.PLAIN, 11));
        add(mercandiseSubtotal);

        JLabel shippingSubtotal = new JLabel("Shipping Subtotal");
        shippingSubtotal.setBounds(24, 652, 258, 14);
        shippingSubtotal.setForeground(Color.WHITE);
        shippingSubtotal.setFont(new Font("Montserrat", Font.PLAIN, 11));
        add(shippingSubtotal);

        JLabel totalAmount = new JLabel("Total Amount");
        totalAmount.setBounds(24, 686, 82, 14);
        totalAmount.setForeground(Color.WHITE);
        totalAmount.setFont(new Font("Montserrat", Font.BOLD, 11));
        add(totalAmount);

        payBtn = new JLabel("");
        payBtn.addMouseListener(new MouseAdapter() {
            private boolean toggle = true;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (addressChoice.getText().isEmpty()) {
                    System.out.println(
                            "Make sure that the corresponding needed information is filled up. Cannot proceed to checkout.");
                    notice.setVisible(true);
                    return;
                } else {
                    paymentTransactionComplete();
                }
                toggle = !toggle;
            }
        });

        payBtn.setIcon(new ImageIcon(Payment.class.getResource("/resources/buynowbtn.png")));
        payBtn.setBounds(285, 693, 232, 66);
        add(payBtn);

        JLabel mask = new JLabel("");
        mask.setIcon(new ImageIcon(Payment.class.getResource("/resources/ItemCardBg.png")));
        mask.setBounds(0, 0, 517, 759);
        add(mask);

        JLabel label = new JLabel("New label");
        label.setBounds(176, 633, 46, 14);
        add(label);

    }

    private void updateNoDays() {
        String selectedMonth = month.getText();
        String dayInput = day.getText();

        if (selectedMonth.isEmpty()) {
            noDays = "";
            return;
        }

        if (dayInput.isEmpty()) {
            noDays = "";
            return;
        }

        try {
            int dayValue = Integer.parseInt(dayInput);
            noDays = home.auth.days(dayInput, selectedMonth);
            home.auth.daysLimit(day, month);
            SwingUtilities.invokeLater(() -> {
                home.auth.limitInput(day, 2);
            });
        } catch (NumberFormatException ex) {
            System.out.println("Invalid day format: " + dayInput);
        }
    }

    private void updatePayBtnText() {
        payBtn.setText("Name: " + fname + " " + init + " " + lname);
    }

    public void updateTestSum() {
        testSum = home.table.calculateTotalSum();
        updateAmountLabel();
    }

    public void updateAmountLabel() {
        merchandiseSubtotalAmount.setText("₱   " + home.table.formatSum(testSum));
        amount.setText("₱   " + home.table.formatSum(testSum + home.shoppingCart.shippingFee()));
        home.cps.merchandeFinalSubtotalAmount.setText("₱   " + home.table.formatSum(testSum));
    }

    public void reset() {
        JTextField[] textFields = { firstname, lastname, initial, day, month, year, cvv, cardNumber, username,
                passwordPin, accessCode };

        for (JTextField textField : textFields) {
            textField.setText("");
        }

        cashOnDelivery.setFont(new Font("Montserrat", Font.BOLD, 13));
        creditCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        debitCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        digitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditDebitCardMenu.setVisible(false);
        codMenu.setVisible(true);
        digitalWalletMenu.setVisible(false);
    }

    public void paymentTransactionComplete() {
        notice.setVisible(false);
        String recieverName = home.checkout.firstname.getText() + " " + home.checkout.initial.getText() + " " + home.checkout.lastname.getText();
        String retrievePrice = amount.getText();
        String retrieveAddress = addressChoice.getText();
        System.out.println(payBtn.getText());
        home.cpPane.add(home.cps);
        home.cpPane.setVisible(true);
        home.cpPane.setComponentZOrder(home.cps, 0);
        home.getContentPane().setComponentZOrder(home.cpPane, 0);
        home.paymentPane.setVisible(false);
        home.checkout.setVisible(false);
        home.cartPane.setVisible(false);
        home.cps.totalAmount.setText(retrievePrice);
        home.cps.recieverName.setText(recieverName);
        home.cps.streetDetails.setText(retrieveAddress);
        home.cps.setVisible(true);
        home.cpPane.add(home.cps);
        home.contentPane.setComponentZOrder(home.cpPane, 0);
        System.out.println(home.checkout.firstname.getText() + " " + home.checkout.initial.getText() + " "
                + home.checkout.lastname.getText());
        home.cpPane.repaint();
        home.cpPane.revalidate();
        repaint();
        revalidate();
        reset();
    }

    private void paymentCashOnDelivery() {
        home.cps.modeOfPayment.setText("Cash on Delivery");
        cashOnDelivery.setFont(new Font("Montserrat", Font.BOLD, 13));
        creditCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        debitCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        digitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditDebitCardMenu.setVisible(false);
        codMenu.setVisible(true);
        digitalWalletMenu.setVisible(false);
        day.setText("");
        year.setText("");
        month.setText("");
        cvv.setText("");
        cardHolder.setText("");
        cardNumber.setText("");
        username.setText("");
        passwordPin.setText("");
        accessCode.setText("");
    }

    private void paymentCreditCard() {
        home.cps.modeOfPayment.setText("Credit Card");
        cashOnDelivery.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditCard.setFont(new Font("Montserrat", Font.BOLD, 13));
        debitCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        digitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditDebitCardMenu.setVisible(true);
        codMenu.setVisible(false);
        digitalWalletMenu.setVisible(false);
        firstname.setText("");
        initial.setText("");
        lastname.setText("");
        day.setText("");
        year.setText("");
        month.setText("");
        cvv.setText("");
        cardHolder.setText("");
        cardNumber.setText("");
        username.setText("");
        passwordPin.setText("");
        accessCode.setText("");
    }

    private void paymentDebitCard() {
        home.cps.modeOfPayment.setText("Debit Card");
        cashOnDelivery.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        debitCard.setFont(new Font("Montserrat", Font.BOLD, 13));
        digitalWallet.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditDebitCardMenu.setVisible(true);
        codMenu.setVisible(false);
        digitalWalletMenu.setVisible(false);
        firstname.setText("");
        initial.setText("");
        lastname.setText("");
        day.setText("");
        year.setText("");
        month.setText("");
        cvv.setText("");
        cardHolder.setText("");
        cardNumber.setText("");
        username.setText("");
        passwordPin.setText("");
        accessCode.setText("");
    }

    private void paymentDigitalWallet() {
        home.cps.modeOfPayment.setText("Digital Wallet");
        cashOnDelivery.setFont(new Font("Montserrat", Font.PLAIN, 13));
        creditCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        debitCard.setFont(new Font("Montserrat", Font.PLAIN, 13));
        digitalWallet.setFont(new Font("Montserrat", Font.BOLD, 13));
        creditDebitCardMenu.setVisible(false);
        codMenu.setVisible(false);
        digitalWalletMenu.setVisible(true);
        firstname.setText("");
        initial.setText("");
        lastname.setText("");
        day.setText("");
        year.setText("");
        month.setText("");
        cvv.setText("");
        cardHolder.setText("");
        cardNumber.setText("");
    }
}
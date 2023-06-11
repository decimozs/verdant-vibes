package components;

import javax.swing.SwingWorker;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;

public class LoadingScreen extends JFrame {

	private JLabel loadingStatus;
	private JPanel contentPane;
	private static int index = 0;
	private static String[] messages = {
			"Loading...", "Preparing products...", "Unearthing the green wonders...", "Loading complete!", "Opening home dashboard..."
	};

	public LoadingScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(325, 160, 1271, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loadingStatus = new JLabel("Loading...");
		loadingStatus.setFont(new Font("Poppins", Font.PLAIN, 17));
		loadingStatus.setForeground(Color.WHITE);
		loadingStatus.setHorizontalAlignment(SwingConstants.CENTER);
		loadingStatus.setBounds(435, 680, 400, 29);
		contentPane.add(loadingStatus);
		
		JLabel lblNewLabel = new JLabel(messages[index]);
		lblNewLabel.setIcon(new ImageIcon(LoadingScreen.class.getResource("/resources/loaderMask.png")));
		lblNewLabel.setBounds(0, 0, 1271, 759);
		contentPane.add(lblNewLabel);
		
		SwingWorker<Void, Void> loadingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 1; i <= messages.length; i++) {
                    Thread.sleep(500);
                    index = (index + 1) % messages.length;
                    publish();
                }

                return null;
            }

            @Override
            protected void process(java.util.List<Void> chunks) {
            	loadingStatus.setText(messages[index]);
            }
            @Override
            protected void done() {
                dispose();
                SwingUtilities.invokeLater(() -> new Home().setVisible(true));;
             }

		};
		
		loadingWorker.execute();
	}         
}

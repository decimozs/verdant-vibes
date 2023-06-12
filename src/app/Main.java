import javax.swing.SwingUtilities;
import forms.LoginForm;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new LoginForm().setVisible(true);
				System.out.print("The system is running!");
			} catch (Exception err) {
				err.printStackTrace();
				System.out.println("The system failed to execute!");
			}
		});
	}
}

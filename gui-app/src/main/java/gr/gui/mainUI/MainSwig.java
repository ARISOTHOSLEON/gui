package gr.gui.mainUI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.AbstractAction;
import javax.swing.Action;



public class MainSwig {

	private JFrame f;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSwig window = new MainSwig();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainSwig() {
		initialize();
	}

	/**
	 * Initialize the contents of the f.
	 */
	private void initialize() {
		f = new JFrame();

		String img = "public/images/arsenic.png";
		InputStream is = MainSwig.class.getClassLoader().getResourceAsStream(img );
		BufferedImage bf;
		try {
			bf = ImageIO.read(is);
			System.out.println(" \tbf = ImageIO.read(is); " );

			if (bf != null) {
				System.out.println(" ImageIO.read(is);  " );


			}
			Image icon = (Image) bf;
			f.setIconImage(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}


		
		
		f.setBounds(100, 100, 450, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(135, 72, 204, 20);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("******");
		lblNewLabel.setBounds(57, 75, 46, 14);
		f.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("*****");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(135, 103, 168, 23);
		f.getContentPane().add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		 System.out.println("clicked "+ textField.getText() );
			
		}
	}
}

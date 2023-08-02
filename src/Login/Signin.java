package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Signin() {
		setResizable(false);
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 485);
		setLocation(750,200);
		 ImageIcon img = new ImageIcon("2.png");
	        setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log frame = new Log();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnBack.setOpaque(false);
		btnBack.setBounds(75, 349, 104, 30);
		contentPane.add(btnBack);
		
		lblNewLabel_3 = new JLabel("Create an account!");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(138, 179, 120, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(98, 264, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(98, 198, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = new Login();
				a.addData(textField.getText(),passwordField.getText()); 
				JOptionPane.showMessageDialog(null,"Data Registered"); 
				Log frame = new Log();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton.setBounds(209, 349, 104, 30);
		btnNewButton.setOpaque(false);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 288, 193, 30);
		passwordField.setOpaque(false);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(98, 223, 193, 30);
		textField.setOpaque(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("IMG_0713.PNG"));
		lblNewLabel.setBounds(-255, -40, 697, 524);
		contentPane.add(lblNewLabel);
	}
}

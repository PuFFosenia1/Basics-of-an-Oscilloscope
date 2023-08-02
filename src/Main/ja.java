package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Log;
import Login.Signin;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ja frame = new ja();
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
	public ja() {
		setTitle("Start ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		setLocation(550,200);
		 ImageIcon img = new ImageIcon("2.png");
	        setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Sign in");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signin frame = new Signin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_1.setBounds(566, 407, 119, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log frame = new Log();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton.setBounds(566, 342, 119, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("IMG_0713 (2).PNG"));
		lblNewLabel.setBounds(0, 0, 884, 511);
		contentPane.add(lblNewLabel);
	}
}

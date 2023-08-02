package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Main.Old;
import Main.Oscilloscope;
import Main.Update;
import Main.ja;

public class Log extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnBack;
	boolean isValid = true;
	String update;
	StringBuffer sb = new StringBuffer();
    String line;
    String everything;
    int number;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
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
	public Log() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 409, 485);
		setLocation(750,200);
		 ImageIcon img = new ImageIcon("2.png");
	     setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja frame = new ja();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnBack.setOpaque(false);
		btnBack.setBounds(75, 349, 104, 30);
		contentPane.add(btnBack);
		
		lblNewLabel_3 = new JLabel("Welcome back! ");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(151, 181, 120, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(98, 264, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(98, 198, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = new Login();
				String usr = textField.getText();
				String pswd = passwordField.getText();
				isValid = a.logic(usr, pswd);
				update = Read();
				if(isValid == true && update.equals("1"))
				{
					Oscilloscope frame = new Oscilloscope();
					frame.setVisible(true);
					dispose();}
				else if(isValid == true) {
					Old frame = new Old();
				    frame.setVisible(true);
				    dispose();
				}
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
	
	
	String Read() {
		try {
		      File myObj = new File("update.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        return data;
		      }
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return "0";
	}

}

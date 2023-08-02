package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	 StringBuffer sb = new StringBuffer();
	    String line;
	    String everything;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 300);
		setTitle("Update");
        ImageIcon img = new ImageIcon("2.png");
        setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnNewButton.setOpaque(true);
		btnNewButton.setBounds(279, 212, 113, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Update");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = new Login();
				int b = 1;
				String s =String.valueOf(b);
				 try {
					 
						update(s);
						read();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				dispose();
				
			}
		});
		btnNext.setBackground(new Color(123, 104, 238));
		btnNext.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnNext.setOpaque(true);
		btnNext.setBounds(431, 212, 113, 38);
		contentPane.add(btnNext);
		
		JLabel lblNewLabel = new JLabel("New version alert!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel.setBounds(39, 11, 170, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update is available!");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(261, 65, 220, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A new version is available and ready to be installed.");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(261, 91, 293, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(204, 204, 255));
		lblNewLabel_4.setBounds(219, -2, 335, 263);
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("Webp.net-resizeimage (10).png"));
		lblNewLabel_5.setBounds(-33, 11, 241, 231);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("IMG_0713.PNG"));
		lblNewLabel_3.setBounds(-73, -2, 554, 261);
		contentPane.add(lblNewLabel_3);
	}
	static void update(String u) throws IOException{
		try {
		BufferedWriter myWriter = new BufferedWriter(new FileWriter("update.txt", true));
		System.out.println("Versiune "+ u);
	    myWriter.write( u );
	    myWriter.close();
	    System.out.println("Successfully wrote to the file.");
	  } catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	  } 
}
	 void read() throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader("update.txt"));
			try {
			    line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        //sb.append("\n");
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			   everything = sb.toString();
			   
			   System.out.println(everything);
			} finally {
			    br.close();
			}	
	    }	
}

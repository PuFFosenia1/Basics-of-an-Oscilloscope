package Main;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.swing.border.EmptyBorder;


import ex02_oscilloscope.SignalGraph;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Oscilloscope extends JFrame {

	private JPanel contentPane;
	private SignalGraph ct_signal;
	private SignalGraph ct_signal2;
	private SignalGraph ct_signal3;
	private JScrollBar sb_frecuency, sb_amplitude;
	private JTextField freq;
	private JTextField amp;
	private boolean isValidNumber = false;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//private double wave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oscilloscope frame = new Oscilloscope();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Oscilloscope() {
		//setResizable(false);
		//setMovable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 642);
		setLocation(350,200);
		setTitle("Oscilloscope");
		 ImageIcon img = new ImageIcon("2.png");
	        setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("E X I T");
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton_32 = new JButton("S A V E");
		btnNewButton_32.setBackground(new Color(128, 128, 128));
		btnNewButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Robot robot = null;
				try {
					robot = new Robot();
				}
				catch(AWTException ex){
					ex.printStackTrace();
				}
				BufferedImage i = null;
				i = robot.createScreenCapture(new Rectangle(350,200, 1295, 642));
				
				File save = new File("./save.png");
				try {
					ImageIO.write(i, "png", save);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_32.setFont(new Font("Bahnschrift", Font.PLAIN, 27));//nu stiu sa fac doua canale asa ca generez 2 unde in acelasi timp si sper sa nu imi strice pc-ul, a trecut un an inca nu s-a schimbat nimic yAAAAAiiii
		btnNewButton_32.setBounds(245, 559, 119, 34);
		contentPane.add(btnNewButton_32);
		
		JButton btnNewButton_4 = new JButton("H E L P");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			                JOptionPane.showMessageDialog(null,
			                                "\n\nValues per division:"
			                                + "\n5 V/div"
			                                + "\n"
			                                + "5 ms/div", "H E L P", JOptionPane.INFORMATION_MESSAGE);
			            
			} });
		
		JButton btnNewButton_6 = new JButton("B.U.N");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Old frame = new Old();
                frame.setVisible(true);
                dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        btnNewButton_6.setBackground(Color.GRAY);
        btnNewButton_6.setBounds(798, 0, 76, 23);
		btnNewButton_6.setBounds(257, 10, 105, 34);
		contentPane.add(btnNewButton_6);
	
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 79, 241, 7);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Ch. 3");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9_1_1.setForeground(Color.WHITE);
		lblNewLabel_9_1_1.setBounds(184, 86, 46, 23);
		contentPane.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Ch. 2");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setBounds(117, 86, 46, 23);
		contentPane.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9 = new JLabel("Ch. 1");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(10, 86, 46, 23);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("S C A L E");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 34));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(43, 7, 213, 34);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_2_2 = new JButton("25");
		btnNewButton_2_2.setBounds(95, 45, 51, 23);
		contentPane.add(btnNewButton_2_2);
		btnNewButton_2_2.addActionListener(new ActionListener() {//abracadabra
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setScale(25);
				ct_signal2.setScale(25);
				ct_signal3.setScale(25);
			}});
		
		JButton btnNewButton_2 = new JButton("10");
		btnNewButton_2.setBounds(172, 45, 51, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setScale(10);
				ct_signal2.setScale(10);
				ct_signal3.setScale(10);
			}});
		
		JButton btnNewButton_2_1 = new JButton("50");
		btnNewButton_2_1.setBounds(16, 45, 51, 23);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setScale(50);
				ct_signal2.setScale(50);
				ct_signal3.setScale(50);
			}});
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(Color.DARK_GRAY);
		lblNewLabel_6.setBounds(0, 0, 235, 109);
		lblNewLabel_6.setOpaque(true);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1_1.setBounds(0, 458, 241, 7);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1.setBounds(0, 310, 241, 7);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(184, 396, 39, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton_2_5_1_1 = new JButton("1");
		btnNewButton_2_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setFrequency(1);
			}
		});
		btnNewButton_2_5_1_1.setBounds(179, 199, 51, 23);
		contentPane.add(btnNewButton_2_5_1_1);
		
		JButton btnNewButton_2_3_1_1 = new JButton("5");
		btnNewButton_2_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setFrequency(5);
			}
		});
		btnNewButton_2_3_1_1.setBounds(179, 131, 51, 23);
		contentPane.add(btnNewButton_2_3_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Amplitude");
		lblNewLabel_5_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5_1_1.setBounds(184, 382, 57, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JButton btnNewButton_2_6_1_1_1 = new JButton("5");
		btnNewButton_2_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setAmplitude(5);
			}
		});
		btnNewButton_2_6_1_1_1.setBounds(179, 328, 51, 23);
		contentPane.add(btnNewButton_2_6_1_1_1);
		
		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = textField_3.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal3.setFrequency(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5_1.setBounds(184, 267, 20, 20);
		contentPane.add(btnNewButton_5_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Frequency");
		lblNewLabel_2_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(184, 221, 57, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_2_6_2_1_1 = new JButton("3");
		btnNewButton_2_6_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setAmplitude(3);
			}
		});
		btnNewButton_2_6_2_1_1.setBounds(179, 362, 51, 23);
		contentPane.add(btnNewButton_2_6_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(184, 236, 39, 20);
		contentPane.add(textField_3);
		
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("Tri");
		rdbtnNewRadioButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setWave(2.0);
			}
		});
		rdbtnNewRadioButton_3_1.setOpaque(false);
		rdbtnNewRadioButton_3_1.setBounds(196, 490, 20, 23);
		contentPane.add(rdbtnNewRadioButton_3_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = textField_2.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal3.setAmplitude(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1_1.setBounds(184, 427, 20, 20);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2_4_1_1 = new JButton("2");
		btnNewButton_2_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setFrequency(2);
			}
		});
		btnNewButton_2_4_1_1.setBounds(179, 165, 51, 23);
		contentPane.add(btnNewButton_2_4_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_1 = new JRadioButton("Square");
		rdbtnNewRadioButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setWave(3.0);
			}
		});
		rdbtnNewRadioButton_2_1_1.setOpaque(false);
		rdbtnNewRadioButton_2_1_1.setBounds(196, 559, 20, 23);
		contentPane.add(rdbtnNewRadioButton_2_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Sin");
		rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal3.setWave(1.0);
			}
		});
		rdbtnNewRadioButton_1_1_1.setOpaque(false);
		rdbtnNewRadioButton_1_1_1.setBounds(196, 526, 20, 23);
		contentPane.add(rdbtnNewRadioButton_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setOpaque(true);
		lblNewLabel_7_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_7_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1.setBounds(176, 113, 59, 591);
		contentPane.add(lblNewLabel_7_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Sin");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setWave(1.0);
			}
		});
		rdbtnNewRadioButton_1_1.setOpaque(false);
		rdbtnNewRadioButton_1_1.setBounds(126, 526, 20, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);
		
		JButton btnNewButton_2_4_1 = new JButton("2");
		btnNewButton_2_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setFrequency(2);
			}
		});
		btnNewButton_2_4_1.setBounds(112, 165, 51, 23);
		contentPane.add(btnNewButton_2_4_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Tri");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setWave(2.0);
			}
		});
		rdbtnNewRadioButton_3.setOpaque(false);
		rdbtnNewRadioButton_3.setBounds(126, 490, 20, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = textField.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal2.setFrequency(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5.setBounds(117, 267, 20, 20);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_2_3_1 = new JButton("5");
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setFrequency(5);
			}
		});
		btnNewButton_2_3_1.setBounds(112, 131, 51, 23);
		contentPane.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_6_2_1 = new JButton("3");
		btnNewButton_2_6_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setAmplitude(3);
			}
		});
		btnNewButton_2_6_2_1.setBounds(112, 362, 51, 23);
		contentPane.add(btnNewButton_2_6_2_1);
		
		JButton btnNewButton_2_5_1 = new JButton("1");
		btnNewButton_2_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setFrequency(1);
			}
		});
		btnNewButton_2_5_1.setBounds(112, 199, 51, 23);
		contentPane.add(btnNewButton_2_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Frequency");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(117, 221, 57, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2_6_1_1 = new JButton("5");
		btnNewButton_2_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setAmplitude(5);
			}
		});
		btnNewButton_2_6_1_1.setBounds(112, 328, 51, 23);
		contentPane.add(btnNewButton_2_6_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 236, 39, 20);
		contentPane.add(textField);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Square");
		rdbtnNewRadioButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal2.setWave(3.0);
			}
		});
		rdbtnNewRadioButton_2_1.setOpaque(false);
		rdbtnNewRadioButton_2_1.setBounds(126, 559, 20, 23);
		contentPane.add(rdbtnNewRadioButton_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Amplitude");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5_1.setBounds(117, 382, 57, 14);
		contentPane.add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 396, 39, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = textField_1.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal2.setAmplitude(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1.setBounds(117, 427, 20, 20);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setBackground(Color.DARK_GRAY);
		lblNewLabel_7.setBounds(109, 113, 57, 591);
		contentPane.add(lblNewLabel_7);
		btnNewButton_4.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setBounds(1164, 12, 105, 34);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amplitude");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(10, 382, 57, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Frequency");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 221, 68, 14);
		contentPane.add(lblNewLabel_2);
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.PLAIN, 27));//nu stiu sa fac doua canale asa ca generez 2 unde in acelasi timp si sper sa nu imi strice pc-ul
		btnNewButton_3.setBounds(1156, 559, 113, 34);
		contentPane.add(btnNewButton_3);
		
		amp = new JTextField();
		amp.setColumns(10);
		amp.setBounds(10, 396, 79, 20);
		contentPane.add(amp);
		
		freq = new JTextField();
		freq.setBounds(10, 236, 79, 20);
		contentPane.add(freq);
		freq.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(10, 427, 20, 20);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = amp.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal.setAmplitude(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getValue = freq.getText();
				if(isNumberValid(getValue)) {
					JOptionPane.showMessageDialog( null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(getValue);
					ct_signal.setFrequency(a);
				}else {
					JOptionPane.showMessageDialog( null, "Enter a valid Number",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 267, 20, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2_6_2 = new JButton("3");
		btnNewButton_2_6_2.setBounds(10, 362, 79, 23);
		btnNewButton_2_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal.setAmplitude(3);
			}
		});
		contentPane.add(btnNewButton_2_6_2);
		
		JButton btnNewButton_2_6_1 = new JButton("5");
		btnNewButton_2_6_1.setBounds(10, 328, 79, 23);
		btnNewButton_2_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_signal.setAmplitude(5);
			}
		});
		contentPane.add(btnNewButton_2_6_1);
		
		JButton btnNewButton_2_5 = new JButton("1");
		btnNewButton_2_5.setBounds(10, 199, 79, 23);
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setFrequency(1);
			}});
		contentPane.add(btnNewButton_2_5);
		
		JButton btnNewButton_2_4 = new JButton("2");
		btnNewButton_2_4.setBounds(10, 165, 79, 23);
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setFrequency(2);
			}});
		contentPane.add(btnNewButton_2_4);
		
		JButton btnNewButton_2_3 = new JButton("5");
		btnNewButton_2_3.setBounds(10, 131, 79, 23);
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setFrequency(5);
			}});
		contentPane.add(btnNewButton_2_3);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sin");
		rdbtnNewRadioButton_1.setBounds(83, 527, 20, 23);
		rdbtnNewRadioButton_1.setOpaque(false);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setWave(1.0);

			}});
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Square");
		rdbtnNewRadioButton_2.setBounds(83, 559, 20, 23);
		rdbtnNewRadioButton_2.setOpaque(false);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setWave(3.0);

			}});
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tri");
		rdbtnNewRadioButton.setBounds(83, 490, 20, 23);
		rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				ct_signal.setWave(2.0);
			}});
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("1.png"));
		lblNewLabel_4.setBounds(-15, 484, 89, 109);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 113, 104, 591);
		contentPane.add(lblNewLabel);
		getContentPane().setLayout(null);

		JPanel pn_south = new JPanel();
		pn_south.setBackground(Color.DARK_GRAY);
		pn_south.setBounds(251, 52, 1012, 497);

		getContentPane().add(pn_south);
		pn_south.setLayout(null);
		
				ct_signal = new SignalGraph(25,0,0,1.0,1);
				ct_signal.setBounds(0, 0, 1012, 497);
				ct_signal2 = new SignalGraph(25,0,0,1.0,2);
				ct_signal2.setBounds(0, 0, 1012, 497);
				ct_signal3 = new SignalGraph(25,0,0,1.0,3);
				ct_signal3.setBounds(0, 0, 1012, 497);
				pn_south.add(ct_signal);
				pn_south.add(ct_signal2);
				pn_south.add(ct_signal3);
				//ct_signal.setBackground(Color.LIGHT_GRAY);

		
		/*JLabel lblNewLabel_2 = new JLabel("BUN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(765, -5, 138, 34);
		contentPane.add(lblNewLabel_2);*/
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_2);
        G.add(rdbtnNewRadioButton_1);
        G.clearSelection();
        
        ButtonGroup F = new ButtonGroup();;
        F.add(rdbtnNewRadioButton_3);
        F.add(rdbtnNewRadioButton_1_1);
        F.add(rdbtnNewRadioButton_2_1);
        F.clearSelection();
        
        ButtonGroup A = new ButtonGroup();;
        A.add(rdbtnNewRadioButton_3_1);
        A.add(rdbtnNewRadioButton_1_1_1);
        A.add(rdbtnNewRadioButton_2_1_1);
        A.clearSelection();
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(0, 0, 1279, 704);
		contentPane.add(lblNewLabel_3);
	}
	
	
	public boolean isNumberValid(String a){
		isValidNumber = false;
		if(a.length() > 0) {
			try {
				double nr = Double.parseDouble(a);
				if(nr != Double.NaN) {
					isValidNumber = true;
				}
			} catch(NumberFormatException nfe) {
				isValidNumber = false;
			}
		}
		return isValidNumber;
	}
	}
	


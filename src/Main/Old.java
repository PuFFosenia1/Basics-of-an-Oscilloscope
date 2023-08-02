package Main;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import java.util.*;
import java.io.*;

import javax.swing.border.EmptyBorder;


import ex02_oscilloscope.SignalGraph;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Old extends JFrame {

    private JPanel contentPane;
    private SignalGraph ct_signal;
    private JScrollBar sb_frecuency, sb_amplitude;
    private JTextField freq;
    private JTextField amp;
    private boolean isValidNumber = false;
    //private double wave;

    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Old frame = new Old();
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
    public Old() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 550);
        setLocation(550, 200);
        setTitle("Oscilloscope - Old");
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

        JButton btnNewButton_4 = new JButton("H E L P");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "The order of the buttons:"
                                + "\n1st - Scale of the Oscilloscope"
                                + "\n2nd - Frequency of the Oscilloscope"
                                + "\n3rd - Amplitude of the Oscilloscope"
                                + "\n\nValues per division:"
                                + "\n5 V/div"
                                + "\n"
                                + "5 ms/div", "H E L P", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton btnNewButton_5 = new JButton("B.U.N.");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Oscilloscope frame = new Oscilloscope();
				frame.setVisible(true);
				dispose();
        	}
        });
        btnNewButton_5.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
        btnNewButton_5.setOpaque(true);
        btnNewButton_5.setBackground(Color.GRAY);
        btnNewButton_5.setBounds(149, 0, 89, 23);
        contentPane.add(btnNewButton_5);
        btnNewButton_4.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
        btnNewButton_4.setBackground(Color.GRAY);
        btnNewButton_4.setBounds(798, 0, 76, 23);
        contentPane.add(btnNewButton_4);

        JLabel lblNewLabel_5 = new JLabel("Amplitude");
        lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_5.setBounds(10, 339, 57, 14);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_2 = new JLabel("Frequency");
        lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_2.setBounds(10, 221, 68, 14);
        contentPane.add(lblNewLabel_2);
        btnNewButton_3.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
        btnNewButton_3.setBounds(748, 456, 113, 34);
        contentPane.add(btnNewButton_3);

        amp = new JTextField();
        amp.setColumns(10);
        amp.setBounds(10, 353, 76, 20);
        contentPane.add(amp);

        freq = new JTextField();
        freq.setBounds(10, 236, 76, 20);
        contentPane.add(freq);
        freq.setColumns(10);

        ButtonGroup G = new ButtonGroup();

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBounds(96, 352, 20, 20);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String getValue = amp.getText();
                if (isNumberValid(getValue)) {
                    JOptionPane.showMessageDialog(null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
                    double a = Double.parseDouble(getValue);
                    ct_signal.setAmplitude(a);
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid Number",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        contentPane.add(btnNewButton_1);

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String getValue = freq.getText();
                if (isNumberValid(getValue)) {
                    JOptionPane.showMessageDialog(null, "The number is valid", "Correct", JOptionPane.INFORMATION_MESSAGE);
                    double a = Double.parseDouble(getValue);
                    ct_signal.setFrequency(a);
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid Number",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(96, 236, 20, 20);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1.setOpaque(true);
        lblNewLabel_1_1_1.setBackground(Color.GRAY);
        lblNewLabel_1_1_1.setBounds(0, 384, 121, 7);
        contentPane.add(lblNewLabel_1_1_1);

        JButton btnNewButton_2_6_2 = new JButton("3");
        btnNewButton_2_6_2.setBounds(0, 319, 121, 23);
        btnNewButton_2_6_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setAmplitude(3);
            }
        });
        contentPane.add(btnNewButton_2_6_2);

        JButton btnNewButton_2_6_1 = new JButton("5");
        btnNewButton_2_6_1.setBounds(0, 285, 121, 23);
        btnNewButton_2_6_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setAmplitude(5);
            }
        });
        contentPane.add(btnNewButton_2_6_1);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setOpaque(true);
        lblNewLabel_1_1.setBackground(Color.GRAY);
        lblNewLabel_1_1.setBounds(0, 267, 121, 7);
        contentPane.add(lblNewLabel_1_1);

        JButton btnNewButton_2_5 = new JButton("1");
        btnNewButton_2_5.setBounds(0, 199, 121, 23);
        btnNewButton_2_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setFrequency(1);
            }
        });
        contentPane.add(btnNewButton_2_5);

        JButton btnNewButton_2_4 = new JButton("2");
        btnNewButton_2_4.setBounds(0, 165, 121, 23);
        btnNewButton_2_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setFrequency(2);
            }
        });
        contentPane.add(btnNewButton_2_4);

        JButton btnNewButton_2_3 = new JButton("5");
        btnNewButton_2_3.setBounds(0, 131, 121, 23);
        btnNewButton_2_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setFrequency(5);
            }
        });
        contentPane.add(btnNewButton_2_3);

        JButton btnNewButton_2 = new JButton("10");
        btnNewButton_2.setBounds(0, 79, 121, 23);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setScale(10);
            }
        });

        JButton btnNewButton_2_2 = new JButton("25");
        btnNewButton_2_2.setBounds(0, 45, 121, 23);
        contentPane.add(btnNewButton_2_2);
        btnNewButton_2_2.addActionListener(new ActionListener() {//abracadabra
            public void actionPerformed(ActionEvent e) {
                ct_signal.setScale(25);
            }
        });

        JButton btnNewButton_2_1 = new JButton("50");
        btnNewButton_2_1.setBounds(0, 11, 121, 23);
        contentPane.add(btnNewButton_2_1);
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setScale(50);
            }
        });

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sin");
        rdbtnNewRadioButton_1.setBounds(84, 448, 20, 23);
        rdbtnNewRadioButton_1.setOpaque(false);
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setWave(1.0);

            }
        });
        contentPane.add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Square");
        rdbtnNewRadioButton_2.setBounds(84, 481, 20, 23);
        rdbtnNewRadioButton_2.setOpaque(false);
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setWave(3.0);

            }
        });
        contentPane.add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Tri");
        rdbtnNewRadioButton.setBounds(84, 412, 20, 23);
        rdbtnNewRadioButton.setOpaque(false);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ct_signal.setWave(2.0);
            }
        });
        contentPane.add(rdbtnNewRadioButton);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("1.png"));
        lblNewLabel_4.setBounds(-11, 402, 89, 109);
        contentPane.add(lblNewLabel_4);


        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.GRAY);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBounds(0, 113, 121, 7);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(Color.DARK_GRAY);
        lblNewLabel.setBounds(0, 0, 121, 511);
        contentPane.add(lblNewLabel);

        ct_signal = new SignalGraph(25, 0, 0, 1.0, 1);
        ct_signal.setBackground(Color.LIGHT_GRAY);
        ct_signal.setBounds(149, 29, 712, 416);
        getContentPane().setLayout(null);
        getContentPane().add(ct_signal);

        JPanel pn_south = new JPanel();
        pn_south.setBackground(Color.DARK_GRAY);
        pn_south.setBounds(149, 29, 712, 416);

        getContentPane().add(pn_south);
        pn_south.setLayout(null);

//My hero
       /* JLabel lblNewLabel_3 = new JLabel("BUN");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblNewLabel_3.setBounds(150, -5, 138, 34);
        contentPane.add(lblNewLabel_3);*/

        G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_2);
        G.add(rdbtnNewRadioButton_1);
        G.clearSelection();

        JLabel lblNewLabel_55 = new JLabel("");
        lblNewLabel_55.setBackground(Color.GRAY);
        lblNewLabel_55.setOpaque(true);
        lblNewLabel_55.setBounds(119, 0, 765, 511);
        contentPane.add(lblNewLabel_55);
    }


    public boolean isNumberValid(String a) {
        isValidNumber = false;
        if (a.length() > 0) {
            try {
                double nr = Double.parseDouble(a);
                if (nr != Double.NaN) {
                    isValidNumber = true;
                }
            } catch (NumberFormatException nfe) {
                isValidNumber = false;
            }
        }
        return isValidNumber;
    }
}
	



package com.koroliuk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EricCartmansPhrases {

	private JFrame frame;
	private JTextArea txtTitle = new JTextArea();
	private JTextArea txtPhrase01 = new JTextArea();
	private JTextArea txtPhrase02 = new JTextArea();
	private JTextArea txtPhrase03 = new JTextArea();

	public static void main(String[] args) throws SecurityException, IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EricCartmansPhrases window = new EricCartmansPhrases();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public EricCartmansPhrases() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(600, 400, 579, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEnButtton = new JButton("English");
		btnEnButtton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldsLocale(btnEnButtton.getText());
				changeVisibleOfTextFields();
			}
		});

		btnEnButtton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnButtton.setForeground(new Color(255, 255, 255));
		btnEnButtton.setBackground(new Color(135, 206, 250));
		btnEnButtton.setBounds(78, 28, 89, 23);
		frame.getContentPane().add(btnEnButtton);

		JButton btnDeButton = new JButton("Deutsch");
		btnDeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldsLocale(btnDeButton.getText());
				changeVisibleOfTextFields();
			}
		});

		btnDeButton.setForeground(new Color(255, 255, 255));
		btnDeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeButton.setBackground(new Color(135, 206, 250));
		btnDeButton.setBounds(238, 28, 89, 23);
		frame.getContentPane().add(btnDeButton);

		JButton btnRuButton = new JButton("\u0420\u0443\u0441\u0441\u043A\u0438\u0439");
		btnRuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldsLocale(btnRuButton.getText());
				changeVisibleOfTextFields();
			}
		});

		btnRuButton.setForeground(new Color(255, 255, 255));
		btnRuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRuButton.setBackground(new Color(135, 206, 250));
		btnRuButton.setBounds(399, 28, 89, 23);
		frame.getContentPane().add(btnRuButton);

		JLabel lblCartmanLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Cartman-icon.png")).getImage();
		lblCartmanLabel.setIcon(new ImageIcon(img));
		lblCartmanLabel.setBounds(33, 116, 134, 149);
		frame.getContentPane().add(lblCartmanLabel);

		txtTitle.setForeground(Color.WHITE);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		txtTitle.setBackground(Color.GRAY);
		txtTitle.setBounds(171, 87, 363, 23);
		txtTitle.setVisible(false);
		frame.getContentPane().add(txtTitle);

		txtPhrase01.setForeground(Color.WHITE);
		txtPhrase01.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtPhrase01.setBackground(Color.GRAY);
		txtPhrase01.setBounds(209, 137, 325, 30);
		txtPhrase01.setVisible(false);
		frame.getContentPane().add(txtPhrase01);

		txtPhrase02.setForeground(Color.WHITE);
		txtPhrase02.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtPhrase02.setBackground(Color.GRAY);
		txtPhrase02.setBounds(209, 178, 325, 30);
		txtPhrase02.setVisible(false);
		frame.getContentPane().add(txtPhrase02);

		txtPhrase03.setForeground(Color.WHITE);
		txtPhrase03.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtPhrase03.setBackground(Color.GRAY);
		txtPhrase03.setBounds(209, 217, 325, 30);
		txtPhrase03.setVisible(false);
		frame.getContentPane().add(txtPhrase03);
	}

	private void changeVisibleOfTextFields() {
		txtTitle.setVisible(true);
		txtPhrase01.setVisible(true);
		txtPhrase02.setVisible(true);
		txtPhrase03.setVisible(true);
	}

	private void txtFieldsLocale(String s) {
		String lang = "";
		String country = "";

		if (s.equals("English")) {
			lang = "en";
			country = "EN";
		}
		if (s.equals("\u0420\u0443\u0441\u0441\u043A\u0438\u0439")) {
			lang = "ru";
			country = "RU";
		}
		if (s.equals("Deutsch")) {
			lang = "de";
			country = "DE";
		}

		Locale currentLocale = new Locale(lang, country);
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

		txtTitle.setText(messages.getString("phrase01"));
		txtPhrase01.setText(messages.getString("phrase02"));
		txtPhrase02.setText(messages.getString("phrase03"));
		txtPhrase03.setText(messages.getString("phrase04"));

		try (FileWriter writer = new FileWriter("ericCartmansPhrasesLog.txt", true);) {
			writer.write(messages.getString("phrase02") + " : " + messages.getString("phrase03") + " : "
				+ messages.getString("phrase04") + '\n');
		} catch (Exception e) {
		}

	}

}

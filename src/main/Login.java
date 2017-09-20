package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldUsername;
	private JPasswordField jPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("SMS Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSchoolManagementSystem = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblSchoolManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSchoolManagementSystem.setBounds(133, 0, 385, 68);
		contentPane.add(lblSchoolManagementSystem);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(47, 83, 78, 35);
		contentPane.add(lblNewLabel);
		
		jTextFieldUsername = new JTextField();
		jTextFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldUsername.setBounds(133, 85, 429, 35);
		contentPane.add(jTextFieldUsername);
		jTextFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(51, 131, 74, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton JButtonLogin = new JButton("LOGIN");
		JButtonLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButtonLogin.setBounds(133, 202, 205, 35);
		contentPane.add(JButtonLogin);
		
		JButton JButtonCancel = new JButton("CANCEL");
		JButtonCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButtonCancel.setBounds(357, 202, 205, 35);
		contentPane.add(JButtonCancel);
		
		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(133, 133, 429, 35);
		contentPane.add(jPasswordField);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\AkasakaTien\\Pictures\\Categories-applications-education-university-icon.png"));
		label.setBounds(37, 0, 84, 80);
		contentPane.add(label);
	}
}

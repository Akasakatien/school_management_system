package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AccountDAO;
import entities.Account;
import helper.EncryptPasswordWithPBKDF2WithHmacSHA1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldUsername;
	private JPasswordField JPasswordFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 260);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel(" SCHOOL MAGAGEMENT");
		lblLogin.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\iconEdu.png"));
		lblLogin.setForeground(new Color(211, 211, 211));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogin.setBounds(17, 6, 426, 56);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(211, 211, 211));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(69, 66, 85, 28);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(69, 110, 78, 28);
		contentPane.add(lblPassword);
		
		JTextFieldUsername = new JTextField();
		JTextFieldUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldUsername.setBackground(SystemColor.controlHighlight);
		JTextFieldUsername.setBounds(153, 66, 219, 30);
		contentPane.add(JTextFieldUsername);
		JTextFieldUsername.setColumns(10);
		
		JPasswordFieldPassword = new JPasswordField();
		JPasswordFieldPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JPasswordFieldPassword.setBackground(SystemColor.controlHighlight);
		JPasswordFieldPassword.setBounds(153, 110, 219, 30);
		contentPane.add(JPasswordFieldPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(new Color(211, 211, 211));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButtonLoginActionPerform(arg0);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(140, 167, 89, 28);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Cancel");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnRegister.setForeground(new Color(211, 211, 211));
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(242, 167, 89, 28);
		contentPane.add(btnRegister);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label.setBounds(0, 0, 464, 213);
		contentPane.add(label);
	}
	private void JButtonLoginActionPerform(ActionEvent actionEvent){
		try {
			AccountDAO accountDAO = new AccountDAO();
			
			String username = JTextFieldUsername.getText();
			String password = String.valueOf(JPasswordFieldPassword.getPassword());
			Account account = accountDAO.find(username);
			if(account != null){
				if(!EncryptPasswordWithPBKDF2WithHmacSHA1.validatePassword(password, account.getPassword())){
					System.out.println("loi ngay day");
				}else{
					this.setVisible(false);
					JFrameMain jFrameMain = new JFrameMain();
					jFrameMain.assingMenu(username);
					
					jFrameMain.username = username;
					jFrameMain.loadData();
					jFrameMain.setVisible(true);				}
			}else{
				System.out.println("ngay day");
			}
			//account = accountDAO.Login(username, password);
//			if(account == null){
//				JLabelMessenger.setText("Account's Invalid");
//			}else{
//				this.setVisible(false);
//				JFrameMain jFrameMain = new JFrameMain();
//				jFrameMain.assingMenu(username);
//				
//				jFrameMain.username = username;
//				jFrameMain.loadData();
//				jFrameMain.setVisible(true);
//			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Looiii");
		}
		
	
	}
}

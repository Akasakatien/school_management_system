package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AccountDAO;
import entities.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;

public class JFrameEditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldUsername;
	private JPasswordField JPasswordFieldPassword;
	private JTextField JTextFieldEmail;
	private File file = null;
	private JLabel JLabelPhoto;
	private JTextField JTextFieldFullname;
	boolean flag = true;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEditProfile frame = new JFrameEditProfile();
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
	public JFrameEditProfile() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Username");
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(49, 68, 85, 19);
		contentPane.add(label);

		JTextFieldUsername = new JTextField();
		JTextFieldUsername.setBackground(Color.GRAY);
		JTextFieldUsername.setEditable(false);
		JTextFieldUsername.setColumns(10);
		JTextFieldUsername.setBounds(153, 62, 285, 33);
		contentPane.add(JTextFieldUsername);

		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(49, 114, 103, 19);
		contentPane.add(label_1);

		JPasswordFieldPassword = new JPasswordField();
		JPasswordFieldPassword.setBackground(SystemColor.controlHighlight);
		JPasswordFieldPassword.setBounds(153, 108, 285, 33);
		contentPane.add(JPasswordFieldPassword);

		JLabel label_2 = new JLabel("Email");
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(49, 440, 103, 19);
		contentPane.add(label_2);

		JTextFieldEmail = new JTextField();
		JTextFieldEmail.setBackground(SystemColor.controlHighlight);
		JTextFieldEmail.setColumns(10);
		JTextFieldEmail.setBounds(153, 434, 285, 33);
		contentPane.add(JTextFieldEmail);

		JButton button = new JButton("Save");
		button.setFont(new Font("SansSerif", Font.PLAIN, 16));
		button.setForeground(new Color(211, 211, 211));
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountDAO accountDAO = new AccountDAO();
				Account account = accountDAO.find(JFrameMain.username);
				String password = String.valueOf(JPasswordFieldPassword.getPassword());
				if (!password.isEmpty()) {
					account.setPassword(password);
				}
				if( flag == false){
					account.setPhoto(ConvertFile(file.getAbsolutePath()));
				}
				
				account.setEmail(JTextFieldEmail.getText());
				account.setFullName(JTextFieldFullname.getText());
				try {
					accountDAO.update(account);
					JOptionPane.showMessageDialog(null, "success");
					
					

				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Fail");
				}
				JFrameMain jFrameMain = new JFrameMain();
				setVisible(false);
				//jFrameMain.setVisible(false);
				jFrameMain.loadData();
				jFrameMain.setVisible(true);
			}
		});
		button.setBounds(153, 480, 102, 33);
		contentPane.add(button);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnCancel.setForeground(new Color(211, 211, 211));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(263, 479, 103, 34);
		contentPane.add(btnCancel);

		JLabel lblEditProfile = new JLabel("Edit Profile");
		lblEditProfile.setForeground(new Color(211, 211, 211));
		lblEditProfile.setIcon(null);
		lblEditProfile.setBackground(new Color(255, 255, 255));
		lblEditProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditProfile.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEditProfile.setBounds(0, 0, 514, 49);
		contentPane.add(lblEditProfile);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setForeground(new Color(211, 211, 211));
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoto.setBounds(49, 210, 103, 23);
		contentPane.add(lblPhoto);

		JLabelPhoto = new JLabel("");
		JLabelPhoto.setBorder(new LineBorder(Color.GRAY));
		JLabelPhoto.setBounds(153, 210, 200, 200);
		contentPane.add(JLabelPhoto);

		JButton btnBrowes = new JButton("Browes..");
		btnBrowes.setForeground(new Color(211, 211, 211));
		btnBrowes.setBackground(Color.BLACK);
		btnBrowes.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBrowes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = false;
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select Photo");
				chooser.setMultiSelectionEnabled(false);
				chooser.setFileFilter(new dao.FileTypeFilter(".jpg", "JPG"));
				chooser.setFileFilter(new dao.FileTypeFilter(".jpeg", "JPEG"));
				chooser.setFileFilter(new dao.FileTypeFilter(".gif", "GIF"));
				chooser.setFileFilter(new dao.FileTypeFilter(".png", "PNG"));
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
							.getScaledInstance(173, 101, Image.SCALE_DEFAULT));
					JLabelPhoto.setIcon(imageIcon);
				}
			}
		});
		btnBrowes.setBounds(353, 378, 85, 33);
		contentPane.add(btnBrowes);

		JLabel blbFullname = new JLabel("Full name");
		blbFullname.setForeground(new Color(211, 211, 211));
		blbFullname.setFont(new Font("Tahoma", Font.BOLD, 16));
		blbFullname.setBounds(49, 158, 103, 23);
		contentPane.add(blbFullname);

		JTextFieldFullname = new JTextField();
		JTextFieldFullname.setBackground(SystemColor.controlHighlight);
		JTextFieldFullname.setColumns(10);
		JTextFieldFullname.setBounds(153, 154, 285, 33);
		contentPane.add(JTextFieldFullname);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label_3.setBounds(0, 0, 514, 49);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_4.setBounds(0, 48, 514, 486);
		contentPane.add(label_4);
		loadData();
	}

	public void loadData() {
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.find(JFrameMain.username);
		JTextFieldUsername.setText(account.getUsername());
		JTextFieldEmail.setText(account.getEmail());
		JTextFieldFullname.setText(account.getFullName());
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(account.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		JLabelPhoto.setIcon(imageIcon);

	}

	private byte[] ConvertFile(String fileName) {
		FileInputStream fileInputStream = null;
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			bFile = null;
		}
		return bFile;
	}
}

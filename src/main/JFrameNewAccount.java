package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import dao.AccountDAO;
import dao.RoleDAO;
import entities.Account;
import entities.Role;
import helper.EncryptPasswordWithPBKDF2WithHmacSHA1;

import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrameNewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldUsername;
	private JTextField JTextFieldFullName;
	private JTextField JTextFieldEmail;
	private JPasswordField JPasswordFieldPassword;
	private JLabel JLabelPhoto;
	private JComboBox JComboBoxRole;
	private File file = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNewAccount frame = new JFrameNewAccount();
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
	public JFrameNewAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		panel.setBounds(20, 67, 409, 536);
		contentPane.add(panel);

		JLabel label = new JLabel("Username");
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(29, 11, 90, 24);
		panel.add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(29, 58, 90, 24);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Full name");
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(29, 106, 90, 24);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Email");
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(29, 448, 63, 24);
		panel.add(label_3);

		JLabel label_5 = new JLabel("Role");
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setFont(new Font("Dialog", Font.BOLD, 16));
		label_5.setBounds(29, 494, 63, 24);
		panel.add(label_5);

		JTextFieldUsername = new JTextField();
		JTextFieldUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldUsername.setBackground(SystemColor.controlHighlight);
		JTextFieldUsername.setColumns(10);
		JTextFieldUsername.setBounds(131, 7, 254, 34);
		panel.add(JTextFieldUsername);

		JTextFieldFullName = new JTextField();
		JTextFieldFullName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldFullName.setBackground(SystemColor.controlHighlight);
		JTextFieldFullName.setColumns(10);
		JTextFieldFullName.setBounds(131, 102, 254, 34);
		panel.add(JTextFieldFullName);

		JTextFieldEmail = new JTextField();
		JTextFieldEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldEmail.setBackground(SystemColor.controlHighlight);
		JTextFieldEmail.setColumns(10);
		JTextFieldEmail.setBounds(131, 444, 254, 34);
		panel.add(JTextFieldEmail);

		JPasswordFieldPassword = new JPasswordField();
		JPasswordFieldPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JPasswordFieldPassword.setBackground(SystemColor.controlHighlight);
		JPasswordFieldPassword.setBounds(131, 54, 254, 34);
		panel.add(JPasswordFieldPassword);

		JComboBoxRole = new JComboBox();
		JComboBoxRole.setBackground(Color.GRAY);
		JComboBoxRole.setBounds(131, 491, 254, 32);
		panel.add(JComboBoxRole);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setForeground(new Color(211, 211, 211));
		lblPhoto.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhoto.setBounds(29, 149, 63, 24);
		panel.add(lblPhoto);

		JLabelPhoto = new JLabel("");
		JLabelPhoto.setBorder(new LineBorder(Color.GRAY));
		JLabelPhoto.setBounds(131, 149, 254, 254);
		panel.add(JLabelPhoto);

		JButton btnNewButton = new JButton("Brower...");
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							.getScaledInstance(254, 254, Image.SCALE_DEFAULT));
					JLabelPhoto.setIcon(imageIcon);
				}
			}
		});
		btnNewButton.setBounds(292, 406, 93, 25);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Add new account");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 453, 54);
		contentPane.add(lblNewLabel);
		
				JButton btnAdd = new JButton("Add ");
				btnAdd.setForeground(new Color(211, 211, 211));
				btnAdd.setBackground(Color.BLACK);
				btnAdd.setBounds(226, 616, 99, 35);
				contentPane.add(btnAdd);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							AccountDAO accountDAO = new AccountDAO();
							RoleDAO roleDAO = new RoleDAO();
							Account account = new Account();
							int selectedIndex = JComboBoxRole.getSelectedIndex();
							Role role = roleDAO.findAll().get(selectedIndex);
							account.setRole(role);
							account.setUsername(JTextFieldUsername.getText());
							account.setPassword(EncryptPasswordWithPBKDF2WithHmacSHA1
									.generateStorngPasswordHash(String.valueOf(
											JPasswordFieldPassword.getPassword())));
							account.setFullName(JTextFieldFullName.getText());
							account.setEmail(JTextFieldEmail.getText());
							account.setPhoto(ConvertFile(file.getAbsolutePath()));
							accountDAO.create(account);
							JOptionPane.showMessageDialog(null, "Add new account successfull");
							JFrameManagementAccout jFrameManagementAccout = new JFrameManagementAccout();
							jFrameManagementAccout.loadData();
							jFrameManagementAccout.setVisible(true);
							setVisible(false);
							
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Can't add new account");
						}
						
						
					}
				});
				btnAdd.setFont(new Font("Dialog", Font.PLAIN, 16));
				
						JButton btnCancel = new JButton("Cancel");
						btnCancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
								switch (result){
									case 0:
										setVisible(false);
										JFrameManagementAccout jFrameManagementAccout = new JFrameManagementAccout();
										jFrameManagementAccout.loadData();
										jFrameManagementAccout.setVisible(true);
										break;
									case 1:
										
										break;
									}
							}
						});
						btnCancel.setForeground(new Color(211, 211, 211));
						btnCancel.setBackground(Color.BLACK);
						btnCancel.setBounds(326, 616, 89, 35);
						contentPane.add(btnCancel);
						btnCancel.setFont(new Font("Dialog", Font.PLAIN, 16));
						
						JLabel label_4 = new JLabel("");
						label_4.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
						label_4.setBounds(0, 0, 453, 54);
						contentPane.add(label_4);
						
						JLabel label_6 = new JLabel("");
						label_6.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
						label_6.setBounds(0, 54, 453, 610);
						contentPane.add(label_6);
		loadData();
	}

	public void loadData() {
		AccountDAO accountDAO = new AccountDAO();
		RoleDAO roleDAO = new RoleDAO();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Role role : roleDAO.findAll()) {
			defaultComboBoxModel.addElement(role.getName());
		}
		JComboBoxRole.setModel(defaultComboBoxModel);
		JComboBoxRole.setSelectedIndex(0);
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

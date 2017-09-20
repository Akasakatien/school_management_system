package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dao.AccountDAO;
import dao.RoleDAO;

import entities.Account;
import entities.Role;
import helper.EncryptPasswordWithPBKDF2WithHmacSHA1;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameUpdateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldUsername;
	private JTextField JTextFieldFullname;
	private JTextField JTextFieldEmail;
	private JPasswordField JPasswordFieldPassword;
	private JComboBox JComboBoxRole;
	private JLabel JLabelPhoto;
	private File file = null;
	private JButton JButtonChange;
	private boolean flag = false;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// JFrameUpdateAccount frame = new JFrameUpdateAccount();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public JFrameUpdateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Update Account Infomation", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(153, 180, 209)));
		panel.setBounds(36, 57, 412, 563);
		contentPane.add(panel);

		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setForeground(new Color(211, 211, 211));
		label.setBounds(31, 25, 90, 28);
		panel.add(label);

		JTextFieldUsername = new JTextField();
		JTextFieldUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldUsername.setBackground(SystemColor.controlHighlight);
		JTextFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldUsername.setForeground(new Color(95, 158, 160));
		JTextFieldUsername.setEditable(false);
		JTextFieldUsername.setColumns(10);
		JTextFieldUsername.setBounds(122, 23, 254, 35);
		panel.add(JTextFieldUsername);

		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setBounds(31, 74, 90, 28);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Full name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setBounds(31, 122, 90, 28);
		panel.add(label_2);

		JTextFieldFullname = new JTextField();
		JTextFieldFullname.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldFullname.setBackground(SystemColor.controlHighlight);
		JTextFieldFullname.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldFullname.setForeground(new Color(95, 158, 160));
		JTextFieldFullname.setColumns(10);
		JTextFieldFullname.setBounds(122, 120, 254, 35);
		panel.add(JTextFieldFullname);

		JLabel label_3 = new JLabel("Email");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setBounds(31, 473, 90, 20);
		panel.add(label_3);

		JTextFieldEmail = new JTextField();
		JTextFieldEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldEmail.setBackground(SystemColor.controlHighlight);
		JTextFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldEmail.setForeground(new Color(95, 158, 160));
		JTextFieldEmail.setColumns(10);
		JTextFieldEmail.setBounds(122, 467, 254, 35);
		panel.add(JTextFieldEmail);

		JLabel label_5 = new JLabel("Role");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setBounds(31, 521, 90, 20);
		panel.add(label_5);

		JPasswordFieldPassword = new JPasswordField();
		JPasswordFieldPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JPasswordFieldPassword.setBackground(SystemColor.controlHighlight);
		JPasswordFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		JPasswordFieldPassword.setForeground(new Color(95, 158, 160));
		JPasswordFieldPassword.setBounds(122, 72, 254, 35);
		panel.add(JPasswordFieldPassword);

		JComboBoxRole = new JComboBox();
		JComboBoxRole.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JComboBoxRole.setBackground(Color.GRAY);
		JComboBoxRole.setBounds(122, 515, 254, 35);
		panel.add(JComboBoxRole);

		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoto.setForeground(new Color(211, 211, 211));
		lblPhoto.setBounds(31, 170, 90, 28);
		panel.add(lblPhoto);

		JLabelPhoto = new JLabel("");
		JLabelPhoto.setBorder(new LineBorder(Color.GRAY));
		JLabelPhoto.setBounds(122, 170, 254, 254);
		panel.add(JLabelPhoto);

		JButtonChange = new JButton("Change..");
		JButtonChange.setForeground(new Color(211, 211, 211));
		JButtonChange.setBackground(Color.BLACK);
		JButtonChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = true;
				
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
		JButtonChange.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButtonChange.setBounds(278, 426, 98, 28);
		panel.add(JButtonChange);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_6.setBounds(0, 0, 412, 563);
		panel.add(label_6);
		
				JButton button = new JButton("Update");
				button.setForeground(new Color(211, 211, 211));
				button.setBackground(Color.BLACK);
				button.setBounds(255, 633, 96, 35);
				contentPane.add(button);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							AccountDAO accountDAO = new AccountDAO();
							RoleDAO roleDAO = new RoleDAO();
							Account accounts = accountDAO.find(JTextFieldUsername.getText());
							int selectedIndex = JComboBoxRole.getSelectedIndex();
							String password = String.valueOf(JPasswordFieldPassword.getPassword());
							if (!password.isEmpty()) {
								accounts.setPassword(
										EncryptPasswordWithPBKDF2WithHmacSHA1.generateStorngPasswordHash(password));
							}
							accounts.setEmail(JTextFieldEmail.getText());
							accounts.setFullName(JTextFieldFullname.getText());
							 if (flag == true ) {
							 accounts.setPhoto(ConvertFile(file.getAbsolutePath()));
							 }

							accounts.setRole(roleDAO.findAll().get(selectedIndex));
							accountDAO.update(accounts);
							JOptionPane.showMessageDialog(null, " Update information account successfull");
							JFrameManagementAccout jFrameManagementAccout = new JFrameManagementAccout();
							jFrameManagementAccout.loadData();
							jFrameManagementAccout.setVisible(true);
							setVisible(false);
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Loc sai rooi ~^");
						}

					}
				});
				button.setFont(new Font("Tahoma", Font.PLAIN, 16));
				button.setActionCommand("OK");
				
						JButton button_1 = new JButton("Cancel");
						button_1.setForeground(new Color(211, 211, 211));
						button_1.setBackground(Color.BLACK);
						button_1.setBounds(352, 633, 96, 35);
						contentPane.add(button_1);
						button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						button_1.setActionCommand("Cancel");
						
						JLabel lblUpdateAccount = new JLabel("Update Account");
						lblUpdateAccount.setForeground(new Color(211, 211, 211));
						lblUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 35));
						lblUpdateAccount.setHorizontalAlignment(SwingConstants.CENTER);
						lblUpdateAccount.setBounds(0, 0, 489, 54);
						contentPane.add(lblUpdateAccount);
						
						JLabel label_4 = new JLabel("");
						label_4.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
						label_4.setBounds(0, 0, 489, 54);
						contentPane.add(label_4);
						
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
						lblNewLabel.setBounds(0, 49, 489, 633);
						contentPane.add(lblNewLabel);
	}

	public void loadData() {
		AccountDAO accountDAO = new AccountDAO();
		RoleDAO roleDAO = new RoleDAO();
		Account account = accountDAO.find(JFrameManagementAccout.userName);

		JTextFieldUsername.setText(account.getUsername());
		JTextFieldFullname.setText(account.getFullName());
		JTextFieldEmail.setText(account.getEmail());
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(account.getPhoto()).getImage().getScaledInstance(254, 254, Image.SCALE_DEFAULT));

		JLabelPhoto.setIcon(imageIcon);

		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Role role : roleDAO.findAll()) {
			defaultComboBoxModel.addElement(role.getName());
		}
		JComboBoxRole.setModel(defaultComboBoxModel);
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

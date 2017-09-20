package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import dao.AccountDAO;
import entities.Account;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.DebugGraphics;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JMenu jMenuSystem;
	public static String username;
	private JLabel jLabelPhotoUser;
	private JLabel JLabelFullname;
	private JLabel JLabelUsername;
	private JButton jButtonStaff;
	private JButton jButtonClass;
	private JButton jButtonSubject;
	private JButton jButtonGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("School Management\r\n");
		setResizable(false);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 690);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		menuBar.setForeground(new Color(220, 220, 220));
		setJMenuBar(menuBar);
		
		jMenuSystem = new JMenu("Admin");
		jMenuSystem.setVisible(false);
		jMenuSystem.setEnabled(false);
		jMenuSystem.setBackground(Color.DARK_GRAY);
		jMenuSystem.setForeground(new Color(0, 0, 0));
		jMenuSystem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(jMenuSystem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Account Management");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameManagementAccout jFrameManagementAccout = new JFrameManagementAccout();
				jFrameManagementAccout.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jMenuSystem.add(mntmNewMenuItem);
		
		JMenuItem jMenuItemLogout = new JMenuItem("Logout");
		jMenuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrameLogin jFrameLogin = new JFrameLogin();
				jFrameLogin.setVisible(true);
			}
		});
		jMenuItemLogout.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jMenuSystem.add(jMenuItemLogout);
		
		JMenuItem jMenuItemExit = new JMenuItem("Exit");
		jMenuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jMenuItemExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jMenuSystem.add(jMenuItemExit);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(12, 13, 913, 136);
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 0, true));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\edu_icon_60w_icon.ico"));
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 46));
		lblNewLabel_2.setBounds(59, 20, 786, 110);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(272, 167, 653, 440);
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 0, true));
		
		jButtonStaff = new JButton("STAFF");
		jButtonStaff.setEnabled(false);
		jButtonStaff.setForeground(new Color(211, 211, 211));
		jButtonStaff.setBackground(Color.BLACK);
		jButtonStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jFrameStaffInfor jFrameStaffInfor = new jFrameStaffInfor();
				jFrameStaffInfor.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		jButtonStaff.setBounds(11, 153, 309, 128);
		jButtonStaff.setMargin(new Insets(2, 14, 2, 40));
		jButtonStaff.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JButton jButtonMark = new JButton("MARK");
		jButtonMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameManagementMarks jFrameManagementMarks = new JFrameManagementMarks();
				jFrameManagementMarks.setVisible(true);
			}
		});
		jButtonMark.setForeground(new Color(211, 211, 211));
		jButtonMark.setBackground(Color.BLACK);
		jButtonMark.setBounds(332, 13, 309, 128);
		jButtonMark.setMargin(new Insets(2, 14, 2, 37));
		jButtonMark.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		jButtonClass = new JButton("CLASS");
		jButtonClass.setEnabled(false);
		jButtonClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameManagementClass jFrameManagementClass = new JFrameManagementClass();
				jFrameManagementClass.setVisible(true);
			}
		});
		jButtonClass.setForeground(new Color(211, 211, 211));
		jButtonClass.setBackground(Color.BLACK);
		jButtonClass.setBounds(332, 153, 309, 128);
		jButtonClass.setMargin(new Insets(2, 14, 2, 33));
		jButtonClass.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		jButtonGrade = new JButton("GRADE");
		jButtonGrade.setEnabled(false);
		jButtonGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameManagementGrade jFrameManagementGrade = new JFrameManagementGrade();
				jFrameManagementGrade.setVisible(true);
			}
		});
		jButtonGrade.setForeground(new Color(211, 211, 211));
		jButtonGrade.setBackground(Color.BLACK);
		jButtonGrade.setBounds(11, 294, 309, 128);
		jButtonGrade.setMargin(new Insets(2, 14, 2, 26));
		jButtonGrade.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		jButtonSubject = new JButton("SUBJECT");
		jButtonSubject.setEnabled(false);
		jButtonSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameManagementSubjects jFrameManagementSubjects = new JFrameManagementSubjects();
				jFrameManagementSubjects.setVisible(true);
			}
		});
		jButtonSubject.setForeground(new Color(211, 211, 211));
		jButtonSubject.setBackground(Color.BLACK);
		jButtonSubject.setBounds(332, 294, 309, 128);
		jButtonSubject.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_2.setLayout(null);
		panel_2.add(jButtonStaff);
		panel_2.add(jButtonMark);
		panel_2.add(jButtonClass);
		panel_2.add(jButtonGrade);
		panel_2.add(jButtonSubject);
		contentPane.add(panel_2);
		
		JButton jButtonStudent = new JButton("STUDENT");
		jButtonStudent.setForeground(new Color(211, 211, 211));
		jButtonStudent.setBackground(Color.BLACK);
		jButtonStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameStudentInfor jFrameStudentInfor = new JFrameStudentInfor();
				jFrameStudentInfor.setVisible(true);
			}
		});
		jButtonStudent.setFont(new Font("Tahoma", Font.BOLD, 26));
		jButtonStudent.setBounds(11, 13, 309, 128);
		panel_2.add(jButtonStudent);
		
		JLabel jLabelBackGround = new JLabel("");
		jLabelBackGround.setBackground(Color.DARK_GRAY);
		jLabelBackGround.setBounds(0, 0, 653, 440);
		panel_2.add(jLabelBackGround);
		jLabelBackGround.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\bgdoan.jpg"));
		
		JLabel jLblBackGround = new JLabel("New label");
		jLblBackGround.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\bgdoan.jpg"));
		jLblBackGround.setBounds(214, 0, 439, 440);
		panel_2.add(jLblBackGround);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\bgdoan.jpg"));
		label.setBounds(0, 0, 913, 136);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\bgdoan.jpg"));
		label_1.setBounds(280, 0, 633, 136);
		panel_1.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 167, 248, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jLabelPhotoUser = new JLabel("");
		jLabelPhotoUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		jLabelPhotoUser.setBounds(12, 13, 224, 224);
		panel.add(jLabelPhotoUser);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(220, 220, 220));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(12, 270, 47, 16);
		panel.add(lblUser);
		
		JLabelUsername = new JLabel("");
		JLabelUsername.setForeground(Color.LIGHT_GRAY);
		JLabelUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabelUsername.setBounds(81, 270, 155, 20);
		panel.add(JLabelUsername);
		
		JLabel lblId = new JLabel("Name:");
		lblId.setForeground(new Color(220, 220, 220));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(12, 305, 59, 16);
		panel.add(lblId);
		
		JLabelFullname = new JLabel("");
		JLabelFullname.setForeground(new Color(220, 220, 220));
		JLabelFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabelFullname.setBounds(81, 303, 155, 20);
		panel.add(JLabelFullname);
		
		JButton jButtonEditProfile = new JButton("Edit Profile");
		jButtonEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameEditProfile jFrameEditProfile = new JFrameEditProfile();
				jFrameEditProfile.setVisible(true);
			}
		});
		jButtonEditProfile.setForeground(new Color(220, 220, 220));
		jButtonEditProfile.setBackground(Color.BLACK);
		jButtonEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jButtonEditProfile.setBounds(67, 343, 118, 37);
		panel.add(jButtonEditProfile);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrameLogin jFrameLogin = new JFrameLogin();
				jFrameLogin.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(67, 385, 118, 37);
		panel.add(btnNewButton);
		
		JLabel jLblBackGround1 = new JLabel("");
		jLblBackGround1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\bgdoan.jpg"));
		jLblBackGround1.setBounds(0, 0, 248, 440);
		panel.add(jLblBackGround1);
		
		JLabel jLblBackGround2 = new JLabel("");
		jLblBackGround2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\trendenduoitrang.jpg"));
		jLblBackGround2.setBounds(0, 0, 939, 480);
		contentPane.add(jLblBackGround2);
		
		JLabel jLblBackGround3 = new JLabel("");
		jLblBackGround3.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\trendenduoitrang.jpg"));
		jLblBackGround3.setBounds(299, 0, 640, 480);
		contentPane.add(jLblBackGround3);
	}
	public void assingMenu(String username){
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.find(username);
		if(account.getRole().getName().equalsIgnoreCase("admin")){
			jMenuSystem.setVisible(true);
			jMenuSystem.setEnabled(true);
			jButtonClass.setEnabled(true);
			jButtonGrade.setEnabled(true);
			jButtonStaff.setEnabled(true);
			jButtonSubject.setEnabled(true);
		}
	}
	public void studentButtonActionPerform(ActionEvent actionEvent){
		JFrameStudentInfor frameStudentInfor = new JFrameStudentInfor();
		frameStudentInfor.setVisible(true);
		this.setVisible(false);
	}
	public void loadData(){
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.find(username);
		ImageIcon imageIcon = new ImageIcon( new ImageIcon(account.getPhoto()).getImage().getScaledInstance(224, 224, Image.SCALE_DEFAULT)); 
		jLabelPhotoUser.setIcon(imageIcon);
		JLabelUsername.setText(account.getUsername());
		JLabelFullname.setText(account.getFullName());
	}
	public void loadDataAfterEditProfile(){
		
	}
}

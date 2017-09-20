package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.AccountDAO;
import dao.RoleDAO;
import entities.Account;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class JFrameManagementAccout extends JFrame {

	private JPanel contentPane;
	private JTable JTableAccount;
	private JTextField JTextFieldUsername;
	private JTextField JTextFieldEmail;
	private JTextField JTextFieldRole;
	private JLabel JLabelPhoto;
	private JButton JButtonDelete;
	public int selectedRow; 
	public static String userName; 
	private JTextField JTextFieldFullName;
	private JButton JButtonExit;
	private JButton JButtonNew;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameManagementAccout frame = new JFrameManagementAccout();
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
	public JFrameManagementAccout() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Management Account");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setBounds(0, 0, 824, 67);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(23, 89, 780, 155);
		
		JTableAccount = new JTable();
		JTableAccount.setShowHorizontalLines(true);
		JTableAccount.setSelectionBackground(Color.BLACK);
		JTableAccount.setRowHeight(20);
		JTableAccount.setGridColor(Color.GRAY);
		JTableAccount.setForeground(new Color(211, 211, 211));
		JTableAccount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableAccount.setFillsViewportHeight(true);
		JTableAccount.setBackground(Color.DARK_GRAY);
		JTableAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JButtonDelete.setEnabled(true);
				selectedRow= JTableAccount.getSelectedRow();
				userName= JTableAccount.getValueAt(selectedRow, 0).toString();
				AccountDAO accountDAO = new AccountDAO();
				Account account = accountDAO.find(userName);
				RoleDAO roleDAO = new RoleDAO();
				JTextFieldUsername.setText(account.getUsername());
				JTextFieldFullName.setText(account.getFullName());
				JTextFieldEmail.setText(account.getEmail());
				JTextFieldRole.setText(account.getRole().getName());
				ImageIcon imageIcon = new ImageIcon( new ImageIcon(account.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)); 
				JLabelPhoto.setIcon(imageIcon);
				
			}
		});
		JTableAccount.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(JTableAccount);
		
		JPanel JPanelInformationAccount = new JPanel();
		JPanelInformationAccount.setBounds(23, 266, 605, 235);
		JPanelInformationAccount.setBorder(new TitledBorder(null, "Account Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(95, 158, 160)));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(211, 211, 211));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(18, 28, 82, 28);
		
		JLabel lblPassword = new JLabel("Full Name");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(18, 76, 96, 28);
		
		JLabel lblFullname = new JLabel("Email");
		lblFullname.setForeground(new Color(211, 211, 211));
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFullname.setBounds(18, 126, 96, 28);
		
		JLabel lblEmail = new JLabel("Role");
		lblEmail.setForeground(new Color(211, 211, 211));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(18, 177, 96, 22);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setForeground(new Color(211, 211, 211));
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoto.setBounds(324, 20, 57, 21);
		
		JLabelPhoto = new JLabel("");
		JLabelPhoto.setBounds(393, 20, 200, 200);
		JLabelPhoto.setBorder(new LineBorder(Color.GRAY));
		
		JTextFieldUsername = new JTextField();
		JTextFieldUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldUsername.setBackground(SystemColor.controlHighlight);
		JTextFieldUsername.setBounds(118, 25, 179, 35);
		JTextFieldUsername.setEditable(false);
		JTextFieldUsername.setColumns(10);
		
		JTextFieldEmail = new JTextField();
		JTextFieldEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldEmail.setBackground(SystemColor.controlHighlight);
		JTextFieldEmail.setBounds(119, 123, 179, 35);
		JTextFieldEmail.setEditable(false);
		JTextFieldEmail.setColumns(10);
		
		JTextFieldRole = new JTextField();
		JTextFieldRole.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldRole.setBackground(SystemColor.controlHighlight);
		JTextFieldRole.setBounds(119, 171, 179, 35);
		JTextFieldRole.setEditable(false);
		JTextFieldRole.setColumns(10);
		
		JTextFieldFullName = new JTextField();
		JTextFieldFullName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldFullName.setBackground(SystemColor.controlHighlight);
		JTextFieldFullName.setBounds(119, 73, 179, 35);
		JTextFieldFullName.setEditable(false);
		JTextFieldFullName.setColumns(10);
		
		JPanel JPanelButton = new JPanel();
		JPanelButton.setBounds(640, 266, 163, 235);
		JPanelButton.setBorder(new LineBorder(new Color(95, 158, 160)));
		
		JButtonNew = new JButton("New");
		JButtonNew.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonNew.setForeground(new Color(211, 211, 211));
		JButtonNew.setBackground(Color.BLACK);
		JButtonNew.setBounds(11, 36, 140, 35);
		JButtonNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameNewAccount jFrameNewAccount = new JFrameNewAccount();
				jFrameNewAccount.loadData();
				setVisible(false);
				jFrameNewAccount.setVisible(true);
				
			}
		});
		
		JButtonDelete = new JButton("Delete");
		JButtonDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonDelete.setForeground(new Color(211, 211, 211));
		JButtonDelete.setBackground(Color.BLACK);
		JButtonDelete.setBounds(13, 98, 138, 35);
		JButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectedRow= JTableAccount.getSelectedRow();
					userName= JTableAccount.getValueAt(selectedRow, 0).toString();
					AccountDAO accountDAO = new AccountDAO();
					Account account = accountDAO.find(userName);
					accountDAO.delete(account);
					loadData();
					JOptionPane.showMessageDialog(null, "Delete account success");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Delete account fail");
				}

				
			}
		});
		JButtonDelete.setEnabled(false);
		
		JButtonExit = new JButton("Exit");
		JButtonExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonExit.setForeground(new Color(211, 211, 211));
		JButtonExit.setBackground(Color.BLACK);
		JButtonExit.setBounds(13, 158, 138, 35);
		JButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(lblNewLabel);
		contentPane.add(JPanelInformationAccount);
		JPanelInformationAccount.setLayout(null);
		JPanelInformationAccount.add(lblEmail);
		JPanelInformationAccount.add(JTextFieldRole);
		JPanelInformationAccount.add(lblFullname);
		JPanelInformationAccount.add(JTextFieldEmail);
		JPanelInformationAccount.add(lblUsername);
		JPanelInformationAccount.add(JTextFieldUsername);
		JPanelInformationAccount.add(lblPassword);
		JPanelInformationAccount.add(JTextFieldFullName);
		JPanelInformationAccount.add(lblPhoto);
		JPanelInformationAccount.add(JLabelPhoto);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_2.setBounds(0, 0, 605, 235);
		JPanelInformationAccount.add(label_2);
		contentPane.add(JPanelButton);
		JPanelButton.setLayout(null);
		JPanelButton.add(JButtonExit);
		JPanelButton.add(JButtonNew);
		JPanelButton.add(JButtonDelete);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_3.setBounds(0, 0, 163, 235);
		JPanelButton.add(label_3);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 824, 67);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 67, 824, 462);
		contentPane.add(label_1);
		loadData();
	}
	public void loadData(){
		AccountDAO accountDAO = new AccountDAO();
		RoleDAO roleDAO = new RoleDAO();
		fillDataToTable(accountDAO.findAll());
	}
	public void fillDataToTable(List<Account> accounts){
		DefaultTableModel defaultTableModel = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int col){
				if(col==0 || col==1)
					return false;
				return true;	
			}
			
		};
		defaultTableModel.addColumn("Username");
		defaultTableModel.addColumn("Full name");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Role");
		for (Account account : accounts) {
			defaultTableModel.addRow(new Object[] { account.getUsername(), account.getFullName(), account.getEmail(),
					account.getRole().getName(),
					

			});
		}
		JTableAccount.setModel(defaultTableModel);
	}
}

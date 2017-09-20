package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DivisonDAO;
import entities.Divison;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class JFrameManagementDivison extends JFrame {

	private JPanel contentPane;
	private JTable JTableManagementDivison;
	private JButton JButtonAddDivison;
	private JButton JButtonEditDivison;
	public int selectedRow;
	public static String name;
	private JLabel lblStaffName;
	private JLabel lblSubject;
	private JLabel lblNoLesson;
	private JLabel lblTimeDivison;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameManagementDivison frame = new JFrameManagementDivison();
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
	public JFrameManagementDivison() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagementDivison = new JLabel("Management Divison");
		lblManagementDivison.setForeground(new Color(211, 211, 211));
		lblManagementDivison.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblManagementDivison.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagementDivison.setBounds(0, 0, 578, 67);
		contentPane.add(lblManagementDivison);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(12, 80, 554, 109);
		contentPane.add(scrollPane);
		
		JTableManagementDivison = new JTable();
		JTableManagementDivison.setShowHorizontalLines(true);
		JTableManagementDivison.setSelectionBackground(Color.BLACK);
		JTableManagementDivison.setRowHeight(20);
		JTableManagementDivison.setGridColor(Color.GRAY);
		JTableManagementDivison.setForeground(new Color(211, 211, 211));
		JTableManagementDivison.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableManagementDivison.setFillsViewportHeight(true);
		JTableManagementDivison.setBackground(Color.DARK_GRAY);
		JTableManagementDivison.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = JTableManagementDivison.getSelectedRow();
				name = JTableManagementDivison.getValueAt(selectedRow, 0).toString();
				JButtonEditDivison.setEnabled(true);
				
			}
		});
		scrollPane.setViewportView(JTableManagementDivison);
		
		JButtonAddDivison = new JButton("Add divison");
		JButtonAddDivison.setForeground(new Color(211, 211, 211));
		JButtonAddDivison.setBackground(Color.BLACK);
		JButtonAddDivison.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButtonAddDivison.setBounds(438, 202, 117, 35);
		contentPane.add(JButtonAddDivison);
		
		JButtonEditDivison = new JButton("Edit Divison");
		JButtonEditDivison.setForeground(new Color(211, 211, 211));
		JButtonEditDivison.setBackground(Color.BLACK);
		JButtonEditDivison.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButtonEditDivison.setEnabled(false);
		JButtonEditDivison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialogEditDivison jDialogEditDivison = new JDialogEditDivison();
				jDialogEditDivison.loadData();
				jDialogEditDivison.setVisible(true);
				setVisible(false);
			}
		});
		JButtonEditDivison.setBounds(438, 262, 117, 35);
		contentPane.add(JButtonEditDivison);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		lblNewLabel.setBounds(0, 0, 578, 67);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 202, 389, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStaffName = new JLabel("Staff Name");
		lblStaffName.setForeground(new Color(211, 211, 211));
		lblStaffName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaffName.setBounds(12, 17, 108, 25);
		panel.add(lblStaffName);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setForeground(new Color(211, 211, 211));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(12, 69, 108, 23);
		panel.add(lblSubject);
		
		lblNoLesson = new JLabel("No. Lesson");
		lblNoLesson.setForeground(new Color(211, 211, 211));
		lblNoLesson.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoLesson.setBounds(12, 115, 108, 25);
		panel.add(lblNoLesson);
		
		lblTimeDivison = new JLabel("Time Divison");
		lblTimeDivison.setForeground(new Color(211, 211, 211));
		lblTimeDivison.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimeDivison.setBounds(12, 167, 108, 25);
		panel.add(lblTimeDivison);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBounds(123, 13, 240, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_1.setBackground(SystemColor.controlHighlight);
		textField_1.setColumns(10);
		textField_1.setBounds(123, 64, 240, 35);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_2.setBackground(SystemColor.controlHighlight);
		textField_2.setColumns(10);
		textField_2.setBounds(123, 111, 240, 35);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_3.setBackground(SystemColor.controlHighlight);
		textField_3.setColumns(10);
		textField_3.setBounds(123, 163, 240, 35);
		panel.add(textField_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_1.setBounds(0, 0, 389, 211);
		panel.add(label_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(211, 211, 211));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(438, 320, 117, 35);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label.setBounds(0, 65, 578, 361);
		contentPane.add(label);
		loadData();
	}
	public void loadData(){
		DivisonDAO divisonDAO = new DivisonDAO();
		fillDataToTable(divisonDAO.findAll());
	}
	public void fillDataToTable(List<Divison> divisons){
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}

		};
		defaultTableModel.addColumn("Staff");
		defaultTableModel.addColumn("Subject");
		defaultTableModel.addColumn("Number of lession");
		defaultTableModel.addColumn("Time divison");
		
		for (Divison divison : divisons) {
			defaultTableModel.addRow( new Object[]{
					divison.getStaff().getName(), divison.getSubjects().getNameOfSubjects(), divison.getNumberOfLesson(), divison.getTimeDivison()
			});
		}
		JTableManagementDivison.setModel(defaultTableModel);
	}
	
}

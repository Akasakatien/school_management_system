package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.SubjectsDAO;
import entities.Subjects;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JFrameManagementSubjects extends JFrame {

	private JPanel contentPane;
	private JTable JTableManagementSubjects;
	private JButton JButtonNewSubject;
	private JButton JButtonUpdate;
	private JButton JButtonDelete;
	public int selectedRow; 
	public static int id;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameManagementSubjects frame = new JFrameManagementSubjects();
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
	public JFrameManagementSubjects() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagementSubjects = new JLabel("Management Subjects");
		lblManagementSubjects.setForeground(new Color(211, 211, 211));
		lblManagementSubjects.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblManagementSubjects.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagementSubjects.setBounds(0, 0, 474, 68);
		contentPane.add(lblManagementSubjects);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(10, 81, 452, 107);
		contentPane.add(scrollPane);
		
		JTableManagementSubjects = new JTable();
		JTableManagementSubjects.setShowHorizontalLines(true);
		JTableManagementSubjects.setSelectionBackground(Color.BLACK);
		JTableManagementSubjects.setRowHeight(20);
		JTableManagementSubjects.setGridColor(Color.GRAY);
		JTableManagementSubjects.setForeground(new Color(211, 211, 211));
		JTableManagementSubjects.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableManagementSubjects.setFillsViewportHeight(true);
		JTableManagementSubjects.setBackground(Color.DARK_GRAY);
		JTableManagementSubjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SubjectsDAO subjectsDAO = new SubjectsDAO();
				Subjects subjects = new Subjects();
				selectedRow = JTableManagementSubjects.getSelectedRow();
				id = (int) JTableManagementSubjects.getValueAt(selectedRow, 0);
				JButtonDelete.setEnabled(true);
				JButtonUpdate.setEnabled(true);
			}
		});
		scrollPane.setViewportView(JTableManagementSubjects);
		
		JButtonNewSubject = new JButton("New Subject");
		JButtonNewSubject.setForeground(new Color(211, 211, 211));
		JButtonNewSubject.setBackground(Color.BLACK);
		JButtonNewSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogNewSubject jDialogNewSubject = new JDialogNewSubject();
				jDialogNewSubject.setVisible(true);
				setVisible(false);
			}
		});
		JButtonNewSubject.setBounds(10, 215, 100, 35);
		contentPane.add(JButtonNewSubject);
		
		JButtonUpdate = new JButton("Update");
		JButtonUpdate.setForeground(new Color(211, 211, 211));
		JButtonUpdate.setBackground(Color.BLACK);
		JButtonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogUpdateSubject jDialogUpdateSubject = new JDialogUpdateSubject();
				jDialogUpdateSubject.loadData();
				jDialogUpdateSubject.setVisible(true);
				setVisible(false);
			}
		});
		JButtonUpdate.setEnabled(false);
		JButtonUpdate.setBounds(122, 215, 100, 35);
		contentPane.add(JButtonUpdate);
		
		JButtonDelete = new JButton("Delete");
		JButtonDelete.setForeground(new Color(211, 211, 211));
		JButtonDelete.setBackground(Color.BLACK);
		JButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SubjectsDAO subjectsDAO = new SubjectsDAO();
					Subjects subjects = subjectsDAO.find(id);
					subjectsDAO.delete(subjects);
					JOptionPane.showMessageDialog(null, "Delete subjects successfull");
					loadData();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Delete subjects fail");
					// TODO: handle exception
				}
			}
		});
		JButtonDelete.setEnabled(false);
		JButtonDelete.setBounds(233, 215, 100, 35);
		contentPane.add(JButtonDelete);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(345, 215, 106, 35);
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 474, 68);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 68, 474, 203);
		contentPane.add(label_1);
		loadData();
	}
	public void loadData(){
		Subjects subjects = new Subjects();
		SubjectsDAO subjectsDAO = new SubjectsDAO();
		fillDataToTable(subjectsDAO.findAll());
	}
	public void fillDataToTable(List<Subjects> subjects){
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name Subject");
		for (Subjects subject : subjects) {
			defaultTableModel.addRow(new Object[] {subject.getId(), subject.getNameOfSubjects() });
		}
		JTableManagementSubjects.setModel(defaultTableModel);
		
	}
}

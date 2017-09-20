package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MarksDAO;
import dao.MarksIdDAO;
import dao.StudentDAO;
import entities.Marks;
import entities.MarksId;
import entities.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JFrameManagementMarks extends JFrame {

	private JPanel contentPane;
	private JTable JTableListStudentManagementMarks;
	public int selectedRow; 
	public static int id;
	private JButton JButtonEditMarks;
	private JButton JButtonAddNewMarks;
	private JLabel label;
	private JLabel label_1;
	public static String name;
	private JButton jButtonDelete;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameManagementMarks frame = new JFrameManagementMarks();
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
	public JFrameManagementMarks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagementMarks = new JLabel("Management Marks");
		lblManagementMarks.setForeground(new Color(211, 211, 211));
		lblManagementMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagementMarks.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblManagementMarks.setBounds(0, 0, 517, 56);
		contentPane.add(lblManagementMarks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(13, 68, 490, 134);
		contentPane.add(scrollPane);
		
		JTableListStudentManagementMarks = new JTable();
		JTableListStudentManagementMarks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = JTableListStudentManagementMarks.getSelectedRow();
				name = JTableListStudentManagementMarks.getValueAt(selectedRow, 0).toString();
				JButtonEditMarks.setEnabled(true);
				jButtonDelete.setEnabled(true);
			}
		});
		JTableListStudentManagementMarks.setShowHorizontalLines(true);
		JTableListStudentManagementMarks.setSelectionBackground(Color.BLACK);
		JTableListStudentManagementMarks.setRowHeight(20);
		JTableListStudentManagementMarks.setGridColor(Color.GRAY);
		JTableListStudentManagementMarks.setFillsViewportHeight(true);
		JTableListStudentManagementMarks.setForeground(new Color(211, 211, 211));
		JTableListStudentManagementMarks.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableListStudentManagementMarks.setBackground(Color.DARK_GRAY);
//		JTableListStudentManagementMarks.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//				selectedRow = JTableListStudentManagementMarks.getSelectedRow();
//				id = (int) JTableListStudentManagementMarks.getValueAt(selectedRow, 0);
//				JButtonEditMarks.setEnabled(true);
//				JButtonAddNewMarks.setEnabled(true);
//				
//				
//			}
//		});
		scrollPane.setViewportView(JTableListStudentManagementMarks);
		
		JButtonAddNewMarks = new JButton("Add marks");
		JButtonAddNewMarks.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonAddNewMarks.setForeground(new Color(211, 211, 211));
		JButtonAddNewMarks.setBackground(Color.BLACK);
		JButtonAddNewMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogListStudent jDialogListStudent = new JDialogListStudent();
				jDialogListStudent.loadData();
				jDialogListStudent.setVisible(true);
				setVisible(false);		
			}
		});
		JButtonAddNewMarks.setBounds(13, 229, 104, 35);
		contentPane.add(JButtonAddNewMarks);
		
		JButtonEditMarks = new JButton("Edit marks");
		JButtonEditMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogEditMarks jDialogEditMarks = new JDialogEditMarks();
				jDialogEditMarks.loadData();
				jDialogEditMarks.setVisible(true);
				setVisible(false);
			}
		});
		JButtonEditMarks.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonEditMarks.setForeground(new Color(211, 211, 211));
		JButtonEditMarks.setBackground(Color.BLACK);
		JButtonEditMarks.setEnabled(false);
		JButtonEditMarks.setBounds(129, 229, 104, 35);
		contentPane.add(JButtonEditMarks);
		
		jButtonDelete = new JButton("Delete");
		jButtonDelete.setEnabled(false);
		jButtonDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
				switch (result){
					case 0:
						 Marks marks = new Marks();
						 MarksDAO marksDAO = new MarksDAO();
						 marks = marksDAO.findByName(name);
						 marksDAO.delete(marks);
						 JOptionPane.showMessageDialog(null, "Delete marks successfull");
						 loadData();
						break;
					case 1:		
						break;
					}
			}
		});
		jButtonDelete.setForeground(new Color(211, 211, 211));
		jButtonDelete.setBackground(Color.BLACK);
		jButtonDelete.setBounds(245, 229, 104, 35);
		contentPane.add(jButtonDelete);
		
		btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(211, 211, 211));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(372, 229, 104, 35);
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 517, 56);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_1.setBounds(0, 56, 517, 239);
		contentPane.add(label_1);
		loadData();
	}
	public void loadData(){
		MarksDAO marksDAO = new MarksDAO();
		fillDataToTable(marksDAO.findAll());
	}
	public void fillDataToTable(List<Marks> marks){
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}
		};
		defaultTableModel.addColumn("Student");
		defaultTableModel.addColumn("Subject");
		defaultTableModel.addColumn("Semester I");
		defaultTableModel.addColumn("Semester II:");
		defaultTableModel.addColumn("Total marks");
		
		for (Marks mark : marks) {
			defaultTableModel.addRow(new Object[]{
				   mark.getStudent().getName(), mark.getSubjects().getNameOfSubjects(), mark.getMarksSemesterI(), mark.getMarksSemesterIi(), mark.getTotalMarks()
			});
		}
		JTableListStudentManagementMarks.setModel(defaultTableModel);
		JTableListStudentManagementMarks.getTableHeader().setReorderingAllowed(false);

	}
}

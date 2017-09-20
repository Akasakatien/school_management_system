package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.GradeDAO;
import entities.Account;
import entities.Grade;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class JFrameManagementGrade extends JFrame {

	private JPanel contentPane;
	private JTable JTableManagementGrade;
	private JLabel JLabelNameGrade;
	private JLabel JLabelNumberClass;
	public int selectedRow; 
	public static int id;
	private JTextField JTextFieldSearchByName;
	private JButton JButtonUpdate;
	private JButton JButtonDelete;
	private JButton JButtonNewGrade;
	private JButton JButtonExit;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel_1;
	DefaultTableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					JFrameManagementGrade frame = new JFrameManagementGrade();
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
	public JFrameManagementGrade() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Management Grade");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 745, 58);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(23, 125, 698, 115);
		contentPane.add(scrollPane);

		JTableManagementGrade = new JTable();
		JTableManagementGrade.setShowHorizontalLines(true);
		JTableManagementGrade.setSelectionBackground(Color.BLACK);
		JTableManagementGrade.setRowHeight(20);
		JTableManagementGrade.setGridColor(Color.GRAY);
		JTableManagementGrade.setForeground(new Color(211, 211, 211));
		JTableManagementGrade.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableManagementGrade.setFillsViewportHeight(true);
		JTableManagementGrade.setBackground(Color.DARK_GRAY);
		JTableManagementGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Grade grade = new Grade();
				GradeDAO gradeDAO = new GradeDAO();
				JButtonDelete.setEnabled(true);
				JButtonUpdate.setEnabled(true);
				selectedRow= JTableManagementGrade.getSelectedRow();
				id =  (int) JTableManagementGrade.getValueAt(selectedRow, 0);
				grade = gradeDAO.find(id);
				JLabelNameGrade.setText(grade.getGradeName());
				JLabelNumberClass.setText(String.valueOf(grade.getClassStudents().size()));
			}
		});
		scrollPane.setViewportView(JTableManagementGrade);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Grade Management", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(95, 158, 160)));
		panel.setBounds(23, 252, 535, 228);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(90, 56, 63, 24);
		panel.add(lblName);

		JLabelNameGrade = new JLabel("");
		JLabelNameGrade.setForeground(new Color(211, 211, 211));
		JLabelNameGrade.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabelNameGrade.setBounds(165, 45, 248, 35);
		panel.add(JLabelNameGrade);

		JLabel lblNumberClass = new JLabel("Number class :");
		lblNumberClass.setForeground(new Color(211, 211, 211));
		lblNumberClass.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNumberClass.setBounds(31, 114, 122, 24);
		panel.add(lblNumberClass);

		JLabelNumberClass = new JLabel("");
		JLabelNumberClass.setForeground(new Color(211, 211, 211));
		JLabelNumberClass.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabelNumberClass.setBounds(163, 114, 38, 35);
		panel.add(JLabelNumberClass);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		label_2.setBounds(0, 0, 535, 228);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(570, 252, 148, 228);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButtonNewGrade = new JButton("New Grade");
		JButtonNewGrade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonNewGrade.setBackground(Color.BLACK);
		JButtonNewGrade.setForeground(new Color(211, 211, 211));
		JButtonNewGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JDiaLogManagementGradeAdd jDiaLogManagementGradeAdd = new JDiaLogManagementGradeAdd();
				jDiaLogManagementGradeAdd.setVisible(true);
			}
		});
		JButtonNewGrade.setBounds(20, 23, 109, 35);
		panel_1.add(JButtonNewGrade);

		JButtonUpdate = new JButton("Update");
		JButtonUpdate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonUpdate.setBackground(Color.BLACK);
		JButtonUpdate.setForeground(new Color(211, 211, 211));
		JButtonUpdate.setEnabled(false);
		JButtonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JDialogManagementUpdateGrade jDialogManagementUpdateGrade = new JDialogManagementUpdateGrade();
				jDialogManagementUpdateGrade.loadData();
				jDialogManagementUpdateGrade.setVisible(true);
			}
		});
		JButtonUpdate.setBounds(20, 75, 109, 35);
		panel_1.add(JButtonUpdate);

		JButtonDelete = new JButton("Delete");
		JButtonDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonDelete.setBackground(Color.BLACK);
		JButtonDelete.setForeground(new Color(211, 211, 211));
		JButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
				switch (result){
					case 0:
						Grade grade = new Grade();
						GradeDAO gradeDAO = new GradeDAO();
						selectedRow= JTableManagementGrade.getSelectedRow();
						id =  (int) JTableManagementGrade.getValueAt(selectedRow, 0);
						grade = gradeDAO.find(id);
						gradeDAO.delete(grade);
						loadData();
						break;
					case 1:
						
						break;
					}
				
			}
		});
		JButtonDelete.setEnabled(false);
		JButtonDelete.setBounds(20, 126, 109, 35);
		panel_1.add(JButtonDelete);

		JButtonExit = new JButton("Exit");
		JButtonExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonExit.setBackground(Color.BLACK);
		JButtonExit.setForeground(new Color(211, 211, 211));
		JButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				dispose();
			}
		});
		JButtonExit.setBounds(20, 175, 109, 35);
		panel_1.add(JButtonExit);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 148, 228);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblSearch = new JLabel("Search by name :");
		lblSearch.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearch.setForeground(new Color(211, 211, 211));
		lblSearch.setBounds(23, 81, 138, 25);
		contentPane.add(lblSearch);
		
		JTextFieldSearchByName = new JTextField();
		JTextFieldSearchByName.setForeground(new Color(211, 211, 211));
		JTextFieldSearchByName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldSearchByName.setBackground(Color.DARK_GRAY);
		JTextFieldSearchByName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
//				if (JTextFieldSearchByName.getText().isEmpty() || JTextFieldSearchByName.getText().equals("")) {
//					loadData();
//				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String query = JTextFieldSearchByName.getText();
				filterUseJtextfield(query);
			}
		});
		JTextFieldSearchByName.setBounds(173, 78, 548, 35);
		contentPane.add(JTextFieldSearchByName);
		JTextFieldSearchByName.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 741, 58);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 58, 741, 457);
		contentPane.add(label_1);
		loadData();
	}

	public void loadData() {
		GradeDAO gradeDAO = new GradeDAO();
		fillDataToTable(gradeDAO.findAll());
	}

	public void fillDataToTable(List<Grade> grades) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//			
//			@Override
//			public boolean isCellEditable(int row, int col) {
//				if (col == 0 || col == 1)
//					return false;
//				return true;
//
//			}
//		};
		dm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}
		};
		dm.addColumn("ID");
		dm.addColumn("Name grade");
		dm.addColumn("Number Class");
		for (Grade grade : grades) {
			dm.addRow(new Object[] {grade.getGradeId(), grade.getGradeName(), grade.getClassStudents().size() });
		}
		JTableManagementGrade.setModel(dm);
	}
	private void filterUseJtextfield(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		JTableManagementGrade.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
}

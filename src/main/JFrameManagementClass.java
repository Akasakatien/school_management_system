package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.ClassStudentDAO;
import dao.GradeDAO;
import dao.StudentDAO;
import entities.ClassStudent;
import entities.Grade;
import entities.Student;

import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JFrameManagementClass extends JFrame {

	private JPanel contentPane;
	private JTable JTableManagementClass;
	private JTextField JTextFieldSearch;
	private JComboBox JComboBoxGrade;
	private JLabel JLabelNameClass;
	private JLabel JLabelGradeName;
	private JLabel JLabelNumberStudentOfClass;
	public int selectedRow;
	public static int id;
	private JButton JButtonUpdate;
	private JButton JButtonDelete;
	private JButton JButtonNewClass;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	DefaultTableModel dm;

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
					JFrameManagementClass frame = new JFrameManagementClass();
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
	public JFrameManagementClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Management Class");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 0, 747, 57);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(20, 127, 704, 150);
		contentPane.add(scrollPane);

		JTableManagementClass = new JTable();
		JTableManagementClass.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		JTableManagementClass.setShowHorizontalLines(true);
		JTableManagementClass.setSelectionBackground(Color.BLACK);
		JTableManagementClass.setRowHeight(20);
		JTableManagementClass.setGridColor(Color.GRAY);
		JTableManagementClass.setForeground(new Color(211, 211, 211));
		JTableManagementClass.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableManagementClass.setFillsViewportHeight(true);
		JTableManagementClass.setBackground(Color.DARK_GRAY);
		JTableManagementClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClassStudentDAO classStudentDAO = new ClassStudentDAO();
				ClassStudent classStudent = new ClassStudent();
				JButtonDelete.setEnabled(true);
				JButtonUpdate.setEnabled(true);
				selectedRow = JTableManagementClass.getSelectedRow();
				id = (int) JTableManagementClass.getValueAt(selectedRow, 0);
				classStudent = classStudentDAO.find(id);
				JLabelNameClass.setText(classStudent.getNameOfClass());
				JLabelGradeName.setText(classStudent.getGrade().getGradeName());
				JLabelNumberStudentOfClass.setText(String.valueOf(classStudent.getStudents().size()));
			}
		});
		scrollPane.setViewportView(JTableManagementClass);

		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearchByName.setForeground(new Color(211, 211, 211));
		lblSearchByName.setBounds(374, 85, 134, 30);
		contentPane.add(lblSearchByName);

		JTextFieldSearch = new JTextField();
		JTextFieldSearch.setForeground(new Color(211, 211, 211));
		JTextFieldSearch.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldSearch.setBackground(Color.DARK_GRAY);
		JTextFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
//				if (JTextFieldSearch.getText().isEmpty() || JTextFieldSearch.getText().equals("")) {
//					loadData();
//				}
				String query = JTextFieldSearch.getText();
				filterUseJtextfield(query);
			}
		});
		JTextFieldSearch.setBounds(513, 80, 211, 35);
		contentPane.add(JTextFieldSearch);
		JTextFieldSearch.setColumns(10);

		JLabel lblGrade = new JLabel("Search by Grade");
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblGrade.setForeground(new Color(211, 211, 211));
		lblGrade.setBounds(20, 85, 134, 30);
		contentPane.add(lblGrade);

		JComboBoxGrade = new JComboBox();
		JComboBoxGrade.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String query = JComboBoxGrade.getSelectedItem().toString();
				filterUseJComboBox(query);
			}
		});
		JComboBoxGrade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JComboBoxGrade.setBackground(Color.BLACK);
		JComboBoxGrade.setBounds(159, 80, 182, 35);
		contentPane.add(JComboBoxGrade);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Class Infomation",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(153, 180, 209)));
		panel.setBounds(30, 289, 561, 178);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(38, 23, 60, 26);
		panel.add(lblName);

		JLabel lblGrade_1 = new JLabel("Grade : ");
		lblGrade_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblGrade_1.setForeground(new Color(211, 211, 211));
		lblGrade_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade_1.setBounds(38, 78, 60, 26);
		panel.add(lblGrade_1);

		JLabel lblNumberStudentOf = new JLabel("Number student of class :");
		lblNumberStudentOf.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNumberStudentOf.setForeground(new Color(211, 211, 211));
		lblNumberStudentOf.setBounds(38, 129, 215, 26);
		panel.add(lblNumberStudentOf);

		JLabelNameClass = new JLabel("");
		JLabelNameClass.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabelNameClass.setForeground(new Color(211, 211, 211));
		JLabelNameClass.setBackground(Color.DARK_GRAY);
		JLabelNameClass.setBounds(247, 23, 268, 35);
		panel.add(JLabelNameClass);

		JLabelGradeName = new JLabel("");
		JLabelGradeName.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabelGradeName.setForeground(new Color(211, 211, 211));
		JLabelGradeName.setBackground(Color.DARK_GRAY);
		JLabelGradeName.setBounds(247, 69, 268, 35);
		panel.add(JLabelGradeName);

		JLabelNumberStudentOfClass = new JLabel("");
		JLabelNumberStudentOfClass.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabelNumberStudentOfClass.setForeground(new Color(211, 211, 211));
		JLabelNumberStudentOfClass.setBackground(Color.DARK_GRAY);
		JLabelNumberStudentOfClass.setBounds(247, 120, 68, 35);
		panel.add(JLabelNumberStudentOfClass);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		label_2.setBounds(-11, 0, 572, 178);
		panel.add(label_2);
		label_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(1, 0, 824, 57);
		contentPane.add(label);
		
				JButtonNewClass = new JButton("New Class");
				JButtonNewClass.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonNewClass.setForeground(new Color(211, 211, 211));
				JButtonNewClass.setBackground(Color.BLACK);
				JButtonNewClass.setBounds(599, 297, 125, 35);
				contentPane.add(JButtonNewClass);
				
						JButtonUpdate = new JButton("Edit");
						JButtonUpdate.setFont(new Font("SansSerif", Font.PLAIN, 16));
						JButtonUpdate.setForeground(new Color(211, 211, 211));
						JButtonUpdate.setBackground(Color.BLACK);
						JButtonUpdate.setBounds(599, 344, 125, 35);
						contentPane.add(JButtonUpdate);
						JButtonUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JDialogUpdateClass jDialogUpdateClass = new JDialogUpdateClass();
								jDialogUpdateClass.loadData();
								jDialogUpdateClass.setVisible(true);
								setVisible(false);
							}
						});
						JButtonUpdate.setEnabled(false);
						
								JButtonDelete = new JButton("Delete");
								JButtonDelete.setFont(new Font("SansSerif", Font.PLAIN, 16));
								JButtonDelete.setForeground(new Color(211, 211, 211));
								JButtonDelete.setBackground(Color.BLACK);
								JButtonDelete.setBounds(599, 391, 125, 35);
								contentPane.add(JButtonDelete);
								JButtonDelete.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											ClassStudentDAO classStudentDAO = new ClassStudentDAO();
											ClassStudent classStudent = new ClassStudent();
											selectedRow = JTableManagementClass.getSelectedRow();
											id = (int) JTableManagementClass.getValueAt(selectedRow, 0);
											classStudent = classStudentDAO.find(id);
											classStudentDAO.delete(classStudent);
											JOptionPane.showMessageDialog(null, "Delete Class Successfull");
											loadData();
										} catch (Exception e2) {
											JOptionPane.showMessageDialog(null, "Delete Class Fail");
											// TODO: handle exception
										}
									}
								});
								JButtonDelete.setEnabled(false);
								
										JButton JButtonExit = new JButton("Exit");
										JButtonExit.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												dispose();
											}
										});
										JButtonExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
										JButtonExit.setForeground(new Color(211, 211, 211));
										JButtonExit.setBackground(Color.BLACK);
										JButtonExit.setBounds(599, 438, 125, 35);
										contentPane.add(JButtonExit);
										
										label_1 = new JLabel("");
										label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
										label_1.setBounds(0, 0, 747, 504);
										contentPane.add(label_1);
				JButtonNewClass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JDialogNewClass jDialogNewClass = new JDialogNewClass();
						jDialogNewClass.setVisible(true);
						setVisible(false);
					}
				});
		loadData();
	}

	public void loadData() {
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		GradeDAO gradeDAO = new GradeDAO();
		fillDataToTable(classStudentDAO.findAll());
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Grade grade : gradeDAO.findAll()) {
			defaultComboBoxModel.addElement(grade.getGradeName());
		}
		JComboBoxGrade.setModel(defaultComboBoxModel);

	}

	public void fillDataToTable(List<ClassStudent> classStudents) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//			
//			@Override
//			public boolean isCellEditable(int row, int col) {
//				if (col == 0 || col == 1)
//					return false;
//				return true;
//
//			}
//
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
		dm.addColumn("Name");
		dm.addColumn("Grade");
		for (ClassStudent classStudent : classStudents) {
			dm.addRow(new Object[] { classStudent.getClassId(), classStudent.getNameOfClass(),
					classStudent.getGrade().getGradeName() });
		}
		JTableManagementClass.getTableHeader().setReorderingAllowed(false);
		JTableManagementClass.setModel(dm);
	}
	private void filterUseJtextfield(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		JTableManagementClass.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	private void filterUseJComboBox(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		JTableManagementClass.setRowSorter(tr);
		if(query != "All"){
			tr.setRowFilter(RowFilter.regexFilter(query));
		}else{
			ClassStudentDAO classStudentDAO = new ClassStudentDAO();
			dm = new DefaultTableModel();
			dm.addColumn("ID");
			dm.addColumn("Name");
			dm.addColumn("Grade");
//			dm.addColumn("ID");
//			dm.addColumn("Student Code");
//			dm.addColumn("Class");
//			dm.addColumn("Name");
//			dm.addColumn("Date of Birth");
//			dm.addColumn("Sex");
//			dm.addColumn("Address");
//			dm.addColumn("Phone Number");
//			dm.addColumn("Email");
//			dm.addColumn("Remarks");
			for(ClassStudent classStudent:classStudentDAO.findAll()){
				dm.addRow(new Object[] { classStudent.getClassId(), classStudent.getNameOfClass(),
						classStudent.getGrade().getGradeName() });
			}
			JTableManagementClass.setModel(dm);
		}
	
}
}

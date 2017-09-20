package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.AcademicDAO;
import dao.AdmissionDAO;
import dao.ClassStudentDAO;
import dao.FamilyDAO;
import dao.GradeDAO;
import dao.StudentDAO;
import entities.Academic;
import entities.Admisson;
import entities.ClassStudent;
import entities.Family;
import entities.Grade;
import entities.Student;
import helper.ExcelHelper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reports.*;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.activation.DataSource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ListSelectionModel;

public class JFrameStudentInfor extends JFrame {

	private JPanel contentPane;
	private JTable jTableStudentInfor;
	public static int idSelected;
	public int selectedRow;
	private JTextField jTextFieldName;
	DefaultTableModel dm;
	private JComboBox jComboBoxClass;
	private JButton jButtonPrintListStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFrameStudentInfor frame = new JFrameStudentInfor();
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
	public JFrameStudentInfor() {
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1335, 944);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1317, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Profile");
		lblNewLabel.setForeground(new Color(220, 220, 220));
		lblNewLabel.setBounds(516, 13, 273, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 1317, 78);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 91, 1290, 106);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton jButtonNewStudentProfile = new JButton("New");
		jButtonNewStudentProfile.setBackground(Color.BLACK);
		jButtonNewStudentProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jFrameAddStudent jFrameAddStudent = new jFrameAddStudent();
				jFrameAddStudent.setVisible(true);
			}
		});
		jButtonNewStudentProfile.setForeground(Color.LIGHT_GRAY);
		jButtonNewStudentProfile.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonNewStudentProfile.setBounds(6, 0, 139, 100);
		panel_1.add(jButtonNewStudentProfile);
		
		JButton jBtnEditStudentProfile = new JButton("Edit");
		jBtnEditStudentProfile.setEnabled(false);
		jBtnEditStudentProfile.setBackground(Color.BLACK);
		jBtnEditStudentProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jFrameEditStudent editStudent = new jFrameEditStudent();
				editStudent.setVisible(true);				
			}
		});
		jBtnEditStudentProfile.setForeground(Color.LIGHT_GRAY);
		jBtnEditStudentProfile.setFont(new Font("SansSerif", Font.BOLD, 20));
		jBtnEditStudentProfile.setBounds(198, 0, 139, 100);
		panel_1.add(jBtnEditStudentProfile);
		
		JButton jBtnDeleteStudent = new JButton("Delete");
		jBtnDeleteStudent.setBackground(Color.BLACK);
		jBtnDeleteStudent.setEnabled(false);
		jBtnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonDeleteActionPerformed(e);
			}
		});
		jBtnDeleteStudent.setFont(new Font("SansSerif", Font.BOLD, 20));
		jBtnDeleteStudent.setForeground(new Color(211, 211, 211));
		jBtnDeleteStudent.setBounds(388, 0, 139, 100);
		panel_1.add(jBtnDeleteStudent);
		
		JButton jButtonExportToExcel = new JButton("Export to Excel");
		jButtonExportToExcel.setBackground(Color.BLACK);
		jButtonExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonExportToExcelActionPerformed(arg0);
			}
		});
		jButtonExportToExcel.setForeground(new Color(211, 211, 211));
		jButtonExportToExcel.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonExportToExcel.setBounds(572, 0, 187, 100);
		panel_1.add(jButtonExportToExcel);
		
		jButtonPrintListStudent = new JButton("Print Student");
		jButtonPrintListStudent.setEnabled(false);
		jButtonPrintListStudent.setBackground(Color.BLACK);
		jButtonPrintListStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameReportListStudent frameReportListStudent = new JFrameReportListStudent();
				frameReportListStudent.setVisible(true);
			}
		});
		jButtonPrintListStudent.setForeground(new Color(211, 211, 211));
		jButtonPrintListStudent.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonPrintListStudent.setBounds(808, 0, 156, 100);
		panel_1.add(jButtonPrintListStudent);
		
		JButton jBtnExit = new JButton("EXIT");
		jBtnExit.setBackground(Color.BLACK);
		jBtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		jBtnExit.setFont(new Font("SansSerif", Font.BOLD, 20));
		jBtnExit.setForeground(new Color(211, 211, 211));
		jBtnExit.setBounds(1034, 0, 156, 100);
		panel_1.add(jBtnExit);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBorder(new CompoundBorder());
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1290, 106);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 16));
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setBounds(18, 260, 1282, 620);
		contentPane.add(scrollPane);
		
		jTableStudentInfor = new JTable();
		jTableStudentInfor.setRowHeight(20);
		jTableStudentInfor.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		jTableStudentInfor.setFillsViewportHeight(true);
		jTableStudentInfor.setShowHorizontalLines(true);
		jTableStudentInfor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jTableStudentInfor.setSelectionBackground(Color.BLACK);
		jTableStudentInfor.setGridColor(Color.GRAY);
		jTableStudentInfor.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableStudentInfor.setForeground(new Color(211, 211, 211));
		jTableStudentInfor.setBackground(Color.DARK_GRAY);
		jTableStudentInfor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = jTableStudentInfor.getSelectedRow();
				idSelected = (int)jTableStudentInfor.getValueAt(selectedRow, 0);
				jBtnDeleteStudent.setEnabled(true);
				jBtnEditStudentProfile.setEnabled(true);
				jButtonPrintListStudent.setEnabled(true);
			}
		});
		scrollPane.setViewportView(jTableStudentInfor);
		
		JLabel lblNewLabel_1 = new JLabel("Search by Class");
		lblNewLabel_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 208, 124, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Search by Name ");
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(457, 209, 130, 36);
		contentPane.add(lblName);
		
		jTextFieldName = new JTextField();
		jTextFieldName.setForeground(new Color(211, 211, 211));
		jTextFieldName.setBackground(Color.DARK_GRAY);
		jTextFieldName.addKeyListener(new KeyAdapter() {
				@Override
			public void keyReleased(KeyEvent arg0) {
				String query = jTextFieldName.getText();
				filterUseJtextfield(query);
			}
		});
		jTextFieldName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldName.setBounds(588, 209, 316, 39);
		contentPane.add(jTextFieldName);
		jTextFieldName.setColumns(10);
		
		jComboBoxClass = new JComboBox();
		jComboBoxClass.setName("");
		jComboBoxClass.setForeground(new Color(240, 255, 255));
		jComboBoxClass.setBackground(Color.DARK_GRAY);
		jComboBoxClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String query = jComboBoxClass.getSelectedItem().toString();
				filterUseJComboBox(query);
			}
		});
		jComboBoxClass.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jComboBoxClass.setBounds(150, 209, 244, 36);
		contentPane.add(jComboBoxClass);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		lblNewLabel_3.setBounds(0, 78, 1317, 819);
		contentPane.add(lblNewLabel_3);
		loadData();
	}
	public void fillDataToTable(List<Student> students) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dm = new DefaultTableModel();
		dm.addColumn("ID");
		dm.addColumn("Student Code");
		dm.addColumn("Class");
		dm.addColumn("Name");
		dm.addColumn("Date of Birth");
		dm.addColumn("Sex");
		dm.addColumn("Address");
		dm.addColumn("Phone Number");
		dm.addColumn("Email");
		dm.addColumn("Remarks");
		for(Student student:students){
			ClassStudent classStudent = student.getClassStudent();
			dm.addRow(new Object[]{
					student.getId(), student.getStudentCode(), classStudent.getNameOfClass(), student.getName(),
					dateFormat.format(student.getDateOfBirth()), student.getSex(), student.getAddress(), 
					student.getPhoneNo(), student.getEmail(), student.getRemarks()});
		}
		jTableStudentInfor.setModel(dm);
	}
	public void loadData() {
		StudentDAO studentDAO = new StudentDAO();
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		fillDataToTable(studentDAO.findAll());	
		fillDataToComboBoxClass(classStudentDAO.findAll());
		
	}
	public void fillDataToComboBoxClass(List<ClassStudent> classStudents) {
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		comboBoxModel.addElement("All");
		for(ClassStudent classStudent:classStudentDAO.findAll()){
			comboBoxModel.addElement(classStudent.getNameOfClass());
		}
		jComboBoxClass.setModel(comboBoxModel);
	}
	public void jButtonDeleteActionPerformed(ActionEvent event) {
		StudentDAO studentDAO = new StudentDAO();
		FamilyDAO familyDAO = new FamilyDAO();
		AdmissionDAO admissionDAO = new AdmissionDAO();
		AcademicDAO academicDAO = new AcademicDAO();
		Student student = studentDAO.find(idSelected);
		for(Family family : student.getFamilies()){
			if(!(family==null)){
				familyDAO.delete(family);
			}
		}
		for(Admisson admisson : student.getAdmissons()){
			if(!(admisson==null))
				admissionDAO.delete(admisson);
		}
		for(Academic academic : student.getAcademics()){
			if(!(academic==null))
				academicDAO.delete(academic);
		}
		studentDAO.delete(student);
		JOptionPane.showMessageDialog(null, "Delete Successful");
		loadData();
	}
	private void filterUseJComboBox(String query) {
			TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
			jTableStudentInfor.setRowSorter(tr);
			if(query != "All"){
				tr.setRowFilter(RowFilter.regexFilter(query));
			}else{
				StudentDAO studentDAO = new StudentDAO();
				dm = new DefaultTableModel();
				dm.addColumn("ID");
				dm.addColumn("Student Code");
				dm.addColumn("Class");
				dm.addColumn("Name");
				dm.addColumn("Date of Birth");
				dm.addColumn("Sex");
				dm.addColumn("Address");
				dm.addColumn("Phone Number");
				dm.addColumn("Email");
				dm.addColumn("Remarks");
				for(Student student:studentDAO.findAll()){
					ClassStudent classStudent = student.getClassStudent();
					dm.addRow(new Object[]{
							student.getId(), student.getStudentCode(), classStudent.getNameOfClass(), student.getName(), student.getDateOfBirth(), student.getSex(), 
							 student.getAddress(), student.getPhoneNo(), student.getEmail(), student.getRemarks()
					});
				}
				jTableStudentInfor.setModel(dm);
			}
		
	}
	private void filterUseJtextfield(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		jTableStudentInfor.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	public void jButtonExportToExcelActionPerformed(ActionEvent event) {
		try {
			JFileChooser jf = new JFileChooser();
			jf.setDialogTitle("Save Excel File");
			int result = jf.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION){
				String excelPath = jf.getSelectedFile().getAbsolutePath();
				ExcelHelper excelHelper = new ExcelHelper(excelPath);
				StudentDAO studentDAO = new StudentDAO();
				excelHelper.writeData(studentDAO.findAllStudentExport());
				JOptionPane.showMessageDialog(null, "Done");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}

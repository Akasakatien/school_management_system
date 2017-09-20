package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.Set;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
import entities.Marks;
import entities.Student;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

public class jFrameEditStudent extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldStudentCode;
	private JTextField jTextFieldName;
	private JTextField jTextFieldDateOfBirthStudent;
	private JTextField jTextFieldAddressStudent;
	private JTextField jTextFieldEmailStudent;
	private JTextField jTextFieldPhoneNoStudent;
	private JTextField jTextFieldRegistrationNo;
	private JTextField jTextFieldStudentStatus;
	private JTextField jTextFieldDateStart;
	private JTextField jTextFieldProgram;
	private JTextField jTextFieldPreviousInstitute;
	private JTextField jTextFieldAdmissionDate;
	private JTextField jTextFieldReasonForLeaving;
	private JTextField jTextFieldNameFamily;
	private JTextField jTextFieldDateOfBirthFamily;
	private JTextField jTextFieldJobFamily;
	private JTextField jTextFieldEmailFamily;
	private JTextField jTextFieldPhoneFamily;
	private JTextField jTextFieldAddressFamily;
	private JScrollPane scrollPane_2;
	private JComboBox jComboBoxGrade;
	private JComboBox jComboBoxClass;
	private JComboBox jComboBoxGender;
	private JEditorPane jEditorPaneRemarks;
	private File file = null;
	private JTable jTableFamily;
	int id;
	int idFamily;
	int idAcademic;
	int idAdmission;
	private boolean flag = false;
	private JComboBox jComboBoxRelation;
	private JTable jTableAcademic;
	private JComboBox jComboBoxSection;
	private JComboBox jComboBoxSemester;
	private JTable jTableAdmissionInfor;
	private JLabel jLabelPhotoStudent;
	private JButton jButtonUpdateAdmission;
	private JButton jButtonUpdateAcademic;
	private JButton jButtonUpdateFamily;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					jFrameEditStudent frame = new jFrameEditStudent();
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
	public jFrameEditStudent() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1139, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLUE);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 1121, 74);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Student Information");
		label.setForeground(new Color(211, 211, 211));
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(397, 13, 373, 44);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		lblNewLabel.setBounds(0, 0, 1121, 74);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.setBounds(21, 82, 1076, 589);
		contentPane.add(tabbedPane);
		
		JPanel jPanelPersonalInformation = new JPanel();
		jPanelPersonalInformation.setBackground(Color.DARK_GRAY);
		jPanelPersonalInformation.setLayout(null);
		jPanelPersonalInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("  Personal Information  ", null, jPanelPersonalInformation, null);
		tabbedPane.setForegroundAt(0, Color.LIGHT_GRAY);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		
		JLabel label_1 = new JLabel("Student Code");
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_1.setBounds(47, 80, 114, 40);
		jPanelPersonalInformation.add(label_1);
		
		jTextFieldStudentCode = new JTextField();
		jTextFieldStudentCode.setBackground(SystemColor.controlHighlight);
		jTextFieldStudentCode.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldStudentCode.setColumns(10);
		jTextFieldStudentCode.setBounds(190, 81, 316, 40);
		jPanelPersonalInformation.add(jTextFieldStudentCode);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_2.setBounds(47, 152, 114, 40);
		jPanelPersonalInformation.add(label_2);
		
		jTextFieldName = new JTextField();
		jTextFieldName.setBackground(SystemColor.controlHighlight);
		jTextFieldName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldName.setColumns(10);
		jTextFieldName.setBounds(190, 153, 316, 40);
		jPanelPersonalInformation.add(jTextFieldName);
		
		JLabel label_3 = new JLabel("Photo");
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_3.setBounds(579, 80, 114, 40);
		jPanelPersonalInformation.add(label_3);
		
		jLabelPhotoStudent = new JLabel("");
		jLabelPhotoStudent.setBorder(new LineBorder(new Color(128, 128, 128)));
		jLabelPhotoStudent.setBounds(720, 80, 200, 200);
		jPanelPersonalInformation.add(jLabelPhotoStudent);
		
		JLabel label_5 = new JLabel("Date of Birth");
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_5.setBounds(47, 220, 114, 40);
		jPanelPersonalInformation.add(label_5);
		
		jTextFieldDateOfBirthStudent = new JTextField();
		jTextFieldDateOfBirthStudent.setBackground(SystemColor.controlHighlight);
		jTextFieldDateOfBirthStudent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldDateOfBirthStudent.setColumns(10);
		jTextFieldDateOfBirthStudent.setBounds(190, 221, 316, 40);
		jPanelPersonalInformation.add(jTextFieldDateOfBirthStudent);
		
		JButton jButtonBrowser = new JButton("Browser");
		jButtonBrowser.setForeground(new Color(211, 211, 211));
		jButtonBrowser.setBackground(Color.BLACK);
		jButtonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select Photo");
				chooser.setMultiSelectionEnabled(false);
				chooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
				chooser.setFileFilter(new FileTypeFilter(".jpeg", "JPEG"));
				chooser.setFileFilter(new FileTypeFilter(".gif", "GIF"));
				chooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					ImageIcon imageIcon = new ImageIcon( new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)); 
					jLabelPhotoStudent.setIcon(imageIcon);
				}
				flag = true;
			}
		});
		jButtonBrowser.setFont(new Font("SansSerif", Font.PLAIN, 12));
		jButtonBrowser.setBounds(720, 286, 200, 42);
		jPanelPersonalInformation.add(jButtonBrowser);
		
		jComboBoxGender = new JComboBox();
		jComboBoxGender.setBackground(Color.GRAY);
		jComboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		jComboBoxGender.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jComboBoxGender.setBounds(190, 289, 121, 40);
		jPanelPersonalInformation.add(jComboBoxGender);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(new Color(211, 211, 211));
		label_6.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_6.setBounds(47, 289, 114, 40);
		jPanelPersonalInformation.add(label_6);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setForeground(new Color(211, 211, 211));
		label_7.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_7.setBounds(47, 359, 114, 40);
		jPanelPersonalInformation.add(label_7);
		
		jTextFieldAddressStudent = new JTextField();
		jTextFieldAddressStudent.setBackground(SystemColor.controlHighlight);
		jTextFieldAddressStudent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldAddressStudent.setColumns(10);
		jTextFieldAddressStudent.setBounds(190, 360, 316, 40);
		jPanelPersonalInformation.add(jTextFieldAddressStudent);
		
		jTextFieldEmailStudent = new JTextField();
		jTextFieldEmailStudent.setBackground(SystemColor.controlHighlight);
		jTextFieldEmailStudent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldEmailStudent.setColumns(10);
		jTextFieldEmailStudent.setBounds(721, 360, 294, 40);
		jPanelPersonalInformation.add(jTextFieldEmailStudent);
		
		jTextFieldPhoneNoStudent = new JTextField();
		jTextFieldPhoneNoStudent.setBackground(SystemColor.controlHighlight);
		jTextFieldPhoneNoStudent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldPhoneNoStudent.setColumns(10);
		jTextFieldPhoneNoStudent.setBounds(721, 451, 294, 40);
		jPanelPersonalInformation.add(jTextFieldPhoneNoStudent);
		
		JLabel label_8 = new JLabel("Email");
		label_8.setForeground(new Color(211, 211, 211));
		label_8.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_8.setBounds(579, 359, 114, 40);
		jPanelPersonalInformation.add(label_8);
		
		JLabel label_9 = new JLabel("Phone Number");
		label_9.setForeground(new Color(211, 211, 211));
		label_9.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_9.setBounds(579, 450, 121, 40);
		jPanelPersonalInformation.add(label_9);
		
		JButton jButtonUpdatePersonalInfor = new JButton("Save");
		jButtonUpdatePersonalInfor.setForeground(new Color(211, 211, 211));
		jButtonUpdatePersonalInfor.setBackground(Color.BLACK);
		jButtonUpdatePersonalInfor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSavePersonalInforActionPerformed(arg0);
			}
		});
		jButtonUpdatePersonalInfor.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonUpdatePersonalInfor.setBounds(470, 504, 147, 33);
		jPanelPersonalInformation.add(jButtonUpdatePersonalInfor);
		
		JLabel label_10 = new JLabel("Remarks");
		label_10.setForeground(new Color(211, 211, 211));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(47, 444, 114, 33);
		jPanelPersonalInformation.add(label_10);
		
		jEditorPaneRemarks = new JEditorPane();
		jEditorPaneRemarks.setIgnoreRepaint(true);
		jEditorPaneRemarks.setBackground(new Color(0, 0, 0));
		jEditorPaneRemarks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jEditorPaneRemarks.setBounds(190, 425, 316, 66);
		jPanelPersonalInformation.add(jEditorPaneRemarks);
		
		jComboBoxGrade = new JComboBox();
		jComboBoxGrade.setBackground(Color.GRAY);
		jComboBoxGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
//				int selected = jComboBoxGender.getSelectedIndex();
//				GradeDAO gradeDAO = new GradeDAO();
//				ClassStudentDAO classStudentDAO = new ClassStudentDAO();
//				Grade grade = gradeDAO.find(selected);
//				for(ClassStudent classStudent : grade.getClassStudents()){
//					comboBoxModel.addElement(classStudent.getNameOfClass());
//				}
//				jComboBoxClass.setModel(comboBoxModel);
			}
		});
		jComboBoxGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxGrade.setBounds(190, 13, 316, 40);
		jPanelPersonalInformation.add(jComboBoxGrade);
		
		jComboBoxClass = new JComboBox();
		jComboBoxClass.setBackground(Color.GRAY);
		jComboBoxClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxClass.setBounds(720, 13, 200, 40);
		jPanelPersonalInformation.add(jComboBoxClass);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(new Color(211, 211, 211));
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrade.setBounds(47, 11, 106, 42);
		jPanelPersonalInformation.add(lblGrade);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setForeground(new Color(211, 211, 211));
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClass.setBounds(579, 12, 87, 40);
		jPanelPersonalInformation.add(lblClass);
		
		JPanel jPanelFamilyInfo = new JPanel();
		jPanelFamilyInfo.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Family Information  ", null, jPanelFamilyInfo, null);
		jPanelFamilyInfo.setLayout(null);
		
		JLabel label_11 = new JLabel("Name");
		label_11.setForeground(new Color(211, 211, 211));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(38, 223, 120, 38);
		jPanelFamilyInfo.add(label_11);
		
		jTextFieldNameFamily = new JTextField();
		jTextFieldNameFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldNameFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldNameFamily.setColumns(10);
		jTextFieldNameFamily.setBounds(192, 223, 336, 39);
		jPanelFamilyInfo.add(jTextFieldNameFamily);
		
		JLabel label_12 = new JLabel("Date of Birth");
		label_12.setForeground(new Color(211, 211, 211));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBounds(38, 284, 120, 38);
		jPanelFamilyInfo.add(label_12);
		
		JLabel label_13 = new JLabel("Job");
		label_13.setForeground(new Color(211, 211, 211));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_13.setBounds(592, 223, 95, 38);
		jPanelFamilyInfo.add(label_13);
		
		JLabel label_14 = new JLabel("Email");
		label_14.setForeground(new Color(211, 211, 211));
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(592, 284, 108, 38);
		jPanelFamilyInfo.add(label_14);
		
		JLabel label_15 = new JLabel("Phone");
		label_15.setForeground(new Color(211, 211, 211));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_15.setBounds(592, 347, 95, 38);
		jPanelFamilyInfo.add(label_15);
		
		JLabel label_16 = new JLabel("Address");
		label_16.setForeground(new Color(211, 211, 211));
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setBounds(38, 411, 120, 38);
		jPanelFamilyInfo.add(label_16);
		
		jTextFieldDateOfBirthFamily = new JTextField();
		jTextFieldDateOfBirthFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldDateOfBirthFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldDateOfBirthFamily.setColumns(10);
		jTextFieldDateOfBirthFamily.setBounds(192, 285, 191, 38);
		jPanelFamilyInfo.add(jTextFieldDateOfBirthFamily);
		
		jTextFieldJobFamily = new JTextField();
		jTextFieldJobFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldJobFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldJobFamily.setColumns(10);
		jTextFieldJobFamily.setBounds(712, 223, 335, 39);
		jPanelFamilyInfo.add(jTextFieldJobFamily);
		
		jTextFieldEmailFamily = new JTextField();
		jTextFieldEmailFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldEmailFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldEmailFamily.setColumns(10);
		jTextFieldEmailFamily.setBounds(712, 284, 336, 40);
		jPanelFamilyInfo.add(jTextFieldEmailFamily);
		
		jTextFieldPhoneFamily = new JTextField();
		jTextFieldPhoneFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldPhoneFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldPhoneFamily.setColumns(10);
		jTextFieldPhoneFamily.setBounds(711, 347, 336, 40);
		jPanelFamilyInfo.add(jTextFieldPhoneFamily);
		
		jTextFieldAddressFamily = new JTextField();
		jTextFieldAddressFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldAddressFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldAddressFamily.setColumns(10);
		jTextFieldAddressFamily.setBounds(192, 412, 856, 38);
		jPanelFamilyInfo.add(jTextFieldAddressFamily);
		
		JLabel label_17 = new JLabel("Relation");
		label_17.setForeground(new Color(211, 211, 211));
		label_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_17.setBounds(38, 346, 120, 38);
		jPanelFamilyInfo.add(label_17);
		
		jComboBoxRelation = new JComboBox();
		jComboBoxRelation.setBackground(Color.GRAY);
		jComboBoxRelation.setModel(new DefaultComboBoxModel(new String[] {"Father", "Mother", "Sister", "Brother", "Young Sister", "Young Brother"}));
		jComboBoxRelation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxRelation.setBounds(192, 347, 191, 38);
		jPanelFamilyInfo.add(jComboBoxRelation);
		
		JLabel label_18 = new JLabel("(dd/MM/yyyy)");
		label_18.setForeground(new Color(211, 211, 211));
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_18.setBounds(394, 284, 134, 38);
		jPanelFamilyInfo.add(label_18);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 13, 1043, 186);
		jPanelFamilyInfo.add(scrollPane);
		
		jTableFamily = new JTable();
		jTableFamily.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableFamily.setShowHorizontalLines(true);
		jTableFamily.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jTableFamily.setSelectionBackground(Color.BLACK);
		jTableFamily.setRowHeight(20);
		jTableFamily.setGridColor(Color.GRAY);
		jTableFamily.setForeground(new Color(211, 211, 211));
		jTableFamily.setBackground(Color.DARK_GRAY);
		jTableFamily.setFillsViewportHeight(true);
		jTableFamily.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTableFamilyAction(arg0);
			}
		});
		scrollPane.setViewportView(jTableFamily);
		
		jButtonUpdateFamily = new JButton("Save");
		jButtonUpdateFamily.setForeground(new Color(211, 211, 211));
		jButtonUpdateFamily.setBackground(Color.BLACK);
		jButtonUpdateFamily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonSaveFamilyActionPerformed(e);
			}
		});
		jButtonUpdateFamily.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonUpdateFamily.setBounds(483, 469, 145, 38);
		jPanelFamilyInfo.add(jButtonUpdateFamily);
		
		JPanel jPanelAcademicInfo = new JPanel();
		jPanelAcademicInfo.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Academic Information  ", null, jPanelAcademicInfo, null);
		jPanelAcademicInfo.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 13, 1040, 169);
		jPanelAcademicInfo.add(scrollPane_1);
		
		jTableAcademic = new JTable();
		jTableAcademic.setRowHeight(20);
		jTableAcademic.setShowHorizontalLines(true);
		jTableAcademic.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jTableAcademic.setSelectionBackground(Color.BLACK);
		jTableAcademic.setGridColor(Color.GRAY);
		jTableAcademic.setForeground(new Color(211, 211, 211));
		jTableAcademic.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableAcademic.setFillsViewportHeight(true);
		jTableAcademic.setBackground(Color.DARK_GRAY);
		jTableAcademic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTableAcademicAction(arg0);
			}
		});
		scrollPane_1.setViewportView(jTableAcademic);
		
		JLabel label_19 = new JLabel("Program");
		label_19.setForeground(new Color(211, 211, 211));
		label_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_19.setBounds(43, 238, 127, 36);
		jPanelAcademicInfo.add(label_19);
		
		JLabel label_20 = new JLabel("Registration No");
		label_20.setForeground(new Color(211, 211, 211));
		label_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_20.setBounds(43, 319, 133, 36);
		jPanelAcademicInfo.add(label_20);
		
		JLabel label_21 = new JLabel("Date Start");
		label_21.setForeground(new Color(211, 211, 211));
		label_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_21.setBounds(562, 397, 142, 36);
		jPanelAcademicInfo.add(label_21);
		
		JLabel label_22 = new JLabel("Semester");
		label_22.setForeground(new Color(211, 211, 211));
		label_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_22.setBounds(43, 397, 142, 36);
		jPanelAcademicInfo.add(label_22);
		
		JLabel label_23 = new JLabel("Student Status");
		label_23.setForeground(new Color(211, 211, 211));
		label_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_23.setBounds(562, 319, 142, 36);
		jPanelAcademicInfo.add(label_23);
		
		JLabel label_24 = new JLabel("Section");
		label_24.setForeground(new Color(211, 211, 211));
		label_24.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_24.setBounds(562, 238, 119, 36);
		jPanelAcademicInfo.add(label_24);
		
		jComboBoxSemester = new JComboBox();
		jComboBoxSemester.setBackground(Color.GRAY);
		jComboBoxSemester.setModel(new DefaultComboBoxModel(new String[] {"Semester I", "Semester II", "Semester III", "Semester IV", "Semester VI", "Semester VII", "Semester VIII"}));
		jComboBoxSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxSemester.setBounds(196, 395, 284, 43);
		jPanelAcademicInfo.add(jComboBoxSemester);
		
		jTextFieldRegistrationNo = new JTextField();
		jTextFieldRegistrationNo.setBackground(SystemColor.controlHighlight);
		jTextFieldRegistrationNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldRegistrationNo.setColumns(10);
		jTextFieldRegistrationNo.setBounds(196, 317, 284, 43);
		jPanelAcademicInfo.add(jTextFieldRegistrationNo);
		
		jComboBoxSection = new JComboBox();
		jComboBoxSection.setBackground(Color.GRAY);
		jComboBoxSection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxSection.setBounds(711, 236, 85, 43);
		jPanelAcademicInfo.add(jComboBoxSection);
		
		jTextFieldStudentStatus = new JTextField();
		jTextFieldStudentStatus.setBackground(SystemColor.controlHighlight);
		jTextFieldStudentStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldStudentStatus.setColumns(10);
		jTextFieldStudentStatus.setBounds(711, 317, 284, 43);
		jPanelAcademicInfo.add(jTextFieldStudentStatus);
		
		jTextFieldDateStart = new JTextField();
		jTextFieldDateStart.setBackground(SystemColor.controlHighlight);
		jTextFieldDateStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldDateStart.setColumns(10);
		jTextFieldDateStart.setBounds(711, 395, 167, 43);
		jPanelAcademicInfo.add(jTextFieldDateStart);
		
		jTextFieldProgram = new JTextField();
		jTextFieldProgram.setBackground(SystemColor.controlHighlight);
		jTextFieldProgram.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldProgram.setColumns(10);
		jTextFieldProgram.setBounds(196, 237, 284, 41);
		jPanelAcademicInfo.add(jTextFieldProgram);
		
		jButtonUpdateAcademic = new JButton("Save");
		jButtonUpdateAcademic.setForeground(new Color(211, 211, 211));
		jButtonUpdateAcademic.setBackground(Color.BLACK);
		jButtonUpdateAcademic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSaveAcademicActionPerFormed(arg0);
			}
		});
		jButtonUpdateAcademic.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonUpdateAcademic.setBounds(474, 471, 142, 36);
		jPanelAcademicInfo.add(jButtonUpdateAcademic);
		
		JLabel label_25 = new JLabel("(dd/MM/yyyy)");
		label_25.setForeground(new Color(211, 211, 211));
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_25.setBounds(890, 397, 105, 36);
		jPanelAcademicInfo.add(label_25);
		
		JPanel jPanelAdmissionInformation = new JPanel();
		jPanelAdmissionInformation.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Admission Information  ", null, jPanelAdmissionInformation, null);
		jPanelAdmissionInformation.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(17, 13, 1041, 189);
		jPanelAdmissionInformation.add(scrollPane_2);
		
		jTableAdmissionInfor = new JTable();
		jTableAdmissionInfor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableAdmissionInfor.setRowHeight(20);
		jTableAdmissionInfor.setShowHorizontalLines(true);
		jTableAdmissionInfor.setSelectionBackground(Color.BLACK);
		jTableAdmissionInfor.setGridColor(Color.GRAY);
		jTableAdmissionInfor.setForeground(new Color(211, 211, 211));
		jTableAdmissionInfor.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableAdmissionInfor.setFillsViewportHeight(true);
		jTableAdmissionInfor.setBackground(Color.DARK_GRAY);
		jTableAdmissionInfor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTableAdmissionAction(arg0);
			}
		});
		scrollPane_2.setViewportView(jTableAdmissionInfor);
		
		JLabel label_26 = new JLabel("Admission Date");
		label_26.setForeground(new Color(211, 211, 211));
		label_26.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_26.setBounds(226, 312, 174, 40);
		jPanelAdmissionInformation.add(label_26);
		
		JLabel label_27 = new JLabel("Previous Institute");
		label_27.setForeground(new Color(211, 211, 211));
		label_27.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_27.setBounds(226, 230, 174, 40);
		jPanelAdmissionInformation.add(label_27);
		
		JLabel label_28 = new JLabel("Reason for Leaving");
		label_28.setForeground(new Color(211, 211, 211));
		label_28.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_28.setBounds(226, 398, 174, 40);
		jPanelAdmissionInformation.add(label_28);
		
		jTextFieldPreviousInstitute = new JTextField();
		jTextFieldPreviousInstitute.setBackground(SystemColor.controlHighlight);
		jTextFieldPreviousInstitute.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldPreviousInstitute.setColumns(10);
		jTextFieldPreviousInstitute.setBounds(442, 231, 364, 40);
		jPanelAdmissionInformation.add(jTextFieldPreviousInstitute);
		
		jTextFieldAdmissionDate = new JTextField();
		jTextFieldAdmissionDate.setBackground(SystemColor.controlHighlight);
		jTextFieldAdmissionDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldAdmissionDate.setColumns(10);
		jTextFieldAdmissionDate.setBounds(442, 313, 364, 40);
		jPanelAdmissionInformation.add(jTextFieldAdmissionDate);
		
		jTextFieldReasonForLeaving = new JTextField();
		jTextFieldReasonForLeaving.setBackground(SystemColor.controlHighlight);
		jTextFieldReasonForLeaving.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldReasonForLeaving.setColumns(10);
		jTextFieldReasonForLeaving.setBounds(442, 399, 364, 40);
		jPanelAdmissionInformation.add(jTextFieldReasonForLeaving);
		
		jButtonUpdateAdmission = new JButton("Save");
		jButtonUpdateAdmission.setForeground(new Color(211, 211, 211));
		jButtonUpdateAdmission.setBackground(Color.BLACK);
		jButtonUpdateAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSaveAdmissionActionPerformed(arg0);
			}
		});
		jButtonUpdateAdmission.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonUpdateAdmission.setBounds(442, 470, 137, 40);
		jPanelAdmissionInformation.add(jButtonUpdateAdmission);
		
		JButton jBtnOk = new JButton("OK");
		jBtnOk.setForeground(new Color(211, 211, 211));
		jBtnOk.setBackground(Color.BLACK);
		jBtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameStudentInfor jFrameStudentInfor = new JFrameStudentInfor();
				jFrameStudentInfor.loadData();
				dispose();
			}
		});
		jBtnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jBtnOk.setBounds(893, 684, 107, 35);
		contentPane.add(jBtnOk);
		
		JButton jBtnCancel = new JButton("Cancel");
		jBtnCancel.setForeground(new Color(211, 211, 211));
		jBtnCancel.setBackground(Color.BLACK);
		jBtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jBtnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jBtnCancel.setBounds(1012, 684, 97, 35);
		contentPane.add(jBtnCancel);
		
		JLabel lblNewLabelContain = new JLabel("");
		lblNewLabelContain.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		lblNewLabelContain.setBounds(0, 74, 1121, 658);
		contentPane.add(lblNewLabelContain);
		loadData();
		
	}
	public void loadData(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		GradeDAO gradeDAO = new GradeDAO();
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();	
		Student student = new Student();
		StudentDAO studentDAO = new StudentDAO();
		student = studentDAO.find(JFrameStudentInfor.idSelected);
		
		fillDataToComboBoxGrade(gradeDAO.findAll());
		fillDataToComboBoxClass(classStudentDAO.findAll());
		
		

		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(student.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		jLabelPhotoStudent.setIcon(imageIcon);	 
		
		jComboBoxClass.setSelectedItem(student.getClassStudent().getNameOfClass());	
		jComboBoxGrade.setSelectedItem(student.getClassStudent().getGrade().getGradeName());
		
		jTextFieldName.setText(student.getName());
		jTextFieldAddressStudent.setText(student.getAddress());
//		jTextFieldDateOfBirthStudent.setText(student.getDateOfBirth().toString());
		jTextFieldDateOfBirthStudent.setText(dateFormat.format(student.getDateOfBirth()));
		jTextFieldPhoneNoStudent.setText(student.getPhoneNo().toString());
		jTextFieldStudentCode.setText(student.getStudentCode().toString());
		jEditorPaneRemarks.setText(student.getRemarks());
		jTextFieldEmailStudent.setText(student.getEmail());
		jComboBoxGender.setSelectedItem(student.getSex());
		
		loadDataToFamily();
		loadDataToComboBoxSection();
		loadDataToAcademic();
		loadDataToAdmission();		
	}
	public void loadDataToComboBoxSection(){
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		comboBoxModel.addElement("A");
		comboBoxModel.addElement("B");
		comboBoxModel.addElement("C");
		comboBoxModel.addElement("D");
		jComboBoxSection.setModel(comboBoxModel);
	}
	public void fillDataToComboBoxGrade(List<Grade> grades) {
		GradeDAO gradeDAO = new GradeDAO();
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		for(Grade grade:gradeDAO.findAll()){
			comboBoxModel.addElement(grade.getGradeName());
		}
		jComboBoxGrade.setModel(comboBoxModel);
	}
	public void fillDataToComboBoxClass(List<ClassStudent> classStudents) {
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		for(ClassStudent classStudent:classStudentDAO.findAll()){
			comboBoxModel.addElement(classStudent.getNameOfClass());
		}
		jComboBoxClass.setModel(comboBoxModel);
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
	public void jButtonSavePersonalInforActionPerformed(ActionEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		String value = jComboBoxGender.getSelectedItem().toString();
		int selectedIndex = jComboBoxClass.getSelectedIndex();	
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		ClassStudent classStudent = classStudentDAO.findAll().get(selectedIndex);
		
		student.setClassStudent(classStudent);
		student.setStudentCode(Integer.parseInt(jTextFieldStudentCode.getText()));
		student.setName(jTextFieldName.getText());
		try {
			student.setDateOfBirth(dateFormat.parse(jTextFieldDateOfBirthStudent.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		student.setSex(value);
		student.setAddress(jTextFieldAddressStudent.getText());
		student.setPhoneNo(Integer.parseInt(jTextFieldPhoneNoStudent.getText()));
		student.setEmail(jTextFieldEmailStudent.getText());
		student.setRemarks(jEditorPaneRemarks.getText());
		if(flag == true){
			student.setPhoto(ConvertFile(file.getAbsolutePath()));
		}
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Student> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		studentDAO.update(student);
		JOptionPane.showMessageDialog(null, "Update infomation student successful");
		
	}
	
	public void loadDataToFamily() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Relation");
		defaultTableModel.addColumn("Date of Birth");
		defaultTableModel.addColumn("Job");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone Number");
		defaultTableModel.addColumn("Email");
		for(Family family : student.getFamilies()){
			defaultTableModel.addRow(new Object[]{
					family.getFamilyId(), family.getName(), family.getRelation(), dateFormat.format(family.getDateOfBirth()), family.getJob(), family.getAddress(),
					family.getPhoneNumber(), family.getEmail()	});
		}
		jTableFamily.setModel(defaultTableModel);
	}
	public void loadDataToAcademic() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Registration No");
		defaultTableModel.addColumn("Program");
		defaultTableModel.addColumn("Semester");
		defaultTableModel.addColumn("Section");
		defaultTableModel.addColumn("Date Start");
		defaultTableModel.addColumn("Student Status");
		for(Academic academic : student.getAcademics()){
			defaultTableModel.addRow(new Object[]{
					academic.getAcademicId(), academic.getRegistrationNo(), academic.getProgram(), academic.getSemester(), academic.getSection(),
					dateFormat.format(academic.getDateStart()), academic.getStudentStatus()});
		}
		jTableAcademic.setModel(defaultTableModel);
	}
	public void loadDataToAdmission() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Previous Institute");
		defaultTableModel.addColumn("Admission Date");
		defaultTableModel.addColumn("Reason for Leaving");
		for(Admisson admisson : student.getAdmissons()){
			defaultTableModel.addRow(new Object[]{
				admisson.getAdmissonId(), admisson.getPreviousInstitute(), dateFormat.format(admisson.getDateofAdmisson()), admisson.getReasonForLeave() });
		}
		jTableAdmissionInfor.setModel(defaultTableModel);
	}
	public void mouseClickedTableFamilyAction(MouseEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FamilyDAO familyDAO = new FamilyDAO();
		int selectedRowFamily = jTableFamily.getSelectedRow();
		idFamily = (int) jTableFamily.getValueAt(selectedRowFamily, 0);
		Family family = familyDAO.find(idFamily);
		jTextFieldNameFamily.setText(family.getName());
		jTextFieldJobFamily.setText(family.getJob());
		jTextFieldAddressFamily.setText(family.getAddress());
		jTextFieldDateOfBirthFamily.setText(dateFormat.format(family.getDateOfBirth()));
//		jTextFieldDateOfBirthFamily.setText(family.getDateOfBirth().toString());
		jTextFieldEmailFamily.setText(family.getEmail());
		jTextFieldPhoneFamily.setText(family.getPhoneNumber().toString());
		String familyRelation = family.getRelation();
		jComboBoxRelation.setSelectedItem(familyRelation);
	}	
	public void mouseClickedTableAcademicAction(MouseEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		AcademicDAO academicDAO = new AcademicDAO();
		int selectedRowAcademic = jTableAcademic.getSelectedRow();
		idAcademic = (int) jTableAcademic.getValueAt(selectedRowAcademic, 0);
		Academic academic = academicDAO.find(idAcademic);
		jTextFieldProgram.setText(academic.getProgram());
		jTextFieldRegistrationNo.setText(academic.getRegistrationNo().toString());
		jTextFieldDateStart.setText(dateFormat.format(academic.getDateStart()));
//		jTextFieldDateStart.setText(academic.getDateStart().toString());
		jTextFieldStudentStatus.setText(academic.getStudentStatus());
		String section = academic.getSection();
		jComboBoxSection.setSelectedItem(section);
		String semester = academic.getSemester();
		jComboBoxSemester.setSelectedItem(semester);
	}
	public void mouseClickedTableAdmissionAction(MouseEvent event){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		AdmissionDAO admissionDAO = new AdmissionDAO();
		int selectedRowAdmission = jTableAdmissionInfor.getSelectedRow();
		idAdmission = (int)	jTableAdmissionInfor.getValueAt(selectedRowAdmission, 0);
		Admisson admisson = admissionDAO.find(idAdmission);
		jTextFieldAdmissionDate.setText(dateFormat.format(admisson.getDateofAdmisson()));
//		jTextFieldAdmissionDate.setText(admisson.getDateofAdmisson().toString());
		jTextFieldPreviousInstitute.setText(admisson.getPreviousInstitute());
		jTextFieldReasonForLeaving.setText(admisson.getReasonForLeave());
	}
	public void jButtonSaveFamilyActionPerformed(ActionEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		
		FamilyDAO familyDAO = new FamilyDAO();
		Family family = familyDAO.find(idFamily);
		String value = jComboBoxRelation.getSelectedItem().toString();
		family.setStudent(student);
		family.setName(jTextFieldNameFamily.getText());
		try {
			family.setDateOfBirth(dateFormat.parse(jTextFieldDateOfBirthFamily.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		family.setJob(jTextFieldJobFamily.getText());
		family.setAddress(jTextFieldAddressFamily.getText());
		family.setEmail(jTextFieldEmailFamily.getText());
		family.setPhoneNumber(Integer.parseInt(jTextFieldPhoneFamily.getText()));
		family.setRelation(value);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Family>> constraintViolations = validator.validate(family);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Family> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		familyDAO.update(family);
		JOptionPane.showMessageDialog(null, "Update family successful");
		loadDataToFamily();
	}
	
	public void loadDataToTableAcademic() {
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Registration No");
		defaultTableModel.addColumn("Program");
		defaultTableModel.addColumn("Semester");
		defaultTableModel.addColumn("Section");
		defaultTableModel.addColumn("Date Start");
		defaultTableModel.addColumn("Student Status");
		for(Academic academic : student.getAcademics()){
			defaultTableModel.addRow(new Object[]{
					academic.getRegistrationNo(), academic.getProgram(), academic.getSemester(), academic.getSection(),
					academic.getDateStart(), academic.getStudentStatus()});
		}
		jTableAcademic.setModel(defaultTableModel);
	}
	public void jButtonSaveAcademicActionPerFormed(ActionEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		AcademicDAO academicDAO = new AcademicDAO();
		Academic academic = academicDAO.find(idAcademic);
		String value = jComboBoxSemester.getSelectedItem().toString();
		String value1 = jComboBoxSection.getSelectedItem().toString();
		academic.setStudent(student);
		academic.setProgram(jTextFieldProgram.getText());
		try {
			academic.setDateStart(dateFormat.parse(jTextFieldDateStart.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		academic.setRegistrationNo(Integer.parseInt(jTextFieldRegistrationNo.getText()));
		academic.setStudentStatus(jTextFieldStudentStatus.getText());
		academic.setSemester(value);
		academic.setSection(value1);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Academic>> constraintViolations = validator.validate(academic);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Academic> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		academicDAO.update(academic);
		JOptionPane.showMessageDialog(null, "Update Academic successful");
		loadDataToTableAcademic();	
	}

	public void loadDataToTableAdmission() {
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Previous Institute");
		defaultTableModel.addColumn("Admission Date");
		defaultTableModel.addColumn("Reason for Leaving");
		for(Admisson admisson : student.getAdmissons()){
			defaultTableModel.addRow(new Object[]{
				admisson.getPreviousInstitute(), admisson.getDateofAdmisson(), admisson.getReasonForLeave() });
		}
		jTableAdmissionInfor.setModel(defaultTableModel);
	}
	public void jButtonSaveAdmissionActionPerformed(ActionEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.find(JFrameStudentInfor.idSelected);
		AdmissionDAO admissionDAO = new AdmissionDAO();
		Admisson admisson = admissionDAO.find(idAdmission);
		
		admisson.setStudent(student);
		admisson.setPreviousInstitute(jTextFieldPreviousInstitute.getText());
		admisson.setReasonForLeave(jTextFieldReasonForLeaving.getText());
		try {
			admisson.setDateofAdmisson(dateFormat.parse(jTextFieldAdmissionDate.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Admisson>> constraintViolations = validator.validate(admisson);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Admisson> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		admissionDAO.update(admisson);
		JOptionPane.showMessageDialog(null, "Update Admission successful");
		loadDataToTableAdmission();
	}
}

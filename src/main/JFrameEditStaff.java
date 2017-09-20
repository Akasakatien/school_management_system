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

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.eclipse.jdt.core.compiler.ITerminalSymbols;

import dao.EducationalDAO;
import dao.FamilyDAO;
import dao.PromotionDAO;
import dao.StaffDAO;
import dao.StaffExperienceDAO;
import dao.StaffFamilyDAO;
import dao.StudentDAO;
import entities.Educational;
import entities.Family;
import entities.Marks;
import entities.Promotion;
import entities.Staff;
import entities.StaffExperience;
import entities.StaffFamily;
import entities.Student;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class JFrameEditStaff extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldStaffCode;
	private JTextField jTextFieldNameStaff;
	private JTextField jTextFieldDateOfBirthStaff;
	private JTextField jTextFieldAddressStaff;
	private JTextField jTextFieldEmailStaff;
	private JTextField jTextFieldPhoneNumberStaff;
	private JTextField jTextFieldNameFamily;
	private JTextField jTextFieldDateOfBirthFamily;
	private JTextField jTextFieldJob;
	private JTextField jTextFieldEmailFamily;
	private JTextField jTextFieldPhoneFamily;
	private JTextField jTextFieldAddressFamily;
	private JTable jTableFamilyInfor;
	private JTable jTableEducational;
	private JTextField jTextFieldNameOfUniverOrInstitute;
	private JTextField jTextFieldYearOfEducation;
	private JTextField jTextFieldDegree;
	private JTextField jTextFieldGrade;
	private JTable jTableExperience;
	private JTextField jTextFieldNameOfWorkplace;
	private JTextField jTextFieldYearWorking;
	private JTextField jTextFieldPosition;
	private JTextField jTextFieldAchievement;
	private JTable jTablePromotion;
	private JTextField jTextFieldNameOfPosition;
	private JTextField jTextFieldAchievementPromotion;
	private JComboBox jComboBoxGender;
	private JEditorPane jEditorPaneFeedback;
	private File file = null;
	int idStaff;
	int idStaffFamily;
	int idEducational;
	int idStaffExperience;
	int idPromotion;
	private JLabel jLabelPhoto;
	private JComboBox jComboBoxRelation;
	private boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEditStaff frame = new JFrameEditStaff();
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
	public JFrameEditStaff() {
		setBounds(100, 100, 1140, 797);
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
		
		JLabel lblStaffInformation = new JLabel("Staff Information");
		lblStaffInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffInformation.setForeground(new Color(211, 211, 211));
		lblStaffInformation.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblStaffInformation.setBounds(397, 13, 373, 44);
		panel.add(lblStaffInformation);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1121, 74);
		panel.add(lblNewLabel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.setBounds(22, 82, 1076, 604);
		contentPane.add(tabbedPane);
		
		JPanel jPanelPersonalInformation = new JPanel();
		jPanelPersonalInformation.setBackground(Color.DARK_GRAY);
		jPanelPersonalInformation.setLayout(null);
		jPanelPersonalInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("  Personal Information  ", null, jPanelPersonalInformation, null);
		
		JLabel lblStaffCode = new JLabel("Staff Code");
		lblStaffCode.setForeground(new Color(211, 211, 211));
		lblStaffCode.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblStaffCode.setBounds(47, 28, 114, 40);
		jPanelPersonalInformation.add(lblStaffCode);
		
		jTextFieldStaffCode = new JTextField();
		jTextFieldStaffCode.setBackground(SystemColor.controlHighlight);
		jTextFieldStaffCode.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldStaffCode.setColumns(10);
		jTextFieldStaffCode.setBounds(190, 29, 316, 40);
		jPanelPersonalInformation.add(jTextFieldStaffCode);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setForeground(new Color(211, 211, 211));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_2.setBounds(47, 94, 114, 40);
		jPanelPersonalInformation.add(label_2);
		
		jTextFieldNameStaff = new JTextField();
		jTextFieldNameStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldNameStaff.setColumns(10);
		jTextFieldNameStaff.setBounds(190, 95, 316, 40);
		jPanelPersonalInformation.add(jTextFieldNameStaff);
		
		JLabel label_3 = new JLabel("Photo");
		label_3.setForeground(new Color(211, 211, 211));
		label_3.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_3.setBounds(579, 80, 114, 40);
		jPanelPersonalInformation.add(label_3);
		
		jLabelPhoto = new JLabel("");
		jLabelPhoto.setBorder(new LineBorder(Color.GRAY));
		jLabelPhoto.setBounds(720, 28, 200, 200);
		jPanelPersonalInformation.add(jLabelPhoto);
		
		JLabel label_5 = new JLabel("Date of Birth");
		label_5.setForeground(new Color(211, 211, 211));
		label_5.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_5.setBounds(47, 163, 114, 40);
		jPanelPersonalInformation.add(label_5);
		
		jTextFieldDateOfBirthStaff = new JTextField();
		jTextFieldDateOfBirthStaff.setBackground(SystemColor.controlHighlight);
		jTextFieldDateOfBirthStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldDateOfBirthStaff.setColumns(10);
		jTextFieldDateOfBirthStaff.setBounds(190, 164, 316, 40);
		jPanelPersonalInformation.add(jTextFieldDateOfBirthStaff);
		
		JButton jButtonBrowser = new JButton("Browser");
		jButtonBrowser.setForeground(new Color(211, 211, 211));
		jButtonBrowser.setBackground(Color.BLACK);
		jButtonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					jLabelPhoto.setIcon(imageIcon);
				}
			}
		});
		jButtonBrowser.setFont(new Font("SansSerif", Font.PLAIN, 12));
		jButtonBrowser.setBounds(720, 241, 200, 42);
		jPanelPersonalInformation.add(jButtonBrowser);
		
		jComboBoxGender = new JComboBox();
		jComboBoxGender.setBackground(Color.GRAY);
		jComboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		jComboBoxGender.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jComboBoxGender.setBounds(190, 231, 121, 40);
		jPanelPersonalInformation.add(jComboBoxGender);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(new Color(211, 211, 211));
		label_6.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_6.setBounds(47, 231, 114, 40);
		jPanelPersonalInformation.add(label_6);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setForeground(new Color(211, 211, 211));
		label_7.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_7.setBounds(47, 306, 114, 40);
		jPanelPersonalInformation.add(label_7);
		
		jTextFieldAddressStaff = new JTextField();
		jTextFieldAddressStaff.setBackground(SystemColor.controlHighlight);
		jTextFieldAddressStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldAddressStaff.setColumns(10);
		jTextFieldAddressStaff.setBounds(190, 307, 316, 40);
		jPanelPersonalInformation.add(jTextFieldAddressStaff);
		
		jTextFieldEmailStaff = new JTextField();
		jTextFieldEmailStaff.setBackground(SystemColor.controlHighlight);
		jTextFieldEmailStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldEmailStaff.setColumns(10);
		jTextFieldEmailStaff.setBounds(720, 307, 294, 40);
		jPanelPersonalInformation.add(jTextFieldEmailStaff);
		
		jTextFieldPhoneNumberStaff = new JTextField();
		jTextFieldPhoneNumberStaff.setBackground(SystemColor.controlHighlight);
		jTextFieldPhoneNumberStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldPhoneNumberStaff.setColumns(10);
		jTextFieldPhoneNumberStaff.setBounds(720, 400, 294, 40);
		jPanelPersonalInformation.add(jTextFieldPhoneNumberStaff);
		
		JLabel label_8 = new JLabel("Email");
		label_8.setForeground(new Color(211, 211, 211));
		label_8.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_8.setBounds(579, 306, 114, 40);
		jPanelPersonalInformation.add(label_8);
		
		JLabel label_9 = new JLabel("Phone Number");
		label_9.setForeground(new Color(211, 211, 211));
		label_9.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_9.setBounds(579, 399, 121, 40);
		jPanelPersonalInformation.add(label_9);
		
		JButton jButtonSavePersonalInfor = new JButton("Save");
		jButtonSavePersonalInfor.setForeground(new Color(211, 211, 211));
		jButtonSavePersonalInfor.setBackground(Color.BLACK);
		jButtonSavePersonalInfor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSavePersonalInforActionPerformed(arg0);
			}
		});
		jButtonSavePersonalInfor.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonSavePersonalInfor.setBounds(469, 487, 147, 33);
		jPanelPersonalInformation.add(jButtonSavePersonalInfor);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setForeground(new Color(211, 211, 211));
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFeedback.setBounds(47, 404, 114, 33);
		jPanelPersonalInformation.add(lblFeedback);
		
		jEditorPaneFeedback = new JEditorPane();
		jEditorPaneFeedback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jEditorPaneFeedback.setBounds(190, 374, 316, 66);
		jPanelPersonalInformation.add(jEditorPaneFeedback);
		
		JPanel jPanelFamilyInformation = new JPanel();
		jPanelFamilyInformation.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Family Information  ", null, jPanelFamilyInformation, null);
		jPanelFamilyInformation.setLayout(null);
		
		JLabel label_13 = new JLabel("Name");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_13.setBounds(38, 223, 120, 38);
		jPanelFamilyInformation.add(label_13);
		
		jTextFieldNameFamily = new JTextField();
		jTextFieldNameFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldNameFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldNameFamily.setColumns(10);
		jTextFieldNameFamily.setBounds(192, 223, 336, 39);
		jPanelFamilyInformation.add(jTextFieldNameFamily);
		
		JLabel label_14 = new JLabel("Date of Birth");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(38, 284, 120, 38);
		jPanelFamilyInformation.add(label_14);
		
		JLabel label_15 = new JLabel("Job");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_15.setBounds(592, 223, 95, 38);
		jPanelFamilyInformation.add(label_15);
		
		JLabel label_16 = new JLabel("Email");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setBounds(592, 284, 108, 38);
		jPanelFamilyInformation.add(label_16);
		
		JLabel label_17 = new JLabel("Phone");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_17.setBounds(592, 347, 95, 38);
		jPanelFamilyInformation.add(label_17);
		
		JLabel label_18 = new JLabel("Address");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_18.setBounds(38, 411, 120, 38);
		jPanelFamilyInformation.add(label_18);
		
		jTextFieldDateOfBirthFamily = new JTextField();
		jTextFieldDateOfBirthFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldDateOfBirthFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldDateOfBirthFamily.setColumns(10);
		jTextFieldDateOfBirthFamily.setBounds(192, 285, 191, 38);
		jPanelFamilyInformation.add(jTextFieldDateOfBirthFamily);
		
		jTextFieldJob = new JTextField();
		jTextFieldJob.setBackground(SystemColor.controlHighlight);
		jTextFieldJob.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldJob.setColumns(10);
		jTextFieldJob.setBounds(712, 223, 335, 39);
		jPanelFamilyInformation.add(jTextFieldJob);
		
		jTextFieldEmailFamily = new JTextField();
		jTextFieldEmailFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldEmailFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldEmailFamily.setColumns(10);
		jTextFieldEmailFamily.setBounds(712, 284, 336, 40);
		jPanelFamilyInformation.add(jTextFieldEmailFamily);
		
		jTextFieldPhoneFamily = new JTextField();
		jTextFieldPhoneFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldPhoneFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldPhoneFamily.setColumns(10);
		jTextFieldPhoneFamily.setBounds(711, 347, 336, 40);
		jPanelFamilyInformation.add(jTextFieldPhoneFamily);
		
		jTextFieldAddressFamily = new JTextField();
		jTextFieldAddressFamily.setBackground(SystemColor.controlHighlight);
		jTextFieldAddressFamily.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldAddressFamily.setColumns(10);
		jTextFieldAddressFamily.setBounds(192, 412, 856, 38);
		jPanelFamilyInformation.add(jTextFieldAddressFamily);
		
		JLabel label_19 = new JLabel("Relation");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_19.setBounds(38, 346, 120, 38);
		jPanelFamilyInformation.add(label_19);
		
		jComboBoxRelation = new JComboBox();
		jComboBoxRelation.setBackground(Color.GRAY);
		jComboBoxRelation.setModel(new DefaultComboBoxModel(new String[] {"Father", "Mother", "Brother", "Sister", "Young Brother", "Young Sister"}));
		jComboBoxRelation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jComboBoxRelation.setBounds(192, 347, 191, 38);
		jPanelFamilyInformation.add(jComboBoxRelation);
		
		JLabel label_20 = new JLabel("(dd/MM/yyyy)");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_20.setBounds(394, 284, 134, 38);
		jPanelFamilyInformation.add(label_20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 13, 1040, 186);
		jPanelFamilyInformation.add(scrollPane);
		
		jTableFamilyInfor = new JTable();
		jTableFamilyInfor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTableFamilyInforMouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(jTableFamilyInfor);
		
		JButton jButtonSaveFamily = new JButton("Save");
		jButtonSaveFamily.setForeground(new Color(211, 211, 211));
		jButtonSaveFamily.setBackground(Color.BLACK);
		jButtonSaveFamily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSaveFamilyActionPerformed(arg0);
			}
		});
		jButtonSaveFamily.setFont(new Font("Tahoma", Font.BOLD, 16));
		jButtonSaveFamily.setBounds(483, 488, 145, 38);
		jPanelFamilyInformation.add(jButtonSaveFamily);
		
		JPanel jPanelEducational = new JPanel();
		jPanelEducational.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Educational  ", null, jPanelEducational, null);
		jPanelEducational.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 13, 1039, 192);
		jPanelEducational.add(scrollPane_1);
		
		jTableEducational = new JTable();
		jTableEducational.setShowHorizontalLines(true);
		jTableEducational.setSelectionBackground(Color.BLACK);
		jTableEducational.setRowHeight(20);
		jTableEducational.setGridColor(Color.GRAY);
		jTableEducational.setForeground(new Color(211, 211, 211));
		jTableEducational.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableEducational.setFillsViewportHeight(true);
		jTableEducational.setBackground(Color.DARK_GRAY);
		jTableEducational.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableEducationalInforMouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(jTableEducational);
		
		JLabel lblNameofuniversityorinstituteofeducation = new JLabel("Name of University or Institute");
		lblNameofuniversityorinstituteofeducation.setForeground(new Color(211, 211, 211));
		lblNameofuniversityorinstituteofeducation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameofuniversityorinstituteofeducation.setBounds(252, 232, 265, 31);
		jPanelEducational.add(lblNameofuniversityorinstituteofeducation);
		
		JLabel lblYearOfEducational = new JLabel("Year of Education");
		lblYearOfEducational.setForeground(new Color(211, 211, 211));
		lblYearOfEducational.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYearOfEducational.setBounds(252, 303, 265, 31);
		jPanelEducational.add(lblYearOfEducational);
		
		JLabel lblNewLabel = new JLabel("Degree");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(252, 378, 265, 31);
		jPanelEducational.add(lblNewLabel);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(new Color(211, 211, 211));
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrade.setBounds(252, 447, 265, 31);
		jPanelEducational.add(lblGrade);
		
		jTextFieldNameOfUniverOrInstitute = new JTextField();
		jTextFieldNameOfUniverOrInstitute.setBackground(SystemColor.controlHighlight);
		jTextFieldNameOfUniverOrInstitute.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldNameOfUniverOrInstitute.setBounds(517, 227, 341, 40);
		jPanelEducational.add(jTextFieldNameOfUniverOrInstitute);
		jTextFieldNameOfUniverOrInstitute.setColumns(10);
		
		jTextFieldYearOfEducation = new JTextField();
		jTextFieldYearOfEducation.setBackground(SystemColor.controlHighlight);
		jTextFieldYearOfEducation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldYearOfEducation.setColumns(10);
		jTextFieldYearOfEducation.setBounds(517, 298, 341, 40);
		jPanelEducational.add(jTextFieldYearOfEducation);
		
		jTextFieldDegree = new JTextField();
		jTextFieldDegree.setBackground(SystemColor.controlHighlight);
		jTextFieldDegree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldDegree.setColumns(10);
		jTextFieldDegree.setBounds(517, 373, 341, 40);
		jPanelEducational.add(jTextFieldDegree);
		
		jTextFieldGrade = new JTextField();
		jTextFieldGrade.setBackground(SystemColor.controlHighlight);
		jTextFieldGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldGrade.setColumns(10);
		jTextFieldGrade.setBounds(517, 442, 341, 40);
		jPanelEducational.add(jTextFieldGrade);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(211, 211, 211));
		btnSave.setBackground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSaveEducationalActionPerformed(arg0);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(517, 506, 118, 31);
		jPanelEducational.add(btnSave);
		
		JPanel jPanelExperience = new JPanel();
		jPanelExperience.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Experience  ", null, jPanelExperience, null);
		jPanelExperience.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(17, 13, 1040, 189);
		jPanelExperience.add(scrollPane_2);
		
		jTableExperience = new JTable();
		jTableExperience.setShowHorizontalLines(true);
		jTableExperience.setSelectionBackground(Color.BLACK);
		jTableExperience.setRowHeight(20);
		jTableExperience.setGridColor(Color.GRAY);
		jTableExperience.setForeground(new Color(211, 211, 211));
		jTableExperience.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableExperience.setFillsViewportHeight(true);
		jTableExperience.setBackground(Color.DARK_GRAY);
		jTableExperience.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableExperienceInforMouseClicked(e);
			}
		});
		scrollPane_2.setViewportView(jTableExperience);
		
		JLabel lblNameofworkplace = new JLabel("name of Workplace");
		lblNameofworkplace.setForeground(new Color(211, 211, 211));
		lblNameofworkplace.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameofworkplace.setBounds(250, 229, 191, 40);
		jPanelExperience.add(lblNameofworkplace);
		
		JLabel lblYearOfWorking = new JLabel("Year of Working");
		lblYearOfWorking.setForeground(new Color(211, 211, 211));
		lblYearOfWorking.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYearOfWorking.setBounds(250, 296, 191, 40);
		jPanelExperience.add(lblYearOfWorking);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setForeground(new Color(211, 211, 211));
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPosition.setBounds(250, 366, 191, 40);
		jPanelExperience.add(lblPosition);
		
		JLabel lblAchievement = new JLabel("Achievement");
		lblAchievement.setForeground(new Color(211, 211, 211));
		lblAchievement.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAchievement.setBounds(250, 438, 191, 40);
		jPanelExperience.add(lblAchievement);
		
		jTextFieldNameOfWorkplace = new JTextField();
		jTextFieldNameOfWorkplace.setBackground(SystemColor.controlHighlight);
		jTextFieldNameOfWorkplace.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldNameOfWorkplace.setBounds(441, 229, 384, 40);
		jPanelExperience.add(jTextFieldNameOfWorkplace);
		jTextFieldNameOfWorkplace.setColumns(10);
		
		jTextFieldYearWorking = new JTextField();
		jTextFieldYearWorking.setBackground(SystemColor.controlHighlight);
		jTextFieldYearWorking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldYearWorking.setColumns(10);
		jTextFieldYearWorking.setBounds(441, 296, 384, 40);
		jPanelExperience.add(jTextFieldYearWorking);
		
		jTextFieldPosition = new JTextField();
		jTextFieldPosition.setBackground(SystemColor.controlHighlight);
		jTextFieldPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldPosition.setColumns(10);
		jTextFieldPosition.setBounds(441, 366, 384, 40);
		jPanelExperience.add(jTextFieldPosition);
		
		jTextFieldAchievement = new JTextField();
		jTextFieldAchievement.setBackground(SystemColor.controlHighlight);
		jTextFieldAchievement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldAchievement.setColumns(10);
		jTextFieldAchievement.setBounds(441, 438, 384, 40);
		jPanelExperience.add(jTextFieldAchievement);
		
		JButton jBtnSaveExperience = new JButton("Save");
		jBtnSaveExperience.setForeground(new Color(211, 211, 211));
		jBtnSaveExperience.setBackground(Color.BLACK);
		jBtnSaveExperience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSaveExperienceActionPerformed(arg0);
			}
		});
		jBtnSaveExperience.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jBtnSaveExperience.setBounds(441, 507, 121, 33);
		jPanelExperience.add(jBtnSaveExperience);
		
		JPanel jPanelPromotion = new JPanel();
		jPanelPromotion.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("  Promotion  ", null, jPanelPromotion, null);
		jPanelPromotion.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(21, 13, 1029, 186);
		jPanelPromotion.add(scrollPane_3);
		
		jTablePromotion = new JTable();
		jTablePromotion.setShowHorizontalLines(true);
		jTablePromotion.setSelectionBackground(Color.BLACK);
		jTablePromotion.setRowHeight(20);
		jTablePromotion.setGridColor(Color.GRAY);
		jTablePromotion.setForeground(new Color(211, 211, 211));
		jTablePromotion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTablePromotion.setFillsViewportHeight(true);
		jTablePromotion.setBackground(Color.DARK_GRAY);
		jTablePromotion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTablePromotionInforMouseClicked(e);
			}
		});
		scrollPane_3.setViewportView(jTablePromotion);
		
		JLabel lblNewLabel_1 = new JLabel("Name of Position");
		lblNewLabel_1.setForeground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(249, 311, 251, 40);
		jPanelPromotion.add(lblNewLabel_1);
		
		JLabel lblAchivement = new JLabel("Achievement");
		lblAchivement.setForeground(new Color(211, 211, 211));
		lblAchivement.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAchivement.setBounds(249, 368, 251, 40);
		jPanelPromotion.add(lblAchivement);
		
		jTextFieldNameOfPosition = new JTextField();
		jTextFieldNameOfPosition.setBackground(SystemColor.controlHighlight);
		jTextFieldNameOfPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldNameOfPosition.setBounds(499, 311, 340, 40);
		jPanelPromotion.add(jTextFieldNameOfPosition);
		jTextFieldNameOfPosition.setColumns(10);
		
		jTextFieldAchievementPromotion = new JTextField();
		jTextFieldAchievementPromotion.setBackground(SystemColor.controlHighlight);
		jTextFieldAchievementPromotion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextFieldAchievementPromotion.setBounds(499, 368, 340, 40);
		jPanelPromotion.add(jTextFieldAchievementPromotion);
		jTextFieldAchievementPromotion.setColumns(10);
		
		JButton jBtnSavePromotion = new JButton("Save");
		jBtnSavePromotion.setForeground(new Color(211, 211, 211));
		jBtnSavePromotion.setBackground(Color.BLACK);
		jBtnSavePromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButtonSavePromotionActionPerformed(arg0);
			}
		});
		jBtnSavePromotion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jBtnSavePromotion.setBounds(499, 428, 114, 32);
		jPanelPromotion.add(jBtnSavePromotion);
		
		JButton button = new JButton("OK");
		button.setForeground(new Color(211, 211, 211));
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jFrameStaffInfor frameStaffInfor = new jFrameStaffInfor();
				frameStaffInfor.loadData();
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(894, 699, 107, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setForeground(new Color(211, 211, 211));
		button_1.setBackground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(1013, 699, 97, 35);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		lblNewLabel_3.setBounds(0, 74, 1121, 676);
		contentPane.add(lblNewLabel_3);
		loadData();
	}
	public void loadData() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(staff.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		jLabelPhoto.setIcon(imageIcon);
		jTextFieldNameStaff.setText(staff.getName());
		jTextFieldEmailStaff.setText(staff.getEmail());
		jTextFieldDateOfBirthStaff.setText(dateFormat.format(staff.getDateOfBirth()));
		jTextFieldAddressStaff.setText(staff.getAddress());
		jTextFieldPhoneNumberStaff.setText(staff.getPhone().toString());
		jTextFieldStaffCode.setText(staff.getStaffCode().toString());
		jEditorPaneFeedback.setText(staff.getFeedback());
		loadDataToFamily();
		loadDataToEducational();
		loadDataToExperience();
		loadDataToPromotion();
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
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		staff.setStaffCode(Integer.parseInt(jTextFieldStaffCode.getText()));
		staff.setName(jTextFieldNameStaff.getText());	
		try {
			staff.setDateOfBirth(dateFormat.parse(jTextFieldDateOfBirthStaff.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		staff.setEmail(jTextFieldEmailStaff.getText());
		staff.setAddress(jTextFieldAddressStaff.getText());
		staff.setPhone(Integer.parseInt(jTextFieldPhoneNumberStaff.getText()));
		staff.setFeedback(jEditorPaneFeedback.getText());
		staff.setSex(jComboBoxGender.getSelectedItem().toString());
		if(flag == true){
			staff.setPhoto(ConvertFile(file.getAbsolutePath()));
		}
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Staff>> constraintViolations = validator.validate(staff);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Staff> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		staffDAO.update(staff);
		JOptionPane.showMessageDialog(null, "Update staff successful");
	}
	public void createTableFamily() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Relation");
		defaultTableModel.addColumn("Date of Birth");
		defaultTableModel.addColumn("Job");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone Number");
		defaultTableModel.addColumn("Email");
		jTableFamilyInfor.setModel(defaultTableModel);
	}
	public void loadDataToFamily() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Relation");
		defaultTableModel.addColumn("Date of Birth");
		defaultTableModel.addColumn("Job");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone Number");
		defaultTableModel.addColumn("Email");
		for(StaffFamily staffFamily : staff.getStaffFamilies()){
			defaultTableModel.addRow(new Object[]{
				staffFamily.getFamilyId(), staffFamily.getName(), staffFamily.getRelation(), dateFormat.format(staffFamily.getDateOfBirth()), 
				staffFamily.getJob(), staffFamily.getAddress(),staffFamily.getPhoneNumber(), staffFamily.getEmail()});
		}
		jTableFamilyInfor.setModel(defaultTableModel);
	}
	public void loadDataToEducational() {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name of Uni or Institute");
		defaultTableModel.addColumn("Year of Education");
		defaultTableModel.addColumn("Degree");
		defaultTableModel.addColumn("Grade");
		for(Educational educational:staff.getEducationals()){
			defaultTableModel.addRow(new Object[]{
					educational.getId(), educational.getNameOfUniversityOrInstitute(), educational.getYearOfEducation(),
					educational.getDegree(), educational.getGrade()
			});
		}
		jTableEducational.setModel(defaultTableModel);
	}
	public void loadDataToExperience() {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name of Workplace");
		defaultTableModel.addColumn("Year of Working");
		defaultTableModel.addColumn("Position");
		defaultTableModel.addColumn("Achievement");
		for(StaffExperience staffExperience:staff.getStaffExperiences()){
			defaultTableModel.addRow(new Object[]{
					staffExperience.getId(), staffExperience.getNameOfWorkplace(), staffExperience.getYearOfWorking(),
					staffExperience.getPosition(), staffExperience.getAchievement()
			});
		}
		jTableExperience.setModel(defaultTableModel);
	}
	public void loadDataToPromotion() {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name of Position");
		defaultTableModel.addColumn("Achievement");
		for(Promotion promotion:staff.getPromotions()){
			defaultTableModel.addRow(new Object[]{
					promotion.getId(), promotion.getNameOfPosition(), promotion.getAchievements()
			});
		}
		jTablePromotion.setModel(defaultTableModel);
	}
	public void jTableFamilyInforMouseClicked(MouseEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StaffFamilyDAO staffFamilyDAO = new StaffFamilyDAO();
		int selectedRowStaffFamily = jTableFamilyInfor.getSelectedRow();
		idStaffFamily = (int) jTableFamilyInfor.getValueAt(selectedRowStaffFamily, 0);
		StaffFamily staffFamily = staffFamilyDAO.find(idStaffFamily);
		jTextFieldNameFamily.setText(staffFamily.getName());
		jTextFieldAddressFamily.setText(staffFamily.getAddress());
//		jTextFieldDateOfBirthFamily.setText(staffFamily.getDateOfBirth().toString());
		jTextFieldDateOfBirthFamily.setText(dateFormat.format(staffFamily.getDateOfBirth()));
		jTextFieldPhoneFamily.setText(staffFamily.getPhoneNumber().toString());
		jComboBoxRelation.setSelectedItem(staffFamily.getRelation());
		jTextFieldJob.setText(staffFamily.getJob());
		jTextFieldEmailFamily.setText(staffFamily.getEmail());
		
	}
	public void jTableEducationalInforMouseClicked(MouseEvent event) {
		EducationalDAO educationalDAO = new EducationalDAO();
		int selectedRowEducational = jTableEducational.getSelectedRow();
		idEducational = (int) jTableEducational.getValueAt(selectedRowEducational, 0);
		Educational educational = educationalDAO.find(idEducational);
		jTextFieldNameOfUniverOrInstitute.setText(educational.getNameOfUniversityOrInstitute());
		jTextFieldYearOfEducation.setText(educational.getYearOfEducation());
		jTextFieldDegree.setText(educational.getDegree());
		jTextFieldGrade.setText(educational.getGrade());
	}
	public void jTableExperienceInforMouseClicked(MouseEvent event) {
		StaffExperienceDAO staffExperienceDAO = new StaffExperienceDAO();
		int selectedRowStaffExperience = jTableExperience.getSelectedRow();
		idStaffExperience = (int) jTableExperience.getValueAt(selectedRowStaffExperience, 0);
		StaffExperience staffExperience = staffExperienceDAO.find(idStaffExperience);
		jTextFieldNameOfWorkplace.setText(staffExperience.getNameOfWorkplace());
		jTextFieldYearWorking.setText(staffExperience.getYearOfWorking());
		jTextFieldAchievement.setText(staffExperience.getAchievement());
		jTextFieldPosition.setText(staffExperience.getPosition());
	}
	public void jTablePromotionInforMouseClicked(MouseEvent event) {
		PromotionDAO promotionDAO = new PromotionDAO();
		int selectedRowPromotion = jTablePromotion.getSelectedRow();
		idPromotion = (int) jTablePromotion.getValueAt(selectedRowPromotion, 0);
		Promotion promotion = promotionDAO.find(idPromotion);
		jTextFieldAchievementPromotion.setText(promotion.getAchievements());
		jTextFieldNameOfPosition.setText(promotion.getNameOfPosition());
	}
	public void jButtonSaveFamilyActionPerformed(ActionEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);	
		StaffFamilyDAO staffFamilyDAO = new StaffFamilyDAO();
		StaffFamily staffFamily = staffFamilyDAO.find(idStaffFamily);
		
		staffFamily.setStaff(staff);
		staffFamily.setName(jTextFieldNameFamily.getText());
		staffFamily.setAddress(jTextFieldAddressFamily.getText());
		staffFamily.setPhoneNumber(Integer.parseInt(jTextFieldPhoneFamily.getText()));
		staffFamily.setJob(jTextFieldJob.getText());
		staffFamily.setEmail(jTextFieldEmailFamily.getText());
		try {
			staffFamily.setDateOfBirth(dateFormat.parse(jTextFieldDateOfBirthFamily.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		staffFamily.setRelation(jComboBoxGender.getSelectedItem().toString());
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<StaffFamily>> constraintViolations = validator.validate(staffFamily);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<StaffFamily> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		staffFamilyDAO.update(staffFamily);
		JOptionPane.showMessageDialog(null, "Update family successful");
		loadDataToFamily();
		
	}
	public void jButtonSaveEducationalActionPerformed(ActionEvent event) {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		EducationalDAO educationalDAO = new EducationalDAO();
		Educational educational = educationalDAO.find(idEducational);	
		educational.setStaff(staff);
		educational.setNameOfUniversityOrInstitute(jTextFieldNameOfUniverOrInstitute.getText());
		educational.setYearOfEducation(jTextFieldYearOfEducation.getText());
		educational.setDegree(jTextFieldDegree.getText());
		educational.setGrade(jTextFieldGrade.getText());
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Educational>> constraintViolations = validator.validate(educational);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Educational> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		educationalDAO.update(educational);
		JOptionPane.showMessageDialog(null, "Update Educational successfull");
		loadDataToEducational();
	}
	public void jButtonSaveExperienceActionPerformed(ActionEvent event) {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);	
		StaffExperienceDAO staffExperienceDAO = new StaffExperienceDAO();
		StaffExperience staffExperience = staffExperienceDAO.find(idStaffExperience);
		staffExperience.setStaff(staff);
		staffExperience.setNameOfWorkplace(jTextFieldNameOfWorkplace.getText());
		staffExperience.setYearOfWorking(jTextFieldYearWorking.getText());
		staffExperience.setPosition(jTextFieldPosition.getText());
		staffExperience.setAchievement(jTextFieldAchievement.getText());
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<StaffExperience>> constraintViolations = validator.validate(staffExperience);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<StaffExperience> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		staffExperienceDAO.update(staffExperience);
		JOptionPane.showMessageDialog(null, "Update Experience successfull");
		loadDataToExperience();
	}
	public void jButtonSavePromotionActionPerformed(ActionEvent event) {
		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.find(jFrameStaffInfor.idSelected);
		PromotionDAO promotionDAO = new PromotionDAO();
		Promotion promotion = promotionDAO.find(idPromotion);
		promotion.setStaff(staff);
		promotion.setNameOfPosition(jTextFieldNameOfPosition.getText());
		promotion.setAchievements(jTextFieldAchievementPromotion.getText());
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Promotion>> constraintViolations = validator.validate(promotion);
		if(!constraintViolations.isEmpty()){
			String errors = "Co " + constraintViolations.size() + " error! \n";
			for(ConstraintViolation<Promotion> violation :constraintViolations){
				errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
			}
			JOptionPane.showMessageDialog(null, errors);
		}
		promotionDAO.update(promotion);
		JOptionPane.showMessageDialog(null, "Update Promotion successfull");
		loadDataToPromotion();
	}
}

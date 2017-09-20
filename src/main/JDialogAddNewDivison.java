package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import dao.DivisonDAO;
import dao.DivisonIdDAO;
import dao.MarksDAO;
import dao.MarksIdDAO;
import dao.StaffDAO;
import dao.StudentDAO;
import dao.SubjectsDAO;
import entities.Divison;
import entities.DivisonId;
import entities.Marks;
import entities.MarksId;
import entities.Staff;
import entities.Student;
import entities.Subjects;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class JDialogAddNewDivison extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton JButtonSave;
	private JButton JButtonCancel;
	private JTextField JTextFieldNumberOfLesson;
	private JTextField JTextFieldTimeDivison;
	private JComboBox JComboBoxSubject;
	private JLabel lblSemesterI;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			JDialogAddNewDivison dialog = new JDialogAddNewDivison();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogAddNewDivison() {
		setBounds(100, 100, 484, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAddNewMarks = new JLabel("Add new divison");
			lblAddNewMarks.setForeground(new Color(211, 211, 211));
			lblAddNewMarks.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddNewMarks.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblAddNewMarks.setBounds(0, 0, 466, 56);
			contentPanel.add(lblAddNewMarks);
		}
		{
			JLabel lblSubject = new JLabel("Subject:");
			lblSubject.setForeground(new Color(211, 211, 211));
			lblSubject.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblSubject.setBounds(10, 74, 80, 30);
			contentPanel.add(lblSubject);
		}

		JComboBoxSubject = new JComboBox();
		JComboBoxSubject.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JComboBoxSubject.setBackground(Color.GRAY);
		JComboBoxSubject.setBounds(160, 74, 298, 35);
		contentPanel.add(JComboBoxSubject);

		lblSemesterI = new JLabel("number of lesson");
		lblSemesterI.setForeground(new Color(211, 211, 211));
		lblSemesterI.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSemesterI.setBounds(10, 129, 138, 30);
		contentPanel.add(lblSemesterI);

		JLabel lblSemesterIi = new JLabel("Time Divison");
		lblSemesterIi.setForeground(new Color(211, 211, 211));
		lblSemesterIi.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSemesterIi.setBounds(10, 186, 116, 30);
		contentPanel.add(lblSemesterIi);

		JTextFieldNumberOfLesson = new JTextField();
		JTextFieldNumberOfLesson.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldNumberOfLesson.setBackground(SystemColor.controlHighlight);
		JTextFieldNumberOfLesson.setBounds(160, 129, 298, 35);
		contentPanel.add(JTextFieldNumberOfLesson);
		JTextFieldNumberOfLesson.setColumns(10);

		JTextFieldTimeDivison = new JTextField();
		JTextFieldTimeDivison.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldTimeDivison.setBackground(SystemColor.controlHighlight);
		JTextFieldTimeDivison.setColumns(10);
		JTextFieldTimeDivison.setBounds(160, 186, 298, 35);
		contentPanel.add(JTextFieldTimeDivison);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 466, 56);
		contentPanel.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 55, 466, 180);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.setForeground(new Color(211, 211, 211));
				JButtonSave.setBackground(Color.BLACK);
				JButtonSave.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							DivisonDAO divisonDAO = new DivisonDAO();
							DivisonIdDAO divisonIdDAO = new DivisonIdDAO();
							Divison divison = new Divison();
							DivisonId divisonId = new DivisonId();
							Staff staff = new Staff();
							StaffDAO  staffDAO = new StaffDAO();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
							Subjects subjects = new Subjects();
							SubjectsDAO subjectsDAO = new SubjectsDAO();
							staff = staffDAO.find(JDialogListStaff.idStaff);
							subjects = subjectsDAO.findAll().get(JComboBoxSubject.getSelectedIndex());
							divisonId.setStaffId(staff.getId());
							divisonId.setSubjectsId(subjects.getId());
							
							divison.setId(divisonId);
							divison.setStaff(staff);
							divison.setSubjects(subjects);
							divison.setNumberOfLesson(Integer.valueOf(JTextFieldNumberOfLesson.getText()));
							divison.setTimeDivison(simpleDateFormat.parse(JTextFieldTimeDivison.getText()));
							
							ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
							Validator validator = validatorFactory.getValidator();
							Set<ConstraintViolation<Divison>> constraintViolations = validator.validate(divison);
							if(!constraintViolations.isEmpty()){
								String errors = "Co " + constraintViolations.size() + " error! \n";
								for(ConstraintViolation<Divison> violation :constraintViolations){
									errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
								}
								JOptionPane.showMessageDialog(null, errors);
							}
							divisonDAO.create(divison);
							JOptionPane.showMessageDialog(null, "Add new divison successfull");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Add new divison fail!");
						}
					}
				});
				JButtonSave.setActionCommand("OK");
				buttonPane.add(JButtonSave);
				getRootPane().setDefaultButton(JButtonSave);
			}
			{
				JButtonCancel = new JButton("Cancel");
				JButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						JFrameManagementDivison jFrameManagementDivison = new JFrameManagementDivison();
						jFrameManagementDivison.loadData();
						jFrameManagementDivison.setVisible(true);
					}
				});
				JButtonCancel.setForeground(new Color(211, 211, 211));
				JButtonCancel.setBackground(Color.BLACK);
				JButtonCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonCancel.setActionCommand("Cancel");
				buttonPane.add(JButtonCancel);
			}
		}
		loadData();

	}

	public void loadData() {
		SubjectsDAO subjectsDAO = new SubjectsDAO();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Subjects subject : subjectsDAO.findAll()) {
			defaultComboBoxModel.addElement(subject.getNameOfSubjects());
		}
		JComboBoxSubject.setModel(defaultComboBoxModel);

	}

}

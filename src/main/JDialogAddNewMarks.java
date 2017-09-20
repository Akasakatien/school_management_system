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

import dao.MarksDAO;
import dao.MarksIdDAO;
import dao.StudentDAO;
import dao.SubjectsDAO;
import entities.Marks;
import entities.MarksId;
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
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class JDialogAddNewMarks extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton JButtonSave;
	private JButton JButtonCancel;
	private JTextField JTextFieldSemesterI;
	private JTextField JTextFieldSemesterII;
	private JComboBox JComboBoxSubject;

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
			JDialogAddNewMarks dialog = new JDialogAddNewMarks();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogAddNewMarks() {
		setBounds(100, 100, 484, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAddNewMarks = new JLabel("Add new marks");
			lblAddNewMarks.setForeground(new Color(211, 211, 211));
			lblAddNewMarks.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddNewMarks.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblAddNewMarks.setBounds(0, 0, 466, 48);
			contentPanel.add(lblAddNewMarks);
		}
		{
			JLabel lblSubject = new JLabel("Subject:");
			lblSubject.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblSubject.setForeground(new Color(211, 211, 211));
			lblSubject.setBounds(10, 77, 101, 30);
			contentPanel.add(lblSubject);
		}

		JComboBoxSubject = new JComboBox();
		JComboBoxSubject.setBackground(Color.GRAY);
		JComboBoxSubject.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JComboBoxSubject.setBounds(123, 77, 335, 35);
		contentPanel.add(JComboBoxSubject);

		JLabel lblSemesterI = new JLabel("Semester I :");
		lblSemesterI.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSemesterI.setForeground(new Color(211, 211, 211));
		lblSemesterI.setBounds(10, 124, 101, 30);
		contentPanel.add(lblSemesterI);

		JLabel lblSemesterIi = new JLabel("Semester II:");
		lblSemesterIi.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSemesterIi.setForeground(new Color(211, 211, 211));
		lblSemesterIi.setBounds(10, 171, 101, 30);
		contentPanel.add(lblSemesterIi);

		JTextFieldSemesterI = new JTextField();
		JTextFieldSemesterI.setBackground(SystemColor.controlHighlight);
		JTextFieldSemesterI.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldSemesterI.setBounds(123, 124, 333, 35);
		contentPanel.add(JTextFieldSemesterI);
		JTextFieldSemesterI.setColumns(10);

		JTextFieldSemesterII = new JTextField();
		JTextFieldSemesterII.setBackground(SystemColor.controlHighlight);
		JTextFieldSemesterII.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldSemesterII.setColumns(10);
		JTextFieldSemesterII.setBounds(123, 171, 333, 35);
		contentPanel.add(JTextFieldSemesterII);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 466, 48);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 46, 466, 187);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.setForeground(new Color(211, 211, 211));
				JButtonSave.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonSave.setBackground(Color.BLACK);
				JButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							MarksDAO marksDAO = new MarksDAO();
							MarksIdDAO marksIdDAO = new MarksIdDAO();
							Marks marks = new Marks();
							MarksId marksId = new MarksId();
							Student student = new Student();
							StudentDAO studentDAO = new StudentDAO();
							Subjects subjects = new Subjects();
							SubjectsDAO subjectsDAO = new SubjectsDAO();
							student = studentDAO.find(JDialogListStudent.idStudent);
							subjects = subjectsDAO.findAll().get(JComboBoxSubject.getSelectedIndex());
							marksId.setIdOfStudent(student.getId());
							marksId.setIdOfSubjects(subjects.getId());
							
							marks.setId(marksId);
							marks.setStudent(student);
							marks.setSubjects(subjects);
							marks.setMarksSemesterI(Double.valueOf(JTextFieldSemesterI.getText()));
							marks.setMarksSemesterIi(Double.valueOf(JTextFieldSemesterII.getText()));
							marks.setTotalMarks((Double.valueOf(JTextFieldSemesterI.getText())
									+ Double.valueOf(JTextFieldSemesterII.getText()))/2);
							ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
							Validator validator = validatorFactory.getValidator();
							Set<ConstraintViolation<Marks>> constraintViolations = validator.validate(marks);
							if(!constraintViolations.isEmpty()){
								String errors = "Co " + constraintViolations.size() + " error! \n";
								for(ConstraintViolation<Marks> violation :constraintViolations){
									errors += violation.getPropertyPath() + ": " + violation.getMessage() + "\n";
								}
								JOptionPane.showMessageDialog(null, errors);
							}
							marksDAO.create(marks);
							JOptionPane.showMessageDialog(null, "Add new marks successfull");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Add new marks fail!");
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
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						JDialogListStudent jDialogListStudent = new JDialogListStudent();
						jDialogListStudent.loadData();
						jDialogListStudent.setVisible(true);
					}
				});
				JButtonCancel.setForeground(new Color(211, 211, 211));
				JButtonCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonCancel.setBackground(Color.BLACK);
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

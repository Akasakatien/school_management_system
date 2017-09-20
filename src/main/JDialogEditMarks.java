package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class JDialogEditMarks extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSemesterIi;
	private JTextField JTextFieldStudent;
	private JTextField JTextFieldSubject;
	private JTextField JTextFieldSemesterI;
	private JTextField JTextFieldSemesterII;
	private JButton JButtonSave;
	private JButton JButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogEditMarks dialog = new JDialogEditMarks();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogEditMarks() {
		setBounds(100, 100, 496, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEditMarks = new JLabel("Edit Marks");
		lblEditMarks.setForeground(new Color(211, 211, 211));
		lblEditMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditMarks.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEditMarks.setBounds(0, 0, 478, 39);
		contentPanel.add(lblEditMarks);
		
		JLabel lblStudent = new JLabel("Student :");
		lblStudent.setForeground(new Color(211, 211, 211));
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudent.setBounds(10, 61, 107, 29);
		contentPanel.add(lblStudent);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setForeground(new Color(211, 211, 211));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(10, 101, 107, 29);
		contentPanel.add(lblSubject);
		
		JLabel lblSemesterI = new JLabel("Semester I:");
		lblSemesterI.setForeground(new Color(211, 211, 211));
		lblSemesterI.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemesterI.setBounds(10, 141, 107, 29);
		contentPanel.add(lblSemesterI);
		
		lblSemesterIi = new JLabel("Semester II:");
		lblSemesterIi.setForeground(new Color(211, 211, 211));
		lblSemesterIi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemesterIi.setBounds(10, 181, 107, 29);
		contentPanel.add(lblSemesterIi);
		
		JTextFieldStudent = new JTextField();
		JTextFieldStudent.setBackground(SystemColor.controlHighlight);
		JTextFieldStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTextFieldStudent.setEnabled(false);
		JTextFieldStudent.setEditable(false);
		JTextFieldStudent.setBounds(127, 61, 343, 35);
		contentPanel.add(JTextFieldStudent);
		JTextFieldStudent.setColumns(10);
		
		JTextFieldSubject = new JTextField();
		JTextFieldSubject.setBackground(SystemColor.controlHighlight);
		JTextFieldSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTextFieldSubject.setEnabled(false);
		JTextFieldSubject.setEditable(false);
		JTextFieldSubject.setColumns(10);
		JTextFieldSubject.setBounds(127, 101, 343, 35);
		contentPanel.add(JTextFieldSubject);
		
		JTextFieldSemesterI = new JTextField();
		JTextFieldSemesterI.setBackground(SystemColor.controlHighlight);
		JTextFieldSemesterI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTextFieldSemesterI.setColumns(10);
		JTextFieldSemesterI.setBounds(127, 141, 343, 35);
		contentPanel.add(JTextFieldSemesterI);
		
		JTextFieldSemesterII = new JTextField();
		JTextFieldSemesterII.setBackground(SystemColor.controlHighlight);
		JTextFieldSemesterII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTextFieldSemesterII.setColumns(10);
		JTextFieldSemesterII.setBounds(127, 181, 343, 35);
		contentPanel.add(JTextFieldSemesterII);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 478, 39);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 39, 478, 247);
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
					public void actionPerformed(ActionEvent e) {
						MarksDAO marksDAO = new MarksDAO();
						MarksIdDAO marksIdDAO = new MarksIdDAO();
						Marks marks = new Marks();
						MarksId marksId = new MarksId();
						Student student = new Student();
						StudentDAO studentDAO = new StudentDAO();
						Subjects subjects = new Subjects();
						SubjectsDAO subjectsDAO = new SubjectsDAO();
						marks = marksDAO.findByName(JFrameManagementMarks.name);
						marks.setMarksSemesterI(Double.valueOf(JTextFieldSemesterI.getText()));
						marks.setMarksSemesterIi(Double.valueOf(JTextFieldSemesterII.getText()));
						marks.setTotalMarks((Double.valueOf(JTextFieldSemesterI.getText()) + Double.valueOf(JTextFieldSemesterII.getText()) )/2);
						marksDAO.update(marks);
						JOptionPane.showMessageDialog(null, "Update marks successfull");
						setVisible(true);
						JFrameManagementMarks jFrameManagementMarks = new JFrameManagementMarks();
						jFrameManagementMarks.loadData();
						jFrameManagementMarks.setEnabled(true);
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
						JFrameManagementMarks jFrameManagementMarks = new JFrameManagementMarks();
						jFrameManagementMarks.loadData();
						jFrameManagementMarks.setVisible(true);
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
	public void loadData(){
		MarksDAO marksDAO = new MarksDAO();
		MarksIdDAO marksIdDAO = new MarksIdDAO();
		Marks marks = new Marks();
		MarksId marksId = new MarksId();
		Student student = new Student();
		StudentDAO studentDAO = new StudentDAO();
		Subjects subjects = new Subjects();
		SubjectsDAO subjectsDAO = new SubjectsDAO();
		marks = marksDAO.findByName(JFrameManagementMarks.name);
		JTextFieldStudent.setText(marks.getStudent().getName());
		JTextFieldSubject.setText(marks.getSubjects().getNameOfSubjects());
		JTextFieldSemesterI.setText(String.valueOf(marks.getMarksSemesterI()));
		JTextFieldSemesterII.setText(String.valueOf(marks.getMarksSemesterIi()));
		
		
	}
}

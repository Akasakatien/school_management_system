package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DivisonDAO;
import dao.MarksDAO;
import dao.MarksIdDAO;
import dao.StudentDAO;
import dao.SubjectsDAO;
import entities.Divison;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class JDialogEditDivison extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSemesterIi;
	private JTextField JTextFieldStaff;
	private JTextField JTextFieldSubject;
	private JTextField JTextFieldNumberOfLesson;
	private JTextField JTextFieldTimeDivison;
	private JButton JButtonSave;
	private JButton JButtonCancel;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogEditDivison dialog = new JDialogEditDivison();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogEditDivison() {
		setBounds(100, 100, 573, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEditMarks = new JLabel("Edit Divison");
		lblEditMarks.setForeground(new Color(211, 211, 211));
		lblEditMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditMarks.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEditMarks.setBounds(0, 0, 554, 48);
		contentPanel.add(lblEditMarks);
		
		JLabel lblStudent = new JLabel("Staff :");
		lblStudent.setForeground(new Color(211, 211, 211));
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudent.setBounds(40, 61, 107, 29);
		contentPanel.add(lblStudent);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setForeground(new Color(211, 211, 211));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(40, 111, 107, 29);
		contentPanel.add(lblSubject);
		
		JLabel lblSemesterI = new JLabel("Number of lesson:");
		lblSemesterI.setForeground(new Color(211, 211, 211));
		lblSemesterI.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemesterI.setBounds(40, 159, 156, 29);
		contentPanel.add(lblSemesterI);
		
		lblSemesterIi = new JLabel("Time Divison:");
		lblSemesterIi.setForeground(new Color(211, 211, 211));
		lblSemesterIi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemesterIi.setBounds(40, 207, 120, 29);
		contentPanel.add(lblSemesterIi);
		
		JTextFieldStaff = new JTextField();
		JTextFieldStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldStaff.setBackground(SystemColor.controlHighlight);
		JTextFieldStaff.setEnabled(false);
		JTextFieldStaff.setEditable(false);
		JTextFieldStaff.setBounds(205, 59, 294, 35);
		contentPanel.add(JTextFieldStaff);
		JTextFieldStaff.setColumns(10);
		
		JTextFieldSubject = new JTextField();
		JTextFieldSubject.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldSubject.setBackground(SystemColor.controlHighlight);
		JTextFieldSubject.setEnabled(false);
		JTextFieldSubject.setEditable(false);
		JTextFieldSubject.setColumns(10);
		JTextFieldSubject.setBounds(205, 109, 294, 35);
		contentPanel.add(JTextFieldSubject);
		
		JTextFieldNumberOfLesson = new JTextField();
		JTextFieldNumberOfLesson.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldNumberOfLesson.setBackground(SystemColor.controlHighlight);
		JTextFieldNumberOfLesson.setColumns(10);
		JTextFieldNumberOfLesson.setBounds(205, 157, 294, 35);
		contentPanel.add(JTextFieldNumberOfLesson);
		
		JTextFieldTimeDivison = new JTextField();
		JTextFieldTimeDivison.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldTimeDivison.setBackground(SystemColor.controlHighlight);
		JTextFieldTimeDivison.setColumns(10);
		JTextFieldTimeDivison.setBounds(205, 205, 294, 35);
		contentPanel.add(JTextFieldTimeDivison);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 554, 48);
		contentPanel.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_1.setBounds(0, 46, 555, 213);
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
						Divison divison = new Divison();
						DivisonDAO divisonDAO = new DivisonDAO();
						try {
							
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

							divison = divisonDAO.findByName(JFrameManagementMarks.name);
							divison.setNumberOfLesson(Integer.valueOf(JTextFieldNumberOfLesson.getText()));
							divison.setTimeDivison(simpleDateFormat.parse(JTextFieldTimeDivison.getText()));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						divisonDAO.update(divison);
						JOptionPane.showMessageDialog(null, "Update divison successfull");
					}
				});
				JButtonSave.setActionCommand("OK");
				buttonPane.add(JButtonSave);
				getRootPane().setDefaultButton(JButtonSave);
			}
			{
				JButtonCancel = new JButton("Cancel");
				JButtonCancel.setForeground(new Color(211, 211, 211));
				JButtonCancel.setBackground(Color.BLACK);
				JButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						JFrameManagementDivison jFrameManagementDivison = new JFrameManagementDivison();
						jFrameManagementDivison.loadData();
						jFrameManagementDivison.setVisible(true);
					}
				});
				JButtonCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonCancel.setActionCommand("Cancel");
				buttonPane.add(JButtonCancel);
			}
		}
		loadData();
	}
	public void loadData(){
		Divison divison = new Divison();
		DivisonDAO divisonDAO = new DivisonDAO();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		divison = divisonDAO.findByName(JFrameManagementDivison.name);
		JTextFieldStaff.setText(divison.getStaff().getName());
		JTextFieldSubject.setText(divison.getSubjects().getNameOfSubjects());
		JTextFieldNumberOfLesson.setText(String.valueOf(divison.getNumberOfLesson()));
		JTextFieldTimeDivison.setText(String.valueOf(divison.getTimeDivison()));
		
		
	}
}

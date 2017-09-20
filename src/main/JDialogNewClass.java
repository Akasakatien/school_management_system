package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClassStudentDAO;
import dao.GradeDAO;
import entities.ClassStudent;
import entities.Grade;
import entities.Role;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JDialogNewClass extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton JButtonSave;
	private JTextField JTextFieldNameClass;
	private JComboBox JComboBoxGrade;
	private JButton JButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogNewClass dialog = new JDialogNewClass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogNewClass() {
		setBounds(100, 100, 413, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new class");
		lblNewLabel.setForeground(new Color(211, 211, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 391, 53);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 51, 375, 105);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setBounds(12, 9, 71, 28);
		panel.add(lblName);
		
		JLabel lblGrade = new JLabel("Grade :");
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblGrade.setForeground(new Color(211, 211, 211));
		lblGrade.setBounds(12, 58, 71, 28);
		panel.add(lblGrade);
		
		JTextFieldNameClass = new JTextField();
		JTextFieldNameClass.setBounds(77, 8, 298, 35);
		panel.add(JTextFieldNameClass);
		JTextFieldNameClass.setColumns(10);
		
		JComboBoxGrade = new JComboBox();
		JComboBoxGrade.setBounds(77, 57, 298, 35);
		panel.add(JComboBoxGrade);
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
							
							ClassStudent classStudent = new ClassStudent();
							ClassStudentDAO classStudentDAO = new ClassStudentDAO();
							
							GradeDAO gradeDAO = new GradeDAO();
							Grade grade = gradeDAO.findAll().get(JComboBoxGrade.getSelectedIndex());
							classStudent.setNameOfClass(JTextFieldNameClass.getText());
							classStudent.setGrade(grade);
							classStudentDAO.create(classStudent);
							JOptionPane.showMessageDialog(null, "Add new class successfull");
							JFrameManagementClass jFrameManagementClass = new JFrameManagementClass();
							jFrameManagementClass.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Add new class fail!");
							// TODO: handle exception
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
						int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
						switch (result){
							case 0:
								setVisible(false);
								JFrameManagementClass jFrameManagementClass = new JFrameManagementClass();
								jFrameManagementClass.loadData();
								jFrameManagementClass.setVisible(true);
								break;
							case 1:
								
								break;
							}
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
		ClassStudent classStudent = new ClassStudent();
		GradeDAO gradeDAO = new GradeDAO();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for(Grade grade :gradeDAO.findAll()){
			defaultComboBoxModel.addElement(grade.getGradeName());
		}
		JComboBoxGrade.setModel(defaultComboBoxModel);
	}
}

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

import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class JDialogUpdateClass extends JDialog {
	private JTextField JTextFieldUpdateClass;
	private JComboBox JComboBoxUpdateClass;
	private JButton JButtonSave;
	private JButton JButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogUpdateClass dialog = new JDialogUpdateClass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogUpdateClass() {
		setBounds(100, 100, 406, 263);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.setBackground(Color.BLACK);
				JButtonSave.setForeground(new Color(211, 211, 211));
				JButtonSave.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							ClassStudentDAO classStudentDAO = new ClassStudentDAO();
							ClassStudent classStudent = classStudentDAO.find(JFrameManagementClass.id);
							int selectedIndex = JComboBoxUpdateClass.getSelectedIndex();
							GradeDAO gradeDAO = new GradeDAO();
							Grade grade = gradeDAO.findAll().get(selectedIndex);
							classStudent.setNameOfClass(JTextFieldUpdateClass.getText());
							classStudent.setGrade(grade);
							classStudentDAO.update(classStudent);
							JOptionPane.showMessageDialog(null, "Update Class Successfull");
							JFrameManagementClass jFrameManagementClass = new JFrameManagementClass();
							jFrameManagementClass.loadData();
							jFrameManagementClass.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Update Class Fail!");
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
					public void actionPerformed(ActionEvent e) {
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
				JButtonCancel.setBackground(Color.BLACK);
				JButtonCancel.setForeground(new Color(211, 211, 211));
				JButtonCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonCancel.setActionCommand("Cancel");
				buttonPane.add(JButtonCancel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblUpdateClass = new JLabel("Update class");
				lblUpdateClass.setForeground(new Color(211, 211, 211));
				lblUpdateClass.setBackground(Color.DARK_GRAY);
				lblUpdateClass.setHorizontalAlignment(SwingConstants.CENTER);
				lblUpdateClass.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblUpdateClass.setBounds(0, 0, 385, 55);
				panel.add(lblUpdateClass);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.DARK_GRAY);
				panel_1.setLayout(null);
				panel_1.setBounds(0, 68, 385, 134);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Name :");
					label.setFont(new Font("SansSerif", Font.BOLD, 16));
					label.setForeground(new Color(211, 211, 211));
					label.setBounds(25, 9, 65, 28);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Grade :");
					label.setFont(new Font("SansSerif", Font.BOLD, 16));
					label.setForeground(new Color(211, 211, 211));
					label.setBounds(25, 61, 65, 28);
					panel_1.add(label);
				}
				{
					JTextFieldUpdateClass = new JTextField();
					JTextFieldUpdateClass.setFont(new Font("SansSerif", Font.PLAIN, 16));
					JTextFieldUpdateClass.setBackground(SystemColor.controlHighlight);
					JTextFieldUpdateClass.setColumns(10);
					JTextFieldUpdateClass.setBounds(102, 6, 257, 39);
					panel_1.add(JTextFieldUpdateClass);
				}
				{
					JComboBoxUpdateClass = new JComboBox();
					JComboBoxUpdateClass.setFont(new Font("SansSerif", Font.PLAIN, 16));
					JComboBoxUpdateClass.setBackground(Color.GRAY);
					JComboBoxUpdateClass.setBounds(102, 58, 257, 39);
					panel_1.add(JComboBoxUpdateClass);
				}
			}
		}
		loadData();
	}
	public void loadData(){
		ClassStudentDAO classStudentDAO = new ClassStudentDAO();
		ClassStudent classStudent = classStudentDAO.find(JFrameManagementClass.id);
		GradeDAO gradeDAO = new GradeDAO();
		JTextFieldUpdateClass.setText(classStudent.getNameOfClass());
		fillDataToComboboxGrade(gradeDAO.findAll());
		JComboBoxUpdateClass.setSelectedItem(classStudent.getGrade().getGradeName());
	}
	public void fillDataToComboboxGrade(List<Grade> grades){
		GradeDAO gradeDAO = new GradeDAO();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Grade grade : gradeDAO.findAll()) {
			defaultComboBoxModel.addElement(grade.getGradeName());
		}
		JComboBoxUpdateClass.setModel(defaultComboBoxModel);
	}

}

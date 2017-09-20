package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SubjectsDAO;
import entities.Subjects;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogUpdateSubject extends JDialog {
	private JTextField JTextFieldUpdateSubjects;
	private JButton JButtonSave;
	private JButton JButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogUpdateSubject dialog = new JDialogUpdateSubject();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogUpdateSubject() {
		setBounds(100, 100, 468, 196);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonSave.setForeground(new Color(211, 211, 211));
				JButtonSave.setBackground(Color.BLACK);
				JButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							SubjectsDAO subjectsDAO = new SubjectsDAO();
							Subjects subjects = subjectsDAO.find(JFrameManagementSubjects.id);
							subjects.setNameOfSubjects(JTextFieldUpdateSubjects.getText());
							subjectsDAO.update(subjects);
							JOptionPane.showMessageDialog(null, "Update Subject Successfull");
							JFrameManagementSubjects jFrameManagementSubjects = new JFrameManagementSubjects();
							jFrameManagementSubjects.loadData();
							jFrameManagementSubjects.setVisible(true);
							setVisible(false);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Update subjects fail");
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
								JFrameManagementSubjects jfFrameManagementSubjects = new JFrameManagementSubjects();
								jfFrameManagementSubjects.loadData();
								jfFrameManagementSubjects.setVisible(true);
								break;
							case 1:
								
								break;
							}
					}
				});
				JButtonCancel.setFont(new Font("SansSerif", Font.PLAIN, 16));
				JButtonCancel.setForeground(new Color(211, 211, 211));
				JButtonCancel.setBackground(Color.BLACK);
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
				JLabel lblUpdateNewSubjects = new JLabel("Update new subjects");
				lblUpdateNewSubjects.setHorizontalAlignment(SwingConstants.CENTER);
				lblUpdateNewSubjects.setForeground(new Color(211, 211, 211));
				lblUpdateNewSubjects.setFont(new Font("Tahoma", Font.BOLD, 39));
				lblUpdateNewSubjects.setBounds(0, 0, 450, 48);
				panel.add(lblUpdateNewSubjects);
			}
			{
				JLabel label = new JLabel("Name :");
				label.setFont(new Font("SansSerif", Font.BOLD, 16));
				label.setForeground(new Color(211, 211, 211));
				label.setBounds(22, 66, 64, 20);
				panel.add(label);
			}
			{
				JTextFieldUpdateSubjects = new JTextField();
				JTextFieldUpdateSubjects.setColumns(10);
				JTextFieldUpdateSubjects.setBounds(98, 61, 335, 35);
				panel.add(JTextFieldUpdateSubjects);
			}
		}
		loadData();
	}
	public void loadData(){
		SubjectsDAO subjectsDAO = new SubjectsDAO();
		Subjects subjects = subjectsDAO.find(JFrameManagementSubjects.id);
		JTextFieldUpdateSubjects.setText(subjects.getNameOfSubjects());
	}

}

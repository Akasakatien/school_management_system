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

public class JDialogNewSubject extends JDialog {
	private JTextField JTextFieldSubjects;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogNewSubject dialog = new JDialogNewSubject();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogNewSubject() {
		setBounds(100, 100, 382, 182);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				okButton.setForeground(new Color(211, 211, 211));
				okButton.setBackground(Color.BLACK);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							SubjectsDAO subjectsDAO = new SubjectsDAO();
							Subjects subjects = new Subjects();
							subjects.setNameOfSubjects(JTextFieldSubjects.getText());
							subjectsDAO.create(subjects);
							JFrameManagementSubjects jFrameManagementSubjects = new JFrameManagementSubjects();
							jFrameManagementSubjects.loadData();
							jFrameManagementSubjects.setVisible(true);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "");
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Add new subject fail");
							// TODO: handle exception
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
				cancelButton.setForeground(new Color(211, 211, 211));
				cancelButton.setBackground(Color.BLACK);
				cancelButton.addActionListener(new ActionListener() {
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblAddNewSubjects = new JLabel("Add new subjects");
				lblAddNewSubjects.setHorizontalAlignment(SwingConstants.CENTER);
				lblAddNewSubjects.setForeground(new Color(211, 211, 211));
				lblAddNewSubjects.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblAddNewSubjects.setBounds(0, 0, 364, 48);
				panel.add(lblAddNewSubjects);
			}
			{
				JLabel label = new JLabel("Name :");
				label.setForeground(new Color(211, 211, 211));
				label.setFont(new Font("SansSerif", Font.BOLD, 16));
				label.setBounds(10, 66, 54, 20);
				panel.add(label);
			}
			{
				JTextFieldSubjects = new JTextField();
				JTextFieldSubjects.setColumns(10);
				JTextFieldSubjects.setBounds(76, 61, 276, 35);
				panel.add(JTextFieldSubjects);
			}
		}
	}

}

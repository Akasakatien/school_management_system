package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GradeDAO;
import entities.Grade;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogManagementUpdateGrade extends JDialog {
	private JTextField JTextFieldManagementUpdateName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogManagementUpdateGrade dialog = new JDialogManagementUpdateGrade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogManagementUpdateGrade() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 341, 237);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(0, 0, 321, 140);
			getContentPane().add(panel);
			{
				JLabel lblUpdateGrade = new JLabel("Update grade");
				lblUpdateGrade.setHorizontalAlignment(SwingConstants.CENTER);
				lblUpdateGrade.setForeground(new Color(95, 158, 160));
				lblUpdateGrade.setFont(new Font("Tahoma", Font.BOLD, 30));
				lblUpdateGrade.setBounds(14, 13, 295, 45);
				panel.add(lblUpdateGrade);
			}
			{
				JLabel label = new JLabel("Name :");
				label.setFont(new Font("SansSerif", Font.BOLD, 16));
				label.setForeground(new Color(211, 211, 211));
				label.setBounds(10, 96, 57, 20);
				panel.add(label);
			}
			{
				JTextFieldManagementUpdateName = new JTextField();
				JTextFieldManagementUpdateName.setColumns(10);
				JTextFieldManagementUpdateName.setBounds(79, 88, 230, 36);
				panel.add(JTextFieldManagementUpdateName);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 142, 321, 35);
			getContentPane().add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton button = new JButton("Save");
				button.setFont(new Font("SansSerif", Font.PLAIN, 14));
				button.setForeground(new Color(211, 211, 211));
				button.setBackground(Color.BLACK);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							GradeDAO gradeDAO = new GradeDAO();
							Grade grade = gradeDAO.find(JFrameManagementGrade.id);
							grade.setGradeName(JTextFieldManagementUpdateName.getText());
							gradeDAO.update(grade);
							setVisible(true);
							JFrameManagementGrade jFrameManagentGrade = new JFrameManagementGrade();
							jFrameManagentGrade.loadData();
							jFrameManagentGrade.setVisible(true);
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Update fail");
						}
						
					}
				});
				panel.add(button);
			}
			{
				JButton button = new JButton("Cancel");
				button.setFont(new Font("SansSerif", Font.PLAIN, 14));
				button.setForeground(new Color(211, 211, 211));
				button.setBackground(Color.BLACK);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
						switch (result){
							case 0:
								setVisible(false);
								JFrameManagementGrade jFrameManagentGrade = new JFrameManagementGrade();
								jFrameManagentGrade.loadData();
								jFrameManagentGrade.setVisible(true);
								break;
							case 1:
								break;
							}
					}
				});
				button.setActionCommand("Cancel");
				panel.add(button);
			}
		}
	}
	public void loadData(){
		GradeDAO gradeDAO = new GradeDAO();
		Grade grade = gradeDAO.find(JFrameManagementGrade.id);
		JTextFieldManagementUpdateName.setText(grade.getGradeName());
		
	}

}

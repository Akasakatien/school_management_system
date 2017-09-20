package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GradeDAO;
import entities.Grade;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class JDiaLogManagementGradeAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton JButtonCancel;
	private JButton JButtonSave;
	private JTextField JTextFieldNameGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			JDiaLogManagementGradeAdd dialog = new JDiaLogManagementGradeAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDiaLogManagementGradeAdd() {
		setBounds(100, 100, 417, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAddNewGrade = new JLabel("Add new grade");
		lblAddNewGrade.setForeground(new Color(211, 211, 211));
		lblAddNewGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewGrade.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddNewGrade.setBounds(0, 0, 399, 48);
		contentPanel.add(lblAddNewGrade);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(44, 65, 53, 20);
		contentPanel.add(lblName);
		
		JTextFieldNameGrade = new JTextField();
		JTextFieldNameGrade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JTextFieldNameGrade.setBackground(SystemColor.controlHighlight);
		JTextFieldNameGrade.setBounds(98, 61, 254, 33);
		contentPanel.add(JTextFieldNameGrade);
		JTextFieldNameGrade.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							GradeDAO gradeDAO = new GradeDAO();
							Grade grade = new Grade();
							grade.setGradeName(JTextFieldNameGrade.getText());
							gradeDAO.create(grade);
							JOptionPane.showMessageDialog(null, "Add new grade successfull");
							setVisible(false);
							JFrameManagementGrade jFrameManagentGrade = new JFrameManagementGrade();
							jFrameManagentGrade.loadData();
							jFrameManagentGrade.setVisible(true);
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Add new grade fail");
						}
					}
				});
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
								JFrameManagementGrade jFrameManagentGrade = new JFrameManagementGrade();
								jFrameManagentGrade.loadData();
								jFrameManagentGrade.setVisible(true);
								break;
							case 1:
								
								break;
							}
					}
				});
				JButtonCancel.setActionCommand("Cancel");
				buttonPane.add(JButtonCancel);
			}
		}
	}
}

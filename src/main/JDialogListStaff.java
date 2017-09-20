package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DivisonDAO;
import dao.StaffDAO;
import dao.StudentDAO;
import entities.Staff;
import entities.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogListStaff extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JTextFieldSearchByName;
	private JTable JTableListStudent;
	public int selectedRow;
	public static int idStaff;
	private JButton JButtonAddNewDivison;
	private JButton JButtonEditDivison;
	private JButton JButtonSave;
	private JButton JButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogListStaff dialog = new JDialogListStaff();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogListStaff() {
		setBounds(100, 100, 539, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblListStudent = new JLabel("List Staff");
		lblListStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblListStudent.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblListStudent.setBounds(10, 11, 499, 100);
		contentPanel.add(lblListStudent);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 499, 134);
		contentPanel.add(scrollPane);

		JTableListStudent = new JTable();
		JTableListStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JButtonAddNewDivison.setEnabled(true);
				JButtonEditDivison.setEnabled(true);
				selectedRow = JTableListStudent.getSelectedRow();
				idStaff = (int) JTableListStudent.getValueAt(selectedRow, 0);
			}
		});
		scrollPane.setViewportView(JTableListStudent);

		JLabel label_1 = new JLabel("Search by name: ");
		label_1.setBounds(20, 123, 100, 30);
		contentPanel.add(label_1);

		JTextFieldSearchByName = new JTextField();
		JTextFieldSearchByName.setColumns(10);
		JTextFieldSearchByName.setBounds(129, 122, 380, 30);
		contentPanel.add(JTextFieldSearchByName);

		JButtonAddNewDivison = new JButton("Add new divison");
		JButtonAddNewDivison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialogAddNewDivison jDialogAddNewDivison = new JDialogAddNewDivison();
				jDialogAddNewDivison.loadData();
				jDialogAddNewDivison.setVisible(true);
				setVisible(false);
			}
		});
		JButtonAddNewDivison.setEnabled(false);
		JButtonAddNewDivison.setBounds(198, 310, 113, 30);
		contentPanel.add(JButtonAddNewDivison);

		JButtonEditDivison = new JButton("Edit divison");
		JButtonEditDivison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		JButtonEditDivison.setEnabled(false);
		JButtonEditDivison.setBounds(341, 310, 113, 30);
		contentPanel.add(JButtonEditDivison);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButtonSave = new JButton("Save");
				JButtonSave.setActionCommand("OK");
				buttonPane.add(JButtonSave);
				getRootPane().setDefaultButton(JButtonSave);
			}
			{
				JButtonCancel = new JButton("Cancel");
				JButtonCancel.setActionCommand("Cancel");
				buttonPane.add(JButtonCancel);
			}
		}
		loadData();
	}

	public void loadData() {

		StaffDAO staffDAO = new StaffDAO();
		
		fillDataToTable(staffDAO.findAll());
	}

	public void fillDataToTable(List<Staff> staffs) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");

		for (Staff staff : staffs) {
			defaultTableModel.addRow(new Object[] { staff.getId(), staff.getName() });
		}
		JTableListStudent.setModel(defaultTableModel);
		JTableListStudent.getTableHeader().setReorderingAllowed(false);

	}
}
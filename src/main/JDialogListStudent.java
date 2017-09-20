package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.StudentDAO;
import entities.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JDialogListStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JTextFieldSearchByName;
	private JTable JTableListStudent;
	public int selectedRow;
	public static int idStudent;
	private JButton JButtonAddNewMarks;
	DefaultTableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogListStudent dialog = new JDialogListStudent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogListStudent() {
		setBounds(100, 100, 539, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblListStudent = new JLabel("List Student");
		lblListStudent.setForeground(new Color(211, 211, 211));
		lblListStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblListStudent.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblListStudent.setBounds(0, 0, 521, 56);
		contentPanel.add(lblListStudent);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(24, 113, 469, 134);
		contentPanel.add(scrollPane);

		JTableListStudent = new JTable();
		JTableListStudent.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		JTableListStudent.setShowHorizontalLines(true);
		JTableListStudent.setSelectionBackground(Color.BLACK);
		JTableListStudent.setRowHeight(20);
		JTableListStudent.setGridColor(Color.GRAY);
		JTableListStudent.setForeground(new Color(211, 211, 211));
		JTableListStudent.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JTableListStudent.setFillsViewportHeight(true);
		JTableListStudent.setBackground(Color.DARK_GRAY);
		JTableListStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = JTableListStudent.getSelectedRow();
				idStudent = (int) JTableListStudent.getValueAt(selectedRow, 0);
			}
		});
		scrollPane.setViewportView(JTableListStudent);

		JLabel label_1 = new JLabel("Search by name: ");
		label_1.setForeground(new Color(211, 211, 211));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(24, 70, 147, 30);
		contentPanel.add(label_1);

		JTextFieldSearchByName = new JTextField();
		JTextFieldSearchByName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String key = JTextFieldSearchByName.getText();
				filterUseJtextfield(key);
			}
		});
		JTextFieldSearchByName.setBackground(SystemColor.controlHighlight);
		JTextFieldSearchByName.setColumns(10);
		JTextFieldSearchByName.setBounds(183, 69, 310, 35);
		contentPanel.add(JTextFieldSearchByName);

		JButtonAddNewMarks = new JButton("Add new marks");
		JButtonAddNewMarks.setFont(new Font("SansSerif", Font.PLAIN, 16));
		JButtonAddNewMarks.setForeground(new Color(211, 211, 211));
		JButtonAddNewMarks.setBackground(Color.BLACK);
		JButtonAddNewMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialogAddNewMarks jDialogAddNewMarks = new JDialogAddNewMarks();
				jDialogAddNewMarks.loadData();
				jDialogAddNewMarks.setVisible(true);
				setVisible(false);
			}
		});
		JButtonAddNewMarks.setBounds(245, 259, 136, 35);
		contentPanel.add(JButtonAddNewMarks);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setForeground(new Color(211, 211, 211));
			cancelButton.setBackground(Color.BLACK);
			cancelButton.setBounds(393, 261, 100, 32);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JFrameManagementMarks jFrameManagementMarks = new JFrameManagementMarks();
					jFrameManagementMarks.loadData();
					jFrameManagementMarks.setVisible(true);
				}
			});
			cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 521, 56);
		contentPanel.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		label_2.setBounds(0, 55, 521, 257);
		contentPanel.add(label_2);
		loadData();
	}

	public void loadData() {

		StudentDAO studentDAO = new StudentDAO();
		fillDataToTable(studentDAO.findAll());
	}

	public void fillDataToTable(List<Student> students) {
		dm = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1)
					return false;
				return true;

			}
		};
		dm.addColumn("ID");
		dm.addColumn("Name");

		for (Student student : students) {
			dm.addRow(new Object[] { student.getId(), student.getName() });
		}
		JTableListStudent.setModel(dm);
		JTableListStudent.getTableHeader().setReorderingAllowed(false);
	}
	private void filterUseJtextfield(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		JTableListStudent.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
}
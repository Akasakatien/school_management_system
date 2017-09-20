package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.engine.transaction.internal.jta.JtaTransactionFactory;

import dao.AcademicDAO;
import dao.AdmissionDAO;
import dao.EducationalDAO;
import dao.FamilyDAO;
import dao.PromotionDAO;
import dao.StaffDAO;
import dao.StaffExperienceDAO;
import dao.StaffFamilyDAO;
import dao.StudentDAO;
import entities.Academic;
import entities.Admisson;
import entities.Educational;
import entities.Family;
import entities.Promotion;
import entities.Staff;
import entities.StaffExperience;
import entities.StaffFamily;
import entities.Student;
import helper.ExcelHelper;

import javax.security.auth.Subject;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class jFrameStaffInfor extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldNameStaff;
	private JTable jTableStaff;
	DefaultTableModel dm;
	public static int idSelected;
	public int selectedRow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					jFrameStaffInfor frame = new jFrameStaffInfor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jFrameStaffInfor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1335, 946);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 1317, 78);
		contentPane.add(panel);
		
		JLabel lblStaffProfile = new JLabel("Staff Profile");
		lblStaffProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffProfile.setForeground(new Color(211, 211, 211));
		lblStaffProfile.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblStaffProfile.setBounds(516, 13, 273, 44);
		panel.add(lblStaffProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header.jpg"));
		label.setBounds(0, 0, 1317, 78);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 91, 1269, 106);
		contentPane.add(panel_1);
		
		JButton jButtonNew = new JButton("New");
		jButtonNew.setBackground(Color.BLACK);
		jButtonNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameAddStaff jFrameAddStaff = new JFrameAddStaff();
				jFrameAddStaff.setVisible(true);
			}
		});
		jButtonNew.setForeground(new Color(211, 211, 211));
		jButtonNew.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonNew.setBounds(20, 0, 139, 100);
		panel_1.add(jButtonNew);
		
		JButton jButtonEdit = new JButton("Edit");
		jButtonEdit.setBackground(Color.BLACK);
		jButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameEditStaff jFrameEditStaff = new JFrameEditStaff();
				jFrameEditStaff.setVisible(true);
			}
		});
		jButtonEdit.setForeground(new Color(211, 211, 211));
		jButtonEdit.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonEdit.setEnabled(false);
		jButtonEdit.setBounds(187, 0, 139, 100);
		panel_1.add(jButtonEdit);
		
		JButton jButtonDelete = new JButton("Delete");
		jButtonDelete.setBackground(Color.BLACK);
		jButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonDeleteActionPerformed(e);
			}
		});
		jButtonDelete.setForeground(new Color(211, 211, 211));
		jButtonDelete.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonDelete.setEnabled(false);
		jButtonDelete.setBounds(353, 0, 139, 100);
		panel_1.add(jButtonDelete);
		
		JButton jButtonExportToExcel = new JButton("Export to Excel");
		jButtonExportToExcel.setBackground(Color.BLACK);
		jButtonExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonExportToExcelActionPerformed(e);
			}
		});
		jButtonExportToExcel.setForeground(new Color(211, 211, 211));
		jButtonExportToExcel.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonExportToExcel.setBounds(705, 0, 187, 100);
		panel_1.add(jButtonExportToExcel);
		
		JButton jButtonPrintList = new JButton("Print Staff");
		jButtonPrintList.setEnabled(false);
		jButtonPrintList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameReportStaff jFrameReportStaff = new JFrameReportStaff();
				jFrameReportStaff.setVisible(true);
			}
		});
		jButtonPrintList.setBackground(Color.BLACK);
		jButtonPrintList.setForeground(new Color(211, 211, 211));
		jButtonPrintList.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonPrintList.setBounds(916, 0, 156, 100);
		panel_1.add(jButtonPrintList);
		
		JButton jButtonExit = new JButton("EXIT");
		jButtonExit.setBackground(Color.BLACK);
		jButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		jButtonExit.setForeground(new Color(211, 211, 211));
		jButtonExit.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButtonExit.setBounds(1095, 0, 156, 100);
		panel_1.add(jButtonExit);
		
		JButton jBtnDivison = new JButton("Divison");
		jBtnDivison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameManagementDivison jFrameManagementDivison = new JFrameManagementDivison();
				jFrameManagementDivison.setVisible(true);
			}
		});
		jBtnDivison.setForeground(new Color(211, 211, 211));
		jBtnDivison.setBackground(Color.BLACK);
		jBtnDivison.setFont(new Font("Tahoma", Font.BOLD, 20));
		jBtnDivison.setBounds(520, 0, 156, 100);
		panel_1.add(jBtnDivison);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\header1.jpg"));
		lblNewLabel.setBounds(0, 0, 1290, 106);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		scrollPane.setBounds(21, 260, 1274, 617);
		contentPane.add(scrollPane);
		
		jTableStaff = new JTable();
		jTableStaff.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		jTableStaff.setShowHorizontalLines(true);
		jTableStaff.setSelectionBackground(Color.BLACK);
		jTableStaff.setRowHeight(20);
		jTableStaff.setGridColor(Color.GRAY);
		jTableStaff.setForeground(new Color(211, 211, 211));
		jTableStaff.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jTableStaff.setFillsViewportHeight(true);
		jTableStaff.setBackground(Color.DARK_GRAY);
		jTableStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = jTableStaff.getSelectedRow();
				idSelected = (int)jTableStaff.getValueAt(selectedRow, 0);
				jButtonDelete.setEnabled(true);
				jButtonEdit.setEnabled(true);
				jButtonPrintList.setEnabled(true);
			}
		});
		scrollPane.setViewportView(jTableStaff);
		
		JLabel lblSearchByName = new JLabel("Search by Name ");
		lblSearchByName.setForeground(new Color(211, 211, 211));
		lblSearchByName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearchByName.setBounds(21, 209, 129, 36);
		contentPane.add(lblSearchByName);
		
		jTextFieldNameStaff = new JTextField();
		jTextFieldNameStaff.setForeground(new Color(211, 211, 211));
		jTextFieldNameStaff.setBackground(Color.DARK_GRAY);
		jTextFieldNameStaff.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String key = jTextFieldNameStaff.getText();
				filterUseJtextfield(key);
			}
		});
		jTextFieldNameStaff.setFont(new Font("SansSerif", Font.PLAIN, 16));
		jTextFieldNameStaff.setColumns(10);
		jTextFieldNameStaff.setBounds(162, 209, 316, 39);
		contentPane.add(jTextFieldNameStaff);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Tien\\Picture\\icon\\contain.jpg"));
		lblNewLabel_1.setBounds(0, 78, 1317, 821);
		contentPane.add(lblNewLabel_1);
		loadData();
	}
	public void fillDataToTable(List<Staff> staffs) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dm = new DefaultTableModel();
		dm.addColumn("ID");
		dm.addColumn("Staff Code");
		dm.addColumn("Name");
		dm.addColumn("Date of Birth");
		dm.addColumn("Gender");
		dm.addColumn("Phone");
		dm.addColumn("Address");
		dm.addColumn("Email");
		dm.addColumn("Feedback");
		for(Staff staff:staffs){
			dm.addRow(new Object[]{
				staff.getId(), staff.getStaffCode(), staff.getName(), dateFormat.format(staff.getDateOfBirth()), staff.getSex(), 
				staff.getPhone(), staff.getAddress(), staff.getEmail(), staff.getFeedback()
			});
		}
		jTableStaff.setModel(dm);
	}
	public void loadData() {
		StaffDAO staffDAO = new StaffDAO();
		fillDataToTable(staffDAO.findAll());
	}
	public void jButtonDeleteActionPerformed(ActionEvent event) {
		StaffDAO staffDAO = new StaffDAO();
		StaffFamilyDAO staffFamilyDAO = new StaffFamilyDAO();
		EducationalDAO educationalDAO = new EducationalDAO();
		StaffExperienceDAO staffExperienceDAO = new StaffExperienceDAO();
		PromotionDAO promotionDAO = new PromotionDAO();
		Staff staff = staffDAO.find(idSelected);
		for(StaffFamily staffFamily : staff.getStaffFamilies()){
			if(!(staffFamily==null)){
				staffFamilyDAO.delete(staffFamily);
			}
		}
		for(Educational educational:staff.getEducationals()){
			if(!(educational==null)){
				educationalDAO.delete(educational);
			}
		}
		for(StaffExperience staffExperience:staff.getStaffExperiences()){
			if(!(staffExperience==null)){
				staffExperienceDAO.delete(staffExperience);
			}
		}
		for(Promotion promotion:staff.getPromotions()){
			if(!(promotion==null)){
				promotionDAO.delete(promotion);
			}
		}
		staffDAO.delete(staff);
		loadData();
	}
	private void filterUseJtextfield(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		jTableStaff.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	public void jButtonExportToExcelActionPerformed(ActionEvent event) {
		try {
			JFileChooser jf = new JFileChooser();
			jf.setDialogTitle("Save Excel File");
			int result = jf.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION){
				String excelPath = jf.getSelectedFile().getAbsolutePath();
				ExcelHelper excelHelper = new ExcelHelper(excelPath);
				StaffDAO staffDAO = new StaffDAO();
				excelHelper.writeData(staffDAO.findAllStaffExport());
				JOptionPane.showMessageDialog(null, "Done");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}

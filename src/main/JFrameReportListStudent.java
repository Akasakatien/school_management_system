package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.*;
import dao.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.swing.*;
import net.sf.jasperreports.view.JRViewer;
import reports.*;

public class JFrameReportListStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameReportListStudent frame = new JFrameReportListStudent();
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
	public JFrameReportListStudent() {
		setBounds(100, 100, 478, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		loadData();
	}
	private void loadData(){
		try {
			StudentDAO studentDAO = new StudentDAO();
//			JRDataSource jrDataSource = new JRBeanCollectionDataSource(studentDAO.findAllRP());
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(studentDAO.findRP(JFrameStudentInfor.idSelected));
			JasperReport jasperReport = JasperCompileManager.compileReport("src/reports/StudentDetail.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
			this.getContentPane().add(new JRViewer(jasperPrint));
			this.pack();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}


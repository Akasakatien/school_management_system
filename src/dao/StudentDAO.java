package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import entities.Account;
import entities.Student;
import entities.*;

public class StudentDAO extends AbstractModel<Student>{
	public StudentDAO(){
		super(Student.class);
	}
	public List<Student> search(String keyword){
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select a "
							+ "from Student a "
							+ "where a.name like :keyword");
			query.setString("keyword","%" + keyword+ "%");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public List<Map<String, Object>> findAllRP(){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(Student student:super.findAll()){
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("ID", student.getId());
			row.put("Student Code", student.getStudentCode());
			row.put("Name", student.getName());
			row.put("Gender", student.getSex());
			row.put("Address", student.getAddress());
			row.put("Phone No", student.getPhoneNo());
			row.put("Email", student.getEmail());
			result.add(row);
		}
		return result;
	}
	public List<Map<String, Object>> findRP(int id) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Student student = super.find(id);
		for(Family family:student.getFamilies()){	
			Map<String, Object> row1 = new HashMap<String, Object>();
			row1.put("Student Name", student.getName());
			row1.put("Student Code", student.getStudentCode());
			row1.put("Gender", student.getSex());
			row1.put("Address", student.getAddress());
			row1.put("Phone No", student.getPhoneNo());
			row1.put("Email", student.getEmail());
			
			row1.put("Relation", family.getRelation());
			row1.put("Name", family.getName());
//			row.put("Date of Birth", family.getDateOfBirth());
			row1.put("Job", family.getJob());
			row1.put("Address Family", family.getAddress());
			row1.put("Phone No Family", family.getPhoneNumber());
			row1.put("Email Family", family.getEmail());
			result.add(row1);
		}
		return result;
	}
	public List<StudentExport> findAllStudentExport() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		List<StudentExport> result = new ArrayList<StudentExport>();
		for(Student student:this.findAll()){
			StudentExport studentExport = new StudentExport();
			studentExport.setId(student.getId());
			studentExport.setClassName(student.getClassStudent().getNameOfClass());
			studentExport.setStudentCode(student.getStudentCode());
			studentExport.setName(student.getName());
			studentExport.setDateOfBirth(student.getDateOfBirth());
			studentExport.setSex(student.getSex());
			studentExport.setAddress(student.getAddress());
			studentExport.setPhoneNo(student.getPhoneNo());
			studentExport.setEmail(student.getEmail());
			studentExport.setRemarks(student.getRemarks());
			result.add(studentExport);
		}
		return result;
	}
}

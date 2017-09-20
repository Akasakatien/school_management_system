package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Family;
import entities.Staff;
import entities.StaffExport;
import entities.StaffFamily;
import entities.Student;

public class StaffDAO extends AbstractModel<Staff>{
	public StaffDAO(){
		super(Staff.class);
	}
	public List<StaffExport> findAllStaffExport() {
		List<StaffExport> result = new ArrayList<StaffExport>();
		for(Staff staff:this.findAll()){
			StaffExport staffExport = new StaffExport();
			staffExport.setId(staff.getId());
			staffExport.setStaffCode(staff.getStaffCode());
			staffExport.setName(staff.getName());
			staffExport.setDateOfBirth(staff.getDateOfBirth());
			staffExport.setSex(staff.getSex());
			staffExport.setAddress(staff.getAddress());
			staffExport.setPhone(staff.getPhone());
			staffExport.setEmail(staff.getEmail());
			staffExport.setFeedback(staff.getFeedback());
			result.add(staffExport);
		}
		return result;
	}
	public List<Map<String, Object>> findRP(int id) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Staff staff = super.find(id);
		for(StaffFamily family:staff.getStaffFamilies()){	
			Map<String, Object> row1 = new HashMap<String, Object>();
			row1.put("Staff Name", staff.getName());
			row1.put("Staff Code", staff.getStaffCode());
			row1.put("Gender", staff.getSex());
			row1.put("Address", staff.getAddress());
			row1.put("Phone No", staff.getPhone());
			row1.put("Email", staff.getEmail());
			
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
}

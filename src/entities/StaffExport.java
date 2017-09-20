package entities;

import java.util.Date;

public class StaffExport {
	private int id;
	private Integer staffCode;
	private String name;
	private Date dateOfBirth;
	private String sex;
	private Integer phone;
	private String address;
	private String email;
	private String feedback;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(Integer staffCode) {
		this.staffCode = staffCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public StaffExport(int id, Integer staffCode, String name, Date dateOfBirth, String sex, Integer phone,
			String address, String email, String feedback) {
		super();
		this.id = id;
		this.staffCode = staffCode;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.feedback = feedback;
	}
	public StaffExport() {
		super();
	}
	
}

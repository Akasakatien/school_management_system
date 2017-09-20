package entities;

import java.util.Date;

public class StudentExport {
	private int id;
	private String className;
	private Integer studentCode;
	private String name;
	private Date dateOfBirth;
	private String sex;
	private String address;
	private Integer phoneNo;
	private String email;
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(Integer studentCode) {
		this.studentCode = studentCode;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public StudentExport(int id, String className, Integer studentCode, String name, Date dateOfBirth, String sex,
			String address, Integer phoneNo, String email, String remarks) {
		super();
		this.id = id;
		this.className = className;
		this.studentCode = studentCode;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.remarks = remarks;
	}
	public StudentExport() {
		super();
	}
	
}

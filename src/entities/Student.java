package entities;
// Generated Aug 26, 2016 12:06:24 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "Student", catalog = "schoolmanagement")
public class Student implements java.io.Serializable {

	private int id;
	private ClassStudent classStudent;
	private Integer studentCode;
	private String name;
	private Date dateOfBirth;
	private String sex;
	private String address;
	private Integer phoneNo;
	private String email;
	private String remarks;
	private byte[] photo;
	private Set<Academic> academics = new HashSet<Academic>(0);
	private Set<Marks> markses = new HashSet<Marks>(0);
	private Set<Family> families = new HashSet<Family>(0);
	private Set<Admisson> admissons = new HashSet<Admisson>(0);

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, ClassStudent classStudent, Integer studentCode, String name, Date dateOfBirth, String sex,
			String address, Integer phoneNo, String email, String remarks, byte[] photo, Set<Academic> academics,
			Set<Marks> markses, Set<Family> families, Set<Admisson> admissons) {
		this.id = id;
		this.classStudent = classStudent;
		this.studentCode = studentCode;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.remarks = remarks;
		this.photo = photo;
		this.academics = academics;
		this.markses = markses;
		this.families = families;
		this.admissons = admissons;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classId")
	public ClassStudent getClassStudent() {
		return this.classStudent;
	}

	public void setClassStudent(ClassStudent classStudent) {
		this.classStudent = classStudent;
	}
	@NotNull
	@Column(name = "studentCode")
	public Integer getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(Integer studentCode) {
		this.studentCode = studentCode;
	}
	@NotEmpty
	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateOfBirth", length = 23)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@NotEmpty
	@Column(name = "sex", length = 20)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@NotNull
	@Column(name = "phoneNo")
	public Integer getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "remarks", length = 150)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "photo")
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Academic> getAcademics() {
		return this.academics;
	}

	public void setAcademics(Set<Academic> academics) {
		this.academics = academics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Marks> getMarkses() {
		return this.markses;
	}

	public void setMarkses(Set<Marks> markses) {
		this.markses = markses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Family> getFamilies() {
		return this.families;
	}

	public void setFamilies(Set<Family> families) {
		this.families = families;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Admisson> getAdmissons() {
		return this.admissons;
	}

	public void setAdmissons(Set<Admisson> admissons) {
		this.admissons = admissons;
	}

}
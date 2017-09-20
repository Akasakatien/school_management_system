package entities;
// Generated Aug 26, 2016 12:06:24 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Family generated by hbm2java
 */
@Entity
@Table(name = "Family", catalog = "schoolmanagement")
public class Family implements java.io.Serializable {

	private int familyId;
	private Student student;
	private String name;
	private Date dateOfBirth;
	private String job;
	private String address;
	private Integer phoneNumber;
	private String email;
	private String relation;

	public Family() {
	}

	public Family(int familyId) {
		this.familyId = familyId;
	}

	public Family(int familyId, Student student, String name, Date dateOfBirth, String job, String address,
			Integer phoneNumber, String email, String relation) {
		this.familyId = familyId;
		this.student = student;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.job = job;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.relation = relation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "familyId", unique = true, nullable = false)
	public int getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
	@Column(name = "job", length = 50)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@NotNull
	@Column(name = "phoneNumber")
	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Email
	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "relation", length = 50)
	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
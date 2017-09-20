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

/**
 * Academic generated by hbm2java
 */
@Entity
@Table(name = "Academic", catalog = "schoolmanagement")
public class Academic implements java.io.Serializable {

	private int academicId;
	private Student student;
	private Integer registrationNo;
	private String program;
	private String section;
	private String studentStatus;
	private Date dateStart;
	private String semester;

	public Academic() {
	}

	public Academic(int academicId) {
		this.academicId = academicId;
	}

	public Academic(int academicId, Student student, Integer registrationNo, String program, String section,
			String studentStatus, Date dateStart, String semester) {
		this.academicId = academicId;
		this.student = student;
		this.registrationNo = registrationNo;
		this.program = program;
		this.section = section;
		this.studentStatus = studentStatus;
		this.dateStart = dateStart;
		this.semester = semester;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "academicId", unique = true, nullable = false)
	public int getAcademicId() {
		return this.academicId;
	}

	public void setAcademicId(int academicId) {
		this.academicId = academicId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@NotNull
	@Column(name = "registrationNo")
	public Integer getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(Integer registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Column(name = "program", length = 30)
	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	@Column(name = "section", length = 50)
	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Column(name = "studentStatus", length = 50)
	public String getStudentStatus() {
		return this.studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateStart", length = 23)
	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	@Column(name = "semester", length = 50)
	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}

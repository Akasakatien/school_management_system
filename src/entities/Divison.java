package entities;
// Generated Aug 26, 2016 12:06:24 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Divison generated by hbm2java
 */
@Entity
@Table(name = "Divison", catalog = "schoolmanagement")
public class Divison implements java.io.Serializable {

	private DivisonId id;
	private Staff staff;
	private Subjects subjects;
	private Integer numberOfLesson;
	private Date timeDivison;

	public Divison() {
	}

	public Divison(DivisonId id, Staff staff, Subjects subjects) {
		this.id = id;
		this.staff = staff;
		this.subjects = subjects;
	}

	public Divison(DivisonId id, Staff staff, Subjects subjects, Integer numberOfLesson, Date timeDivison) {
		this.id = id;
		this.staff = staff;
		this.subjects = subjects;
		this.numberOfLesson = numberOfLesson;
		this.timeDivison = timeDivison;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "staffId", column = @Column(name = "staffId", nullable = false)),
			@AttributeOverride(name = "subjectsId", column = @Column(name = "subjectsId", nullable = false)) })
	public DivisonId getId() {
		return this.id;
	}

	public void setId(DivisonId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staffId", nullable = false, insertable = false, updatable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjectsId", nullable = false, insertable = false, updatable = false)
	public Subjects getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	@NotNull
	@Column(name = "numberOfLesson")
	public Integer getNumberOfLesson() {
		return this.numberOfLesson;
	}

	public void setNumberOfLesson(Integer numberOfLesson) {
		this.numberOfLesson = numberOfLesson;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timeDivison", length = 23)
	public Date getTimeDivison() {
		return this.timeDivison;
	}

	public void setTimeDivison(Date timeDivison) {
		this.timeDivison = timeDivison;
	}

}

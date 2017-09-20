package entities;
// Generated Aug 26, 2016 12:06:24 AM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Promotion generated by hbm2java
 */
@Entity
@Table(name = "Promotion", catalog = "schoolmanagement")
public class Promotion implements java.io.Serializable {

	private int id;
	private Staff staff;
	private String nameOfPosition;
	private String achievements;

	public Promotion() {
	}

	public Promotion(int id) {
		this.id = id;
	}

	public Promotion(int id, Staff staff, String nameOfPosition, String achievements) {
		this.id = id;
		this.staff = staff;
		this.nameOfPosition = nameOfPosition;
		this.achievements = achievements;
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
	@JoinColumn(name = "idStaff")
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	@NotEmpty
	@Column(name = "nameOfPosition", length = 50)
	public String getNameOfPosition() {
		return this.nameOfPosition;
	}

	public void setNameOfPosition(String nameOfPosition) {
		this.nameOfPosition = nameOfPosition;
	}
	@NotEmpty
	@Column(name = "achievements", length = 150)
	public String getAchievements() {
		return this.achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

}
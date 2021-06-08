package com.vti.BasicCRUD.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Account", catalog = "TestingSystem")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountID")
	private int id;

	@Column(name = "Email", length = 50, nullable = false, unique = true)
	@Length(min = 6, max = 50)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true)
	@Length(min = 6, max = 50)
	private String userName;

	@Column(name = "FullName", length = 50, nullable = false, unique = false)
	@Length(min = 6, max = 50)
	private String fullName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartmentID", nullable = false)
	@Valid
	private Department department;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PositionID", nullable = false)
	@Valid
	private Position position;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date createDate;

	public Account() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", departmentName=" + department.getName() + ", positionName=" + position.getName() + ", createDate="
				+ createDate + "]";
	}

}

package com.vti.BasicCRUD.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartmentID")
	private int id;

	@Column(name = "DepartmentName", length = 50, nullable = false, unique = true)
	@Length(min = 6, max = 50)
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	@Size(min = 0)
	@Valid
	private Set<Account> listAccount = new HashSet<Account>();

	public Department() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(Set<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}

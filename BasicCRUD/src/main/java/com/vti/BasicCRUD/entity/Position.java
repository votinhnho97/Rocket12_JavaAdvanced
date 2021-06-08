package com.vti.BasicCRUD.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PositionID")
	private int id;

	@Column(name = "PositionName")
	@Length(min = 6, max = 50)
	private String name;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	@Size(min = 0)
	@Valid
	private Set<Account> listAccount = new HashSet<Account>();

	public Position() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}

}

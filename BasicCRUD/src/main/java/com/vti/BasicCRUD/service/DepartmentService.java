package com.vti.BasicCRUD.service;

import java.util.List;

import com.vti.BasicCRUD.repository.DepartmentRepository;
import com.vti.BasicCRUD.repository.IDepartmentRepository;

public class DepartmentService implements IDepartmentService {
	private IDepartmentRepository departmentRepository;

	public DepartmentService() {
		departmentRepository = new DepartmentRepository();
	}

	public List<?> getAllDepartment() {
		return departmentRepository.getAllDepartment();
	}

	public Object getDepartmentById(int id) {
		return departmentRepository.getDepartmentById(id);
	}

	public Object getDepartmentByName(String name) {
		return departmentRepository.getDepartmentByName(name);
	}

	public void close() {
		departmentRepository.close();
	}

}

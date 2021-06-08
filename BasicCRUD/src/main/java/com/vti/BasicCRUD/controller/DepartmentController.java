package com.vti.BasicCRUD.controller;

import java.util.List;

import com.vti.BasicCRUD.service.DepartmentService;
import com.vti.BasicCRUD.service.IDepartmentService;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() {
		departmentService = new DepartmentService();
	}

	public List<?> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	public Object getDepartmentById(int id) {
		return departmentService.getDepartmentById(id);
	}

	public Object getDepartmentByName(String name) {
		return departmentService.getDepartmentByName(name);
	}

	public void createDepartment() {

	}

	public void updateDepartment() {

	}

	public void deleteDepartment() {

	}

	public void close() {
		departmentService.close();
	}
}

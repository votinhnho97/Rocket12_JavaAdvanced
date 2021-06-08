package com.vti.BasicCRUD.service;

import java.util.List;

public interface IDepartmentService {

	List<?> getAllDepartment();

	Object getDepartmentById(int id);

	Object getDepartmentByName(String name);

	void close();

}

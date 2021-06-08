package com.vti.BasicCRUD.repository;

import java.util.List;

public interface IDepartmentRepository {

	List<?> getAllDepartment();

	Object getDepartmentById(int id);

	Object getDepartmentByName(String name);

	void close();

}

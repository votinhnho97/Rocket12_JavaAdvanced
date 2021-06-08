package com.vti.BasicCRUD.repository;

import java.util.ArrayList;
import java.util.List;

import com.vti.BasicCRUD.entity.*;
import com.vti.BasicCRUD.utils.*;
import com.vti.BasicCRUD.validation.EntityValidation;

public class DepartmentRepository implements IDepartmentRepository {
	private ICRUDUtils crudUtils;
	private EntityValidation entityValidation;
	private List<Class<?>> listClass;

	public DepartmentRepository() {
		listClass = new ArrayList<Class<?>>();
		listClass.add(Account.class);
		listClass.add(Department.class);
		listClass.add(Position.class);

		crudUtils = new CRUDHibernate(listClass);
		crudUtils.open();

		entityValidation = new EntityValidation();
	}

	public List<?> getAllDepartment() {
		return crudUtils.findAll(Department.class, "id", 1, 0, 0, null, "LIKE", "");
	}

	public Object getDepartmentById(int id) {
		List<?> result = crudUtils.findByColumns(Department.class, null, null, 0, 0, 1, "id", "=", id);
		return result.size() > 0 ? result.get(0) : null;
	}

	public Object getDepartmentByName(String name) {
		List<?> result = crudUtils.findByColumns(Department.class, null, null, 0, 0, 1, "name", "=", name);
		return result.size() > 0 ? result.get(0) : null;
	}

	public void close() {
		crudUtils.close();
	}
}

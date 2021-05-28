package com.vti.BasicCRUD;

import java.util.List;

import com.vti.BasicCRUD.entity.Department;
import com.vti.BasicCRUD.repository.DepartmentRepository;

public class Program {
	public static void main(String[] args) {
		DepartmentRepository depRepository = new DepartmentRepository();

		System.out.println("\n########### GET ALL DEPARTMENT ###########");
		List<Department> departments = depRepository.getAllDepartment();
		for (Department department : departments) {
			System.out.println(department.toString());
		}

		System.out.println("\n########### GET DEPARTMENT BY ID ###########");
		System.out.println(depRepository.getDepartmentById((short) 1).toString());

		System.out.println("\n########### GET DEPARTMENT BY NAME ###########");
		System.out.println(depRepository.getDepartmentByName("IT1").toString());

		System.out.println("\n########### CREATE DEPARTMENT ###########");
		Department department = new Department();
		department.setName("New_Department");
		depRepository.createDepartment(department);

		System.out.println("\n########### UPDATE DEPARTMENT ###########");
		depRepository.updateDepartment(
				depRepository.getDepartmentByName("New_Department").getId(),
				"Department_Edited"
		);

		System.out.println("\n########### DELETE DEPARTMENT ###########");
		depRepository.deleteDepartment(depRepository.getDepartmentByName("Department_Edited").getId());
	}
}

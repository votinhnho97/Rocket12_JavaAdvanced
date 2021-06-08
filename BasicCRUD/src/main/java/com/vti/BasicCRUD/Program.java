package com.vti.BasicCRUD;

import com.vti.BasicCRUD.controller.DepartmentController;

public class Program {
	public static void main(String[] args) {
		DepartmentController depController = new DepartmentController();
		
		depController.getAllDepartment();
		System.out.println(depController.getDepartmentById(1).toString());
		System.out.println(depController.getDepartmentByName("Marketing").toString());
		depController.close();
	}
}

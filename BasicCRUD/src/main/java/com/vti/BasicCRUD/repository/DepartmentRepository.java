package com.vti.BasicCRUD.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.BasicCRUD.entity.Department;

public class DepartmentRepository {
	private SessionFactory sessionFactory;

	public DepartmentRepository() {
		sessionFactory = buildSF();
	}

	private SessionFactory buildSF() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Department.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}

	public List<Department> getAllDepartment() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Department> query = session.createQuery("FROM Department");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Department getDepartmentById(short id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hqlQuery = "FROM Department WHERE name='" + name + "'";
			Query<Department> query = session.createQuery(hqlQuery);
			Department department = query.getSingleResult();
			return department;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void createDepartment(Department department) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(department);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void updateDepartment(short id, String newDepartmentName) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			// Get department
			Department department = (Department) session.load(Department.class, id);

			// Update via persistent instance
			department.setName(newDepartmentName);

			session.getTransaction().commit();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void updateDepartment(Department department) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteDepartment(short id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			// Get department
			Department department = (Department) session.load(Department.class, id);
			
			// Delete
			session.delete(department);
			
			session.getTransaction().commit();
		} finally {
			if (session != null)
				session.close();
		}
	}
}

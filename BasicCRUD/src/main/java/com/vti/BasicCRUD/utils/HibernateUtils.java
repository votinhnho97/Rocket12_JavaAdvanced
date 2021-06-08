package com.vti.BasicCRUD.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private Configuration configuration;
	private SessionFactory sessionFactory;

	private static HibernateUtils instance;

	public HibernateUtils() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	}

	public void addAnnotated(Class<?> clazz) {
		configuration.addAnnotatedClass(clazz);
		System.out.println("Add annotated: " + clazz.getName());
	}

	public void addAnnotated(List<Class<?>> listClass) {
		for (Class<?> clazz : listClass) {
			addAnnotated(clazz);
		}
	}

	private SessionFactory buildSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

	public void closeSession() {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public static HibernateUtils getInstance() {
		if (instance == null) {
			instance = new HibernateUtils();
		}
		return instance;
	}
}

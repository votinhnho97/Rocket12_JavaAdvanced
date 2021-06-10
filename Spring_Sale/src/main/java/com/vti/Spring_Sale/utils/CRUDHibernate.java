package com.vti.Spring_Sale.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CRUDHibernate implements ICRUDUtils {
	private HibernateUtils hibernateUtils;
	private Session session;

	public CRUDHibernate(List<Class<?>> listClass) {
		hibernateUtils = HibernateUtils.getInstance();
		hibernateUtils.addAnnotated(listClass);
	}

	public void open() {
		session = hibernateUtils.openSession();
	}

	public void close() {
		hibernateUtils.closeSession();
		if (session != null)
			session.close();
	}

	public <T> List<?> findByColumns(Class<?> entityClass, String[] columns, String sortBy, int sortType,
			int pageNumber, int pageSize, String searchBy, String searchType, T searchValue) {
		
		String entityAlias = "e";
		String hqlQuery = "";
		if (columns != null && columns.length > 0) {
			String aPartQuery = entityAlias + "." + columns[0];
			for (int i = 1; i < columns.length; i++) {
				aPartQuery = String.join(aPartQuery, entityAlias + "." + columns[i]);
			}
			hqlQuery = String.join(" ", "SELECT", aPartQuery, "FROM", entityClass.getName(), entityAlias);
		}
		hqlQuery = String.join(" ", "FROM", entityClass.getName(), entityAlias);
		if (searchBy != null && searchBy != "") {
			hqlQuery = String.join(" ", hqlQuery, "WHERE", searchBy, searchType, ":searchValue");
		}
		if (sortBy != null && sortBy != "") {
			hqlQuery = String.join(" ", hqlQuery, "ORDER BY", sortBy, sortType == 0 ? "ASC" : "DESC");
		}

		Query<?> query = session.createQuery(hqlQuery);
		if (pageSize > 0)
			query.setMaxResults(pageSize);
		if (pageNumber > 0)
			query.setFirstResult(pageSize * (pageNumber - 1));
		if (searchBy != null && searchBy != "") {
			query.setParameter("searchValue", searchValue);
		}

		return query.list();
	}

	public <T> List<?> findAll(Class<?> entityClass, String sortBy, int sortType, int pageNumber, int pageSize,
			String searchBy, String searchType, T searchValue) {
		
		return findByColumns(entityClass, null, sortBy, sortType, pageNumber, pageSize, searchBy, searchType,
				searchValue);
	}

	public <T> void create(T newEntityObject) {
		try {
			session.beginTransaction();
			session.save(newEntityObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	public <T> void update(T entityObject) {
		try {
			session.beginTransaction();
			session.update(entityObject);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	public <T> void delete(Class<T> entityClass, int id) {
		try {
			session.beginTransaction();
			Object object = session.load(entityClass, id);
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

}

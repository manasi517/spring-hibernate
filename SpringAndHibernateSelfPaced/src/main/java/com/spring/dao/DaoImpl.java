package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.spring.entity.EmployeeDetails;
import com.spring.entity.ProjectDetails;
import com.spring.entity.TaskDetails;

@Repository
public class DaoImpl implements DaoInterface{

	public List<ProjectDetails> getProjects() {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM ProjectDetails";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;
	}

	public ProjectDetails getProject(String projectName) {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM ProjectDetails where projectId =:projectName";
		Query query = session.createQuery(hql).setParameter("projectName", projectName);
		List results = query.list();
		return (ProjectDetails)results.get(0);
	}

	public List<EmployeeDetails> getEmployees(String projectId) {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM EmployeeDetails where project_id =(select id from ProjectDetails where projectId=:projectId)";
		Query query = session.createQuery(hql).setParameter("projectId", projectId);
		List results = query.list();

		return results;
	}

	public List<EmployeeDetails> getEmployees(List<String> empIds) {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM EmployeeDetails where empId in (:empIds)";

		Query query = session.createQuery(hql).setParameterList("empIds", empIds);
		List results = query.list();

		return results;
	}
	public List<TaskDetails> getTaskDetails() {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM TaskDetails ";

		Query query = session.createQuery(hql);
		List results = query.list();

		return results;
	}

	public boolean assignTask(TaskDetails task) {
		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		session.save(task);
		t.commit();
		return true;
	}

	public List<TaskDetails> getTaskDetailsForProject(long projectId)
	{

		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		String hql = "FROM TaskDetails where projectId_id =:projectId";

		Query query = session.createQuery(hql).setParameter("projectId", projectId);
		List results = query.list();

		return results;

	}


}

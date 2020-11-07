package myServlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.dao.DaoImpl;
import com.spring.entity.EmployeeDetails;
import com.spring.entity.ProjectDetails;
import com.spring.entity.TaskDetails;
import com.spring.service.ServiceImpl;

public class TestClass {

	public static void main(String[] args) {

		/*ProjectDetails projectDetails = new ProjectDetails();
		projectDetails.setProjectName("iPhone");
		projectDetails.setProjectId("p2201");
		projectDetails.setId(2);



		EmployeeDetails emp=new EmployeeDetails();
		emp.setId(6);
		emp.setEmpId("m1002005");
		emp.setEmpName("alina salvator");
		emp.setProject(projectDetails);

		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setId(1);
		taskDetails.setProjectId(projectDetails);
		taskDetails.setDescription("create classes");
		taskDetails.setStartDate(new Date());
		taskDetails.setEndDate(new Date());

		List<EmployeeDetails> emps =new ArrayList<EmployeeDetails>();
		emps.add(emp);
		taskDetails.setEmps(emps);

		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t=session.beginTransaction(); 
		//session.save(projectDetails);
		// session.save(taskDetails);
		session.save(emp);
		t.commit();*/
		/*ServiceImpl d=new ServiceImpl();
		d.getTaskDetails();*/
	}
}

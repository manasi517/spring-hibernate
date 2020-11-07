package com.spring.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.DaoImpl;
import com.spring.dao.DaoInterface;
import com.spring.entity.EmployeeDetails;
import com.spring.entity.ProjectDetails;
import com.spring.entity.TaskDetails;
import com.spring.entity.TaskViewDto;

@Service
public class ServiceImpl implements ServiceInterface{

	DaoImpl daoInterface= new DaoImpl();
	
	public boolean assignTask(String projectName,Date startDate, Date endDate, String description, String[] empNames)
	{
		ProjectDetails projectDetails = daoInterface.getProject(projectName);
		List<TaskDetails> tasks = daoInterface.getTaskDetails();
		
		List<String> empIds = new ArrayList<String>();
		for(int i=0;i<empNames.length;i++)
			empIds.add(empNames[i]);
		
		List<EmployeeDetails> emps = daoInterface.getEmployees(empIds);
		
		int max=0;
		for(int i=0;i<tasks.size();i++)
			if(max<tasks.get(i).getId())
				max=tasks.get(i).getId();
		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setId(max+1);
		taskDetails.setProjectId(projectDetails);
		taskDetails.setDescription(description);
		taskDetails.setEndDate(endDate);
		taskDetails.setStartDate(startDate);
		taskDetails.setEmps(emps);
		return daoInterface.assignTask(taskDetails);

	}

	public List<ProjectDetails> getProjects() {
		
		DaoImpl daoInterface= new DaoImpl();
		return daoInterface.getProjects();
		
	}
	
public List<EmployeeDetails> getEmployees(String projectId) {
		
		return daoInterface.getEmployees(projectId);
		
	}

public List<TaskViewDto> getTaskDetails(String projectId)
{
	List<TaskViewDto> taskForProjects = new ArrayList<TaskViewDto>();
	if(projectId.equalsIgnoreCase("allProjects"))
	{
	List<ProjectDetails> projects=daoInterface.getProjects();
	for(ProjectDetails project:projects)
	{
		TaskViewDto taskDetails = new TaskViewDto();
		List<TaskDetails> tasks=
		daoInterface.getTaskDetailsForProject((long)project.getId());
		taskDetails.setProjectId(project.getProjectId());
		taskDetails.setTaskDetails(tasks);
		taskForProjects.add(taskDetails);
	}
	}
	else
	{
		ProjectDetails project=daoInterface.getProject(projectId);
		TaskViewDto taskDetails = new TaskViewDto();
		List<TaskDetails> tasks=
		daoInterface.getTaskDetailsForProject((long)project.getId());
		taskDetails.setProjectId(project.getProjectId());
		taskDetails.setTaskDetails(tasks);
		taskForProjects.add(taskDetails);
	}
	
	return taskForProjects;
}
}

package com.mindtree.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindtree.entity.ProjectDetails;

@Service
@Component
public interface ServiceInterface {
	
	public boolean assignTask(String projectName,Date startDate, Date endDate, String description, String[] emp);
	
	public List<ProjectDetails> getProjects();

}

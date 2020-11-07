package com.mindtree.entity;

import java.util.List;

public class TaskViewDto {
	
	String projectId;
	List<TaskDetails> taskDetails;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public List<TaskDetails> getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(List<TaskDetails> taskDetails) {
		this.taskDetails = taskDetails;
	}
	@Override
	public String toString() {
		return "TaskViewDto [projectId=" + projectId + ", taskDetails=" + taskDetails + "]";
	}

}

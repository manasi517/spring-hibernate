package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="ProjectDetails")
@Table(name = "ProjectDetails")
public class ProjectDetails {

	@Id
	private int id;
	private String projectId;
	private String projectName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "ProjectDetails [id=" + id + ", projectId=" + projectId + ", projectName=" + projectName + "]";
	}
}

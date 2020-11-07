package com.spring.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="TaskDetails")
@Table(name = "TaskDetails")
public class TaskDetails {

	@Id
	private int id;
	@OneToOne
	private ProjectDetails projectId;
	private String description;
	private Date startDate;
	private Date endDate;
	@ManyToMany
	private List<EmployeeDetails> emps;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProjectDetails getProjectId() {
		return projectId;
	}
	public void setProjectId(ProjectDetails projectId) {
		this.projectId = projectId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<EmployeeDetails> getEmps() {
		return emps;
	}
	public void setEmps(List<EmployeeDetails> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "TaskDetails [id=" + id + ", projectId=" + projectId + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", emps=" + emps + "]";
	}
	
	
}

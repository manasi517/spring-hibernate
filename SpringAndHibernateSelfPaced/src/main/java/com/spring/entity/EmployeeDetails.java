package com.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="EmployeeDetails")
@Table(name = "EmployeeDetails")
public class EmployeeDetails {

	@Id
	private int id;
	private String empId;
	private String empName;
	@OneToOne
	private ProjectDetails project;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public ProjectDetails getProject() {
		return project;
	}
	public void setProject(ProjectDetails project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", empId=" + empId + ", empName=" + empName + ", project=" + project + "]";
	}
	
	
	
	

}

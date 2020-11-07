package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.entity.ProjectDetails;

@Repository
public interface DaoInterface {

	public List<ProjectDetails> getProjects();
}


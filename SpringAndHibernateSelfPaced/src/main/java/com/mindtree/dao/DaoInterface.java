package com.mindtree.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindtree.entity.ProjectDetails;

@Repository
public interface DaoInterface {

	public List<ProjectDetails> getProjects();
}


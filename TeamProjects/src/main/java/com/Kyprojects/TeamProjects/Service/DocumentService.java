package com.Kyprojects.TeamProjects.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Documents;

@Service
public interface DocumentService {

	public void createdocument(Documents em);
	public void updatedocument(Documents sem);
	public void delete(Documents em);
	public List<Documents> findAll(Class c);
	
}

package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Documents;
import com.Kyprojects.TeamProjects.Repository.Documentsrepo;
import com.Kyprojects.TeamProjects.Service.DocumentService;



@Service
public class DocumentImplementation implements DocumentService {
	
	@Autowired
	private Documentsrepo docrepo;

	public void createdocument(Documents em) {
		// TODO Auto-generated method stub
		docrepo.save(em);
	}

	public void updatedocument(Documents sem) {
		// TODO Auto-generated method stub
		docrepo.save(sem);
	}

	public void delete(Documents em) {
		// TODO Auto-generated method stub
		docrepo.delete(em);
	}

	public List<Documents> findAll(Class c) {
		// TODO Auto-generated method stub
		return docrepo.findAll();
	}

}

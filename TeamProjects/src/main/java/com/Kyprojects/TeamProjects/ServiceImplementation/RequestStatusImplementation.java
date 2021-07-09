package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Requeststatuss;
import com.Kyprojects.TeamProjects.Repository.RequestStatusRepo;
import com.Kyprojects.TeamProjects.Service.RequestStatusService;

@Service
public class RequestStatusImplementation implements RequestStatusService {

	@Autowired
	private RequestStatusRepo statusrepo;

	public void createrequeststatus(Requeststatuss em) {
		// TODO Auto-generated method stub
		statusrepo.save(em);
	}

	public void updaterequeststatus(Requeststatuss em) {
		// TODO Auto-generated method stub
		statusrepo.save(em);
	}

	public void delete(Requeststatuss em) {
		// TODO Auto-generated method stub
		statusrepo.delete(em);
	}

	public List<Requeststatuss> findAll(Class c) {
		// TODO Auto-generated method stub
		return statusrepo.findAll();
	}

	public Optional<Requeststatuss> findById(int id) {
		// TODO Auto-generated method stub
		return statusrepo.findById(id);
	}
	
	
}

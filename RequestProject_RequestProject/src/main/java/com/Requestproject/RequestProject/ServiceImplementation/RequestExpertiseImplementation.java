package com.Requestproject.RequestProject.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Requestexpertis;
import com.Requestproject.RequestProject.Repository.RequestExpertisrepo;
import com.Requestproject.RequestProject.Service.RequestExpertiseService;



@Service
public class RequestExpertiseImplementation implements RequestExpertiseService {

	@Autowired
	private RequestExpertisrepo exprepo;

	public void createrequestexp(Requestexpertis em) {
		// TODO Auto-generated method stub
		exprepo.save(em);
	}

	public void updatecategory(Requestexpertis em) {
		// TODO Auto-generated method stub
		exprepo.save(em);
	}

	public void delete(Requestexpertis em) {
		// TODO Auto-generated method stub
		exprepo.delete(em);
	}

	public List<Requestexpertis> findAll(Class c) {
		// TODO Auto-generated method stub
		return exprepo.findAll();
	}

	public Optional<Requestexpertis> findById(int id) {
		// TODO Auto-generated method stub
		return exprepo.findByid(id);
	}

	public Optional<Requestexpertis> findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}

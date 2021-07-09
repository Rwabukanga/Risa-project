package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Deliverables;
import com.Kyprojects.TeamProjects.Repository.DeliverablesRepo;
import com.Kyprojects.TeamProjects.Service.DeliverableService;

@Service
public class DeliverableImplementation implements DeliverableService {

	@Autowired
	private DeliverablesRepo delirepo;
	
	
	public void createdeliverable(Deliverables em) {
		// TODO Auto-generated method stub
		delirepo.save(em);
	}

	public void updatedeliverable(Deliverables em) {
		// TODO Auto-generated method stub
		delirepo.save(em);
	}

	public void delete(Deliverables em) {
		// TODO Auto-generated method stub
		delirepo.delete(em);
	}

	public List<Deliverables> findAll(Class c) {
		// TODO Auto-generated method stub
		return delirepo.findAll();
	}

	public Optional<Deliverables> findById(int id) {
		// TODO Auto-generated method stub
		return delirepo.findById(id);
	}

}

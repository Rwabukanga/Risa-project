package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Deliverables;


@Service
public interface DeliverableService {

	public void createdeliverable(Deliverables em);
	public void updatedeliverable(Deliverables em);
	public void delete(Deliverables em);
	public List<Deliverables> findAll(Class c);
	public Optional<Deliverables> findById(int id);
	
}

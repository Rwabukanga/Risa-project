package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Requestexpertis;



@Service
public interface RequestExpertiseService {

	public void createrequestexp(Requestexpertis em);
	public void updatecategory(Requestexpertis em);
	public void delete(Requestexpertis em);
	public List<Requestexpertis> findAll(Class c);
	public Optional<Requestexpertis> findById(int id);
	public Optional<Requestexpertis> findByUuid(String uuid);
	
}

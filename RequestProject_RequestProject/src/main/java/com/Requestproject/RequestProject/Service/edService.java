package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Educationqualification;



@Service
public interface edService {

	public void createstudent(Educationqualification ed);
	public void update(Educationqualification em);
	public void delete(Educationqualification em);
	public List<Educationqualification> findAll(Class c);
	public Optional<Educationqualification> findById(int id);
}

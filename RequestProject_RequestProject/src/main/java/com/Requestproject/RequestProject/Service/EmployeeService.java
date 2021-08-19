package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Employeee;



@Service
public interface EmployeeService {

	public void createemployee(Employeee em);
	public void updateemployee(Employeee em);
	public void delete(Employeee em);
	public List<Employeee> findAll(Class c);
	public Optional<Employeee> findById(int id);
	public Optional<Employeee> findByUuid(String uuid);
}

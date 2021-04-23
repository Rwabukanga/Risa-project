package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Employeee;
import com.Kyprojects.TeamProjects.Repository.EmployeeRepository;
import com.Kyprojects.TeamProjects.Service.EmployeeService;

@Service
public class EmployeeImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;
 	
	public void createemployee(Employeee em) {
		// TODO Auto-generated method stub
		employeerepo.save(em);
	}

	public void updateemployee(Employeee em) {
		// TODO Auto-generated method stub
		employeerepo.save(em);
	}

	public List<Employeee> findAll(Class c) {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

	public Optional<Employeee> findById(int id) {
		// TODO Auto-generated method stub
		return employeerepo.findById(id);
	}

	public Optional<Employeee> findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return employeerepo.findByUuid(uuid);
	}

	public void delete(Employeee em) {
		// TODO Auto-generated method stub
		employeerepo.delete(em);
	}
}

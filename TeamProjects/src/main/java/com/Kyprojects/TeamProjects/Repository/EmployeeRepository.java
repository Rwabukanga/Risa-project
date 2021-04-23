package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Employeee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employeee, Integer> {

	Optional<Employeee> findById(int id);
	Optional<Employeee> findByUuid(String uuid);
}


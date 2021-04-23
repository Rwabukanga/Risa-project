package com.Kyprojects.TeamProjects.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Registrant;
import com.Kyprojects.TeamProjects.Domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	Optional<Request> findById(int id);
	Optional<Request> findByUuid(String uuid);
	
	
}

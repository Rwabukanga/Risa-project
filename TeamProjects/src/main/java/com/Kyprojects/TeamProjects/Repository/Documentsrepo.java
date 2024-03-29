package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Documents;



@Repository
public interface Documentsrepo extends JpaRepository<Documents, Integer> {

	Optional<Documents> findById(int id);
	
}

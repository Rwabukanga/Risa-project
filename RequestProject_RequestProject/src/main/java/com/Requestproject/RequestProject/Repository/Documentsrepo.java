package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Documents;





@Repository
public interface Documentsrepo extends JpaRepository<Documents, Integer> {

	Optional<Documents> findById(int id);
	
}

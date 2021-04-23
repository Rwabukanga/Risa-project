package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

	Optional<Institution>findById(int id);
	/*Optional<Institution>findByUuid(String uuid);*/
	
}

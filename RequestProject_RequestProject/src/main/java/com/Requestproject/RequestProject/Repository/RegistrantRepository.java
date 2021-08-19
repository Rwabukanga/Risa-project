package com.Requestproject.RequestProject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Registrant;





@Repository
public interface RegistrantRepository extends JpaRepository<Registrant, Integer> {

	Optional<Registrant> findById(int id);
	Optional<Registrant> findByUuid(String uuid);
	List<Registrant> findByDistrictId(int id);
	

	List<Registrant> findByCategory(String category);
	Optional<Registrant> findByEmail(String emailAddress);
	
}

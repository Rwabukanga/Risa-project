package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Systemuser;






@Repository
@EnableJpaRepositories
public interface SystemuserRepository extends JpaRepository<Systemuser, Integer> {

	Optional<Systemuser> findById(int id);
	Optional<Systemuser> findByUuid(String uuid);
	public Systemuser findByUsernameAndPassword(String Username, String Password);
	/* Optional<Systemuser> findByUsername(String username); */
	public Systemuser findByUsername(String username); 
	
	
}

package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Systemuser;




@Repository
public interface SystemuserRepository extends JpaRepository<Systemuser, Integer> {

	Optional<Systemuser> findById(int id);
	Optional<Systemuser> findByUuid(String uuid);
	public Systemuser findByUsernameAndPassword(String Username, String Password);
}

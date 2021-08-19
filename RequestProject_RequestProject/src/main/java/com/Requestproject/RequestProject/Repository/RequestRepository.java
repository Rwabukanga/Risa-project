package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Request;


@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	Optional<Request> findById(int id);
	Optional<Request> findByUuid(String uuid);
	
	
}

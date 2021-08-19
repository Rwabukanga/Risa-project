package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Educationqualification;



@Repository
public interface Edrepo extends JpaRepository<Educationqualification, Integer> {

	Optional<Educationqualification> findById(int id);
}

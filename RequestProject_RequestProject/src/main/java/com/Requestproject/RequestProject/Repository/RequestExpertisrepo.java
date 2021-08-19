package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Requestexpertis;


@Repository
public interface RequestExpertisrepo extends JpaRepository<Requestexpertis, Integer> {

	Optional<Requestexpertis>findByid(int id);
}

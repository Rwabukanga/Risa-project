package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Kyprojects.TeamProjects.Domain.Requeststatuss;

@Repository
public interface RequestStatusRepo extends JpaRepository<Requeststatuss, Integer> {

	Optional<Requeststatuss> findById(int id);
}

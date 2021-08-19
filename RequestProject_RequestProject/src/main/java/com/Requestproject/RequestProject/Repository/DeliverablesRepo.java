package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Deliverables;


@Repository
public interface DeliverablesRepo extends JpaRepository<Deliverables, Integer> {

	Optional<Deliverables> findById(int id);
}

package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Requeststatuss;




@Repository
public interface RequestStatusRepo extends JpaRepository<Requeststatuss, Integer> {

	Optional<Requeststatuss> findById(int id);
}

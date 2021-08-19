package com.Requestproject.RequestProject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.District;


@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

	Optional<District> findById(int id);
	List<District> findByProvinceId(int id);
}

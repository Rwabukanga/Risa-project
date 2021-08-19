package com.Requestproject.RequestProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Requestproject.RequestProject.Domain.Province;


@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	Optional<Province> findById(int id);
}

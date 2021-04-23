package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	Optional<Province> findById(int id);
}

package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Memberr;

@Repository
public interface MemberRepository extends JpaRepository<Memberr, Integer> {

	Optional<Memberr> findById(int id);
	Optional<Memberr> findByUuid(String uuid);
	
}

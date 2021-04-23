package com.Kyprojects.TeamProjects.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

	Optional<Meeting> findById(int id);
	Optional<Meeting> findByUuid(String uuid);
	
	
}

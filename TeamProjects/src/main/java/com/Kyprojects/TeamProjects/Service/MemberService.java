package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Memberr;

@Service
public interface MemberService {

	public void createMember(Memberr member);
	public void updateMember(Memberr member);
	public void deletemember(int id);
	public Optional<Memberr> findById(int id);
	public Optional<Memberr> findByUuuid(String uuid);
	public List<Memberr> findAll(Class c); 
}

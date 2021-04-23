package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Memberr;
import com.Kyprojects.TeamProjects.Repository.MemberRepository;
import com.Kyprojects.TeamProjects.Service.MemberService;

@Service
public class MemberImplementation implements MemberService {
	
	@Autowired
	private MemberRepository memberrepo;

	public void createMember(Memberr member) {
		// TODO Auto-generated method stub
		memberrepo.save(member);
	}

	public void updateMember(Memberr member) {
		// TODO Auto-generated method stub
		memberrepo.save(member);
	}

	public void deletemember(int id) {
		// TODO Auto-generated method stub
		memberrepo.deleteById(id);
	}

	public Optional<Memberr> findById(int id) {
		// TODO Auto-generated method stub
		return memberrepo.findById(id);
	}

	
	public List<Memberr> findAll(Class c) {
		// TODO Auto-generated method stub
		return memberrepo.findAll();
	}

	public Optional<Memberr> findByUuuid(String uuid) {
		// TODO Auto-generated method stub
		return memberrepo.findByUuid(uuid);
	}
}

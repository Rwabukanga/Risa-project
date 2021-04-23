package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Request;

@Service
public interface RequestService {

	public void createrequest(Request req);
	public void updaterequest(Request req);
	public void deleterequest(int id);
	public Optional<Request> findById(int id);
	public Optional<Request> findByUuid(String uuid);
	public List<Request> findAll();
	public byte[] RequestDetailsPDF(Request app);
	public byte[] requestDetailsPDF(List<Request> req); 
	
}

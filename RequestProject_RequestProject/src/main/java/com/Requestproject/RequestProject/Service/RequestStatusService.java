package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Requeststatuss;





@Service
public interface RequestStatusService {

	public void createrequeststatus(Requeststatuss em);
	public void updaterequeststatus(Requeststatuss em);
	public void delete(Requeststatuss em);
	public List<Requeststatuss> findAll(Class c);
	public Optional<Requeststatuss> findById(int id);
	
}

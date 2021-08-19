package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Institution;



@Service
public interface InstitutionService {

	public void createinstitution(Institution ins);
	public void updateinstitution(Institution ins);
	public void deleteinstution(int id);
	public Optional<Institution> findById(int id);
	/*public Optional<Institution> findByUuid(String uuid);*/
	public List<Institution> findAll();
}

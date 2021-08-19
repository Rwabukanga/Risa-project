package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Documents;




@Service
public interface DocumentService {

	public void createdocument(Documents em);
	public void updatedocument(Documents sem);
	public void delete(Documents em);
	public List<Documents> findAll(Class c);
	public Optional<Documents> findById(int id);
	public byte[] documentDetailsPDF(List<Documents> req); 
}

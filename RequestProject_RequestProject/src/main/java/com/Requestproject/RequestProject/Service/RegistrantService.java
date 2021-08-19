package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Registrant;



@Service
public interface RegistrantService {

	public Registrant createregistrar(Registrant registrar);
	public void updateRegistrar(Registrant registrar);
	public void deleteRegistrar(int id);
	public Optional<Registrant> findByid(int id);
	public Optional<Registrant> findByUuid(String uuid);
	public List<Registrant> findAll(Class c);
	/*public Registrant buildRegistrant(RegistrarController.RegAdmin regAdmin);*/
	/*public Category checkRegistrarCategory(String registrant);*/
	public List<Registrant> findByDistrictId(int id);
	
	/*public List<Registrant> findByCategory(String category);*/
	
	public List<Registrant> findByCategory(String category);
	public void sendSimpleMessage(String to, String subject, String text);
	public Optional<Registrant> findByEmail(String emailAddress);
}

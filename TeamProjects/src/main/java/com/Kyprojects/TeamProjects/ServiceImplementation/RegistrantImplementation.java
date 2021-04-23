package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Categories;
import com.Kyprojects.TeamProjects.Domain.Registrant;
import com.Kyprojects.TeamProjects.Repository.RegistrantRepository;
import com.Kyprojects.TeamProjects.Service.RegistrantService;



@Service
public class RegistrantImplementation implements RegistrantService {

	@Autowired
	private RegistrantRepository regrepo;
	
	
	
	public Registrant createregistrar(Registrant registrar) {
		// TODO Auto-generated method stub
		return regrepo.save(registrar);
	}

	public void updateRegistrar(Registrant registrar) {
		// TODO Auto-generated method stub
		regrepo.save(registrar);
	}

	public void deleteRegistrar(int id) {
		// TODO Auto-generated method stub
		regrepo.deleteById(id);
	}

	public Optional<Registrant> findByid(int id) {
		// TODO Auto-generated method stub
		return regrepo.findById(id);
	}

	public Optional<Registrant> findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return regrepo.findByUuid(uuid);
	}
	/*public Category checkRegistrarCategory(String registrant) {
		
		for(Category re: Category.values()) {
			if(re.name().equalsIgnoreCase(registrant)) {
				return re;
			}
		}
		return null;
	}*/

	public List<Registrant> findAll(Class c) {
		// TODO Auto-generated method stub
		return regrepo.findAll();
	}

	public List<Registrant> findByDistrictId(int id) {
		// TODO Auto-generated method stub
		return regrepo.findByDistrictId(id);
	}

	public List<Registrant> findByCategory(String category) {
		// TODO Auto-generated method stub
		return regrepo.findByCategory(category);
	}

	

	
	
	
	

	

	
	
	
	
}

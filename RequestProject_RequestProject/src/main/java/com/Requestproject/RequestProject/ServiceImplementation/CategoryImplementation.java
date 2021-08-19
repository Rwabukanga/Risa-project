package com.Requestproject.RequestProject.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Categories;
import com.Requestproject.RequestProject.Repository.CategoryRepository;
import com.Requestproject.RequestProject.Service.CategoryService;



@Service
public class CategoryImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryrepo;

	public void createcategory(Categories em) {
		// TODO Auto-generated method stub
		categoryrepo.save(em);
	}

	public void updatecategory(Categories em) {
		// TODO Auto-generated method stub
		categoryrepo.save(em);
	}

	public void delete(Categories em) {
		// TODO Auto-generated method stub
		categoryrepo.delete(em);
	}

	public List<Categories> findAll(Class c) {
		// TODO Auto-generated method stub
		return categoryrepo.findAll();
	}

	public Optional<Categories> findById(int id) {
		// TODO Auto-generated method stub
		return categoryrepo.findById(id);
	}

	public Optional<Categories> findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return categoryrepo.findByUuid(uuid);
	}

	/*public Optional<Categories> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
/*	public List<Categories> findByCategory(Categories ct) {
		// TODO Auto-generated method stub
		return categoryrepo.findByCategory(ct);
	}*/

	/*public Optional<Categories> findByName(String name) {
		// TODO Auto-generated method stub
		return categoryrepo.findByName(name);
	}


	*/
	
	
}

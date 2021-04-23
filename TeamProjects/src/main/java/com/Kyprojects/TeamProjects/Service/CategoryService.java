package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Categories;

@Service
public interface CategoryService {

	public void createcategory(Categories em);
	public void updatecategory(Categories em);
	public void delete(Categories em);
	public List<Categories> findAll(Class c);
	public Optional<Categories> findById(int id);
	public Optional<Categories> findByUuid(String uuid);
	/*public List<Categories> findByCategory(Categories ct);*/
	/*public Optional<Categories> findByName(String name);*/
	
}

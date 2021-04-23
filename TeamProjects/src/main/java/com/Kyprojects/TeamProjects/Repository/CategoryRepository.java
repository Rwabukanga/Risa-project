package com.Kyprojects.TeamProjects.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Kyprojects.TeamProjects.Domain.Categories;



@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

	Optional<Categories> findById(int id);
	Optional<Categories> findByUuid(String uuid);
	
	/*@Query("Select u from Categories u where u.name= :name")
	List<Categories> findByCategory(Categories ct);*/
	
/*	Optional<Categories> findByName(String name);*/
}

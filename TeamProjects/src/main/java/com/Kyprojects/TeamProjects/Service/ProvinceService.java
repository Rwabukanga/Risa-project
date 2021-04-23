package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Province;

@Service
public interface ProvinceService {
	
	public void createprovince(Province province);
	public List<Province> findAll(Class c);
	public Optional<Province> findById(int id);

}

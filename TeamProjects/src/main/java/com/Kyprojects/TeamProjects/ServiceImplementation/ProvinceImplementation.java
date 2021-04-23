package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Province;
import com.Kyprojects.TeamProjects.Repository.ProvinceRepository;
import com.Kyprojects.TeamProjects.Service.ProvinceService;

@Service
public class ProvinceImplementation implements ProvinceService {

	@Autowired
	private ProvinceRepository provincerepo;

	public void createprovince(Province province) {
		// TODO Auto-generated method stub
		provincerepo.save(province);
	}

	public List<Province> findAll(Class c) {
		// TODO Auto-generated method stub
		return provincerepo.findAll();
	}

	public Optional<Province> findById(int id) {
		// TODO Auto-generated method stub
		return provincerepo.findById(id);
	}
}

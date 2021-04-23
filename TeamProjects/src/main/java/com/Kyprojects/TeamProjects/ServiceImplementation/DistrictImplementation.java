package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.District;
import com.Kyprojects.TeamProjects.Repository.DistrictRepository;
import com.Kyprojects.TeamProjects.Service.DistrictService;

@Service
public class DistrictImplementation implements DistrictService{
	
	@Autowired
	private DistrictRepository districtrepo;

	public void createdistrict(District district) {
		// TODO Auto-generated method stub
		districtrepo.save(district);
	}

	public List<District> findAll(Class c) {
		// TODO Auto-generated method stub
		return districtrepo.findAll();
	}

	public Optional<District> findById(int id) {
		// TODO Auto-generated method stub
		return districtrepo.findById(id);
	}

	public List<District> findByProvinceId(int id) {
		// TODO Auto-generated method stub
		return districtrepo.findByProvinceId(id);
	}
	
	

}

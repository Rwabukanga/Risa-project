package com.Requestproject.RequestProject.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.District;
import com.Requestproject.RequestProject.Repository.DistrictRepository;
import com.Requestproject.RequestProject.Service.DistrictService;


@Service
public class DistrictImplementation implements DistrictService{
	
	@Autowired
	private DistrictRepository districtrepo;

	
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

	public void createdistrict(District district) {
		// TODO Auto-generated method stub
		districtrepo.save(district);
	}
	
	

}

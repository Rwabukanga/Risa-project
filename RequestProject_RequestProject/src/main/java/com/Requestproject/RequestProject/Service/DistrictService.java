package com.Requestproject.RequestProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.District;


@Service
public interface DistrictService {

	public void createdistrict(District district);
	public List<District> findAll(Class c);
	public Optional<District> findById(int id);
	public List<District> findByProvinceId(int id);
}

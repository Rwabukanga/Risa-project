package com.Kyprojects.TeamProjects.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Kyprojects.TeamProjects.Domain.District;
import com.Kyprojects.TeamProjects.Domain.Province;
import com.Kyprojects.TeamProjects.Service.DistrictService;
import com.Kyprojects.TeamProjects.Service.ProvinceService;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;

@CrossOrigin
@Controller
@RequestMapping(value="/location")
public class LocationController {

	@Autowired
	private DistrictService districtservice;
	
	@Autowired
	private ProvinceService provinceservice;
	
	@CrossOrigin
	@RequestMapping(value="/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAll(){
		
		ResponseBean rb = new ResponseBean();
		
		try {
		List<Province> list = provinceservice.findAll(Province.class);
		rb.setCode(Msg.SUCCESS_CODE);
		rb.setDescription("find all");
		rb.setObject(list);
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/find/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findbyid(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			Optional<Province> prov = provinceservice.findById(id);
			Province province = prov.get();
			
			if(province == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("found it");
			rb.setObject(province);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}

@CrossOrigin
@RequestMapping(value="/alll", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> findall(){
		
		ResponseBean rb = new ResponseBean();
		
		try {
		List<District> list = districtservice.findAll(District.class);
		rb.setCode(Msg.SUCCESS_CODE);
		rb.setDescription("find all");
		rb.setObject(list);
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
   
   @CrossOrigin
   @RequestMapping(value="/district/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Object>findById(HttpServletRequest request, @PathVariable int id){
	   
	   ResponseBean rb = new ResponseBean();
	   
	   try {
		   List<District> district = districtservice.findByProvinceId(id);
			
			
			if(district == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("found it");
			rb.setObject(district);
			}
	   }catch(Exception ex) {
		rb.setCode(Msg.ERROR_CODE);
		rb.setDescription("failed to found it");
	   }
	   return new ResponseEntity<Object>(rb, HttpStatus.OK);
   }

}

package com.Requestproject.RequestProject.Controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Requestproject.RequestProject.Domain.Educationqualification;
import com.Requestproject.RequestProject.Domain.Employeee;
import com.Requestproject.RequestProject.Service.edService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;



@Controller
@CrossOrigin
@RequestMapping(value="/student")
public class EdController {

	@Autowired
	private edService edservice;
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createstudent(HttpServletRequest request, @RequestBody Educationqualification emp){
		
		ResponseBean rb = new ResponseBean();
		try {
			edservice.createstudent(emp);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well saved");
			rb.setObject(emp);
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/update/{id}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> Updatestudent(HttpServletRequest request, @RequestBody Educationqualification emp,@PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Educationqualification> ed = edservice.findById(id);
			Educationqualification tt = ed.get();
			tt.setCounty(emp.getCounty());
			tt.setEducationlevel(emp.getEducationlevel());
			tt.setInstitutionname(emp.getInstitutionname());
			tt.setYearofcompletion(emp.getYearofcompletion());
			tt.setTown(emp.getTown());
			edservice.update(tt);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well saved");
			rb.setObject(emp);
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Educationqualification> empp= edservice.findById(id);
			Educationqualification emm = empp.get();
			if(emm == null) {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Not Deleted");
			}else {
				edservice.delete(emm);
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("successfully deleted");
				rb.setObject(emm);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/all", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAll(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Educationqualification> list = edservice.findAll(Employeee.class);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("All Employees");
			rb.setObject(list);
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/find/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Educationqualification> ee = edservice.findById(id);
			Educationqualification emp = ee.get();
			if(emp == null) {
				rb.setCode(Msg.NULLS_FOUND);
				rb.setDescription("Not Found");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Data founded");
				rb.setObject(emp);
			}
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to found");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
}

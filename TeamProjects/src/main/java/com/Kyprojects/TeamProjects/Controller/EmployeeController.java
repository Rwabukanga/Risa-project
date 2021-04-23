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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Kyprojects.TeamProjects.Domain.Employeee;
import com.Kyprojects.TeamProjects.Service.EmployeeService;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping(value="/employeeee")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createEmployee(HttpServletRequest request, @RequestBody Employeee emp){
		
		ResponseBean rb = new ResponseBean();
		try {
			empservice.createemployee(emp);
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
	public ResponseEntity<Object> updateemployee(HttpServletRequest request, @RequestBody Employeee emp, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Employeee> em = empservice.findById(id); 
			Employeee emm = em.get();
			emm.setFirstname(emp.getFirstname());
			emm.setLastname(emp.getLastname());
			emm.setDob(emp.getDob());
			emm.setSalary(emp.getSalary());
			empservice.updateemployee(emm);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well Updated");
			rb.setObject(emm);
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
			Optional<Employeee> empp= empservice.findById(id);
			Employeee emm = empp.get();
			if(emm == null) {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Not Deleted");
			}else {
				empservice.delete(emm);
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
	@RequestMapping(value="/find/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Employeee> ee = empservice.findById(id);
			Employeee emp = ee.get();
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
	
	@CrossOrigin
	@RequestMapping(value="/all", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAll(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Employeee> list = empservice.findAll(Employeee.class);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("All Employees");
			rb.setObject(list);
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
}

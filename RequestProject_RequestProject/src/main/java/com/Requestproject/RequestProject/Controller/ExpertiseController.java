package com.Requestproject.RequestProject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Requestproject.RequestProject.Domain.Requestexpertis;
import com.Requestproject.RequestProject.Service.RequestExpertiseService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;


@CrossOrigin
@Controller
@RequestMapping(value="/expertise")
public class ExpertiseController {

	@Autowired
	private RequestExpertiseService reqservice;
	
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createcategory(HttpServletRequest request, @RequestBody innerExpertise ct){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			Requestexpertis cc = new Requestexpertis();
			cc.setName(ct.getName());

			reqservice.createrequestexp(cc);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well saved");
		    rb.setObject(cc);
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to save");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value= "/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allexpertise(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Requestexpertis> list = reqservice.findAll(Requestexpertis.class);
			
			
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("get all");
			rb.setObject(list);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	
	
public static class innerExpertise{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}

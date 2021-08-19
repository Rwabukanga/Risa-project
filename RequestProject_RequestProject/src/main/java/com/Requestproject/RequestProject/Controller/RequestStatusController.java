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

import com.Requestproject.RequestProject.Domain.Requeststatuss;
import com.Requestproject.RequestProject.Service.RequestStatusService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;



@Controller
@RequestMapping(value="/status")
public class RequestStatusController {

	@Autowired
	private RequestStatusService stservice;
	
	
	
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createcategory(HttpServletRequest request, @RequestBody innerStatus ct){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			
			Requeststatuss cc = new Requeststatuss();
			
			
			cc.setName(ct.getName());
			
			
			stservice.createrequeststatus(cc);
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
	public ResponseEntity<Object> allRequestStatus(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Requeststatuss> list = stservice.findAll(Requeststatuss.class);
			
			
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
	
	
	public static class innerStatus{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
			
		}
	
	
	
}

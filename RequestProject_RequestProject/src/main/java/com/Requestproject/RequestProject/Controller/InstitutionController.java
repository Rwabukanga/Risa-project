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

import com.Requestproject.RequestProject.Domain.Institution;
import com.Requestproject.RequestProject.Service.InstitutionService;
import com.Requestproject.RequestProject.Service.RegistrantService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;



@Controller
@RequestMapping(value="/institution")
public class InstitutionController {

	@Autowired
	private InstitutionService inservice;
	
	@Autowired
	private RegistrantService rgservice;
	
	  @CrossOrigin
      @RequestMapping(value="/save", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)	
	  public ResponseEntity<Object> createrequest(HttpServletRequest request,@RequestBody innerinstitution ins) {
			ResponseBean rb = new ResponseBean();
			
			try {
			/*Optional<Registrant> rt = rgservice.findByid(id);
			Registrant reg = rt.get();*/
			  Institution er = new Institution();
			  er.setName(ins.getName());
			/*  er.setId(Integer.parseInt(ins.getId()));*/
			  
			  
			 
			  inservice.createinstitution(er);
	          rb.setCode(Msg.SUCCESS_CODE);
	          rb.setDescription(Msg.save);
	          rb.setObject(er);
				
	} catch (Exception e) {
		    
		    System.out.println(e.getMessage()+"=============================");
		    e.printStackTrace();
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to create registrar");
				rb.setObject(ins);
			}

			return new ResponseEntity<Object>(rb, HttpStatus.OK);
		}
	  
	  
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.PUT, value= "/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateRequest(HttpServletRequest request,@PathVariable int id,@RequestBody Institution inst){
			
			ResponseBean rb = new ResponseBean();
			
			try {
				Optional<Institution> rqq= inservice.findById(id);
				Institution rqt = rqq.get();
		
				rqt.setName(inst.getName());
				/*rqt.setEmail(inst.getEmail());
				rqt.setPhonenumber(inst.getPhonenumber());*/
			
				inservice.updateinstitution(rqt);
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("updated successfully");
				rb.setObject(rqt);
				
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Failed to update institution");
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	    
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
		public ResponseEntity<Object> deleteRequest(HttpServletRequest request, @PathVariable int id){
			ResponseBean rb= new ResponseBean();
			try {
				Optional<Institution> inst= inservice.findById(id);
				Institution ins = inst.get();
				if(ins == null) {
					rb.setCode(Msg.NULLS_FOUND);
					rb.setDescription("not deleted");
					
				}else {
					inservice.deleteinstution(id);
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription(Msg.delete);
					rb.setObject(ins);		
				}
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete Institution");
				
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	        @CrossOrigin
	  		@RequestMapping(value= "/all", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	  		public ResponseEntity<Object> findall(){
	  			
	  			ResponseBean rb = new ResponseBean();
	  			try {			
	  						List<Institution> list = inservice.findAll();
	  						rb.setCode(Msg.SUCCESS_CODE);
	  						rb.setDescription("Institutiton retrieved");
	  						rb.setObject(list);


	  			} catch (Exception ex) {
	  				rb.setCode(Msg.ERROR_CODE);
	  				rb.setDescription("error occured while retrieving request");
	  			}

	  			return new ResponseEntity<Object>(rb, HttpStatus.OK);
	  		}
	        
	        @CrossOrigin
	  		@RequestMapping(method=RequestMethod.GET, value="/find/{id}")
	  		public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id){
	  			ResponseBean rb= new ResponseBean();
	  			try {
	  				Optional<Institution> mtt= inservice.findById(id);
	  				Institution mt = mtt.get();
	  				if(mtt == null) {
	  					rb.setCode(Msg.NULLS_FOUND);
	  					rb.setDescription("not find it");
	  					
	  				}else {
	  					rb.setCode(Msg.SUCCESS_CODE);
	  					rb.setDescription("Data find successfully");
	  					rb.setObject(mtt);		
	  				}
	  			}catch(Exception ex) {
	  				rb.setCode(Msg.ERROR_CODE);
	  				rb.setDescription("failed to delete Meeting");
	  				
	  			}
	  			return new ResponseEntity<Object>(rb,HttpStatus.OK);
	  		}
	        
	        public static class innerinstitution{
	        	
	        	
	        	private String id;
	        	private String Name;
	        	/*private String email;
	        	private String phonenumber;*/
	        	
	        	
				public String getName() {
					return Name;
				}
				public void setName(String name) {
					Name = name;
				}
				
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				
				
				
			/*	public String getEmail() {
					return email;
				}
				public void setEmail(String email) {
					this.email = email;
				}
				public String getPhonenumber() {
					return phonenumber;
				}
				public void setPhonenumber(String phonenumber) {
					this.phonenumber = phonenumber;
				}
	        	*/
	        	
	        }
}

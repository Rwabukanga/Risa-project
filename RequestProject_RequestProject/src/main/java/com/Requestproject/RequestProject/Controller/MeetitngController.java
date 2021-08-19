package com.Requestproject.RequestProject.Controller;

import java.util.Date;
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

import com.Requestproject.RequestProject.Domain.Meeting;
import com.Requestproject.RequestProject.Domain.Registrant;
import com.Requestproject.RequestProject.Service.MeetingService;
import com.Requestproject.RequestProject.Service.RegistrantService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;
import com.fasterxml.jackson.annotation.JsonFormat;

@Controller
@RequestMapping(value="/meeting")
public class MeetitngController {

	@Autowired
	private MeetingService mtservice;
	
	@Autowired
	private RegistrantService regservice;
	
	  @CrossOrigin
      @RequestMapping(value="/save/{id}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)	
	  public ResponseEntity<Object> createrequest(HttpServletRequest request,@RequestBody innerMeeting mm, @PathVariable int id) {
			ResponseBean rb = new ResponseBean();
			
			try {
	        
	          
			  Optional<Registrant> rg=regservice.findByid(id);
			  Registrant rgg = rg.get();
			  Meeting m = new Meeting();
			  m.setName(mm.getName());
			  m.setMeetingdate(mm.getMeetingdate());
			  m.setDescription(mm.getDescription());
			  m.setReg(rgg);
			  mtservice.createMeeting(m);
	          rb.setCode(Msg.SUCCESS_CODE);
	          rb.setDescription(Msg.save);
	          rb.setObject(m);
				
	} catch (Exception e) {
		    
		    System.out.println(e.getMessage()+"=============================");
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to create Meeting");
				rb.setObject(mm);
			}

			return new ResponseEntity<Object>(rb, HttpStatus.OK);
		}
	  
	  
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.PUT, value= "/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateRequest(HttpServletRequest request,@PathVariable int id,@RequestBody Meeting mt){
			
			ResponseBean rb = new ResponseBean();
			
			try {
				Optional<Meeting> rqq= mtservice.findById(id);
				Meeting rqt = rqq.get();
			
				rqt.setName(mt.getName());
				rqt.setDescription(mt.getDescription());
				rqt.setMeetingdate(mt.getMeetingdate());
			
				mtservice.updateMeeting(rqt);
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("updated successfully");
				rb.setObject(rqt);
				
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Failed to update Meeting");
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	    
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
		public ResponseEntity<Object> deleteRequest(HttpServletRequest request, @PathVariable int id){
			ResponseBean rb= new ResponseBean();
			try {
				Optional<Meeting> mtt= mtservice.findById(id);
				Meeting mt = mtt.get();
				if(mtt == null) {
					rb.setCode(Msg.NULLS_FOUND);
					rb.setDescription("not deleted");
					
				}else {
					mtservice.deleteMeeting(id);
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription("Data Deleted successfully");
					rb.setObject(mtt);		
				}
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete Meeting");
				
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	       @CrossOrigin
	  		@RequestMapping(method=RequestMethod.GET, value="/find/{id}")
	  		public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id){
	  			ResponseBean rb= new ResponseBean();
	  			try {
	  				Optional<Meeting> mtt= mtservice.findById(id);
	  				Meeting mt = mtt.get();
	  				if(mtt == null) {
	  					rb.setCode(Msg.NULLS_FOUND);
	  					rb.setDescription("not deleted");
	  					
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
	    
	        @CrossOrigin
	  		@RequestMapping(value= "/all", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	  		public ResponseEntity<Object> findall(){
	  			
	  			ResponseBean rb = new ResponseBean();
	  			try {			
	  						List<Meeting> list = mtservice.findAll(Meeting.class);
	  						rb.setCode(Msg.SUCCESS_CODE);
	  						rb.setDescription("Meeting retrieved");
	  						rb.setObject(list);


	  			} catch (Exception ex) {
	  				ex.printStackTrace();
	  				rb.setCode(Msg.ERROR_CODE);
	  				rb.setDescription("error occured while retrieving Meeting");
	  			}

	  			return new ResponseEntity<Object>(rb, HttpStatus.OK);
	  		}
	        
	        public static class innerMeeting{
	        	
	        	private String name;
	        	@JsonFormat(pattern="yyyy-MM-dd")
	        	private Date meetingdate;
	        	private String description;
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public Date getMeetingdate() {
					return meetingdate;
				}
				public void setMeetingdate(Date meetingdate) {
					this.meetingdate = meetingdate;
				}
				public String getDescription() {
					return description;
				}
				public void setDescription(String description) {
					this.description = description;
				}
	        	
	        	
	        	
	        	
	        }
}

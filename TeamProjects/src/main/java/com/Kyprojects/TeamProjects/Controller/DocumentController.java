package com.Kyprojects.TeamProjects.Controller;

import java.util.Date;
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

import com.Kyprojects.TeamProjects.Domain.Documents;
import com.Kyprojects.TeamProjects.Service.DocumentService;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping(value="/document")
public class DocumentController {

	@Autowired
	private DocumentService docservice;
	
	
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createcategory(HttpServletRequest request, @RequestBody innerdocument ct){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			Documents cc = new Documents();
			
			cc.setReqdate(ct.getReqdate());
			cc.setName(ct.getName());
			
			docservice.createdocument(cc);
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
	
	
	/*@CrossOrigin
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Categories> reg = cservice.findById(id);
			Categories ct = reg.get();
			
			if(ct == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Found Categories");
				rb.setObject(ct);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
	*/
	
	@CrossOrigin
	@RequestMapping(value= "/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> alldocument(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Documents> list = docservice.findAll(Documents.class);
			
			
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
	
	
public static class innerdocument{
		
	private String name;
	private Date reqdate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}

	
		
		
	}
}

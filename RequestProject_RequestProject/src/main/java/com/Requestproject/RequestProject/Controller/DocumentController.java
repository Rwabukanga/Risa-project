package com.Requestproject.RequestProject.Controller;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Requestproject.RequestProject.Domain.Documents;
import com.Requestproject.RequestProject.Domain.Request;
import com.Requestproject.RequestProject.Service.DocumentService;
import com.Requestproject.RequestProject.Service.RequestService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;



@Controller
@CrossOrigin
@RequestMapping(value="/document")
public class DocumentController {

	@Autowired
	private DocumentService docservice;
	
	@Autowired
	private RequestService reqservice;
	
	
	@CrossOrigin
	@RequestMapping(value="/save/{id}", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createcategory(HttpServletRequest request, @RequestBody innerdocument ct, @PathVariable int id  ){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			Optional<Request> rq = reqservice.findById(id);
			Request reque = rq.get();
			Documents cc = new Documents();
			
			cc.setReqdate(ct.getReqdate());
			cc.setName(ct.getName());
			cc.setReq(reque);
			
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
	
	  @CrossOrigin
	    @RequestMapping(value ="/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		 public ResponseEntity<InputStreamResource> quotationDetailsReportList( HttpServletRequest request) {
		        ResponseBean responseBean = new ResponseBean();
		        try {
		           
		                HttpHeaders headers = new HttpHeaders();
		                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		                headers.add("Pragma", "no-cache");
		                headers.add("Expires", "0");
		                headers.add("Content-Disposition", "inline; filename=QuotationDetails.pdf");
		                
		                List<Documents> list= docservice.findAll(Documents.class);
		                
		                
	               ByteArrayInputStream bis = new ByteArrayInputStream(docservice.documentDetailsPDF(list));
	               
	 System.out.print("Print====================================");

	               return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/pdf"))
	                		.body(new InputStreamResource(bis));
	               
	               
	              
	               
		        
		        } catch (Exception ex) {
		        	ex.printStackTrace();
		            responseBean.setCode(Msg.ERROR_CODE);
		            responseBean.setDescription(Msg.error);
		            responseBean.setObject(null);
		        }
		        return new ResponseEntity<InputStreamResource>(HttpStatus.OK);
		        
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

package com.Kyprojects.TeamProjects.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Kyprojects.TeamProjects.Domain.Institution;
import com.Kyprojects.TeamProjects.Domain.Registrant;
import com.Kyprojects.TeamProjects.Domain.Request;
import com.Kyprojects.TeamProjects.Domain.RequestStatus;
import com.Kyprojects.TeamProjects.Domain.Requestexpertis;
import com.Kyprojects.TeamProjects.Service.InstitutionService;
import com.Kyprojects.TeamProjects.Service.RegistrantService;
import com.Kyprojects.TeamProjects.Service.RequestExpertiseService;
import com.Kyprojects.TeamProjects.Service.RequestService;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping(value="/request")
public class RequestController {

	@Autowired
	private RequestService rservice;
	
	@Autowired
	private RegistrantService rgservice;
	
	@Autowired
	private InstitutionService instservice;
	
	@Autowired
	private RequestExpertiseService expservice;
	 
	  @CrossOrigin
      @RequestMapping(value="/saverequest/{id}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)	
	  public ResponseEntity<Object> createrequest(HttpServletRequest request,@RequestBody innerRequest rq,@PathVariable int id) {
			ResponseBean rb = new ResponseBean();
			
			try {
			  Optional<Registrant> rg= rgservice.findByid(id);
			  Registrant rgg = rg.get();
			  Request r = new Request();
			  
			/*  r.setRequestdate(rq.getRequestdate());*/
			 /* r.setRequestexp(RequestExpertise.Pending);*/
			  r.setRequeststatus(RequestStatus.New);
			  r.setComment(rq.getComment());
			  r.setDeliverables(rq.getDeliverables());
			  r.setProjectdecription(rq.getProjectdecription());
			  r.setProjtitle(rq.getProjectTitle());
			  r.setProposdeltimeline(rq.getProposedDeliveryTimeline());
			  r.setProposedfinancialbudget(rq.getProposedfinancialbudget());
			  r.setPropostechnologies(rq.getProposedTechnologies());
			/*  r.setRegistrant(rgg);*/
			  rservice.createrequest(r);
	          rb.setCode(Msg.SUCCESS_CODE);
	          rb.setDescription(Msg.save);
              rb.setObject(r);				
	} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println(e.getMessage()+"=============================");
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to create registrar");
				
			}

			return new ResponseEntity<Object>(rb, HttpStatus.OK);
		}
	  
	  
	  
	  @CrossOrigin
      @RequestMapping(value="/uploadfile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	  public ResponseEntity<Object> saverequest(HttpServletRequest request,@RequestParam Map<String, String> params,
			  HttpSession session, @RequestParam(name="file", required = false) MultipartFile file, @RequestParam(name= "needassessmentreport", required = false) MultipartFile needassessmentreport, @RequestParam(name= "financialproposal", required = false) MultipartFile financialproposal,@RequestParam(name= "technicalproposal", required = false) MultipartFile technicalproposal,@RequestParam(name= "purchaseorder", required = false) MultipartFile purchaseorder,@RequestParam(name= "invoice", required = false) MultipartFile invoice,@RequestParam(name= "termsofreference", required = false) MultipartFile termsofreference) {
			
		  ResponseBean rb = new ResponseBean();
			
			try {
				
			if(file != null) {
			long fileSizeInBytes = file.getSize();
			double fileSizeInKB = fileSizeInBytes / 1024;
			double fileSizeInMB = fileSizeInKB / 1024;
			
			if (fileSizeInMB <= 5) {
				
				Request req = new Request();
				/*Optional<Registrant> reg = rgservice.findByid(Integer.parseInt(params.get("id")));
				
				Registrant registrar = reg.get();*/
				
				Optional<Institution> ins = instservice.findById(Integer.parseInt(params.get("institution")));
				
				Institution institution = ins.get();
				Optional<Requestexpertis> expert = expservice.findById(Integer.parseInt(params.get("expertise")));
				
				Requestexpertis exp = expert.get();
				
				req.setProjtitle(params.get("projecttitle"));
				req.setProjectdecription(params.get("projectdescription"));
				req.setProposdeltimeline(params.get("proposeddeliverytimeline"));
				req.setProposedfinancialbudget(params.get("proposedfinancialbudget"));
				req.setPropostechnologies(params.get("proposedtechnologies"));
				req.setDeliverables(params.get("deliverables"));
				req.setComment(params.get("comment"));
				/*req.setRequestexp(RequestExpertise.Pending);*/
				req.setRequeststatus(RequestStatus.New);
				req.setRequestdate(params.get("requestdate"));
				/*req.setRegistrant(registrar);*/
				/*req.setNeedassessmentreport(params.get("needassessmentreport"));
				req.setFinancialproposal(params.get("financialproposal"));*/
				req.setInstitution(institution);
				req.setReqexp(exp);
				rservice.createrequest(req);
				
				File fil = new File("RequestFile");
				
				String fileName = req.getId() +"-"+ file.getOriginalFilename();
				String filerpath = "Request";
				File ff = new File(fil.getPath() + "/" + filerpath);
				if(!fil.exists()) {
					fil.mkdir();
					if(!ff.exists()) {
						ff.mkdirs();
					}
				}else {
					
					if(!ff.exists()) {
						ff.mkdirs();
						}
				}
				byte[] bytes= file.getBytes();
				Path path = Paths.get(ff.getPath() + "/" + fileName);
				Files.write(path, bytes);
				req.setFile(path.toString());
				req.setNeedassessmentreport(path.toString());
				req.setFinancialproposal(path.toString());
				req.setTechnicalproposal(path.toString());
				req.setPurchaseorder(path.toString());
				req.setInvoice(path.toString());
				req.setTermsofreference(path.toString());
				
				rservice.updaterequest(req);
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("RequestRegisted");
				rb.setObject(req);
			}else {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Not Registedone");
				rb.setObject(null);
			}
			
			 }else {
				 
				    rb.setCode(Msg.ERROR_CODE);
					rb.setDescription("Not Registedtwo");
					rb.setObject(null);
			 }
	} catch (Exception e) {
		    e.printStackTrace();
		    /*System.out.println(e.getMessage()+"=============================");*/
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to create registrar");
				
	}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
		}
	  
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.PUT, value= "/update/{uuid}", consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateRequest(HttpServletRequest request,@PathVariable String uuid,@RequestBody Request rq){
			
			ResponseBean rb = new ResponseBean();
			
			try {
				Optional<Request> rqq= rservice.findByUuid(uuid);
				Request rqt = rqq.get();
				/*branch.setDistrict(brn.getDistrict());
				branch.setProvince(brn.getProvince());*/
				rqt.setComment(rq.getComment());
				rqt.setDeliverables(rq.getDeliverables());
				rqt.setProjectdecription(rq.getProjectdecription());
				/*rqt.setProjectTitle(rq.getProjectTitle());
				rqt.setProposedDeliveryTimeline(rq.getProposedDeliveryTimeline());
				rqt.setProposedfinancialbudget(rq.getProposedfinancialbudget());
				rqt.setProposedTechnologies(rq.getProposedTechnologies());*/
				rservice.updaterequest(rqt);
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("updated successfully");
				rb.setObject(rqt);
				
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Failed to update branchuser");
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
		public ResponseEntity<Object> deleteRequest(HttpServletRequest request, @PathVariable int id){
			ResponseBean rb= new ResponseBean();
			try {
				Optional<Request> rt= rservice.findById(id);
				Request rq = rt.get();
				if(rq == null) {
					rb.setCode(Msg.NULLS_FOUND);
					rb.setDescription("not deleted");
					
				}else {
					rservice.deleterequest(id);
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription(Msg.delete);
					rb.setObject(rq);		
				}
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete branch");
				
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
		
	    @CrossOrigin
		@RequestMapping(value= "/all", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> findall(){
			
			ResponseBean rb = new ResponseBean();
			try {			
						List<Request> list = rservice.findAll();
						rb.setCode(Msg.SUCCESS_CODE);
						rb.setDescription("branchuser retrieved");
						rb.setObject(list);


			} catch (Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("error occured while retrieving request");
			}

			return new ResponseEntity<Object>(rb, HttpStatus.OK);
		}
	    
	        @CrossOrigin
	 		@RequestMapping(value= "/find/{id}", method =RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	 		public ResponseEntity<Object> findinstitution(HttpServletRequest request, @PathVariable int id){
	 			
	 			ResponseBean rb = new ResponseBean();
	 			try {
					Optional<Request> rt= rservice.findById(id);
					Request rq = rt.get();
					if(rq == null) {
						rb.setCode(Msg.NULLS_FOUND);
						rb.setDescription("not deleted");
						
					}else {
					
						rb.setCode(Msg.SUCCESS_CODE);
						rb.setDescription("Data Found it");
						rb.setObject(rq);		
					}
				}catch(Exception ex) {
					rb.setCode(Msg.ERROR_CODE);
					rb.setDescription("failed to delete branch");
					
				}

	 			return new ResponseEntity<Object>(rb, HttpStatus.OK);
	 		}
	    
	    @CrossOrigin
	    @RequestMapping(value="/approve/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> approveRequest(HttpServletRequest request,@PathVariable int id){
	    	
	    	ResponseBean rb = new ResponseBean();
	    	try {
	    		Optional<Request> bb = rservice.findById(id);
	    		Request rr = bb.get();
	    		
	    		rr.setRequeststatus(RequestStatus.Approved);
	    		/*rr.setRequestexp(RequestExpertise.Development);*/
	    		rservice.updaterequest(rr);
	    		
	    		rb.setCode(Msg.SUCCESS_CODE);
	    		rb.setDescription("Request Updated");
	    		rb.setObject(rr);
	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		rb.setCode(Msg.ERROR_CODE);
	    		rb.setDescription("fail to update");
	    	}
	    	return new ResponseEntity<Object>(rb,HttpStatus.OK);
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value="/reject/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> rejectRequest(HttpServletRequest request,@PathVariable int id){
	    	
	    	ResponseBean rb = new ResponseBean();
	    	try {
	    		Optional<Request> bb = rservice.findById(id);
	    		Request rr = bb.get();
	    		
	    		rr.setRequeststatus(RequestStatus.Rejected);
	    	/*	rr.setRequestexp(RequestExpertise.Cancelled);*/
	    		rservice.updaterequest(rr);
	    		
	    		rb.setCode(Msg.SUCCESS_CODE);
	    		rb.setDescription("Request Updated");
	    		rb.setObject(rr);
	    		
	    	}catch(Exception e) {
	    		
	    		rb.setCode(Msg.ERROR_CODE);
	    		rb.setDescription("fail to update");
	    	}
	    	return new ResponseEntity<Object>(rb,HttpStatus.OK);
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value ="/{id}/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		 public ResponseEntity<InputStreamResource> quotationDetailsReport(@PathVariable int id , HttpServletRequest request) {
		        ResponseBean responseBean = new ResponseBean();
		        try {
		           
		                HttpHeaders headers = new HttpHeaders();
		                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		                headers.add("Pragma", "no-cache");
		                headers.add("Expires", "0");
		                headers.add("Content-Disposition", "inline; filename=QuotationDetails.pdf");
		                
		                Optional<Request> gt=rservice.findById(id);
		                Request rq = gt.get();
		                
	               ByteArrayInputStream bis = new ByteArrayInputStream(rservice.RequestDetailsPDF(rq));
	               
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
		                
		                List<Request> list= rservice.findAll();
		                
		                
	               ByteArrayInputStream bis = new ByteArrayInputStream(rservice.requestDetailsPDF(list));
	               
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
		    
		
	    public static class innerRequest{
	    	
	    	/*@JsonFormat(pattern="yyyy-MM-dd")
	    	private Date requestdate;*/
	    	private String ProjectTitle;
	    	private String Projectdecription;
	    	private String ProposedTechnologies;
	    	private String ProposedDeliveryTimeline;
	    	private String Proposedfinancialbudget;
	    	private String Deliverables;
	    	private String Comment;
	    	private String needassessmentreport;
	    	private String financialproposal;
	    	
	    	/*@Enumerated(EnumType.STRING)
	    	private RequestExpertise requestexp;
	    	*/
	    	@Enumerated(EnumType.STRING)
	    	private RequestStatus requeststatus;
	    	

			public String getProjectTitle() {
				return ProjectTitle;
			}

			public void setProjectTitle(String projectTitle) {
				ProjectTitle = projectTitle;
			}

			public String getProjectdecription() {
				return Projectdecription;
			}

			public void setProjectdecription(String projectdecription) {
				Projectdecription = projectdecription;
			}

			public String getProposedTechnologies() {
				return ProposedTechnologies;
			}

			public void setProposedTechnologies(String proposedTechnologies) {
				ProposedTechnologies = proposedTechnologies;
			}

			public String getProposedDeliveryTimeline() {
				return ProposedDeliveryTimeline;
			}

			public void setProposedDeliveryTimeline(String proposedDeliveryTimeline) {
				ProposedDeliveryTimeline = proposedDeliveryTimeline;
			}

			public String getProposedfinancialbudget() {
				return Proposedfinancialbudget;
			}

			public void setProposedfinancialbudget(String proposedfinancialbudget) {
				Proposedfinancialbudget = proposedfinancialbudget;
			}

			public String getDeliverables() {
				return Deliverables;
			}

			public void setDeliverables(String deliverables) {
				Deliverables = deliverables;
			}

			public String getComment() {
				return Comment;
			}

			public void setComment(String comment) {
				Comment = comment;
			}

			

			public RequestStatus getRequeststatus() {
				return requeststatus;
			}

			public void setRequeststatus(RequestStatus requeststatus) {
				this.requeststatus = requeststatus;
			}

			public String getNeedassessmentreport() {
				return needassessmentreport;
			}

			public void setNeedassessmentreport(String needassessmentreport) {
				this.needassessmentreport = needassessmentreport;
			}

			public String getFinancialproposal() {
				return financialproposal;
			}

			public void setFinancialproposal(String financialproposal) {
				this.financialproposal = financialproposal;
			}
	    	
	    	
	    }
}

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

import com.Requestproject.RequestProject.Domain.Categories;
import com.Requestproject.RequestProject.Service.CategoryService;
import com.Requestproject.RequestProject.Service.RegistrantService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;


@Controller
@RequestMapping(value="/category")
public class CategoryController {

	@Autowired
	private CategoryService cservice;
	
	@Autowired
	private RegistrantService regservice;
	
	@CrossOrigin
	@RequestMapping(value="/save", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createcategory(HttpServletRequest request, @RequestBody innercategory ct){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			Categories cc = new Categories();
			cc.setName(ct.getName());

			cservice.createcategory(cc);
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
	
	
	/*@CrossOrigin
	@RequestMapping(value="/found/{name}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByName(HttpServletRequest request, @PathVariable String name){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Categories> ctt= cservice.findByName(name);
			Categories ctr = ctt.get();
			
			if(ctr == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Found Categories");
				rb.setObject(ctr);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}*/
	
	@CrossOrigin
	@RequestMapping(value= "/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allcategory(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Categories> list = cservice.findAll(Categories.class);
			
			
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
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updatecategory(HttpServletRequest request, @PathVariable int id, @RequestBody innercategory rgr){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Categories> rg= cservice.findById(id);
			
			Categories cc = rg.get();
			
			cc.setName(rgr.getName());
			
			cservice.createcategory(cc);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Success Updated");
			rb.setObject(cc);
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to Update");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletecategory(HttpServletRequest request, @PathVariable int id){
		ResponseBean rb = new ResponseBean();
		
		try {
			Optional<Categories> reg = cservice.findById(id);
			Categories regg = reg.get();
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete");
			}else {
				cservice.delete(regg);
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Successfully deleted");
				rb.setObject(regg);
			}
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to delete");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	
	
	
	public static class innercategory{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}

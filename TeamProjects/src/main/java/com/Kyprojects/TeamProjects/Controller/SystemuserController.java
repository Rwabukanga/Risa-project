package com.Kyprojects.TeamProjects.Controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Kyprojects.TeamProjects.Domain.Systemuser;
import com.Kyprojects.TeamProjects.Service.SystemuserService;
import com.Kyprojects.TeamProjects.Utility.Encryption;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;




@RestController
@CrossOrigin
@RequestMapping("/ussss")
public class SystemuserController {

	
	@Autowired
	private SystemuserService sysservice;
	
	@CrossOrigin
	@RequestMapping(value="/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(HttpRequest request, @RequestBody Systemuser user){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			sysservice.create(user);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription(Msg.save);
			rb.setObject(user);
		}catch(Exception ex) {
			
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Fail to save");
			
			ex.printStackTrace();
		}
		
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> login(@RequestBody Userr user){
		
		ResponseBean rb = new ResponseBean();
		try {
			
			if(user != null) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				if((sysservice.findByUsernameAndPassword(user.getUsername(), Encryption.md5(user.getPassword())) != null)) {
					
					Systemuser systemuser = sysservice.findByUsernameAndPassword(user.getUsername(), Encryption.md5(user.getPassword()));
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription(Msg.save);
					map.put("user", systemuser);
					rb.setObject(map);
					
				}else {
					rb.setCode(Msg.ERROR_CODE);
					rb.setDescription("Failed to match username and password");
					rb.setObject(null);
				}
			}else {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Failed to match it");
				rb.setObject(null);
			}
			
		}catch(Exception ex) {
			rb.setDescription("failed to pass it");
			rb.setObject(null);
			
			ex.printStackTrace();
		}
		return new ResponseEntity<Object> (rb, HttpStatus.OK);
	}
	
	public static class Userr {
		
		private String username;
		private String password;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
	}
}

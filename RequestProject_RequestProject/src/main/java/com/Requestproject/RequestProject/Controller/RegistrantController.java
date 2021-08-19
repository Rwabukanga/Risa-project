package com.Requestproject.RequestProject.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Requestproject.RequestProject.Domain.Categories;
import com.Requestproject.RequestProject.Domain.District;
import com.Requestproject.RequestProject.Domain.Gender;
import com.Requestproject.RequestProject.Domain.Registrant;
import com.Requestproject.RequestProject.Domain.Systemuser;
import com.Requestproject.RequestProject.Service.CategoryService;
import com.Requestproject.RequestProject.Service.DistrictService;
import com.Requestproject.RequestProject.Service.RegistrantService;
import com.Requestproject.RequestProject.Service.SystemuserService;
import com.Requestproject.RequestProject.Utility.Msg;
import com.Requestproject.RequestProject.Utility.ResponseBean;
import com.fasterxml.jackson.annotation.JsonFormat;


@RestController
@CrossOrigin
@RequestMapping("/registr")
public class RegistrantController {

	@Autowired
	private RegistrantService regservice;
	
	@Autowired
	private SystemuserService sysservice;
	
	@Autowired
	private DistrictService distservice;
	
	@Autowired
	private CategoryService ctservice;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@CrossOrigin
	@RequestMapping(value="/saveuser", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createuser(HttpServletRequest request, @RequestBody innerRegistrar reg){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			/* String doneBy = request.getHeader("doneBy");*/
	            /*Optional<Province> pr = provinceservice.findById(id);
	            Province province = pr.get();
	            Optional<District>dis = districtservice.findById(pid);
	            District district = dis.get();
	            reg.setProvince(province);
	            reg.setDistrict(district);*/
			
			   Registrant regg = new Registrant();
			   Optional<District> distr = distservice.findById(reg.getDistrict());
			   District district = distr.get();
			   Optional<Categories> ct = ctservice.findById(reg.getCategory());
			   Categories category = ct.get();
			   regg.setFirstname(reg.getFirstname());
			   regg.setLastname(reg.getLastname());
			   regg.setEmail(reg.getEmail());
			   regg.setDateofbirth(reg.getDateofbirth());
			   regg.setGender(reg.getGender());
			 /*  regg.setCategory(reg.getCategory());*/
			   regg.setIdnumber(reg.getIdnumber());
			   regg.setPhonenumber(reg.getPhonenumber());
			   regg.setUsername(reg.getUsername());
			   regg.setPassword(reg.getPassword());
			  /* regg.setRequestexp(reg.getRequestexp());*/
			   regg.setDistrict(district);
			   regg.setCategory(category);
			   
			   /*regg.setCategor(tt);*/
			   
	           regservice.createregistrar(regg);
	           rb.setCode(Msg.SUCCESS_CODE);
			   rb.setDescription(Msg.save);
			   rb.setObject(regg);
				
	           Systemuser user = new Systemuser();
	          
	           user.setFirstname(regg.getFirstname());
	           user.setLastname(regg.getLastname());
	           user.setEmailAddress(regg.getEmail());
	           user.setGender(regg.getGender());
	           user.setNationalId(regg.getIdnumber());
	           user.setPhonenumber(regg.getPhonenumber());
	           user.setUsername(regg.getUsername());
	           user.setPassword(regg.getPassword());
	           /*user.setRole("Admin");*/
	           user.setCategory(regg.getCategory());
	           user.setDob(regg.getDateofbirth());
	            /*user.setUsername(reg.get);
	            user.setPassword(regAdmin.getPassword());*/
	            //user.setObjectId(reg.getId() + "");
	            user.setReg(regg);
	            
	            
	            
	            sysservice.create(user);
	            
	            /*SimpleMailMessage message = new SimpleMailMessage();

	            message.setFrom("sethfils2016@gmail.com");
	            message.setTo(message.getFrom());
	            message.setSubject("This is a plain text email");
	            message.setText("Hello guys! This is a plain text email.");

	            javaMailSender.send(message);*/
	            /*final String uri = Messages.myum_url + "/registrar/save";
				RestTemplate restt = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.set("doneBy", doneBy);
				HttpEntity<SystemUser> en = new HttpEntity<SystemUser>(user, headers);
				ResponseBean res= restt.postForObject(uri,en, ResponseBean.class);
	            */
	         
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription(Msg.save);
				rb.setObject(user);
			    
				SimpleMailMessage message = new SimpleMailMessage();

	            message.setFrom("sethfils2016@gmail.com");
	           
	           /* message.setTo(to);
	            message.setTo("sethfils4@gmail.com");
	            message.setSubject("This is a your email");
	            message.setText("Hello guys! This is your email.");

	            mailSender.send(message);*/
	            regservice.sendSimpleMessage(regg.getEmail(), "This is your Username:"+" "+regg.getUsername(), "Hello this is your Username  :"+" "+regg.getUsername() +"   "+"this is Password:"+" "+regg.getPassword());
			    
				
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("fail to save");
			
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value= "/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> alluser(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Registrant> list = regservice.findAll(Registrant.class);
			
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("get all");
			rb.setObject(list);
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/data")
	public ResponseEntity<Object> data(){
		
		ResponseBean rb = new ResponseBean();
		try {
			System.out.println("Hello World");
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateuser(HttpServletRequest request, @PathVariable int id, @RequestBody innerRegistrar rgr){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Registrant> rg= regservice.findByid(id);
			Registrant reg = rg.get();
			Optional<District> dt = distservice.findById(rgr.getDistrict());
			District dis = dt.get();
		
			Optional<Categories> ct = ctservice.findById(rgr.getCategory());
			Categories category = ct.get();
			reg.setFirstname(rgr.getFirstname());
			reg.setLastname(rgr.getLastname());
			reg.setEmail(rgr.getEmail());
			reg.setIdnumber(rgr.getIdnumber());
			reg.setPhonenumber(rgr.getPhonenumber());
			reg.setUsername(rgr.getUsername());
			reg.setPassword(rgr.getPassword());
			reg.setDateofbirth(rgr.getDateofbirth());
			reg.setGender(rgr.getGender());
			
			reg.setDistrict(dis);
			reg.setCategory(category);
			regservice.updateRegistrar(reg);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Success Updated");
			rb.setObject(reg);
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to Update");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Registrant> reg = regservice.findByid(id);
			Registrant regg = reg.get();
			
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription(Msg.save);
				rb.setObject(regg);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{email}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findEmail(HttpServletRequest request,@PathVariable String email){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			Optional<Registrant> reg = regservice.findByEmail(email);
			Registrant regg= reg.get();
			
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("get all");
				rb.setObject(regg);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value ="/changepassword", method = RequestMethod.POST)
	public ResponseEntity<Object>resetpassword(HttpServletRequest request, @RequestBody Registrant user){
		
		ResponseBean rs = new ResponseBean();
		
		
			Optional<Registrant> existus = regservice.findByEmail(user.getEmail());
			Registrant  existingUser = existus.get();
	        if (existingUser != null) {
	        
	            
	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	            mailMessage.setTo(existingUser.getEmail());
	            mailMessage.setSubject("Complete Password Reset!");
	            mailMessage.setFrom("sethfils2016@gmail.com");
	            mailMessage.setText("To complete the password reset process is: "
	              + " "+existingUser.getPassword());
	            
	            javaMailSender.send(mailMessage);
	            rs.setCode(Msg.SUCCESS_CODE);
				rs.setDescription("Password sent to your email");
				rs.setObject(existingUser);
	            	
				}else {
					rs.setCode(Msg.ERROR_CODE);
					rs.setDescription("Password not  successfully changed1");
					rs.setObject(null);
				}
		System.out.println("===========================================");
		return new ResponseEntity<Object>(rs, HttpStatus.OK);
	}
	
/*	@CrossOrigin
	@RequestMapping(value ="/changepasswordd", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>resetpassword(@RequestBody Userlogin user){
		
		ResponseBean rs = new ResponseBean();
		
		if(user !=null) {
			Map<String, Object> map = new HashMap();
			
			if(user.getPassword().equalsIgnoreCase(user.getConfirmPassword())) {
				Systemuser sys = sysservice.findByUsername(user.getUsername());
				
				sys.setPassword(Encryption.md5(user.getPassword()));
				if(sysservice.update(sys).equalsIgnoreCase(Msg.update)) {
					rs.setCode(Msg.SUCCESS_CODE);
					rs.setDescription("Password successfully changed");
					map.put("user", map);
					rs.setObject(map);
					
				}else {
					rs.setCode(Msg.ERROR_CODE);
					rs.setDescription("Password not  successfully changed1");
					rs.setObject(null);
				}
				
			}else {
				rs.setCode(Msg.ERROR_CODE);
				rs.setDescription("Password not successfully changed2");
				rs.setObject(null);
			}
		}else {
			rs.setCode(Msg.ERROR_CODE);
			rs.setDescription("Password not successfully changed3");
			rs.setObject(null);
		}
		
		return new ResponseEntity<Object>(rs, HttpStatus.OK);
	}
	*/
	
	@CrossOrigin
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteuser(HttpServletRequest request, @PathVariable int id){
		ResponseBean rb = new ResponseBean();
		
		try {
			Optional<Registrant> reg = regservice.findByid(id);
			Registrant regg = reg.get();
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete");
			}else {
				regservice.deleteRegistrar(id);
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
	
	@CrossOrigin
	@RequestMapping(value="/category/{categ}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findBycategory(HttpServletRequest request,@RequestBody Categories  category, @PathVariable String categ){
		ResponseBean rb = new ResponseBean();
		
		
		
		try {
			/*Categories ct = new Categories();*/
			
			
			if(categ.equalsIgnoreCase("Admin")) {
				
			List<Registrant> l = regservice.findByCategory(category.getName().valueOf("Admin"));
			
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well retrieved");
			rb.setObject(l);
			
			}/*else if(category.equalsIgnoreCase("Risafocalpoint")) {
				
				List<Registrant> l = regservice.findByCategory(Category.valueOf("Risafocalpoint"));
				List<Registrant> l = regservice.findByCategory(ct.getName());
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}*//*else if(category.equalsIgnoreCase("RisacontractManager")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("RisacontractManager"));
				List<Registrant> l = regservice.findByCategory(ct.getName());
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}*//*else if(category.equalsIgnoreCase("ExternalinstitutionUser")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("ExternalinstitutionUser"));
				List<Registrant> l = regservice.findByCategory(ct.getName());
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}*//*else if(category.equalsIgnoreCase("Legal")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("Legal"));
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}*/else {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to retrieve");
				
			}
				
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve");
			
			ex.printStackTrace();
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	
	
	/*@CrossOrigin
	@RequestMapping(value="/category/{category}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findBycategory(HttpServletRequest request,@PathVariable String category){
		ResponseBean rb = new ResponseBean();
		
		Registrant reg = new Registrant();
		
		try {
			if(category.equalsIgnoreCase("Admin")) {
				
			List<Registrant> l = regservice.findByCategory(reg.);
			
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Well retrieved");
			rb.setObject(l);
			
			}else if(category.equalsIgnoreCase("Risafocalpoint")) {
				
				List<Registrant> l = regservice.findByCategory(Category.valueOf("Risafocalpoint"));
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}else if(category.equalsIgnoreCase("RisacontractManager")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("RisacontractManager"));
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}else if(category.equalsIgnoreCase("ExternalinstitutionUser")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("ExternalinstitutionUser"));
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}else if(category.equalsIgnoreCase("Legal")) {
				List<Registrant> l = regservice.findByCategory(Category.valueOf("Legal"));
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Well retrieved");
				rb.setObject(l);
			}else {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to retrieve");
				
			}
				
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve");
			
			ex.printStackTrace();
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	*/

	
	
public static class innerRegistrar{
	
	private String firstname;
	private String lastname;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateofbirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	/*@Enumerated(EnumType.STRING)
	private Category category;*/
	private String idnumber;
	private String phonenumber;
	private String email;
	private String username;
	private String password;
	private int district;
	private int category;
	
	/*@Enumerated(EnumType.STRING)
	private RequestExpertise requestexp;*/
	/*private int categor;*/
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	
	
}
}

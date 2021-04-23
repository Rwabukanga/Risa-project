package com.Kyprojects.TeamProjects.Controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Kyprojects.TeamProjects.Domain.Categories;
import com.Kyprojects.TeamProjects.Domain.District;
import com.Kyprojects.TeamProjects.Domain.Gender;
import com.Kyprojects.TeamProjects.Domain.Memberr;
import com.Kyprojects.TeamProjects.Service.CategoryService;
import com.Kyprojects.TeamProjects.Service.DistrictService;
import com.Kyprojects.TeamProjects.Service.MemberService;
import com.Kyprojects.TeamProjects.Utility.Msg;
import com.Kyprojects.TeamProjects.Utility.ResponseBean;
import com.fasterxml.jackson.annotation.JsonFormat;


@Controller
@CrossOrigin
@RequestMapping(value="/mmb")
public class MemberController {

	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private DistrictService districtservice;
	
	@Autowired
	private CategoryService ctservice;
	
	@CrossOrigin
	@RequestMapping(value="/savee", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createmember(HttpServletRequest request , @RequestBody innerMember memberr){
		
		ResponseBean rb = new ResponseBean();
		
		
		try {
			Memberr member = new Memberr();
			
			Optional<District> dis = districtservice.findById(memberr.getDistrict());
			District distr = dis.get();
			Optional<Categories> ct = ctservice.findById(memberr.getCategory());
			Categories cc = ct.get();
			member.setFirstname(memberr.getFirstname());
			member.setLastname(memberr.getLastname());
			member.setEmail(memberr.getEmail());
			member.setDob(memberr.getDob());
			member.setIdnumber(memberr.getIdnumber());
			member.setPhonenumber(memberr.getPhonenumber());
			member.setGender(memberr.getGender());
			member.setDistrict(distr);
			/*member.setCategory(cc);*/
			
			memberservice.createMember(member);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Member Added");
			rb.setObject(member);
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed Added");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/all" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> Findall(){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			List<Memberr> list =memberservice.findAll(Memberr.class);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Data retrieved");
			rb.setObject(list);
			
			
		}catch(Exception ex) {
			
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	public static class  innerMember{
		
		private String firstname;
		private String lastname;
		private String email;
		private String phonenumber;
		private String idnumber;
		
		@Enumerated(EnumType.STRING)
		private Gender gender;
		
		@JsonFormat(pattern="yyy-MM-dd")
		private Date dob;
		
		private int district;
		
		private int category;
		
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
		public int getDistrict() {
			return district;
		}
		public void setDistrict(int district) {
			this.district = district;
		}
		public String getEmail() {
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
		public String getIdnumber() {
			return idnumber;
		}
		public void setIdnumber(String idnumber) {
			this.idnumber = idnumber;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public int getCategory() {
			return category;
		}
		public void setCategory(int category) {
			this.category = category;
		}
		
		
		
	}
}

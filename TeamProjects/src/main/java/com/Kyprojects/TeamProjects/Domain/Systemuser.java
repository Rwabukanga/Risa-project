package com.Kyprojects.TeamProjects.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Systemuser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;	
	private String uuid= UUID.randomUUID().toString();
	private String firstname;
    private String lastname; 
	private String emailAddress;
	private String phonenumber;
    private String nationalId;
    
    /*@Enumerated(EnumType.STRING)
	private Category category;*/
    
    @Enumerated(EnumType.STRING )
	private Gender gender;
	private String username;
	private String password;
	
	@ManyToOne
	private Categories category;
	
	/*private String role;*/
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;

   @ManyToOne
   private Registrant reg;
   
   
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



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



	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getNationalId() {
		return nationalId;
	}



	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
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


/*
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
*/


	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	/*public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

*/

	public Registrant getReg() {
		return reg;
	}



	public void setReg(Registrant reg) {
		this.reg = reg;
	}



	public Categories getCategory() {
		return category;
	}



	public void setCategory(Categories category) {
		this.category = category;
	}
	
	
	
}

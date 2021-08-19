package com.Requestproject.RequestProject.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educationqualification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String educationlevel;
	private String institutionname;
	private String yearofcompletion;
	private String county;
    private String town;
	
	public String getEducationlevel() {
		return educationlevel;
	}

	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}

	public String getInstitutionname() {
		return institutionname;
	}

	public void setInstitutionname(String institutionname) {
		this.institutionname = institutionname;
	}

	public String getYearofcompletion() {
		return yearofcompletion;
	}

	public void setYearofcompletion(String yearofcompletion) {
		this.yearofcompletion = yearofcompletion;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	
}

package com.Kyprojects.TeamProjects.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Contract {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String uuid = UUID.randomUUID().toString();
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startdate;
	
	@Enumerated(EnumType.STRING)
	private ContractStatus contractstatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public ContractStatus getContractstatus() {
		return contractstatus;
	}

	public void setContractstatus(ContractStatus contractstatus) {
		this.contractstatus = contractstatus;
	}
	
	
	
	
}

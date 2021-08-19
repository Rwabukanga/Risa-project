package com.Requestproject.RequestProject.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Documents {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String uuid= UUID.randomUUID().toString();
	
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date reqdate;
	
	@ManyToOne
	private Request req;
	
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
	public Request getReq() {
		return req;
	}
	public void setReq(Request req) {
		this.req = req;
	}
	
	
	
	
}

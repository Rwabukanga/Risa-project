package com.Kyprojects.TeamProjects.Domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Meeting {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String uuid = UUID.randomUUID().toString();
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date meetingdate;
	private String description;
	
	@ManyToOne
	private Registrant reg;
	
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
	public Date getMeetingdate() {
		return meetingdate;
	}
	public void setMeetingdate(Date meetingdate) {
		this.meetingdate = meetingdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Registrant getReg() {
		return reg;
	}
	public void setReg(Registrant reg) {
		this.reg = reg;
	}
	
	
	
	
}

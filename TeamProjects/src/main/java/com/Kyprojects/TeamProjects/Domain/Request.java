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
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String uuid = UUID.randomUUID().toString();
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date requestdate;
	private String Projtitle;
	private String Projectdecription;
	private String Propostechnologies;
	private String Proposdeltimeline;
	private String Proposedfinancialbudget;
	/*private String Deliverables;*/
	private String Comment;
	/*private String file;
	private String needassessmentreport;
	private String financialproposal;
	private String technicalproposal;
	private String purchaseorder;
	private String invoice;
	private String termsofreference;*/
	
	
	
	
	/*@Enumerated(EnumType.STRING)
	private RequestExpertise requestexp;*/
	
	/*@Enumerated(EnumType.STRING)
	private RequestStatus requeststatus;*/
	
	@ManyToOne
	private Institution institution;
	
	@ManyToOne
	private Requestexpertis reqexp;
	
	@ManyToOne
	private Requeststatuss reqst;
	
	@ManyToOne
	private Deliverables del;
   	
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

	/*public RequestStatus getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(RequestStatus requeststatus) {
		this.requeststatus = requeststatus;
	}
*/
	
	public String getProjectdecription() {
		return Projectdecription;
	}

	public void setProjectdecription(String projectdecription) {
		Projectdecription = projectdecription;
	}
	public String getProposedfinancialbudget() {
		return Proposedfinancialbudget;
	}

	public void setProposedfinancialbudget(String proposedfinancialbudget) {
		Proposedfinancialbudget = proposedfinancialbudget;
	}

	/*public String getDeliverables() {
		return Deliverables;
	}
*/
/*	public void setDeliverables(String deliverables) {
		Deliverables = deliverables;
	}*/



	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
/*
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	

	public String getFinancialproposal() {
		return financialproposal;
	}

	public void setFinancialproposal(String financialproposal) {
		this.financialproposal = financialproposal;
	}

	public String getNeedassessmentreport() {
		return needassessmentreport;
	}

	public void setNeedassessmentreport(String needassessmentreport) {
		this.needassessmentreport = needassessmentreport;
	}

	public String getTechnicalproposal() {
		return technicalproposal;
	}

	public void setTechnicalproposal(String technicalproposal) {
		this.technicalproposal = technicalproposal;
	}

	public String getPurchaseorder() {
		return purchaseorder;
	}

	public void setPurchaseorder(String purchaseorder) {
		this.purchaseorder = purchaseorder;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getTermsofreference() {
		return termsofreference;
	}

	public void setTermsofreference(String termsofreference) {
		this.termsofreference = termsofreference;
	}
*/
	public String getProjtitle() {
		return Projtitle;
	}

	public void setProjtitle(String projtitle) {
		Projtitle = projtitle;
	}

	public String getPropostechnologies() {
		return Propostechnologies;
	}

	public void setPropostechnologies(String propostechnologies) {
		Propostechnologies = propostechnologies;
	}

	public String getProposdeltimeline() {
		return Proposdeltimeline;
	}

	public void setProposdeltimeline(String proposdeltimeline) {
		Proposdeltimeline = proposdeltimeline;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Requestexpertis getReqexp() {
		return reqexp;
	}

	public void setReqexp(Requestexpertis reqexp) {
		this.reqexp = reqexp;
	}

	public Requeststatuss getReqst() {
		return reqst;
	}

	public void setReqst(Requeststatuss reqst) {
		this.reqst = reqst;
	}

	public Deliverables getDel() {
		return del;
	}

	public void setDel(Deliverables del) {
		this.del = del;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	
	
	
	
	
	
	
}

package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Documents;
import com.Kyprojects.TeamProjects.Repository.Documentsrepo;
import com.Kyprojects.TeamProjects.Service.DocumentService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DocumentImplementation implements DocumentService {
	
	@Autowired
	private Documentsrepo docrepo;

	public void createdocument(Documents em) {
		// TODO Auto-generated method stub
		docrepo.save(em);
	}

	public void updatedocument(Documents sem) {
		// TODO Auto-generated method stub
		docrepo.save(sem);
	}

	public void delete(Documents em) {
		// TODO Auto-generated method stub
		docrepo.delete(em);
	}

	public List<Documents> findAll(Class c) {
		// TODO Auto-generated method stub
		return docrepo.findAll();
	}

	public Optional<Documents> findById(int id) {
		// TODO Auto-generated method stub
		return docrepo.findById(id);
	}

	public byte[] documentDetailsPDF(List<Documents> req) {
		
		
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 try{
		  Document document = new Document(PageSize.A4);
		  PdfWriter writer = PdfWriter.getInstance(document, bos);
		  document.open();
		  
		  
		  // create 4 column table
		  PdfPTable table = new PdfPTable(4);
		  PdfPTable table1=new PdfPTable(4);

		  // set the width of the table to 100% of page
		  table.setWidthPercentage(200);
		  /*table1.setWidthPercentage(200);*/
		  // set relative columns width
		  table.setWidths(new int[] { 5, 5, 5, 5});
		  table1.setWidths(new int[] { 5, 5, 5, 5});
		  table1.completeRow();
          

		  // ----------------Table Header "Title"----------------
		  // font
		  Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
		  Font font2 = new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
		  // create header cell
		  Chunk title=new Chunk("                                                            Documents Report",font);
		  //title.setUnderline(0.3f, -2f); //0.1 thick, -2 y-location
		  
		  
		  Documents h=new Documents();

		  if(req.size()>0) {
		   h=req.get(0);
		  }
		  
		  document.add(title);
		  
		  document.add(new Paragraph(" "));
		  
		  Chunk title1=new Chunk(""+h.getName(),font);
		  title.setUnderline(0.3f, -2f); //0.1 thick, -2 y-location
		  
		  /*document.add(title1);*/

		  document.add(new Paragraph(" "));

		  Chunk title2=new Chunk("                                                                                                                                   DATE: "+new Date(),font2);
		  // title2.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
		  document.add(title2);
		  
		  /*PdfPCell cell = new PdfPCell(new Phrase("Title:"+" "+h.getProjtitle(), font2));
		  PdfPCell cell2 = new PdfPCell(new Phrase("Description: "+h.getProjectdecription(), font2));*/
		 
		  // set Column span "1 cell = 6 cells width"

		  //document.add(new Paragraph(" "));

		 /*cell.setColspan(2);
		 cell.setPaddingBottom(new Float(10));
		 cell2.setColspan(2);*/

	  
    	 /*cell2.setPaddingBottom(new Float(10));*/
		  // set style
		  // Style.headerCellStyle(cell);
		 // add to table
		/* cell.setBorder(PdfPCell.NO_BORDER);
		 cell2.setBorder(PdfPCell.NO_BORDER);
		 table1.addCell(cell);
		 table1.addCell(cell2);*/

		 

		// ---------------Making Request information table-------------

		 
		   /* table1.addCell(createLabelCellDetails("Project Title:")).setBorderColor(BaseColor.BLACK);*/
		  table1.addCell(praCell(new Paragraph("Name",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("Date",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("Institution",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("Project Name",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		 /* table1.addCell(praCell(new Paragraph("Proposed Technologies",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("Deliverables",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("Comment",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("RequestExpertise",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  table1.addCell(praCell(new Paragraph("RequestStatus",new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK)))).setBorderColor(BaseColor.BLACK);
		  */
		 
		    for(Documents ha:req) {
			    /*Member m=memberservice.findOne(ha.getReferenceId());*/
		    	 /*rservice.findById(ha.getId());*/
			    //T-Data
			   /* table1.addCell(createValueCell(" "+m.getFarmer().getNames()));*/
			   /* table1.addCell(" "+ha.getProjtitle());*/
		    	 table1.addCell(praCell(new Paragraph(ha.getName()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getReqdate()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getReq().getInstitution().getName()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getReq().getProjtitle()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 /*table1.addCell(praCell(new Paragraph(ha.getPropostechnologies()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getDel().getName()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getComment()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getReqexp().getName()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	 table1.addCell(praCell(new Paragraph(ha.getReqst().getName()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		    	*/
		    	 /*table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			    table1.addCell(createValueCell(" "+ha.getWeight()));*/
			    }
		   /* table1.addCell(createLabelCellDetails("Project Description")).setBorderColor(BaseColor.BLACK);*/
		  
		    /*for(Request ha:req) {
		    	rservice.findById(ha.getId());
		    	 rservice.findById(ha.getId());
		          Team t=teamservice.findOne(ha.getReferenceId());
		          //T-Data
		          table1.addCell(createValueCell(" "+ha.getProjtitle()));
		          table.addCell(" "+ha.getProjectdecription());
		    	 table1.addCell(praCell(new Paragraph(ha.getProjectdecription()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
		          table1.addCell(createValueCell(" "+ha.getWeight()));
		    }
		    table1.addCell(createLabelCellDetails("Project Delivery TimeLine")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
		          Team t=teamservice.findOne(ha.getReferenceId());
		          //T-Data
		          table1.addCell(createValueCell(" "+t.getTeamName()));
		          table1.addCell(" "+ha.getProposdeltimeline());
		    	table1.addCell(praCell(new Paragraph(ha.getProposdeltimeline()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
		          table1.addCell(createValueCell(" "+ha.getWeight()));
		          }
		    table1.addCell(createLabelCellDetails("Project Technologies")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
		          Team t=teamservice.findOne(ha.getReferenceId());
		          //T-Data
		          table1.addCell(createValueCell(" "+t.getTeamName()));
		          table1.addCell(" "+ha.getProposedfinancialbudget());
		    	table1.addCell(praCell(new Paragraph(ha.getProposedfinancialbudget()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
		          table1.addCell(createValueCell(" "+ha.getWeight()));
		          }
		    table1.addCell(createLabelCellDetails("Proposed Budget")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getPropostechnologies());
		    	table1.addCell(praCell(new Paragraph(ha.getPropostechnologies()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }
		    table1.addCell(createLabelCellDetails("Deliverables")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getDeliverables());
		    	table1.addCell(praCell(new Paragraph(ha.getDeliverables()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }
		    table1.addCell(createLabelCellDetails("Comment")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getComment());
		    	table1.addCell(praCell(new Paragraph(ha.getComment()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }
		    table1.addCell(createLabelCellDetails("RequestStatus")).setBorderColor(BaseColor.BLACK);
		    for(Request ha:req) {
		    	 rservice.findById(ha.getId());
		          Team t=teamservice.findOne(ha.getReferenceId());
		          //T-Data
		          table1.addCell(createValueCell(" "+t.getTeamName()));
		          table1.addCell(" "+ha.getRequeststatus());
		    	table1.addCell(praCell(new Paragraph(ha.getRequeststatus()+"",new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK))));
		          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
		          table1.addCell(createValueCell(" "+ha.getWeight()));
		          }
		   */
		   
		       /* for(Request ha:req) {
		          Team t=teamservice.findOne(ha.getReferenceId());
		          //T-Data
		          table1.addCell(createValueCell(" "+t.getTeamName()));
		          table1.addCell(" "+ha.getProjectdecription());
		          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
		          table1.addCell(createValueCell(" "+ha.getWeight()));
		          }*/
		        
		        /*for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getProposdeltimeline());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		        
		       /* for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getProposedfinancialbudget());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		        
		      /*  for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getPropostechnologies());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		        
		        /*for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getDeliverables());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		       /* for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getComment());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		    
		        /*for(Request ha:req) {
			          Team t=teamservice.findOne(ha.getReferenceId());
			          //T-Data
			          table1.addCell(createValueCell(" "+t.getTeamName()));
			          table1.addCell(" "+ha.getRequeststatus());
			          table1.addCell(createValueCell(" "+ha.getBatchHarvest().getRegistrantProduct().getSeason().getName()));
			          table1.addCell(createValueCell(" "+ha.getWeight()));
			          }*/
		    
		   
		  document.add(table1);
		  document.close();
		 // document.add(table);
		  
		  
		  
		 }catch(Exception ex){
		         ex.printStackTrace();
		 }
		 
		 return bos.toByteArray();		
	}

	private PdfPCell praCell(Paragraph paragraph) {
		PdfPCell cell = new PdfPCell(paragraph);
		cell.setPadding(new Float(6));
		return cell;
	}

	
	
}

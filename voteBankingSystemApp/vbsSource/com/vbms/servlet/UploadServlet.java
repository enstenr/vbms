package com.vbms.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vbms.domain.VbmsVoterDTO;
import com.vbms.rpc.VBMSRpcService;
import com.vbms.util.GenerateExcelReport;

public class UploadServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	} 

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) {
		 
		try {
			processRequest(arg0, arg1);
			processEmployees(arg0,arg1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processEmployees(HttpServletRequest request,HttpServletResponse response) throws Exception{
		   Workbook wbook=WorkbookFactory.create(new FileInputStream(FilePath+"/"+fileName));
		   Sheet sheetObj=wbook.getSheet("voters");
		 
		  int startRow=1;
		  int startCol=0;
		  
		  Row rowObj=sheetObj.getRow(startRow++);
		  Cell cellObj=rowObj.getCell(startCol);
		  List<VbmsVoterDTO> voterList=new ArrayList<VbmsVoterDTO>();
			  while(rowObj!=null&& (GenerateExcelReport.returnCellValue(cellObj)!=null && !"".equalsIgnoreCase(GenerateExcelReport.returnCellValue(cellObj)))){
				  VbmsVoterDTO voterObj=new VbmsVoterDTO();
				  cellObj=rowObj.getCell(0);
				  voterObj.setVotername(GenerateExcelReport.returnCellValue(cellObj));
				  
				  cellObj=rowObj.getCell(1);
				  voterObj.setCardnumber(GenerateExcelReport.returnCellValue(cellObj));
				  
				  cellObj=rowObj.getCell(2);
				  voterObj.setAddress(GenerateExcelReport.returnCellValue(cellObj));
				  
				  voterList.add(voterObj);
				  
				  rowObj=sheetObj.getRow(startRow++);
				  if(rowObj!=null)
					  cellObj=rowObj.getCell(startCol);
			  }
				  
			  
		  ServletContext servletContext=getServletContext();
		  WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		  VBMSRpcService vbmsService=(VBMSRpcService)applicationContext.getBean("rpcBean");
		  vbmsService.saveorUpdateVoter(voterList);
		   
			
	}
	
	final int maxPostSize=100*1024*1024;
	String FilePath=null;
	String fileName=null;
	public void processRequest(HttpServletRequest arg0, HttpServletResponse resonse) throws Exception{
	  FilePath=getServletContext().getRealPath("/")+"Uploads/";
		resonse.setContentType("text/html;charset=UTF-8");
		DiskFileItemFactory itemFactory=new DiskFileItemFactory();
		itemFactory.setSizeThreshold(4096);
		
		ServletFileUpload fileUpload=new ServletFileUpload(itemFactory);
		fileUpload.setFileSizeMax(maxPostSize);
		
		List<FileItem> fileItem=fileUpload.parseRequest(arg0);
		Iterator<FileItem> itrator=fileItem.iterator();
		while(itrator.hasNext()){
			FileItem itemObj= itrator.next();
			 if(!itemObj.isFormField()){
				   
				 fileName=System.currentTimeMillis()+"_"+itemObj.getName();
				 
				 itemObj.write(new File(FilePath+fileName));
			 }
		}
	}
  
	 
	 

	   

}

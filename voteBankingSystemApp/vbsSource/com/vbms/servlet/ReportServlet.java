package com.vbms.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.exception.VBMSException;
import com.vbms.rpc.VBMSRpcService;
import com.vbms.util.GenerateExcelReport;

public class ReportServlet extends HttpServlet {
	 
	private String VOTER_TEMPLATE= "VOTER_TEMPLATE";

	private String COMPLAINTS= "COMPLAINTS";

	private String SCHEMES= "SCHEMES";

	private String MONTHLY_6A_REPORT = "MONTHLY_6A_REPORT";

	private String MONTHLY_3A_REPORT = "MONTHLY_3A_REPORT";

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		arg1.setContentType("application/excel");
		String action=(String) arg0.getParameter("action");
		
	 
	 	
	 	if(VOTER_TEMPLATE.equalsIgnoreCase(action))
	 	{
	 		//code to generate template
	 		try {
				generateTemplate(arg0, arg1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}else if (COMPLAINTS.equalsIgnoreCase(action)){
	 		String fromDate = (String) arg0.getParameter("fromDate");
			String toDate = (String) arg0.getParameter("toDate");
			String status = (String) arg0.getParameter("status");
		 	VbmsComplaintDTO vbmsComplaintDtoObj=new VbmsComplaintDTO();
		 	vbmsComplaintDtoObj.setStatus(status);
		 	vbmsComplaintDtoObj.setFromDate(fromDate);
		 	vbmsComplaintDtoObj.setToDate(toDate);
		 	
		 	  ServletContext servletContext=getServletContext();
			  WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
			  VBMSRpcService vbmsService=(VBMSRpcService)applicationContext.getBean("rpcBean");
			 
			  try {
				  generateComplaints(arg0,arg1,vbmsService.fetchComplaintsReport(vbmsComplaintDtoObj));
			} catch (VBMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 	}else if( SCHEMES.equalsIgnoreCase(action)){
	 		
	 	}
	 	
	 }

	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		doPost(arg0, arg1);
	}

	public void generateTemplate(HttpServletRequest arg0, HttpServletResponse arg)
			throws Exception {
	 XSSFWorkbook wbook = null;
		arg.setHeader("Content-Disposition",
		"attachment; filename ="+VOTER_TEMPLATE+".xls");
		//arg.setContentType("application/vnd.ms-excel");  
		  //Workbook wbookTemplate=WorkbookFactory.create(new FileInputStream(getServletContext().getRealPath("/")+"/"+VOTER_TEMPLATE+".xls"));
		  HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream(getServletContext().getRealPath("/")+"/"+VOTER_TEMPLATE+".xls"));
 
		   
		  OutputStream out = arg.getOutputStream();
		  wb.write(out);
		  out.close();
	 	}

	 
	public void generateComplaints(HttpServletRequest arg0, HttpServletResponse arg,List<VbmsComplaintDTO> vbmsComplaintList)
			throws Exception {
	 Workbook wbook = null;
		arg.setHeader("Content-Disposition",
		"attachment; filename ="+COMPLAINTS+".xlsx");
	 	 
		wbook=  GenerateExcelReport.generateComplaintReport(vbmsComplaintList);
		  OutputStream out = arg.getOutputStream();
		  wbook.write(out);
		  out.close();
	 	}

	 

	private boolean xlsx = false;

	 

}

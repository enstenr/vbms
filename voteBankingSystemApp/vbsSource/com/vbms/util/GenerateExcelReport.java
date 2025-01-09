package com.vbms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.vbms.domain.VbmsComplaintDTO;

 


public class GenerateExcelReport {

	public static Workbook generateComplaintReport(
			 
			List<VbmsComplaintDTO> complaintList) throws FileNotFoundException,
			IOException {
		 Workbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
	        Sheet sheet = wb.createSheet();
	        int mainRow=0;
	      
 		 
		int rowCount = 3;
		 	Row rowObj = sheet.createRow(rowCount++);
		int cellCount = 1;
		 Cell cellObj;
		Row hssfrowObj = sheet.createRow(0);
		 Cell hssfcellObj = hssfrowObj.createCell(0);
		hssfcellObj.setCellValue("sample");
 
		CellStyle style = wb.createCellStyle();
	    style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setBorderTop(CellStyle.BORDER_THIN);
	   
		 
		for (VbmsComplaintDTO complaintObj : complaintList) {
			cellCount = 1;
			rowObj = sheet.createRow(rowCount++);

			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellType(Cell.CELL_TYPE_STRING);
			cellObj.setCellStyle(style);
			
 			cellObj.setCellValue(complaintObj.getDesc());

			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellType(Cell.CELL_TYPE_STRING);
			cellObj.setCellValue(complaintObj.getStatus());
			cellObj.setCellStyle(style);
			
			
			 	
		 	 		
 			 		
		}

		return wb;

	}
/*
	public static XSSFWorkbook generateDeletedReport(List<EmployeeMaster> resultList, XSSFWorkbook wbook1, String year, String month) {
		// TODO Auto-generated method stub
		return null;
	}

	public static HSSFWorkbook generateMonthlyReportGovt(List<EmployeeSalrayDetails> resultList, HSSFWorkbook wb, String year, String month) {

 		HSSFSheet sheet = wb.getSheet("Sal_Internal");
		int rowCount = 2;
		Field[] fieldObj = EmployeeMaster.class.getDeclaredFields();
		System.out.println(fieldObj + "field");
		HSSFRow rowObj = sheet.createRow(rowCount++);
		int cellCount = 3;
		HSSFCell cellObj;
		HSSFRow hssfrowObj = sheet.getRow(0);
		HSSFCell hssfcellObj = hssfrowObj.getCell(8);
		hssfcellObj.setCellValue(month + " " + year);

		CellStyle style = wb.createCellStyle();
	    style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setBorderTop(CellStyle.BORDER_THIN);
	     
		for (EmployeeSalrayDetails empMasterObj : resultList) {
			cellCount = 3;
			rowObj = sheet.createRow(rowCount++);

			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue(empMasterObj.getEmpName());
			cellObj.setCellStyle(style);
 
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtBasic()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActWorkingTime()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue(String.valueOf((empMasterObj.getGovtActWorkingTime())/8));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellStyle(style);
			
			//cellObj.setCellValue(String.valueOf(Float.parseFloat(empMasterObj.getGovtSalperHour())*8));

			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActOTTime()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActBasicComp()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActOTComp()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActWashComp()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtPfSal()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtESISal()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtActEarnedSal()));
			cellObj.setCellStyle(style);
			
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtPf()));
			cellObj.setCellStyle(style);
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtESI()));
			cellObj.setCellStyle(style);
			
			cellCount++;
			cellCount++;
			
			cellObj = rowObj.createCell(cellCount++);
			cellObj.setCellValue((empMasterObj.getGovtTotalEarnedSal()));
			cellObj.setCellStyle(style);
			
		}

		return wb;
 	} */
	public static String returnCellValue(Cell cellObj){
		String returnValue="";
		if(cellObj==null)
			return "";
		 switch (cellObj.getCellType()) {
         case Cell.CELL_TYPE_STRING:
        	 returnValue=cellObj.getRichStringCellValue().getString();
             break;
         case Cell.CELL_TYPE_NUMERIC:
             if (DateUtil.isCellDateFormatted(cellObj)) {
            	 returnValue=String.valueOf(cellObj.getDateCellValue());
             } else {
            	 returnValue=String.valueOf(cellObj.getNumericCellValue());
             }
             break;
         case Cell.CELL_TYPE_BOOLEAN:
        	 returnValue=String.valueOf(cellObj.getBooleanCellValue());
             break;
         case Cell.CELL_TYPE_FORMULA:
        	// returnValue=cellObj.getCellFormula();
             break;
         default:
             System.out.println();
     }
		return returnValue;
	}

/*	public static Workbook generateMonthlyReport3A(List<EmployeeSalrayDetails> salaryresultList, XSSFWorkbook wbook1, String year, String month) {
		 Workbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
	        Sheet sh = wb.createSheet();
int mainRow=0;
	        Sheet refsheet=wbook1.getSheetAt(0);
	     for(int loop=0;loop<3;loop++){
	        for(int rownum = 0; rownum < 45; rownum++){
	        	Row refRow=refsheet.getRow(rownum);
	        	//CellStyle cellStyle=refRow.getRowStyle();
	            Row row = sh.createRow(mainRow);
	            //row.setRowStyle(cellStyle);
	           // row=inputrow;
	            // Copy style from old cell and apply to new cell
	            
	            for(int cellnum = 0; cellnum < 20; cellnum++){
	                Cell cell = row.createCell(cellnum);
	                if(refRow!=null){
	                	
	                 
	    	            
	    	            
	    	            
	                Cell refCell=refRow.getCell(cellnum);
	            //    CellStyle refStyle=refCell.getCellStyle();
	            //    String address = new CellReference(refCell).formatAsString();
	                
	            	//CellStyle newCellStyle = wb.createCellStyle();
    	            //newCellStyle.cloneStyleFrom(refCell.getCellStyle());
    	           
    	            
	                cell.setCellValue(returnCellValue(refCell));
	                //cell.setCellStyle(newCellStyle);
	               // cell.setCellStyle(refStyle);
	                }
	            }
	            
	            
	            
	            for (int i = 0; i < sh.getNumMergedRegions(); i++) {
	                CellRangeAddress cellRangeAddress = sh.getMergedRegion(i);
	                if (cellRangeAddress.getFirstRow() == refRow.getRowNum()) {
	                    CellRangeAddress newCellRangeAddress = new CellRangeAddress(row.getRowNum(),
	                            (row.getRowNum() +
	                                    (cellRangeAddress.getFirstRow() -
	                                            cellRangeAddress.getLastRow())),
	                            cellRangeAddress.getFirstColumn(),
	                            cellRangeAddress.getLastColumn());
	                    sh.addMergedRegion(newCellRangeAddress);
	                }
	            }
	                
	                
	            mainRow++;
	            

	        }
	     }

		return wb;
	}*/
}

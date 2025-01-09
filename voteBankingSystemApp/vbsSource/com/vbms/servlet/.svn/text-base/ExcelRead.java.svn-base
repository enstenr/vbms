package com.vbms.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vbms.domain.VbmsVoterDTO;
import com.vbms.util.GenerateExcelReport;

public class ExcelRead {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InvalidFormatException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
		String xlsxfileName="1327408926910_voter.xlsx";
		String xlsfileName="voter.xls";
		String FilePath="F:\\workspacerajesh\\voteBankingSystemApp\\Uploads";
		 Workbook wbook=WorkbookFactory.create(new FileInputStream(FilePath+"/"+xlsfileName));
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
				  
			  System.out.println("voterList"+voterList);
		  
		 
	}

}

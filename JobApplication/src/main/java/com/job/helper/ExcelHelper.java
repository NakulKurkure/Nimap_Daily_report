package com.job.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.job.entity.Excel;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "userName", "email", "role","jobTitle","jobDescription" };
	static String SHEET = "Sheet1";

	  public static boolean hasExcelFormat(MultipartFile file) {
		  System.out.println("Type11 "+file);
	    if (!TYPE.equals(file.getContentType())) {
	    	
	    	System.out.println("Type22 "+TYPE);
	      return false;
	    }
	    
	    return true;
	  }
	  
	public static List<Excel> excelToTutorials(InputStream inputStream) {
		//InputStream  is abstract class  superclass of all classes representing an input stream of bytes. 
		
		try {
			//Workbook=It is also the top level object for creating new sheets/etc
			Workbook workbook = new XSSFWorkbook(inputStream);
		      System.out.println("Hi 2 "+workbook);
		      Sheet sheet = workbook.getSheet(SHEET);
		      System.out.println("hi 3"+sheet);
		      Iterator<Row> rows = sheet.iterator();
		      System.out.println("Hi 4"+rows);
		      
		      List<Excel> tutorials = new ArrayList<Excel>();
		      System.out.println("Hi 33"+tutorials);
		      int rowNumber = 0;
		      while (rows.hasNext()) {
		    	    System.out.println("Hi 3");
		        Row currentRow = rows.next();
		        
		        // skip header
		        if (rowNumber == 0) {
		            System.out.println("Hi");
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        Excel tutorial = new Excel();
		        //set id in tutorial
		        int cellIdx = 0;
		        //hasNext() return true if more elements
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		            tutorial.setId((int)currentCell.getNumericCellValue());
		            System.out.print("Id"+cellIdx);
		            break;

		            
		          case 2:
			            tutorial.setUserName(currentCell.getStringCellValue());
			          
			            break;
			            
		          case 3:
		            tutorial.setEmail(currentCell.getStringCellValue());
		          
		            break;

		         
		          case 4:
			        tutorial.setRole(currentCell.getStringCellValue());

			            break;
			            
		          case 5:
		        	  tutorial.setJobTitle(currentCell.getStringCellValue());
		            break;

		          case 6:
		            tutorial.setJobDescription(currentCell.getStringCellValue());
		            break;
		            

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        tutorials.add(tutorial);
		      }

		      workbook.close();

		      return tutorials;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	
	
	
}

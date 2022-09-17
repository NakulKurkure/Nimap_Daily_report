package com.springrestapi.Helper;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.springrestapi.entity.ExcelEntity;

public class ExcelHelper {
	
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Fname", "Lname", "City" };
	  static String SHEET = "Book1.xlsx";

	  public static boolean hasExcelFormat(MultipartFile file) {
		  System.out.println("Type11 "+file);
	    if (!TYPE.equals(file.getContentType())) {
	    	
	    	System.out.println("Type22 "+TYPE);
	      return false;
	    }

	    return true;
	  }

	public static List<ExcelEntity> excelToTutorials(InputStream inputStream) {
		// TODO Auto-generated method stub
		
		
		try {
		      Workbook workbook = new XSSFWorkbook(inputStream);
		      System.out.println("Hi 2 "+workbook);
		      Sheet sheet = workbook.getSheet(SHEET);
		      System.out.println("hi 3"+workbook.getSheet(SHEET));
		      Iterator<Row> rows = sheet.iterator();
		      System.out.println("Hi 4"+rows);

		      List<ExcelEntity> tutorials = new ArrayList<ExcelEntity>();
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

		        ExcelEntity tutorial = new ExcelEntity();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		            tutorial.setId((int) currentCell.getNumericCellValue());
		            break;

		          case 1:
		            tutorial.setFname(currentCell.getStringCellValue());
		            break;

		          case 2:
		            tutorial.setLname(currentCell.getStringCellValue());
		            break;

		          case 3:
		            tutorial.setCity(currentCell.getStringCellValue());
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
	  
	 


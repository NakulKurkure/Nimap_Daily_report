package com.job.serviceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.User;
import com.job.repository.ExcelRepo;
import com.job.util.ExcelExportUtils;

@Service
public class ExcelServiceImpls {

	@Autowired
	private ExcelRepo excelRepo;
	
	 public List<User> exportCustomerToExcel(HttpServletResponse response) throws IOException {
	        List<User> customers = excelRepo.findAll();
	        ExcelExportUtils exportUtils = new ExcelExportUtils(customers);
	        exportUtils.exportDataToExcel(response);
	        return customers;
	    }
}

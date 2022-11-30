package com.job.serviceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.User;
import com.job.entity.UserJob;
import com.job.repository.ExcelRepo;
import com.job.util.ExcelExportUtils;

@Service
public class ExcelServiceImpls {

	@Autowired
	private ExcelRepo excelRepo;
	
	 public List<UserJob> exportUserToExcel(HttpServletResponse response) throws IOException {
	        List<UserJob> customers = excelRepo.findAll();
	        ExcelExportUtils exportUtils = new ExcelExportUtils(customers);
	        exportUtils.exportDataToExcel(response);
	        return customers;
	    }
}

package com.example.demo.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.Model.S_BillItems;

import com.example.demo.Repository.S_BillItemsRepository;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class S_billItems {
	
	 @Autowired
	    private S_BillItemsRepository repository;


	    public String exportReportbill(int Invoice_Number,String filename) throws FileNotFoundException, JRException {
	    	String path = "/Users/yashodadanupama/Desktop/Reports/Bill Item by id";
	        
	        String nameoffile = filename+".pdf";
	        
	        
	        
	        
	        
	        List<S_BillItems> employees = repository.findbillbyid(Invoice_Number);
	        //load file and compile it
	        File file = ResourceUtils.getFile("classpath:BillItems.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Java Techie");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	      
	
	        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/"+nameoffile);
	       

	        return nameoffile+" report generated ";
	    }
	}
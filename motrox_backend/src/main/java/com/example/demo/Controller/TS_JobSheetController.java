package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TS_JobSheet;
import com.example.demo.Repository.TS_JobSheetRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TS_JobSheetController {

	@Autowired
	private TS_JobSheetRepository jobSheetRepository;
	
	//get all job sheets
	@GetMapping("/jobSheets")
	public List<TS_JobSheet> getAllJobSheets(){
		return jobSheetRepository.findAll();
	}
	
	//create a job Sheet
	@PostMapping("/jobSheets")
	public TS_JobSheet createJobSheet(@RequestBody TS_JobSheet jobSheet) {
		return jobSheetRepository.save(jobSheet);
	}
}

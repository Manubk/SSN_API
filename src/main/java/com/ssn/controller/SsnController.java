package com.ssn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.ssn.entity.StateEntity;
import com.ssn.serviceinterface.ISsnService;


@RestController
public class SsnController {
	
	
	private static final Logger log = LoggerFactory.getLogger(SsnController.class);

	
	@Autowired
	private ISsnService ssnService;
	
	@GetMapping("/ssn/state/{ssn}")
	public List<String> getState(@PathVariable(name = "ssn")String ssn) {
		log.info("getStates ssn = "+ssn);
		
		 List<String> states = ssnService.findStateName(ssn);
	  	
		 return states;
	}
	
	@GetMapping("/ssn/validate/{ssn}")
	public boolean validateSsn(@PathVariable(name = "ssn") String ssn) {
		log.info("validateSsn ssn = "+ssn);
		
		boolean isSsnvalid = ssnService.validateSsn(ssn);
		
		return isSsnvalid;	
	}
}

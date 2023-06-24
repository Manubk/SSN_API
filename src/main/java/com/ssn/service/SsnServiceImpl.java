package com.ssn.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.entity.StateEntity;
import com.ssn.repo.StateRepo;
import com.ssn.serviceinterface.ISsnService;

@Service
public class SsnServiceImpl implements ISsnService {

	
	private static final Logger log = LoggerFactory.getLogger(SsnServiceImpl.class);

	@Autowired
	private StateRepo stateRepo;

	/*
	 * -> SSN consists of 9 digits and usually divided by 3 parts by hyphen (XXX-XX-XXXX).
	 * -> The first part can not be 000, 666, or between 700 -999 
	 * -> Second part can not be 00 Third part can not be 0000
	 */
	@Override
	public boolean validateSsn(String ssn) {
		log.info("validateSsn");
		
		if(ssn == null || ssn.equals("")  || ssn.length() != 9)
			return false;
		
		String stateCode = ssn.substring(0, 3);
		String middle = ssn.substring(3, 5);
		String last = ssn.substring(5, 9);
		
		if(stateCode.equals("000") || stateCode.equals("666") || Integer.parseInt(stateCode) >= 733)
			return false;
		
		if(Integer.parseInt(middle) == 00 || Integer.parseInt(last) == 000)
			return false;
		
		
		//TODO Advance validaion should do  we can use regular expressiong
		
		return true;
	}

	
	@Override
	public List<String> findStateName(String ssn) {
		log.info("getStateName");

		Integer StateCode = Integer.parseInt(ssn.substring(0, 3));
		List<String> states = stateRepo.findState(StateCode);
		
		return states;
	}

	@Override
	public boolean saveState(StateEntity state) {
		log.info("saveState");
		
		StateEntity savedState = stateRepo.save(state);
		
		if(savedState.getStateId() !=  null)
			return true;
		
		return false;
	}

	
	
}

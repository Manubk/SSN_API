package com.ssn.serviceinterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssn.entity.StateEntity;

@Service
public interface ISsnService {
	
	public boolean validateSsn(String ssn);
	
	public List<String> findStateName(String ssn);
	
	public boolean saveState(StateEntity state);
}

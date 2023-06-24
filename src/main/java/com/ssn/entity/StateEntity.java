package com.ssn.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.security.RunAs;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "STATE_MASTER")
public class StateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_Id")
	private Integer stateId;

	@Column(name = "STATE_NAME")
	private String stateName;
	
	@Column(name = "START_NUM")
	private Integer sNum;
	
	@Column(name = "FINAL_NUM")
	private Integer fNum;
}

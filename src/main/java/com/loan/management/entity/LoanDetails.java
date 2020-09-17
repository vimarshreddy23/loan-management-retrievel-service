package com.loan.management.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanNumber;
	
	private String loanType;
	
	private String loanInterest;
	
	private Long loanAmount;
	
	private String loanTenure;
	
	private String borrowerFullName;
	
	private String borrowerContact;
	
	private String createdBy;
	
	@LastModifiedDate
	private Date createdTime;
	
}

package com.loan.management.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanNumber;
	
	private String loanType;
	
	private String loanInterest;
	
	private int loanAmount;
	
	private String loanTenure;
	
	private String borrowerFullName;
	
	private int borrowerContact;
	
	private String createdBy;
	
	@LastModifiedDate
	private Date createdTime;

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(String loanInterest) {
		this.loanInterest = loanInterest;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getBorrowerFullName() {
		return borrowerFullName;
	}

	public void setBorrowerFullName(String borrowerFullName) {
		this.borrowerFullName = borrowerFullName;
	}

	public int getBorrowerContact() {
		return borrowerContact;
	}

	public void setBorrowerContact(int borrowerContact) {
		this.borrowerContact = borrowerContact;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
}

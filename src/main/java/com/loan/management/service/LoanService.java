package com.loan.management.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.loan.management.entity.LoanDetails;

@Repository
public interface LoanService{
	List<LoanDetails> getLoanDetails(Long id, String name, Long amount);
}

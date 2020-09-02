package com.loan.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.loan.management.entity.Loan;
import com.loan.management.repository.LoanRepository;

@RestController
@RequestMapping("/api/loans")
public class LoanSearchController {

	@Autowired
	private LoanRepository loanRepository;
	
	@GetMapping("/get")
	public List<Loan> findLoanInfo(@RequestParam (value = "loanNumber", required = false, defaultValue = "0") int number,
			@RequestParam(value = "loanAmount", required = false, defaultValue = "0") int amount,@RequestParam(value = "borrowerFullName", required = false) String fullName) {
		return loanRepository.findOne(number,amount,fullName);	
	}
	
	@GetMapping("/getAll")
	public List<Loan> findAll() {
		return loanRepository.findAll();	
	}
}

package com.loan.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loan.management.entity.LoanDetails;
import com.loan.management.service.LoanServiceImpl;

@RestController
@RequestMapping("/api/loans")
public class LoanSearchController {
	
	@Autowired
	private LoanServiceImpl loanServiceImpl;

	
	@GetMapping("/getLoanDetails")
	public ResponseEntity<?> findLoanInfo(@RequestParam (value = "loanNumber", required = false, defaultValue = "0") long number,
			@RequestParam(value = "loanAmount", required = false, defaultValue = "0") long amount,
			@RequestParam(value = "name", required = false) String fullName) {
		List<LoanDetails> filterDetails = loanServiceImpl.getLoanDetails(number, fullName, amount);
		if(filterDetails.isEmpty())
			return new ResponseEntity<>("No Search Results", HttpStatus.NOT_FOUND);
		else
		 return new ResponseEntity<>(filterDetails, HttpStatus.FOUND);
	}	
}

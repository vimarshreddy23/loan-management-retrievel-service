package com.loan.management.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.management.entity.Loan;

@SpringBootTest
class LoanSearchControllerTest {

	@InjectMocks
	private LoanSearchController LoanSearchController;
	@Test
	void testFindLoanInfo() {
		Loan l = new Loan();
		l.setLoanNumber(1);
	}

}

package com.loan.management.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.loan.management.LoanRetrievalApplication;
import com.loan.management.entity.LoanDetails;
import com.loan.management.service.LoanServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(LoanRetrievalApplication.class)
class LoanSearchControllerTest {

	@Mock
	private LoanServiceImpl loanService;
	
	@InjectMocks
	private LoanSearchController loanSearchController;

	public List<LoanDetails> loanDetails;
	
	@Test
	void testFindLoanInfoFound()  throws Exception {
		
		loanDetails = new ArrayList<>();
		LoanDetails loan = new LoanDetails();
		loan.setLoanNumber(12345l);
		loan.setBorrowerContact("789654123");
		loan.setBorrowerFullName("Borrower 1");
		loan.setLoanType("Personal Loan");
		loan.setLoanAmount(200000l);
		loan.setCreatedBy("User");
		loan.setLoanInterest("13.5");
		loan.setLoanTenure("24 Months");
		loan.setCreatedTime(new Date(123456));
		loanDetails.add(loan);
		
		when(loanService.getLoanDetails(Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong())).thenReturn(loanDetails);
		ResponseEntity<?> result = loanSearchController.findLoanInfo(loanDetails.get(0).getLoanAmount(), loanDetails.get(0).getLoanNumber(), loanDetails.get(0).getBorrowerFullName());
		List<LoanDetails> data = (List<LoanDetails>) result.getBody();
		
		assertEquals(loanDetails, result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());		
		assertEquals("Personal Loan",data.get(0).getLoanType());
		assertEquals("24 Months",data.get(0).getLoanTenure());
		assertEquals("13.5",data.get(0).getLoanInterest());
		assertEquals("User",data.get(0).getCreatedBy());
		assertEquals("789654123",data.get(0).getBorrowerContact());
		assertEquals(new Date(123456),data.get(0).getCreatedTime());
	}
	
	@Test
	void testFindLoanInfoNotFound()  throws Exception {
		loanDetails = new ArrayList<>();
		when(loanService.getLoanDetails(Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong())).thenReturn(loanDetails);
		ResponseEntity<?> result = loanSearchController.findLoanInfo(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString());
		assertEquals("No Search Results", result.getBody());
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());	
		
	}
}

package com.loan.management.controller;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.loan.management.LoanRetrievalServiceApplication;
import com.loan.management.entity.LoanDetails;
import com.loan.management.service.LoanServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { LoanRetrievalServiceApplication.class })
public class LoanSearchControllerTest {

	@Mock
	private LoanServiceImpl loanService;
	
	@InjectMocks
	private LoanSearchController loanSearchController;

	public List<LoanDetails> loanDetails;
	
	@Test
	public void testFindLoanInfoFound()  throws Exception {
		
		loanDetails = new ArrayList<>();
		LoanDetails loan = new LoanDetails();
		loan.setBorrowerContact("789654123");
		loan.setBorrowerFullName("Borrower 1");
		loan.setLoanNumber(12345l);
		loan.setLoanAmount(200000l);
		loanDetails.add(loan);
		
		//when(loanService.getLoanDetails(Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong())).thenReturn(loanDetails);
		ResponseEntity<?> result = loanSearchController.findLoanInfo(loanDetails.get(0).getLoanAmount(), loanDetails.get(0).getLoanNumber(), loanDetails.get(0).getBorrowerFullName());
		assertEquals(loanDetails, result.getBody());
		assertEquals(HttpStatus.FOUND, result.getStatusCode());
	}
	
	@Test
	public void testFindLoanInfoNotFound()  throws Exception {
		loanDetails = new ArrayList<>();
		//when(loanService.getLoanDetails(Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong())).thenReturn(loanDetails);
		ResponseEntity<?> result = loanSearchController.findLoanInfo(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString());
		assertEquals("No Search Results", result.getBody());
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	}
	
}

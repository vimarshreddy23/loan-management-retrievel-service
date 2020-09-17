package com.loan.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.loan.management.entity.LoanDetails;

@DataJpaTest
class LoanServiceImplTest {

	@InjectMocks
	LoanServiceImpl service;

	@Mock
	EntityManager entityManager;
	
	@Mock
	CriteriaBuilder cBuilder;
	
	@Mock
	CriteriaQuery<LoanDetails> cQuery;
	
	@Mock
	TypedQuery<LoanDetails> query;	
	
	@Mock
	Root<LoanDetails> root;
	
	@Test
	void getLoanDetailsTest() {
		
		List<LoanDetails> loanDetails = new ArrayList<>();
		LoanDetails loan = new LoanDetails();
		loan.setBorrowerContact("789654123");
		loan.setBorrowerFullName("Borrower 1");
		loan.setLoanType("Personal Loan");
		loan.setLoanNumber(12345l);
		loan.setLoanAmount(200000l);
		loanDetails.add(loan);
		
		Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cBuilder);
		Mockito.when(cBuilder.createQuery(LoanDetails.class)).thenReturn(cQuery);
		Mockito.when(cQuery.from(LoanDetails.class)).thenReturn(root);
		Mockito.when(entityManager.createQuery(Mockito.any(CriteriaQuery.class))).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(loanDetails);
		
		List<LoanDetails> result = service.getLoanDetails(101L,"harry",0L);
		assertEquals("Borrower 1", result.get(0).getBorrowerFullName());
	}
	
	
}

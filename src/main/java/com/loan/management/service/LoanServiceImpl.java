package com.loan.management.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.loan.management.entity.LoanDetails;

@Service
public class LoanServiceImpl implements LoanService{


	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<LoanDetails> getLoanDetails(Long id, String name, Long amount) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
	    CriteriaQuery<LoanDetails> cq = cb.createQuery(LoanDetails.class);
	 
	    Root<LoanDetails> loans = cq.from(LoanDetails.class);
	    
	    List<Predicate> predicates = new ArrayList<>();
	     
	    predicates.add(cb.or(cb.like(loans.get("borrowerFullName"), name),
	    			 		 cb.equal(loans.get("loanAmount"), amount),
	    			 		 cb.equal(loans.get("loanNumber"), id)));
	
	    cq.where(predicates.toArray(new Predicate[predicates.size()]));
	    return entityManager.createQuery(cq).getResultList();
    
	}

}

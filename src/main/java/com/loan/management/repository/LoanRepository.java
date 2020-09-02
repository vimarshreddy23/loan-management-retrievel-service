package com.loan.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loan.management.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

	@Query("select ld FROM Loan ld WHERE ld.loanNumber =:loanNumber or ld.loanAmount=:loanAmount or ld.borrowerFullName=:borrowerFullName")
	List<Loan> findOne(@Param("loanNumber") int loanNumber,@Param("loanAmount") int amount,@Param("borrowerFullName") String fullName);

}

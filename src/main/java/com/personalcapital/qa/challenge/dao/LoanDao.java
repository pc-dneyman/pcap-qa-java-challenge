package com.personalcapital.qa.challenge.dao;

import java.util.List;

public interface LoanDao
{
	public Loan createLoan(String userName, String userPhone, Double amount, Double interest,
			Integer duration);

	public Loan updateLoan(Loan loan);

	public void deleteLoan(Long loanId);

	public List<Loan> fetchAllLoans();

	public Loan fetchUserLoan(String userName, String userPhone);
}

package com.personalcapital.qa.challenge.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoanDaoImpl implements LoanDao {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Loan createLoan(String userName, String phoneNumber, Double amount,
			Double interest, Integer duration) {
		Loan loan = new Loan();
		loan.setUserName(userName);
		loan.setPhoneNumber(phoneNumber);
		loan.setAmount(amount);
		loan.setBalance(0.0);
		loan.setInceptionDate(new Date());
		loan.setDuration(10);
		em.persist(loan);
		return loan;
	}

	@Override
	public Loan updateLoan(Loan loan) {
		Loan merged = em.merge(loan);
		return merged;
	}

	@Override
	public void deleteLoan(Long loanId) {
		Loan loan = em.find(Loan.class, loanId);
		em.remove(loan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> fetchAllLoans() {
		Query query = em
				.createQuery("select model from Loan model order by model.id");
		List<Loan> result = query.getResultList();
		if (result != null && result.size() > 0) {
			return result;
		} else {
			return null;
		}
	}

	@Override
	public Loan fetchUserLoan(String userName, String userPhone) {
		Query query = em
				.createQuery("select model from LoanImpl model where userName = :name and userPhone = :phone");
		query.setParameter("name", userName);
		query.setParameter("phone", userPhone);
		Loan result = (Loan) query.getSingleResult();
		return result;
	}
}

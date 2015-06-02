package personalcapital.testing.challenge.dao;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.personalcapital.qa.challenge.dao.Loan;
import com.personalcapital.qa.challenge.dao.LoanDao;

/**
 * This test should cover all use cases for given Dao under the test.
 * It can be executed from command line or in Eclipse against pre-configured in-memory HSqlDb
 * At the same time, consider adding a few test cases that demonstrate usage of Mocked implementation
 * of Loan Dao.
 */
@ContextConfiguration(locations = "classpath:test-db-context.xml")
@TransactionConfiguration
@Transactional
public class LoanDaoTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Autowired
	private LoanDao loanDao;

	@Test
	public void testCreateLoan()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoan()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllLoans()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testXXXXXX()
	{
		fail("Not yet implemented");
	}

}

The project you are presented with designed to demonstrate various white box testing techniques and approaches that are considered important by Personal Capital server team. 

The project is a pure Maven based Java module making use of such frameworks as Spring and Hibernate, as well as in-memory HSQLDB that greatly simplifies testing.

You will find number of Java packages and a few classes - each with their own theme. Among them:

1) Utility class for string / number manipulations and formatting (Utils)

2) Sample Dao class exposing basic CRUD operations and corresponding mapped entity (Loan and LoanDao)

3) Sample RESTfull service - QuoteService that calls into Xignite provider and brings back XML and JSON marshalled responses (QouteRestService, QuoteJson, QuoteXml)

Each class above has a corresponding JUnit Test class placeholder. 

Upon initially compilation or test ($mvn compile [test]), you will see number of failures. 

Failed tests: 
  LoanDaoTest.testGetAllLoans:50 Not yet implemented
  LoanDaoTest.testUpdateLoan:44 Not yet implemented
  LoanDaoTest.testCreateLoan:38 Not yet implemented
  LoanDaoTest.testXXXXXX:56 Not yet implemented
  —
  QuoteRestServiceTest.testXml:36 Not yet implemented
  QuoteRestServiceTest.testJson:31 Not yet implemented
  QuoteRestServiceTest.testXXXXXX:41 Not yet implemented
  —
  UtilsTest.testXXXXXX:19 Not yet implemented


Your goal is to implement failed test methods and add any new tests that demonstrate your approach to problems of this sort.

Each test class has a class level comment with some rationale and suggestions about testing this particular class. 

This could be helpful and may point you to the right direction when approaching this challenge.

Feel free to improvise and be creative. Use IDE of your choice and if getting stuck with syntax, prototype your solutions to show main ideas.

Good luck.





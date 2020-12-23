#Author: techyogi25@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Testing the ExchangeRateAPI

  Scenario: Send a request to get rates of a specific date with valid data TC01
    Given Construct the url by adding a specific date TC01
    And Hit the API and capture the response TC01
    Then Verify the response TC01

  Scenario: Send a request to get rates of a specific date with invalid data TC02
    Given Construct the url by adding a invalid date TC02
    And Hit the API and capture the response TC02
    Then Verify that error comes in the response TC02

  Scenario: Send a request for latest date with symbols TC03
    Given Construct the url for latest date TC03
    And Hit the API and capture the response TC03
    Then Verify that response gets generated TC03

  Scenario: Send a invalid request for latest date with symbols TC04
    Given Construct the url for latest date TC04
    And Hit the API and capture the response TC04
    Then Verify that error gets generated TC04

  Scenario: Send a valid request with symbols and base TC05
    Given Construct the url with valid symbol and base TC05
    And Hit the API and capture the response TC05
    Then Verify that response gets generated TC05
 
 Scenario: Send a request for latest data without symbols and base TC06
   Given Construct the url TC06
    And Hit the API and capture the response TC06
    Then Verify that response gets generated TC06
    
 Scenario: Send a request for specific date with symbol TC07
  Given Construct the url TC07
  And Hit the API and capture the response TC07
  Then Verify that response gets generated TC07
  
  Scenario: Send a request for specific date using base TC08
  Given Construct the url TC08
  And Hit the API and capture the response TC08
  Then Verify that response gets generated TC08
  
  Scenario: Send a request for specific date using base and symbols TC09
  Given Construct the url TC09
  And Hit the API and capture the response TC09
  Then Verify that response gets generated TC09
  
  Scenario: Send a request with invalid base TC10
  Given Construct the url TC10
  And Hit the API and capture the response TC10
  Then Verify that error is generated TC10
  
  
  Scenario: Send a request with incomplete API TC11
  Given Hit the API base url and capture response TC11
  Then Verify that error generated TC11
  
  Scenario: Check API is available TC12
  Given Hit the API and capture the response TC12
  Then Check if the api is available TC12
  
 
 
 

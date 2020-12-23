package com.yogesh.assesment.ExchangeRateAPI.stepDef;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.yogesh.assesment.ExchangeRateAPI.TestRunner;
import com.yogesh.assesment.ExchangeRateAPI.pojoClass.ExchangeRates;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ExchangeRatesStepDef {

	public static String url="";
	public static String response="";
	public static String status="FAIL";
	
	 // Scenario: Send a request to get rates of a specific date with valid data TC01
	    @Given("^Construct the url by adding a specific date TC01$")
	    public void constructURLTC01() {
	    	
	    	ExchangeRates.date="2010-01-12";
	    	url=ExchangeRates.baseURL+ExchangeRates.date;
	    	
	    	
	    	
	    	
	    }
	    @And("^Hit the API and capture the response TC01$")
	    public void hitAPIandCaptureResponseTC01() {
	    	response=ExchangeRates.getResponse(url);
	    	
	    }
	    @Then("^Verify the response TC01$")
	    public void verifyResponseTC01() {
	    	if(!response.contains("error")) {
	    		status="PASS";
	    		//that is if there is no error then assert true 
	    		
	    	
	    }
	    	Assert.assertEquals("PASS", status);
	    }
	    
	    //Scenario: Send a request to get rates of a specific date with invalid data TC02

	    @Given("^Construct the url by adding a invalid date TC02$")
	    public void constructURLInvalidDateTC02()
	    {
	    	ExchangeRates.date="2010-13-12"; //invalid date
	    	url=ExchangeRates.baseURL+ExchangeRates.date;
	    	
	    }
	    @And("^Hit the API and capture the response TC02$")
	    public void hitAPICaptureRespTC02() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that error comes in the response TC02$")
	    public void verifyErrorInResponseTC02() {
	    	Assert.assertTrue(response.contains("error"));
	    }
	    
	    //Scenario: Send a request for latest date with symbols TC03
	    @Given("^Construct the url for latest date TC03$")
	    public void constructURLforLatestDateTC03() {
	    	ExchangeRates.symbol="USD,GBP";
	    	url=ExchangeRates.baseURL+"latest?symbols="+ExchangeRates.symbol;
	    }
	    @And("^Hit the API and capture the response TC03$")
	    public void hitAPICaptureResponseTC03() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC03$")
	    public void verifyResponseGetsGeneratedTC03() {
	    	
	    	Assert.assertTrue(response.contains("rates"));
	    	
	    }
	    
	    
	    
	    
	   // Scenario: Send a invalid request for latest date with symbols TC04
	   @Given("^Construct the url for latest date TC04$")
	   public void constructURLForLatestDateTC04() {
		   ExchangeRates.symbol="UXX566767";//passing invalid symbol
	    	url=ExchangeRates.baseURL+"latest?symbols="+ExchangeRates.symbol;
	   }
	   @And("^Hit the API and capture the response TC04$")
	   public void hitAPIandCaptureRespTC04() {
		   response=ExchangeRates.getResponse(url);
	   }
	    @Then("^Verify that error gets generated TC04$")
	    public void verifyErrorGotGeneratedTC04() {
	    	Assert.assertTrue(response.contains("error"));
	    }
	    
	    
	    
	    
	    
	    //Scenario: Send a valid request with symbols and base TC05
	    @Given("^Construct the url with valid symbol and base TC05$")
	    public void constructURLwithValidSymbolAndBaseTC05()
	    {
	    	ExchangeRates.symbol="USD";
	    	ExchangeRates.base="GBP";
	    	url=ExchangeRates.baseURL+"latest?base="+ExchangeRates.base+"&symbols="+ExchangeRates.symbol;
	    }
	    @And("^Hit the API and capture the response TC05$")
	    public void hitAPIandCaptureResponseTC05()
	    {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC05$")
	    public void verifyResponseGetsGentedTC05() {
	    	Assert.assertTrue(response.contains("base")&&response.contains("rates"));
	    }
	    
	    
	    
	    
	    //Scenario: Send a request for latest data without symbols and base TC06
	    @Given("^Construct the url TC06$")
	    public void constructURLTC06() {
	    	url=ExchangeRates.baseURL+"latest";
	    }
	    @And("^Hit the API and capture the response TC06$")
	    public void hitapiandCaptureREspTC06() {
	    	
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC06$")
	    public void verifyRespGeneratedTC06() {
	    	Assert.assertTrue(response.contains("base")&&response.contains("rates"));
	    }
	    
	    
	    
	   // Scenario: Send a request for specific date with symbol TC07
	    @Given("^Construct the url TC07$")
	    public void constructURLTC07() {
	    	
	    	ExchangeRates.symbol="USD,GBP";
	    	ExchangeRates.date="2010-01-12";
	    	url=ExchangeRates.baseURL+ExchangeRates.date+"?symbols="+ExchangeRates.symbol;
	    }
	    @And("^Hit the API and capture the response TC07$")
	    public void hitApiCaptureRespTC07() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC07$")
	    public void responseGetsGenereatedTC07() {
	    	Assert.assertTrue(response.contains("USD")&&response.contains("GBP"));
	    }
	    
	    
	    
	   // Scenario: Send a request for specific date using base TC08
	    @Given("^Construct the url TC08$")
	    public void constructURLTC08() {
	    	ExchangeRates.base="USD";
	    	ExchangeRates.date="2010-01-12";
	    	url=ExchangeRates.baseURL+ExchangeRates.date+"?base="+ExchangeRates.base;
	    }
	    @And("^Hit the API and capture the response TC08$")
	    public void hitAPIandCaptureRespTC08() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC08$")
	    public void verifyResponseGeneratedTC08() {
	    	Assert.assertTrue(response.contains("USD"));
	    }
	    
	    
	    //Scenario: Send a request for specific date using base and symbols TC09
	    @Given("^Construct the url TC09$")
	    public void constructURLTC09() {
	    	
	    	ExchangeRates.base="USD";
	    	ExchangeRates.date="2010-01-12";
	    	ExchangeRates.symbol="GBP";
	    	url=ExchangeRates.baseURL+ExchangeRates.date+"?base="+ExchangeRates.base+"&symbols="+ExchangeRates.symbol;
	    }
	    @And("^Hit the API and capture the response TC09$")
	    public void hitAPIandCaptureResponseTC09() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that response gets generated TC09$")
	    public void verifyResponseGetsGeneratedTC09() {
	    	Assert.assertTrue(response.contains("USD")&&response.contains("GBP"));
	    }
	    
	    
	   // Scenario: Send a request with invalid base TC10
	    @Given("^Construct the url TC10$")
	    public void constructURLTC10() {
	    	ExchangeRates.base="invalid";
	    	ExchangeRates.date="2010-01-12";
	    	url=ExchangeRates.baseURL+ExchangeRates.date+"?base="+ExchangeRates.base;
	    }
	    @And("^Hit the API and capture the response TC10$")
	    public void hitAPICaptureResponseTC10() {
	    	response=ExchangeRates.getResponse(url);
	    }
	    @Then("^Verify that error is generated TC10$")
	    public void verifyErrorGeneratedTC10() {
	    	Assert.assertTrue(response.contains("error"));
	    }
	    
	    

	   // Scenario: Send a request with incomplete API TC11
	    @Given("^Hit the API base url and capture response TC11$")
	    public void hitAPIbaseurlAndCaptureResponseTC11() {
	    	response=ExchangeRates.getResponse(ExchangeRates.baseURL);
	    }
	    @Then("^Verify that error generated TC11$")
	    public void verifyErrorGeneratedTC11() {
	    	
	    	Assert.assertTrue(response.contains("error"));
	    }
	    
	    
	    //Scenario: Check API is available TC12
	    @Given("^Hit the API and capture the response TC12$")
	    public void hitAPIandCaptureResponseTC12() {
	    	ExchangeRates.base="USD";
	    	ExchangeRates.date="2010-01-12";
	    	ExchangeRates.symbol="GBP";
	    	url=ExchangeRates.baseURL+ExchangeRates.date+"?base="+ExchangeRates.base+"&symbols="+ExchangeRates.symbol;
	    	response=ExchangeRates.getResponse(url);
	    	
	    }
	    
	    @Then("^Check if the api is available TC12$")
	    public void checkIfAPIisUnavailableTC12()
	    
	    {
	    	Assert.assertFalse(response.contains("unavailable"));
	    }
}

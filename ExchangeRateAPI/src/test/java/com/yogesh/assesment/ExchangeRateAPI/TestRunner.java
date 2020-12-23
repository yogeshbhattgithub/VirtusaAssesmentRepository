package com.yogesh.assesment.ExchangeRateAPI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.DataProvider;  
import org.testng.annotations.Test;  

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		 monochrome = true,
	        features = "src/main/resources/features/",
	        
	        dryRun = false,
	        glue = "com.yogesh.assesment.ExchangeRateAPI.stepDef" )
        

public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner; 

	

	@BeforeClass(alwaysRun = true)
	 public void beforeClass() {
	      
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	        
	        
	    }
	
	@Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }
 
    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
     *         objects.
     */
    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
 
    
	@AfterClass(alwaysRun= true)
    public void tearDown(){
    	
        testNGCucumberRunner.finish();
        
    }
	
	 	
}

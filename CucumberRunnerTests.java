package runner;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/FeaturesFiles/CompleteRestAssured.feature"},
		glue = {"StepDefinations"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
               "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
		monochrome = true,
		publish = true
	)
	
public class CucumberRunnerTests 
{

}
package myrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"src/test/java/features"}
		,glue={"stepdefinition"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags = "@SmokeTest or @RegressionTest")

public class RunnerClass extends AbstractTestNGCucumberTests {

}

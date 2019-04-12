package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features",
		tags = "@complete, @accepted",
		glue = {"stepDefinition"}
		)

public class AllTests {

}
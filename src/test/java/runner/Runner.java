package runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "java.steps",
        plugin = {"pretty", "json:target/jsonReports/cucumber.json"}
)
public class Runner {
}

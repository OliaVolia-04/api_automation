package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {"html:target/reports/cucumberReport.html"}, // Reports output
        features = "src/test/resources", // Path to feature files
        glue = "steps", // Package where your step definition classes are located
        tags = "@sellerEmail", // Optional tag to run specific scenarios
        dryRun = true // Dry run to check for the connection between feature and step definitions
)


public class CucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}



package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
        glue= {"stepdefs"},
        tags = "@product_details",
        plugin = {"pretty",
                "junit:target/JUnitReports/report.xml",// to generate reports
                "html:target/html/htmlreport.html",
                "json:target/json/file.json"},
        dryRun = false,
        publish = false

)

public class Testrunner {
}

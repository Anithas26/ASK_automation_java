package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue="Definitions",
        monochrome = true,
        plugin={
                "pretty",
                "html:target/cucumber.html",
                "json:target/JSONReports/jsonreport.json",
                "junit:target/junitReports/junitreport.xml"},
        tags="@Login")

public class TestRunner {

}

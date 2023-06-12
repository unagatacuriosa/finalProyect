package com.hiberus.cucumber.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "html:target/cucumber-reports/cucumber-reports.html"
        },
        glue = {
                "com/hiberus/cucumber/stepdefs",
                "com/hiberus/cucumber/support"
        },
        features = {
                "src/test/features"
        }
)
public class CucumberRunnerTest {

}

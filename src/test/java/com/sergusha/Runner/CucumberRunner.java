package com.sergusha.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/reports/mainReport.json"},
        features = {"src/test/resources/features"},
        glue = {"com.sergusha.Stepdefs"} )
public class CucumberRunner {

}
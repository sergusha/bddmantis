package com.sergusha.Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/reports/html", "json:target/reports/mainReport.json"},
        features = {"/home/sergusha/Projects/Java/mantisBDD/src/test/resources/features/MantisTest.feature"},
        glue = {"com.sergusha.Stepdefs"} )
public class CucumberRunner {

}
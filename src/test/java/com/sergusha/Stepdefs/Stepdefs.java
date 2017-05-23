package com.sergusha.Stepdefs;

import com.sergusha.BDDMantis.PageObjects.Entities.Issue;
import com.sergusha.BDDMantis.PageObjects.Entities.User;
import com.sergusha.BDDMantis.PageObjects.MantisSite;
import com.sergusha.Helper.ResourceLoaderMantis;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

import static com.sergusha.BDDMantis.PageObjects.MantisSite.mainPage;
import static com.sergusha.BDDMantis.PageObjects.MantisSite.viewIssuePage;


public class Stepdefs {

    private static Issue issue;

    private static User user;

    private void setupIssue(String issue_name){
        Random random = new Random();
        issue = ResourceLoaderMantis.issues.get(issue_name);
        issue.setOs(System.getProperty("os.name"));
        issue.setOsVersion(System.getProperty("os.version"));
        issue.setPlatform(System.getProperty("os.arch"));

        issue.setDescription(issue.getDescription() + random.nextInt());
        issue.setSummary(issue.getSummary() + random.nextInt());
        issue.setAdditional_info(issue.getAdditional_info() + random.nextInt());
        issue.setSteps_to_reproduce(issue.getSteps_to_reproduce() + random.nextInt());
    }

    @Given("^User logs in as \"([^\"]*)\"$")
    public void userLogsInAs(String login) throws Throwable {
        MantisSite.open();
        user = ResourceLoaderMantis.users.get(login);
        MantisSite.loginPage.fillAndLogin(user);
    }

    @And("^reports an issue$")
    public void reportsAnIssue() throws Throwable {
        mainPage.openReportIssueForm();
    }

    @When("^user fills the form with \"([^\"]*)\"$")
    public void userFillsTheIssueWith(String issue_name) throws Throwable{
        setupIssue(issue_name);
        MantisSite.issuePage.fillFields(issue);
    }

    @And("^submits issue$")
    public void submitsIssue() throws Throwable {
        MantisSite.issuePage.submitIssue();
    }

    @And("^logouts$")
    public void logouts() throws Throwable {
        MantisSite.logout();
    }

    @Then("^user opens the bug table$")
    public void userOpensTheBugTable() throws Throwable {
        MantisSite.gotoBugTable();
    }

    @When("^user opens the \"([^\"]*)\" issue$")
    public void userOpensTheIssue(String assigned) throws Throwable {
        mainPage.findCreatedAndOpen(issue, assigned);
    }

    @And("^checks fields in the issue$")
    public void checksFieldsInTheIssue() throws Throwable {
        viewIssuePage.checkFields(issue, "assigned");
    }

    @And("^user finds the \"([^\"]*)\" issue$")
    public void userFindsTheIssue(String status) throws Throwable {
        mainPage.findCreatedIssue(issue, status);
    }

    @And("^user makes the issue closed")
    public void userMakesTheIssue() throws Throwable {
        viewIssuePage.closeIssue("closed");
    }


    @And("^user turns off the filters$")
    public void userTurnsOffTheFilters() throws Throwable {
        mainPage.turnFilterOff();
    }

    @And("^user makes the issue resolved$")
    public void userMakesTheIssueResolved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        viewIssuePage.resolveIssue("resolved");
    }
}

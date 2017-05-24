package com.sergusha.BDDMantis.PageObjects;

import com.sergusha.BDDMantis.PageObjects.Entities.Issue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sergusha on 10.04.17.
 */
public class MainPage {

    @FindBy(xpath = "//a[@href=\"bug_report_page.php\"]")
    WebElement reportIssueBtn;

    @FindBy(id = "buglist")
    WebElement buglist;

    @FindBy(id = "hide_status_filter")
    WebElement hideStatusFilter;

    @FindBy(xpath = "//select[@name=\"hide_status[]\"]")
    WebElement hideStatusSelector;

    @FindBy(xpath = "//input[@name=\"filter\"]")
    WebElement applyFilterBtn;



    public void findCreatedIssue(Issue issue, String assigned) {
        Assert.assertTrue(MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().anyMatch(row ->
                (row.getText().contains(issue.getSummary()))
                        && (row.getText().contains("block"))
                        && (row.getText().contains(assigned))
                        && (row.getText().contains("General"))));
    }


    public void findCreatedAndOpen(Issue issue, String assigned) {
        MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr")).stream()
                .filter(row ->(row.getText().contains(issue.getSummary()))
                                && (row.getText().contains("block"))
                                && (row.getText().contains(assigned))
                                && (row.getText().contains("General")))
                .collect(Collectors.toList()).get(0)
                .findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[4]/a")).click();
    }


    public void openReportIssueForm(){
        reportIssueBtn.click();
    }

    public void turnFilterOff() {
        hideStatusFilter.click();
        new Select(hideStatusSelector).selectByVisibleText("[none]");
        applyFilterBtn.click();
    }
}
//    @Deprecated
//    private void deleteTableRow(WebElement row){
//        row.findElement(By.className("column-selection")).click();
//        new Select(deletionSelector).selectByValue("DELETE");
//        deleteBtn.click();
//        confirmDeletionBtn.click();
//    }
//    @Deprecated
//    public boolean findCreatedIssueAndDelete(String expected){
//        List<WebElement> rows = buglist.findElements(By.tagName("tr"));
//        boolean testComplete = false;
//        for(WebElement row : rows){
//            boolean cell_found = false;
//            for(WebElement col : row.findElements(By.xpath("./*"))){
//                if(col.getText().equals(expected)){
//                    cell_found = true;
//                    break;
//                }
//            }
//            if(cell_found){
//                deleteTableRow(row);
//                testComplete = true;
//                break;
//            }
//
//        }
//        return testComplete;
//    }
//    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/select")
//    WebElement deletionSelector;
//
//    @FindBy(xpath = "//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")
//    WebElement deleteBtn;
//
//    @FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
//    WebElement confirmDeletionBtn;
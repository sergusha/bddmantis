package com.sergusha.BDDMantis.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sergusha on 10.04.17.
 */
public class MantisSite {

    public static LoginPage loginPage;

    public static IssuePage issuePage;

    public static MainPage mainPage;

    public static ViewIssuePage viewIssuePage;

    public static WebDriver driver;


    public static void init(WebDriver driver){
        MantisSite.loginPage     = PageFactory.initElements(driver, LoginPage.class);
        MantisSite.issuePage     = PageFactory.initElements(driver, IssuePage.class);
        MantisSite.mainPage      = PageFactory.initElements(driver, MainPage.class);
        MantisSite.viewIssuePage = PageFactory.initElements(driver, ViewIssuePage.class);
        MantisSite.driver        = driver;

    }

    public static void gotoBugTable() { driver.navigate().to("http://127.0.0.1/mantisbt/view_all_bug_page.php"); }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt");
    }

    public static void logout() { driver.navigate().to("http://127.0.0.1/mantisbt/logout_page.php"); }
}

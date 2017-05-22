package com.sergusha.BDDMantis.PageObjects;

import com.sergusha.BDDMantis.PageObjects.Entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sergusha on 10.04.17.
 */
public class LoginPage {

    @FindBy(id = "username")
    WebElement login;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[2]")
    WebElement loginButton;

    public void fillAndLogin(User user){
        this.login.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
        this.loginButton.click();
    }

}
